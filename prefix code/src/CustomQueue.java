/*
 * This is a custom written queue data structure class.
 *
 * Note on Generics: This class uses Java Generics (<T>) backed by an Object array.
 * Primitive types (like int, char) cannot be used. Use their respective
 * java.lang equivalents (like Integer, Character).
 *
 * This version contains modified methods that remove their return guard clauses in order to
 * adhere to strict rules concerning good programming practices for C.
 *
 * @author Johann Haree Tolentino
 * @date 05/24/2026
 * @param <T> The type of elements held in this stack
 */

public class CustomQueue<T> {

    private final Object[] queue;
    private final int capacity;
    private int count;
    private int head;
    private int tail;

    /**
     * This function creates an array to act as the queue data structure.
     * Serves as the CreateQueue function of this class.
     * In an event where the parameter maxSize is left null, or set to less than 0, the queue size defaults to 10.
     * @param maxSize specified size of the queue array data type.
     *                It defaults to 10 if it is left null, or set to less than 0
     */
    public CustomQueue(Integer maxSize) 
    {
        if (maxSize == null || maxSize <= 0)
        {
            this.capacity = 10;
        }
        else
        {
            this.capacity = maxSize;
        }

        this.queue = new Object[this.capacity];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }

    public CustomQueue()
    {
        this.capacity = 10;
        this.queue = new Object[this.capacity];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * This function inserts a specified object into the tail of the queue
     * @param item The object to be added at the tail of the queue
     */
    public void enQueue(T item){

        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            this.queue[tail] = item;
            tail = (tail + 1) % capacity;
            count++;
        }
    }

    /**
     * This function removes and returns the item at the front of the queue.
     * Follows a First-In-First-Out (FIFO) methodology
     * @return T - The object at the head of the queue
     */
    public T deQueueItem()
    {
//        if (isEmpty())
//        {
//            System.out.println("Queue is empty");
//            return null;
//        }

        if (!isEmpty()) {
            T item = head();
            deQueue();
            return item;
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    /**
     * Advances the head pointer and removes the front element.
     */
    public void deQueue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
        }
        else {
            this.queue[head] = null;
            head = (head + 1) % capacity;
            count--;
        }
    }

    /**
     * This function returns the first active element of the CustomQueue
     * @return T - specified object type
     */
    @SuppressWarnings("unchecked")
    public T head()
    {
        if (!isEmpty())
        {
            return (T)this.queue[head];
        }
        else
        {
            System.out.println("Queue is empty");
            return null;
        }
    }

    /**
     * This function returns the last active element of the CustomQueue.
     * Returns null if queue is empty or does not exist
     * @return T - specified object type
     */
    @SuppressWarnings("unchecked")
    public T tail()
    {
        if (!isEmpty())
        {
            int lastElement = (tail - 1 + capacity) % capacity;
            return (T) this.queue[lastElement];
        }
        else
        {
            System.out.println("Queue is empty");
            return null;
        }

    }

    /**
     * This function returns true if the current count of CustomQueue is empty
     * @return boolean - True if count is 0, False if otherwise
     */
    public boolean isEmpty()
    {
        return count == 0;
    }

    /**
     * This function returns true if the current count of CustomQueue is full
     * @return boolean - True if count is equal to set capacity, False if otherwise
     */
    public boolean isFull()
    {
        return count == capacity;
    }
}
