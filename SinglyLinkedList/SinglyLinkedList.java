package SinglyLinkedList;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {


    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        if (data == null) {
            throw new IllegalArgumentException();
        }

        SinglyLinkedListNode<T> frontNode = new SinglyLinkedListNode<>(data);

        if (this.head == null) {
            this.head = frontNode;
            this.tail = frontNode;
        } else {
            frontNode.setNext(this.head);
            this.head = frontNode;
        }

        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }

        SinglyLinkedListNode<T> backNode = new SinglyLinkedListNode<>(data);

        if (this.head == null) {
            this.head = backNode;
            this.tail = backNode;
        } else {
            this.tail.setNext(backNode);
            this.tail = backNode;
        }

        size++;

    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {

        if (this.head == null) {
            throw new NoSuchElementException();
        }

        SinglyLinkedListNode<T> headTemp = this.head;
        this.head = this.head.getNext();
        headTemp.setNext(null);

        if (this.tail == headTemp) {
            this.tail = null;
        }

        size--;

        return headTemp.getData();

    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {

        if (this.tail == null) {
            throw new NoSuchElementException();
        }

        SinglyLinkedListNode<T> tailTemp = this.tail;

        if (this.head == tailTemp) {
            this.head = null;
            this.tail = null;
        } else {
            SinglyLinkedListNode<T> current = this.head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            this.tail = current;
            current.setNext(null);
        }

        size--;

        return tailTemp.getData();

    }

    /**
     * Returns the head node of the list.
     *
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }
}