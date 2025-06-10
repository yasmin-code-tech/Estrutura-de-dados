package collections;

public interface Tree<E> {
    void insert(E value);//insere um valor novo
    E delete(E value);//deleta esse valor
    E get(E value);//traz algum valor da arvore
    String treeTraversal(String type);//como se fosse o toString mas ele pode ser implementado de varias maneiras
    boolean isEmpty();
    int size();
    
}