package collections;
public class HashTable<K,V> extends AbstractHashTable<K,V> {
    @Override
    public void set(K key, V value){
        Node newNode = new Node(key, value);
        int index = hashFunction(key);
        if(hashTable[index] == null){
            hashTable[index] = newNode;
        }else{
            Node auxNode = hashTable[index];
            while(auxNode != null){
                if(key.equals(auxNode.entry.getkey())){
                    auxNode.entry.setValue(value);
                    return;
                }

                auxNode = auxNode.next;
            }

            newNode.next = hashTable[index];
            hashTable[index].prev = newNode;
            hashTable[index] = newNode;
        }
    }
}
