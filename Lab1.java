import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if(data == null){
            throw new IllegalArgumentException();
        }
        if(this.backingArray[(this.backingArray.length - 1)] != null){
            T[] newArrList = (T[]) new Object[2 * this.backingArray.length];
            for(int i = 0; i < this.backingArray.length; i++){
                newArrList[i+1] = this.backingArray[i];
            }
            this.backingArray = newArrList;
            this.backingArray[0] = data;
        } else{
            for(int a = (this.size-1); a >= 0; a--){
                this.backingArray[a+1] = this.backingArray[a];
            }
            this.backingArray[0] = data;
        }
        this.size++;
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {

        if(data == null){
            throw new IllegalArgumentException();
        }
        if (this.backingArray[(this.backingArray.length - 1)] != null) {
            T[] newArrList = (T[]) new Object[2 * this.backingArray.length];

            for (int b = 0; b < this.backingArray.length; b++) {
                newArrList[b] = backingArray[b];
            }

            this.backingArray = newArrList;
        }

        this.backingArray[this.size] = data;
        this.size++;

        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {

        if(this.size == 0){
            throw new NoSuchElementException();
        }
        T solution = this.backingArray[0];

        for (int i = 1; i < this.size; i++) {
            backingArray[i - 1] = backingArray[i];
        }

        backingArray[this.size - 1] = null;

        this.size--;
        return solution;

        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if(this.size == 0){
            throw new NoSuchElementException();
        }
        T solution = this.backingArray[size - 1];

        for(int i = (size - 1); i < this.size; i++){
            this.backingArray[i] = null;
        }

        this.size--;

        return solution;
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}