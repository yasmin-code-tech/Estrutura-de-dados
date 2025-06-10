package collections;

public class RecursiveBinarySearchTree<E> extends BinaryTree<E> {

      private Node getMinNode(Node current) {
        if (current.left == null) {
            return current;
        }
        return getMinNode(current.left);
    }

    private Node delete(Node current, E value) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) == 0) {
            if (current.left != null && current.right != null) {
                current.value = getMinNode(current.right).value;
                current.right = delete(current.right, current.value);
            } else {
                size--;
                current = current.left != null ? current.left : current.right;
            }
        } else {
            if (compare(value, current) < 0) {
                current.left = delete(current.left, value);
            } else {
                current.right = delete(current.right, value);

            }
        }
        return current;
    }

    @Override
    public E delete(E value) {
        int auxSize = size;
        root = delete(root, value);
        return auxSize ;
    }

    ///////////////////

    @Override
    public E get(E value) {
        return get(root, value);
    }

    private E get(Node current, E value) {
        if (current == null)
            return null;// ele vai buscando, se nao achar é null

        if (compare(value, current) == 0) {
            return current.value;// se o valor de entrada for igual ao valor atual ele retorna current.value

        } else if (compare(value, current) < 0) {
            return get(current.left, value);// se value for menor que current entao faço
                                            // novamente a compraçao mas com quem esta a esquerda.
        } else {
            return get(current.right, value);// se value for maior que current entao faço
                                             // novamente a compraçao mas com quem esta a direita.
        }

    }

    private Node insert(Node current, E value) {
        if (current == null) {// caso base
            return new Node(value);
        }

        if (compare(value, current) < 0) {
            current.left = insert(current.left, value);// e o value for menor que o valor do current, então ele deve ser
                                                       // inserido na subárvore esquerda.
        } else if (compare(value, current) > 0) {
            current.right = insert(current.right, value);// Se o value for maior, então vamos para a subárvore direita.
        }
        return current;
    }

    @Override
    public void insert(E value) {// metodo recursivo
        root = insert(root, value);
    }

    // tipos de ordenaçao(perguntar para o paulo)
    // Pré-ordem (preOrder): visita a raiz, depois a esquerda, depois a direita → A
    // B C

    // Em ordem (inOrder): esquerda, raiz, direita → B A C

    // Pós-ordem (postOrder): esquerda, direita, raiz → B C A

    protected String preOrder(String treeData, Node current) {
        if (current != null) {
            treeData += current.value + " ";
            treeData = preOrder(treeData, current.left);
            treeData = preOrder(treeData, current.right);
        }
        return treeData;
    }

    protected String inOrder(String treeData, Node current) {
        if (current != null) {
            treeData = inOrder(treeData, current.left);
            treeData += current.value + " ";
            treeData = inOrder(treeData, current.right);
        }
        return treeData;
    }

    protected String postOrder(String treeData, Node current) {
        if (current != null) {
            treeData = postOrder(treeData, current.left);
            treeData = postOrder(treeData, current.right);
            treeData += current.value + " ";
        }
        return treeData;
    }

    @Override
    public String treeTraversal(String type) {
        if (type.equals("bfs")) {
            return "";
        } else {
            if (type.equals("inOrder")) {
                return inOrder("", root);
            } else if (type.equals("preOrder")) {

                return preOrder("", root);
            } else {
                return postOrder("", root);
            }
        }
    }

}
