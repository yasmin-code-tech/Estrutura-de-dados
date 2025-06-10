package collections;
//DE ACORDO COM NOSSO TEACHER IS THIS QUE VAI CAIR BABY

public class BinarySearchTree<E> extends BinaryTree<E> {

    private E removeRightMinNode(Node parent) {
        Node minNode = parent.right;// recebe quem esta a direita de parent(target)

        while (minNode.left != null) {// Isso desce pela esquerda da subárvore direita até encontrar
                                      // o menor valor (sucessor in-order).

            parent = minNode;// Atualiza parent para ser o atual minNode
            minNode = minNode.left;// vai para a esquerda
        }

        if (parent.right == minNode) {// Se o menor nó (minNode) que será removido é filho direito do seu pai (parent)
            parent.right = minNode.right;// então o novo filho direito do pai será o filho direito do minNode, se
                                         // existir (ou null se não existir).
        } else {
            parent.left = minNode.right;// Senão (ou seja, se minNode era filho à esquerda do seu pai),
                                        // o novo filho esquerdo do pai será o filho direito do minNode.
        }
        return minNode.value;
    }

    // private E removeLeftMaxNode(Node parent) {
    // Node maxNode = parent.left;

    // while (maxNode.right != null) {
    // parent = maxNode;
    // maxNode = maxNode.right;
    // }

    // if (parent.left == maxNode) {
    // parent.left = maxNode.left;
    // } else {
    // parent.right = maxNode.left;
    // }
    // return maxNode.value;
    // }

    @Override
    public E delete(E value) {
        Node target = root, parent = null;
        while (target != null && compare(value, target) != 0) {
            parent = target;
            if (compare(value, target) < 0) {// aqui ele ta decidindo para qual lado ele vai dependendo
                target = target.left; // se o valor passado for maior ou menor que o target atual
            } else {
                target = target.right;
            }
        }
        if (target == null) return null;

        E removed = target.value;
        if (target.left != null && target.right != null) {
            target.value = removeRightMinNode(target);
        } else {

            // filho vai receber ou no a esquerda ou no a direita
            // se target a esquerda for diferente de nulo , variavel child(filho) recebe ele
            // se nao recebe o da direita
            Node child = target.left != null ? target.left : target.right;

            if (target == root) { // se o alvo a ser removido for a raiz da arvore
                root = child; // a raiz recebera o seu filho ja determinado acima.

            } else {// caso tenha um filho

                if (parent.left == target) {// se o no a esquerda do pai for o target
                    parent.left = child;// no a esqueda recebe filho do target

                } else { // se o no a direita do pai for o target
                    parent.right = child;// no a direita recebe o filho do target
                }
            }
        }

        size--;
        return removed;
    }

    // public E min(){
    //     if(isEmpty())return null;
    //     Node auxNode = root;
    //     while (auxNode.left != null) {

    //           auxNode = auxNode.left;
    //     }
    //     return auxNode.value;
    // }

    //  public E max(){
    //     if(isEmpty())return null;
    //     Node auxNode = root;
    //     while (auxNode.right != null) {

    //           auxNode = auxNode.right;
    //     }
    //     return auxNode.value;
    // }


    @Override
    public E get(E value) {
        Node auxNode = root;
        while (auxNode != null) {
            int compacao = compare(value, auxNode);
            if (compacao == 0) {
                return auxNode.value;
            } else if (compacao < 0) {
                auxNode = auxNode.left;
            } else {
                auxNode = auxNode.right;
            }
        }
        return null;
    }

    // Node auxNode = root;
    // Node newNode = new Node(value);
    // while (auxNode != null) {
    // int comparacao = compare(newNode, auxNode);
    // if (comparacao == 0) {
    // return auxNode.value;// se os dois forem iguais ele ja retorna
    // } else if (comparacao < 0) {
    // auxNode = auxNode.left;// se auxNode tiver mais prioridade entao vamos para
    // esquerda e novamente
    // // fazemos a verificação de igualdade
    // } else {
    // auxNode = auxNode.right;// se new Node tem mais prioridade passamos a direita
    // e novamente fazemos a
    // // verificação de igualdade
    // }
    // }
    // return null;

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node auxNode = root;
            while (auxNode != null) {
                if (compare(newNode, auxNode) == 0) {
                    return;// nao vamos ter duplicatas!
                } else if (compare(newNode, auxNode) < 0) {// o1 newNode e o2 auxNode
                    if (auxNode.left == null) {
                        auxNode.left = newNode;
                        break;// achou a posiçao e inseriu
                    }
                    auxNode = auxNode.left;// para continuar navegando
                } else {
                    if (auxNode.right == null) {
                        auxNode.right = newNode;
                        break;// achou a posiçao e inseriu
                    }
                    auxNode = auxNode.right;// para continuar navegando
                }
            }
        }
        size++;// aumentamos size
    }

    public void clear(){
        root = null;
        size = 0;
    }

    public void printNodesByLevel(int level) {
        printNodesByLevel(root, level);
    }

    private void printNodesByLevel(Node current, int level) {
    if (current == null) return;

    if (level == 0) {
        System.out.print(current.value + " ");
    } else {
        // direita primeiro, depois esquerda (inverso do comum!)
        printNodesByLevel(current.right, level - 1);
        printNodesByLevel(current.left, level - 1);
    }
}

    private String breadthFirstSearch() {// BFS->POR NIVEL E DA ESQUERDA PARA DIREITA
        DynamicQueue<Node> queue = new DynamicQueue<>();// fila auxiliar

        if (!isEmpty()) {// Se a árvore não estiver vazia, colocamos a raiz na fila.
            queue.enqueue(root);// adiciona a raiz na fila e posteriormente pega seus filhos
        }
        String treeData = "";
        while (!queue.isEmpty()) {
            Node auxNode = queue.dequeue();// pega o ultimo no que foi inserido, no caso root
            treeData += auxNode.value;// treeData recebe ele mesmo mais o auxNode.value
            if (auxNode.left != null) {
                queue.enqueue(auxNode.left);// adiciona o filho a esquerda na fila
            }
            if (auxNode.right != null) {
                queue.enqueue(auxNode.right);// adiciona o filho a direita na fila
            }

            if (!queue.isEmpty())
                treeData += ", ";
        }
        return treeData;
    }

    
    private String preOrder(Node current) {
        if (current == null) return "";
        String result = "";

        result += current.value + " ";
        result += preOrder(current.left);
        result += preOrder(current.right);

        return result;
    }

    private String inOrder(Node current) {
        if (current == null) return "";
        String result = "";

        result += inOrder(current.left);
        result += current.value + " ";
        result += inOrder(current.right);

        return result;
    }

    private String posOrder(Node current) {
        if (current == null) return "";
        String result = "";

        result += posOrder(current.left);
        result += posOrder(current.right);
        result += current.value + " ";

        return result;
    }

    @Override
    public String treeTraversal(String type) {
        if (type.equals("bfs")) {// tem que escrever para retornar o BFS
            return breadthFirstSearch();
        } else {
            if (type.equals("inOrder")) {// esquerda raiz direita

                return inOrder(root);
            } else if (type.equals("preOrder")) {// raiz esquerda direita

                return preOrder(root);
            } else if (type.equals("postOrder")) {// esquerda direita raiz

                return posOrder(root);
            } else {
                return "";
            }
        }

    }

    @Override
    public String toString() {// se chamar o sout sem especifcar qual ela quer que mostre entao sera
                              // automaticamente chamado o toString, ou seja BFS
        return breadthFirstSearch();
    }

}
