public class BinarySearchTree<T extends Comparable<T>> {
    BTNode<T> root;

    public static void main(String[] args) {
        BinarySearchTree<Integer> numbers = new BinarySearchTree<>();
        numbers.insert(12);
        numbers.insert(4);
        numbers.insert(6);
        numbers.insert(5);
        numbers.insert(8);
        numbers.insert(34);
        numbers.insert(100);
        numbers.insert(2);


        System.out.println("------------------");
        numbers.inOrder(numbers.root);

        System.out.println("------------------");
        System.out.println("Size of BST: " + numbers.size());

        System.out.println("------------------");
        System.out.println("Max elem of BST: " + numbers.findMax());

        System.out.println("------------------");
        System.out.println("Min elem of BST: " + numbers.findMin());

        System.out.println("______________________");
        numbers.remove(4);

        System.out.println("______________________");
        numbers.inOrder(numbers.root);

        System.out.println("______________________");
    }

    public void inOrder(BTNode<T> current) {
        if (current == null)
            return;

        // traverse the left child
        inOrder(current.left);

        // traverse the root node
        System.out.print(current.element + " → ");

        // traverse the right child
        inOrder(current.right);
    }


    public class BTNode<T> { // class definition..

        //instances variables...we have an object of type T and then also we are referring to a left and a right node...
        protected T element;
        protected BTNode<T> left;
        protected BTNode<T> right;


        public BTNode(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            String leftVal = (left == null ? "NULL" : left.element.toString());
            String rightVal = (right == null ? "NULL" : right.element.toString());
            return "BTNode {" + "element=" + element + ", left=" + leftVal + ", right=" + rightVal + '}';
        }
    }


    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        //we need to be able to traverse the tree...
        return size(root);
    }

    private int size(BTNode<T> current) {
        //everytime we see a Node we have to add one to a counter...
        if (current == null) { // if the Node doesn't exist return 0
            return 0;
        } else {
            //with the else we are saying that we found a node.
            //we should increment our counter and then search the left and right subtrees.
            //we know in trees that we have a left subtree and a right subtree...
            return 1 + size(current.left) + size(current.right);
        }
    }

    public void insert(T element) {
        if (isEmpty()) {
            root = new BTNode<>(element);
        } else {
            insertHelper(element, root);
        }
    }

    private void insertHelper(T element, BTNode<T> current) {
        //we are going to start the search for the position
        if (element.compareTo(current.element) == -1) {
            //when the comparison is less than zero the new object is less and must be placed in the
            //left subtree.
            if (current.left == null) {
                //this is where there is no child Node and we place the new object as the child node
                current.left = new BTNode<>(element);
            } else {
                insertHelper(element, current.left);
            }
        } else { //this else is called when the new Node is greater than the object that we are comparing
            if (current.right == null) { // if there is no child Node on the right
                current.right = new BTNode<>(element);//we create the child Node on the right
            } else {//there was a child Node on the right...
                insertHelper(element, current.right);
            }
        }
    }

    public T findMax() {
        //this is going to be the object in the rightmost part of the tree...
        if (isEmpty()) {
            throw new TreeEmptyException();
        } else {
            return findMax(root);
        }
    }

    private T findMax(BTNode<T> current) {
        if (current.right == null) {
            return current.element;
        } else {
            return findMax(current.right);
        }
    }


    public T findMin() {
        //this is going to be the object in the leftmost part of the tree...
        // we need to search through the tree and find the Node at the bottom left
        if (isEmpty()) {
            throw new TreeEmptyException();
        } else {
            return findMin(root);
        }
    }

    private T findMin(BTNode<T> current) {
        //we know the smallest value is going to be on the left
        if (current.left == null) {
            return current.element;
        } else {
            return findMin(current.left);
        }
    }

    public void display() {
        displayHelper(root);
    }

    // For Inorder, you traverse from the left subtree to the root then to the right subtree.
    private void displayHelper(BTNode<T> root) {
        // In-order Traversal
        if (root != null) {
            displayHelper(root.left);
            System.out.print(root.element + " ");
            displayHelper(root.right);
        }
    }

    public boolean contains(T element) {
        return contains(element, root);
    }

    private boolean contains(T element, BTNode<T> current) {
        String currentPos = (current == null ? "NULL" : current.element.toString());
        System.out.println("Searching for " + element + " currently at " + currentPos);
        if (current == null) {
            return false;
        }

        if (element.compareTo(current.element) == 0) {
            System.out.println("We found equality");
            return true;
        } else if (element.compareTo(current.element) <= -1) {
            System.out.println("We are going to the left");
            return contains(element, current.left);
        } else {
            System.out.println("Going to the right");
            return contains(element, current.right);
        }
    }


    // For Preorder, you traverse from the root to the left subtree then to the right subtree.
    // For Post order, you traverse from the left subtree to the right subtree then to the root.

    private BTNode<T> findNode(T elem) {
        return findNode(elem, root);
    }

    private BTNode<T> findNode(T elem, BTNode<T> current) {
        if (current == null) {
            return null;
        }
        if (current.element.equals(elem)) {
            return current;
        } else if (current.element.compareTo(elem) == -1) {//new is bigger
            return findNode(elem, current.right);
        } else {
            return findNode(elem, current.left);
        }
    }

    public boolean remove(T element) {
        // we need to locate the node which we must remove
        BTNode<T> toRemove = findNode(element);
        if (toRemove == null) {
            System.out.println("not found");
            return false;
        }
        System.out.println("toRemove = " + toRemove);
        // we need to find its parent as well
        BTNode<T> parent = findParent(element);
        System.out.println("parent = " + parent);

        // to do the simplest case which is the removal of a leaf node
        if (toRemove.left == null && toRemove.right == null) {
            // determine which child it is
            if (toRemove.element.compareTo(parent.element) == -1) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;

        } else if (toRemove.left != null && toRemove.right == null) {
            // in this case the node has a left child but no right child.
            // its important that we are not getting rid of the Nodes just changing the
            // data piece of the object...
            if (toRemove.element.compareTo(parent.element) == -1) {
                // the removed node is the left child
                parent.left = toRemove.left;
            } else {
                // it's the right child
                parent.right = toRemove.left;
            }
            return true;
        } else if (toRemove.left == null && toRemove.right != null) {
            if (toRemove.element.compareTo(parent.element) == -1) {
                parent.left = toRemove.right;
            } else {
                parent.right = toRemove.right;
            }
            return true;
        } else if (toRemove.left != null && toRemove.right != null) {
            // it has both a left and right child
            // find the max value in the left subtree rooted at the current node
            // or the minimum value of the right subTree...
            T minValue = findMin(toRemove.right);
            BTNode<T> replacement = findNode(minValue);
            BTNode<T> replacementParent = findParent(minValue);
            System.out.println("replacementParent = " + replacementParent);

            /*
                T maxValue = findMax(toRemove.right);
                System.out.println("maxValue = " + maxValue);
                BTNode<T> replacement = findNode(maxValue);
                BTNode<T> replacementParent = findParent(maxValue);
          */

            // we dont actually change the value of the Node we simply
            // change the value of the contents...
            replacementParent.left = null;
            toRemove.element = replacement.element;
            return true;
        }
        System.out.println("parent = " + parent);
        return false;
    }

    private BTNode<T> findParent(T element) {
        return findParent(element, root);
    }

    private BTNode<T> findParent(T element, BTNode<T> current) {
        // special case
        if (element.equals(root.element)) {
            return null;
        }
        if (element.compareTo(current.element) == -1) {
            if (current.left == null) {
                // not in the tree
                return null;
            } else if (element.compareTo(current.left.element) == 0) {
                return current;
            } else {
                return findParent(element, current.left);
            }
        } else {
            if (current.right == null) {
                return null;
            } else if (element.compareTo(current.right.element) == 0) {
                return current;
            } else {
                return findParent(element, current.right);
            }
        }
    }
}


