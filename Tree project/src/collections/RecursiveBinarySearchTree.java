package collections;

public class RecursiveBinarySearchTree<E> extends BinaryTree<E> {

      private E deletedValue = null;

      @Override
      public E delete(E value) {
            deletedValue = null;
            root = delete(root, value);
            if (deletedValue != null) {
                  size--;
            }
            return deletedValue;
      }

      private Node delete(Node current, E value) {
            if (current == null) return null;

            int cmp = compare(value, current);

            if (cmp < 0) {
                  current.left = delete(current.left, value);
            } else if (cmp > 0) {
                  current.right = delete(current.right, value);
            } else {
                  // Nó encontrado
                  deletedValue = current.value;

                  if (current.left == null) return current.right;
                  if (current.right == null) return current.left;

                  // Dois filhos: substituir pelo menor da subárvore direita
                  Node successor = findMin(current.right);
                  current.value = successor.value;
                  current.right = delete(current.right, successor.value); // Remove o sucessor
            }

            return current;
      }

      private Node findMin(Node node) {
            while (node.left != null) {
                  node = node.left;
            }
            return node;
      }

      @Override
      public E get(E value) {
            return get(root, value);
      }

      private E get(Node current, E value) {
            if (current == null) {
            return null;
      }
      int cmp = compare(value, current);
      if (cmp == 0) {
            return current.value;
      } else if (cmp < 0) {
            return get(current.left, value);
      } else {
            return get(current.right, value);
      }
      }

      private Node insert(Node current, E value){
            if(current == null){
                  size++;
                  return new Node(value);
            }
            if(compare(value, current)<0){
                  current.left = insert(current.left, value);
            }else if(compare(value, current)>0){
                  current.right = insert(current.right, value);
            }
            return current;
      }
      
      @Override
      public void insert(E value) {
            root = insert(root, value);            
      }

      
      private String inOrder(String dataTree, Node current ){
            if(current!=null){
                  dataTree = inOrder(dataTree, current.left);
                  dataTree += current.value + " ";
                  dataTree = inOrder(dataTree, current.right);
            }
            return dataTree;
      } 
      private String preOrder(String dataTree, Node current ){
            if(current!=null){
                  dataTree += current.value + " ";
                  dataTree = preOrder(dataTree, current.left);
                  dataTree = preOrder(dataTree, current.right);
            }
            return dataTree;
      } 
      private String postOrder(String dataTree, Node current ){
            if(current!=null){
                  dataTree = postOrder(dataTree, current.left);
                  dataTree = postOrder(dataTree, current.right);
                  dataTree += current.value + " ";
            }
            return dataTree;
      } 

      @Override
      public String treeTraversal(String type) {
            // TODO Auto-generated method stub
            return null;
      }

      @Override
      public String toString() {
            return inOrder("",root);
      }

      
      

}
