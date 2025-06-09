package collections;


public class BinarySearchTree<E> extends BinaryTree<E> {

      public E removeRightMinNode(Node minParent){
            Node minNode = minParent.right;
            while(minNode.left != null){
                  minParent = minNode;
                  minNode = minNode.left;
            }
            if(minParent.right == minNode){
                  minParent.right = minNode.right;
            }else{
                  minParent.left = minNode.right;
            }
            return minNode.value;
      }

      @Override
      public E delete(E value) {
            Node target = root , parent = null;
            while (target!=null && compare(value, target)!=0) {
                  parent = target;
                  if(compare(value, target)<0){
                        target = target.left;
                  }else{
                        target = target.right;
                  }                  
            }
            if(target == null){
                  return null;
            }
            E removed = target.value;
            if(target.left!=null && target.right!=null){
                  target.value = removeRightMinNode(target);
            }else{
                  Node child = target.left!=null ? target.left : target.right;
                  if(target == root){
                        root = child;
                  }else{
                        if(parent.left == target){
                              parent.left = child;
                        }else{
                              parent.right = child;
                        }
                  }  
            }
            size--;
            return removed;
      }

      @Override      
      public E get(E value) {
            Node current = root;
            while (current != null) {
                  int cmp = compare(value, current);
                  if (cmp == 0) {
                        return current.value;
                  } else if (cmp < 0) {
                        current = current.left;
                  } else {
                        current = current.right;
                  }
            }
            return null;
      }
      }

      @Override
      public void insert(E value) {
            Node newNode = new Node(value);
            if(isEmpty()){
                  root = newNode;
            }else{
                  Node auxNode = root;
                  while(auxNode!=null){
                        if(compare(newNode, auxNode)<0){
                              if(auxNode.left == null){
                                    auxNode.left = newNode;
                                    break;
                              }
                              auxNode = auxNode.left;                              
                        }else if(compare(newNode, auxNode)>0){
                              if(auxNode.right == null){
                                    auxNode.right = newNode;
                                    break;
                              }
                              auxNode = auxNode.right;
                        }else{
                              return;
                        }
                  }
            }

            size++;
            
      }

      private String breadthFirstSearch(){
            String treeData = "";
            DynamicQueue<Node> queue = new DynamicQueue<>();
            if(!isEmpty()){
                  queue.enqueue(root);
            }
            while(!queue.isEmpty()){
                  Node auxNode = queue.dequeue();
                  treeData += auxNode.value;
                  if(auxNode.left != null){
                        queue.enqueue(auxNode.left);
                  }

                  if(auxNode.right != null){
                        queue.enqueue(auxNode.right);
                  }

                  if(!queue.isEmpty()){
                        treeData += ", ";
                  }
            }
            return treeData;
      }

      

      
      public String treeTraversal(String type) {
            if(type.equals("bfs")){

            }else{
                  if(type.equals("preOrder")){

                  }else if(type.equals("inOrder")){

                  }else{

                  }
            }
            return null;
      }

      @Override
      public String toString() {
            return breadthFirstSearch();
      }

      


