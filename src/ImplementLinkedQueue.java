// Class definition
// Instance variables
// Constructor
// isEmpty method
// size method
// add an element
// remove an element
// toString method

public class ImplementLinkedQueue<T> {
    public static void main(String[] args) {
        ImplementLinkedQueue linkedList_queue = new ImplementLinkedQueue();
        linkedList_queue.enqueue("Aiso");
        linkedList_queue.enqueue("Biso");
        linkedList_queue.enqueue("Ciso");

        System.out.println(linkedList_queue.toString());
    }

    private Node front;
    private Node rear;
    private int length;

    public ImplementLinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    // Create Node class
    private class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Create constructor for the Node class
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T result = (T) front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        System.out.println(result + " is removed!");
        return result;
    }

    public void enqueue(T data) {
        Node temp = new Node(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String toString() {
        Node<T> traverse = front;
        String str = "";
        while (traverse != null) {
            str += traverse.data+"\n";
            traverse = traverse.next;
        }
        return str;
}}

