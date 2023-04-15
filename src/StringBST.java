// Create a new tree which can only store Strings. In that new class create a method
// which returns the length of all the strings in the tree. Create a method which prints out
// all the strings which are of length 5 or greater only

import java.util.ArrayList;

public class StringBST<T> extends BinarySearchTree {

    public static void main(String[] args) {
        StringBST<String> strings = new StringBST();
        strings.insert("A");
        strings.insert("BC");
        strings.insert("DEF");
        strings.insert("GHIJ");
        strings.insert("KLMNO");
        strings.insert("PQRSTU");

//        System.out.println(strings.lengthOfAllString());
        strings.lengthEqualOrBiggerThanFive();
    }

    @Override
    public void insert(Comparable element) {
        super.insert(element);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void display() {
        super.display();
    }

    public int lengthOfAllString() {
        if (isEmpty()) {
            throw new TreeEmptyException();
        } else {
            return lengthOfAllStringHelper(root);
        }
    }

    private int lengthOfAllStringHelper(BTNode current) {
        int lengthOfAllStringSum = 0;
        // Exit point for recursive function
        if (current != null) {
            lengthOfAllStringSum += current.element.toString().length() + lengthOfAllStringHelper(current.left) + lengthOfAllStringHelper(current.right);
        }
        return lengthOfAllStringSum;
    }

    public void lengthEqualOrBiggerThanFive() {
        if (isEmpty()) {
            throw new TreeEmptyException();
        } else {
            lengthEqualOrBiggerThanFiveHelper(root);
        }
    }

    private void lengthEqualOrBiggerThanFiveHelper(BTNode current) {
//        String lengthEqualOrBiggerThanFive = "";
//        ArrayList<String> lengthEqualOrBiggerThanFiveList = new ArrayList<String>();

        // Exit point for recursive function
        if (current != null) {
            if (current.element.toString().length() >= 5)
                System.out.println(current.element);

            lengthEqualOrBiggerThanFiveHelper(current.left);
            lengthEqualOrBiggerThanFiveHelper(current.right);
        }
    }
    // Solution Sample
    //    public class StringBST extends BinarySearchTree<String> {

//        //inside main we are creating an instance of the StringBST and adding some words into the tree.
//        public static void main(String[] args) {
//            StringBST string = new StringBST();
//            string.insert("Hello");
//            string.insert("World");
//            string.insert("How");
//            string.insert("Are");
//            string.insert("You");
//
//            int length  = string.totalLength();
//            System.out.println("length = " + length);
//            string.printGreaterThan(5);
//        }
//
//        //We would like to calculate the total length of the collection of words in the tree.
//        public int totalLength(){
//            return totalLength(root);
//        }
//
//        private int totalLength(BTNode<String> current) {
//            if (current == null){ // this is the place we need to stop
//                return 0;
//            } else {
//                // the current.element gives us access to the value within the Node.
//                // if the element is a string invoking the .length() gives us the number of charactors within the string
//                return current.element.length() + totalLength(current.left) + totalLength(current.right);
//            }
//        }
//
//        public void printGreaterThan(int threshold){
//            printGreaterThan(threshold, root);
//        }
//
//        private void printGreaterThan(int threshold, BTNode<String> current) {
//            if (current == null){
//                return;
//            }
//            printGreaterThan(threshold, current.left);
//            if (current.element.length() >= threshold){
//                System.out.println("current = " + current.element);
//            }
//            printGreaterThan(threshold, current.right);
//
//        }
//    }
}
