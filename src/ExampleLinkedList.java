public class ExampleLinkedList<T> implements List<T> {

    // Declare variables head & tail using "Node" class, and initialize it as null
    // When to call "Node" class, no need to create object as it's static
    private ExampleLinkedList.Node<T> head;
    private ExampleLinkedList.Node<T> tail;

    // Constructor for Class "ExampleLinkedList"
    public ExampleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Internal node class to represent data with type parameter of generic
    private static class Node<T> {

        // Declare variable to which data info to be assigned and reference variables
        private T data;
        private Node<T> prev, next;

        // Declare constructor for "Node" class

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    // To check whether the list is empty or not (if head doesn't exist = List doesn't exist from the first place)
    public boolean isEmpty() {
        return head == null;
    }

    // Default function to add elements to the list
    public void add(T elem) {
        addLast(elem);
    }


    public void addBefore(T target, T elem) {
        if (head.data == target) {
            // If head node has target value, newly inserted node becomes head node
            head.prev = new Node<T>(elem, null, head);
        } else {
            // Declare temporal node to save node info which comes prior to target node
            Node temporal = null;
            // This loop will loop through till node is found which is prior to the target node
            for (Node traverse = head; traverse.data != target; temporal = traverse, traverse = traverse.next) ;
            // Create a new node
            Node newNode = new Node(elem);

            // Update the newNode.next so that the newly created node points out to the pre-existing next node
            newNode.next = temporal.next;
        }
    }

    public boolean contain(T target){
        Node<T> traverse = head;
        while(tail !=null){
            if (traverse.data == target) return true;
        }
        return false;
    }

    public void addAfter(T target, T elem) {
        if (tail.data == target) {
            addLast(elem);
        } else {
            Node<T> temporal = null;
            for (Node traverse = head; traverse.data != target; temporal = traverse, traverse = traverse.next) ;

            Node newNode = new Node(elem);
            newNode.next = temporal.next.next;

            temporal.next.next = newNode;
        }
    }

    // Add a node to the tail of the linked list, O(1)
    public void addLast(T elem) {
        // If the LinkedList is empty, newly created node become head and tail at the same time
        // And it doesn't have any previous or next reference value
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
    }

    public T remove(T target) {
        Node<T> traverse = head;
        while (traverse != null) {
            if (traverse.data == target) {
                // If the node to remove is somewhere either at the
                // head or the tail handle those independently
                if (traverse.prev == null) {
                    removeFirst();
                    return traverse.data;
                } else if (traverse.next == null) {
                    removeLast();
                    return traverse.data;
                } else
                    // Make Link between nodes which are precedent and following of Target Node
                    traverse.next.prev = traverse.prev;
                traverse.prev.next = traverse.next;

                // Memory cleanup
                traverse.data = null;
                traverse = traverse.prev = traverse.next = null;
            } else traverse = traverse.next;
        }
        return traverse.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    public void removeFirst() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Remove existing head node by shifting it to node which was following head node
        head = head.next;

        // Do a memory cleanup of the previous node
        head.prev = null;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public void removeLast() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Make node which is prior to tail node as last node
        tail = tail.prev;

        // Do a memory clean of the node that was just removed
        tail.next = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ExampleLinkedList.Node<T> traverse = head;
        while (traverse != null) {
            sb.append(traverse.data);
            if (traverse.next != null) {
                sb.append(", ");
            }
            traverse = traverse.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}

