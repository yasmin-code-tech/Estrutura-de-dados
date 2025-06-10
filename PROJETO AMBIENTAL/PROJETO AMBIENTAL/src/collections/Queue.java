package collections;

import exceptions.EmptyQueueException;

public interface Queue<E>{
    void enqueue(E value);
    E dequeue() throws EmptyQueueException;
    E first() throws EmptyQueueException;
    int size(); // int length();
    boolean isEmpty();
}
