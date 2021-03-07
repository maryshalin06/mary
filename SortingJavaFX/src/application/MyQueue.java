package application;


public class MyQueue<T> {


	private T[] arr; //used to store data into this array in a queue manner

	private int total; //the total number of elements in the queue
	private int first; //the location of the first element in the queue
	private int rear; //the location of the next available element (last one's next)

	//Default constructor, by default the capacity is two elements of type T 
	public MyQueue()
    {
        arr = (T[]) new Object[2];
    }

	//Resize the MyQueue to the capacity as the input argument specifies
    private void resize(int capacity)
    {
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0; i < total; i++)
            tmp[i] = arr[(first + i) % arr.length];

        arr = tmp;
        first = 0;
        rear = total;
    }
    
    //Check if the queue is empty: if empty, returns true; otherwise returns false
    public boolean isEmpty()
    {
	    	if(total > 0)
	    		return false;
	    	else
	    		return true;
    }

    //Add one element "ele" into the queue
    //Attention: (1) if the current queue is full, you need to resize it to twice of the current size.
    //           (2) if the "rear" is already pointing to the end of the queue, but there is available space
    	//               in the beginning, you need to "loop" the rear position.
    public void enqueue(T ele)
    {
        if (arr.length == total) resize(arr.length * 2);
        arr[rear++] = ele;
        if (rear == arr.length) rear = 0;
        total++;
    }

    
    //Delete the first (oldest) element from the queue and return this element.
    //Below is just an example code, you need to modify it. 
    //Attention: (1) To save space, if the current number of elements is less than or equal to 1/4 of the
    	// 			     the capacity, shrink the capacity to 1/2 (half) of the original size.
    	//			 (2) If the "first" is pointing to the end of the queue, but there is available space
    //				 in the beginning, you need to consider "loop" the first position.
    public T dequeue()
    {
        if (total == 0) return null;
        T ele = arr[first];
        arr[first] = null;
        if (++first == arr.length) first = 0;
        if (--total > 0 && total == arr.length / 4) resize(arr.length / 2);
        return ele;
    }
	
}
