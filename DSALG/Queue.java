/**
 * This is a queue library designed for integers.
 * The main function is used to check for implementation.
 * 
 * @author Edriel Lexine A. Maullon
 */

import java.util.Arrays;
import java.util.Scanner;

public class Queue{
    private int maxSize; //Defined maximum size for now
    private int size;
    private int[] Queue = new int[180]; //99 is self-imposed limit

    /**
     * This method creates and returns an empty queue of a specified maximum size.
     * This maximum size will be unable to be changed after setting. If it is set
     * to a negative value, the maximum size will default to 10.
     * @param maxSize - The set maximum size for the queue.
     * @return a new array with size "maxSize".
     */
    public Queue(int maxSize) {
        if (maxSize > 0)
            this.maxSize = maxSize;
        else
            this.maxSize = 10;

        this.size = 0;

        Arrays.fill(this.Queue, 0, this.maxSize, 0);
    }

    /**
     * This method allows the user to get the maximum size of the Queue if need be.
     * @return the queue's set max size.
     */
    public int getMaxSize(){
        return this.maxSize;
    }

    /**
     * This method sets the queue size to an integer.
     * @param size - The value the queue's current size will be set to.
     */
    public void setSize(int size){
        if (size >= 0)
            this.size = size;
    }

    /**
     * This method gets the current size of the queue.
     * @return the queue's current size
     */
    public int getSize(){
        return this.size;
    }

    /**
     * This method returns the current value at the head of the queue.
     * @return the integer currently at the head of the queue
     * (the start of the array)
     */
    public int queueHead() {
        return this.Queue[0];
    }

    /**
     * This method returns the current value at the tail of the queue.
     * If the queue only has 1 element, it returns the queue head.
     * @return the integer currently at the tail of the queue,
     * or the queue head if the queue only has 1 element.
     */
    public int queueTail() {
        if (this.size > 0)
            return this.Queue[size-1];
        else
            return queueHead();
    }

    /**
     * This is a boolean method that tells whether or not a queue
     * is full.
     * @return 1 if the queue is full, 0 otherwise.
     */
    public boolean isQueueFull() {
        return this.size == this.maxSize;
    }

    /**
     * This is a boolean method that tells whether or not a queue
     * is empty.

     * @return 1 if the queue is empty, 0 otherwise.
     */
    public boolean isQueueEmpty() {
        return queueHead() == queueTail() && size == 0;
    }

    /**
     * This method adds an element to the end of the queue.
     * @param add - The element to be added to the queue.
     */
    public void enqueue(int add) {
        this.Queue[this.size] = add;
        setSize(this.size + 1);

        System.out.println("Successfully enqueued " + add + "!");
    }

    /**
     * This method dequeues the queue head from the array.
     * @return the dequeued value.
     */
    public int dequeue() {
        int i;
        int res = this.Queue[0];

        if (this.size != 1)
        {
            for (i=0; i<this.size - 1; i++)
                this.Queue[i] = this.Queue[i+1];
        }
        else
            this.Queue[0] = 0;

        setSize(this.size - 1);

        return res;
    }
    
    /**
     * This is a display method that shows the queue's values
     * from head to tail.
     */
    public void displayQueue() {
        int i;

        if (!isQueueEmpty())
        {
            for (i=0; i<this.maxSize; i++)
            {
                if (i<size)
                    System.out.println(this.Queue[i]);
                else
                    System.out.println("??");
            }
        }
        else
            System.out.println("Queue is empty!");

        System.out.println();
        System.out.println();
    }
}