import collections.BinarySearchTree;
import collections.RecursiveBinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        RecursiveBinarySearchTree<Integer> myBST = new RecursiveBinarySearchTree<>();

        myBST.insert(200);
        myBST.insert(100);
        myBST.insert(250);
        myBST.insert(5);
        myBST.insert(150);
        myBST.insert(235);
        myBST.insert(300);
        myBST.insert(125);
        myBST.insert(170);
        myBST.insert(220);
        myBST.insert(110);
        myBST.insert(225);
        System.out.println(myBST);
        
      

    }
}
