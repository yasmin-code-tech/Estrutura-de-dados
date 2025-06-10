import collections.BinarySearchTree;
import collections.RecursiveBinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> myBST = new BinarySearchTree<>();
        RecursiveBinarySearchTree<Integer> myBSTRecursive = new RecursiveBinarySearchTree<>();

        myBST.insert(200);
        myBST.insert(50);

        myBST.insert(250);

        myBST.insert(25);

        myBST.insert(55);

        myBST.insert(230);
        myBST.insert(300);
        myBST.insert(60);
        myBST.insert(220);
        myBST.insert(225);
        System.out.println(myBST);
        System.out.println();
        myBST.printNodesByLevel(2);
        System.out.println();
        // 0,1,2 3,10 ,9
        System.out.println(myBST.get(1));
        System.out.println(myBST.delete(200));
        System.out.println(myBST);
        System.out.println(myBST.treeTraversal("inOrder"));
        System.out.println(myBST.treeTraversal("preOrder"));
        System.out.println(myBST.treeTraversal("postOrder"));


        System.out.println("===========================================");

        myBSTRecursive.insert(200);
        myBSTRecursive.insert(50);

        myBSTRecursive.insert(250);

        myBSTRecursive.insert(25);

        myBSTRecursive.insert(55);

        myBSTRecursive.insert(230);
        myBSTRecursive.insert(300);
        myBSTRecursive.insert(60);
        myBSTRecursive.insert(220);
        myBSTRecursive.insert(25);
        myBSTRecursive.insert(225);
        System.out.println(myBSTRecursive.treeTraversal("inOrder"));
        System.out.println(myBSTRecursive.treeTraversal("preOrder"));
        System.out.println(myBSTRecursive.treeTraversal(""));

        // System.out.println(myBSTRecursive);

        // 0,1,2 3,10 ,9
        System.out.println(myBSTRecursive.get(300));
        // System.out.println(myBSTRecursive.delete(200));
        // System.out.println(myBSTRecursive);

    }
}
