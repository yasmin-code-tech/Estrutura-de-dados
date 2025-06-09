package collections;

import exceptions.EmptyQueueException;

public class DynamicQueue<E> implements Queue<E> {


    class Node{
        Node next;
        E value;
        public Node(E value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return value.toString();
        }      
          
    }


    private int size;
    private Node first;
    private Node last;

    @Override
    public E dequeue() {
        E value = first();
        first = first.next;
        if(size == 1){
            last = first;          
        }        
        size--;
        return value;
    }

    @Override
    public void enqueue(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
        
    }

    @Override
    public E first() {
        if(isEmpty()) throw new EmptyQueueException();
        return first.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        String queueData = "";
        Node auxNode = first;
        while(auxNode!=null){
            queueData += auxNode;

            auxNode = auxNode.next;
            if(auxNode!=null){
                queueData += ", ";
            }
        }
        return queueData;
    }

    

}
