package collections;

import java.util.Comparator;

public abstract class BinaryTree<E> implements Tree<E> {

      class Node{
            Node left;
            Node right;
            E value;
            public Node(E value) {
                  this.value = value;
            }            
      }

      protected int size;
      protected Node root;
      protected Comparator<E> comparator;

      public BinaryTree(){
            comparator = new DefaultComparator<>();
      }

      protected int compare(Node n1, Node n2){
            return comparator.compare(n1.value, n2.value);
      }

      protected int compare(E value, Node node){
            return comparator.compare(value, node.value);
      }

      @Override
      public boolean isEmpty() {
            return root == null;
      }
      @Override
      public int size() {
            return size;
      }

      

}
