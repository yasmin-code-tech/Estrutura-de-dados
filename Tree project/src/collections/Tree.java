package collections;

public interface Tree<E> {
      void insert(E value);
      E delete(E value);
      E get(E value);
      String treeTraversal(String type);
      int size();
      boolean isEmpty();
}
