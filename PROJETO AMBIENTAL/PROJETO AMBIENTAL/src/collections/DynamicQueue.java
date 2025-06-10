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
            return value.toString() ;
        }
    }

    private int size;
    private Node first;
    private Node last;

    @Override
    public E dequeue() throws EmptyQueueException {
        E value = first();
        first = first.next;
        if(size==1){        
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
        }else{
            last.next = newNode;
        }
        size++;
        last = newNode;
        
    }

    @Override
    public E first() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        return first.value;
    }

    @Override
    public boolean isEmpty() {        
        return first == null;
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        String queueData = "\\/First\n";
        Node auxNode = first;
        String aux = "";
        while(auxNode!=null){
            queueData += auxNode;
            String dado = auxNode.value.toString();
            auxNode = auxNode.next;
            if(auxNode!=null){
                for(int j = 0; j < dado.length(); j++){
                    aux += " ";
                }
                aux += "  ";
                queueData += ", ";
            }
        }


        return queueData + "\n"+aux+"/\\Last";
    }


    
    

}
