/*
 * This is a custom written stack data structure class.
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

public class CustomStack<T> {
    private final Object[] stack;
    private final int capacity;
    private int count;

    public CustomStack(Integer maxSize)
    {
        if (maxSize == null || maxSize <= 0)
        {
            this.capacity = 10;
        }
        else
        {
            this.capacity = maxSize;
        }

        this.stack = new Object[this.capacity];
        this.count = 0;
    }

    /**
     * This function returns the last active element of the stack.
     * Returns null if stack is empty or does not exist
     * @return topmost element of type object
     */
    @SuppressWarnings("unchecked")
    public T top()
    {
        if (!isEmpty())
        {
            return (T) this.stack[count - 1];
        }
        else
        {
            return null;
        }
    }

    /**
     * This function returns and removes the last active element of the stack.
     * Returns null if stack is empty
     * @return topmost element of type object
     */
    public T popItem()
    {
        if (!isEmpty())
        {
            T topItem = this.top();
            pop();
            return topItem;
        }
        else
        {
            return null;
        }
    }

    /**
     * This function removes the last active element of the stack.
     */
    public void pop()
    {
        if (!isEmpty())
        {
            this.stack[count - 1] = "";
            count--;
        }
    }

    /**
     * This function adds a specified object type onto the top of the custom stack
     * @param item object type
     */
    public void push(T item)
    {
        if (!isFull())
        {
            this.stack[count] = item;
            count++;
        }
        else
        {
            System.out.println("Stack is full");
        }
    }

    /**
     * This function returns true if the current count of custom stack is empty, false if otherwise
     * @return boolean - True if count is 0, False if otherwise
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * This function returns true if the current count of custom stack is full, false if otherwise
     * @return boolean - True if count is equal to set capacity, False if otherwise
     */
    public boolean isFull() {
        return count == capacity;
    }

}
