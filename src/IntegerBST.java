import java.util.ArrayList;

public class IntegerBST<T> extends BinarySearchTree {


    public static void main(String[] args) {
        IntegerBST<Integer> numbers = new IntegerBST<>();
        numbers.insert(3);
        numbers.insert(5);
        numbers.insert(4);
        numbers.insert(2);
        numbers.insert(7);

        System.out.println("------------------");
        numbers.display();
        System.out.println();

        System.out.println("------------------");
        System.out.println("Sum of BST: " + numbers.sum());

        System.out.println("------------------");
        System.out.println("Product of BST: " + numbers.product());

        System.out.println("------------------");
        numbers.even();
    }

    @Override
    public void inOrder(BTNode current) {
        super.inOrder(current);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void insert(Comparable element) {
        super.insert(element);
    }

    public int sum() {
        if (isEmpty()) {
            throw new TreeEmptyException();
        } else {
            return sumHelper(root);
        }
    }

    private int sumHelper(BTNode current) {
        int nodeSum = 0;
        // Exit point for recursive function
        if (current != null) {
            nodeSum += (int) current.element + sumHelper(current.left) + sumHelper(current.right);
        }
        return nodeSum;
    }

    private double product() {
        if (isEmpty()) {
            throw new TreeEmptyException();
        } else {
            return productHelper(root);
        }
    }

    private double productHelper(BTNode current) {
        int nodeProduct = 1;
        // Exit point for recursive function
        if (current != null) {
            nodeProduct *= (int) current.element * productHelper(current.left) * productHelper(current.right);
        }
        return nodeProduct;
    }

    private void even() {
        if (isEmpty()) {
            throw new TreeEmptyException();
        } else {
            evenHelper(root);
        }
    }

    private ArrayList<Integer> evenHelper(BTNode current) {
        ArrayList<Integer> evenList = new ArrayList();
        // Exit point for recursive function
        if (current != null) {
            if (((int) current.element) % 2 != 0) {
                evenList.add((int) current.element);
            }
            evenHelper(current.left);
            evenHelper(current.right);
        }
        return evenList;
    }

    // Sample Solution
    //Here we are creating our IntegerBST by extending our original BinarySearchTree
    /*public class IntegerBST extends BinarySearchTree<Integer> {



        // We need to create a method that prints out the value of the node when the value is even....
*//*
    We need to get access to the Node value... Node.element gives us the value....
    We need to check if the value of the Node is even: if NUM % 2 == 0 => the mod operator checks to see if the remainder of the
    calculation is == 0.
    We also need to print out to the standard output...System.out.print...
    We need to search the full tree of Nodes
*//*
        public void findEven() {
            findEven(root);
        }

        private void findEven(BTNode<Integer> current) {
            if (current == null){
                return;
            }
            findEven(current.left);
            if ((current.element % 2) == 0){
                System.out.println("Num Found = " + current.element);
            }
            findEven(current.right);
        }


        public int product() {
            return product(root);
        }

        private int product(BTNode<Integer> current) {
            if (current.left == null && current.right == null) {
                return current.element;
            } else if (current.left == null && current.right != null) {
                return current.element * product(current.right);
            } else if (current.left != null && current.right == null) {
                return current.element * product(current.left);
            } else {
                return current.element * product(current.left) * product(current.right);
            }
        }


        public int calcSUM(BTNode<Integer> current){
            if(current == null){
                return 0;
            }else{
                return current.element + calcSUM(current.left) +calcSUM(current.right);
            }
        }

        //The first method that we are looking at is to calculate the SUM of the values in the tree
        // the return type should be of type int. Inside this method we make a call to the SUM method that requires a node.
        public int sum() {
            return sum(root);
        }

        //The idea of the SUM method is to able to traverse the tree adding all the values along the way...
        // This method when called returns the value of the Node to be added to the running total and also the search that is required to
        // progress through the full tree.
        private int sum(BTNode<Integer> current) {
            //The base case of the search is when we reach a leaf Node. This is where we have no other elements to traverse.
            //we check to see if there is nothing below the current Node and if this is the case we simply return the value of the element
            //and stop the search...
            if (current.left == null && current.right == null) {
                System.out.println(current.element + " is a leaf node");
                return current.element;// remember the current.element is the value of the Node...
            } else if (current.left == null && current.right != null) {
                //This is the case when we have no nodes to the left of the current node and a node to the right of the current node...
                System.out.println("the node " + current.element + " has only a right subtree rooted at " + current.right.element);
                // we want to return the value of the element added to the result from exploring the right subtree.
                return current.element + sum(current.right);
            } else if (current.left != null && current.right == null) {
                System.out.println("the node " + current.element + " has only a left subtree rooted at " + current.left.element);
                return current.element + sum(current.left);
            } else {
                System.out.println("the node " + current.element + " has both subtrees " + current.left.element + ", and " + current.right.element);
                return current.element + sum(current.left) + sum(current.right);
            }
        }
        public static void main(String[] args) {
            // here we are going to initialise a new IntegerBST
            IntegerBST numbers = new IntegerBST();
            // we are just adding in new Integers into our tree.
            numbers.insert(12);
            numbers.insert(4);
            numbers.insert(3);
            numbers.insert(100);
            numbers.insert(2);
            numbers.insert(10);
            //making a call to the method sum() to calculate the sum of all the values within the tree.
            int sum = numbers.sum();
            int calS = numbers.sum(numbers.root);

            int prodS = numbers.calcProduct(numbers.root);
            int prod = numbers.product();
            System.out.println("sum = " + sum);
            System.out.println("the cal sum is = " + calS);
            System.out.println("product = " + prod);
            System.out.println("new product = " + prodS);
            numbers.findEven();
        }*/

}

