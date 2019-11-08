public class BinaryHeap
{
	private int size = 0;
	private int [] data = new int[10];
	//adds an int to the priority queue
	public void add(int item)
	{
		if (size == data.length)
		grow();
		data[size++] = item;
		int child = size-1;
		int parent = (child - 1) / 2;

		if(parent >= 0){
		while(data[parent] > data[child]){
			swap(data, parent, child);
			child = parent;
			parent = (child -1)/2;
			}
		}
	}
	//removes the lowest number from the priority queue
	public int remove()
	{
		int removed = data[0];
		data[0] = data[--size];
		siftdown(0);
		return removed;
	}
	//this grows the array
	private void grow()
	{
		int[] array = new int[data.length * 2];
		int size = data.length;
		for (int i = 0; i < size; i++) {
			array[i] = data[i];
		}
		data = array;
	}

	public void swap(int [] a, int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	private void siftdown(int parent)
	{
		int child = parent * 2 + 1;
		if(child < size)
		{
			if ((data[child] > data[child + 1]) && ((child + 1) < size))
				child++;
			if (data[parent] > data[child])
			{
				swap(data, parent, child);
				siftdown(child);
			}
		}
	}
}