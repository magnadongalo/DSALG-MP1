/**
 * This is a stack library designed for integers.
 * The main function is used to check for implementation.
 * 
 * @author Edriel Lexine A. Maullon
 */

import java.util.Arrays;

public class intStack {
    private int maxSize;
    private int size;
    private int[] Stack = new int[180]; //180 is a self-imposed maximum

    /**
     * This constructor initializes an empty stack of a specified maximum size.
     * If the set maximum size is less than or equal to zero, it defaults to 10.
     * The maximum size of a stack cannot be changed after being set.
     * @param maxSize - The specified maximum size of the stack.
     */
    public intStack(int maxSize) {
        if (maxSize > 0)
            this.maxSize = maxSize;
        else
            this.maxSize = 10;

        this.size = 0;

        Arrays.fill(this.Stack, 0, this.maxSize, 0);
    }

    /**
     * This method sets the stack's current size.
     * @param size - The current size of the stack.
     */
    public void setSize(int size){
        if (size >= 0)
            this.size = size;
    }

    /**
     * This method gets the stack's current size
     * @return the stack's current size
     */
    public int getSize(){
        return this.size;
    }

    /**
     * This method gets the stack's maximum size.
     * @return the stack's maximum size
     */
    public int getMaxSize(){
        return this.maxSize;
    }

    /**
     * This method pushes a value into the stack.
     * @param add - The element to be added into the stack.
     */
    public void push(int add) {
        this.Stack[this.size] = add;
        setSize(this.size + 1);
    }

    /**
     * This method pops a value out of the stack by removing it and
     * returning the value.
     * @return the integer popped from the stack.
     */
    public int pop() {
        int res = this.Stack[this.size - 1];
        this.Stack[this.size - 1] = 0;

        setSize(this.size - 1);

        return res;
    }
    
    /**
     * This method returns the current top value of the stack.
     * @return the integer currently on the top of the stack 
     * (the end of the array)
     */
    public int stackTop() {
        if (!isStackEmpty())
            return this.Stack[this.size-1];
        else
            return this.Stack[0];
    }

    /**
     * This is a boolean method that tells whether or not 
     * a stack is empty.
     * @return 1 if the stack is empty, 0 otherwise.
     */
    public boolean isStackEmpty() {
        return this.size == 0;
    }

    /**
     * This is a boolean method that tells whether or not
     * a stack is full.
     * @return 1 if the stack is full, 0 otherwise.
     */
    public boolean isStackFull() {
        return this.size == this.maxSize;
    }

    /**
     * This is a display method that shows the stack's values 
     * from bottom to top.
     */
    public void displayStack() {
        int i;

        if (!isStackEmpty())
        {
            for (i=this.maxSize; i>0; i--)
            {
                if (i-1<this.size)
                    System.out.println(this.Stack[i-1]);
                else
                    System.out.println("??");
            }
        }
        else
            System.out.println("Stack is empty!");

        System.out.println();
        System.out.println();
    }
}