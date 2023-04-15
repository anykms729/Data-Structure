import java.awt.*;

public class ExampleLinkedList4<T extends CarNode> {
    Node<T> head = null;
    Node<T> tail = null;

    public static void main(String[] args) {
        // Create Instances of "CarNode" Class
        CarNode car_node1 = new CarNode("19-D-21", "Keith Maycock", "08X 8736271", "The car only had 3 wheels", 100, "Ready for Collection");
        CarNode car_node2 = new CarNode("29-D-21", "Aiso", "08X 8393494", "The car only had 3 wheels", 200, "Not Ready for Collection");
        CarNode car_node3 = new CarNode("39-D-21", "Biso", "08X 8291393", "Window broken", 300, "Not Ready for Collection");
        CarNode car_node4 = new CarNode("49-D-21", "Ciso", "08X 8484222", "The car only had 2 wheels", 400, "Not Ready for Collection");
        CarNode car_node5 = new CarNode("59-D-21", "Diso", "08X 8102292", "The car only had 3 wheels", 400, "Ready for Collection");

        ExampleLinkedList4 car_node_linked_list = new ExampleLinkedList4();
        car_node_linked_list.add(car_node1);
        car_node_linked_list.add(car_node2);
        car_node_linked_list.add(car_node3);
        car_node_linked_list.add(car_node4);
        car_node_linked_list.add(car_node5);

        System.out.println("Total number of cars: " + car_node_linked_list.size());
        System.out.println("Head node: " + car_node_linked_list.head.data);
        System.out.println("Tail node: " + car_node_linked_list.tail.data);
        System.out.println("Detail of cars at the service center: " + car_node_linked_list.toString());
        System.out.println("Ready to be collected: " + car_node_linked_list.readySize());
        System.out.println("Not ready to be collected: " + car_node_linked_list.currentProblems());
        System.out.println("Average fixing cost: Euro " + car_node_linked_list.get_average());
        car_node_linked_list.remove("39-D-21");
        System.out.println("Total number of cars after removed: " + car_node_linked_list.size());
    }

    public class Node<T> {
        Node<T> previous;
        T data;
        Node<T> next;

        public Node(T data) {
            this.previous = null;
            this.data = data;
            this.next = null;
        }

        public Node(Node<T> previous, T data, Node<T> next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    // Default function to add elements to the list
    public void add(T car_node) {
        addLast(car_node);
    }

    // Add a node to the tail of the linked list, O(1)
    public void addLast(T car_node) {
        // If the LinkedList is empty, newly created node become head and tail at the same time
        // And it doesn't have any previous or next reference value
        if (isEmpty()) {
            head = tail = new Node<T>(null, car_node, null);
        } else {
            tail.next = new Node<T>(tail, car_node, null);
            tail = tail.next;
        }
    }

    public int size() {
        Node<T> traverse = head;
        int size = 0;
        while (traverse != null) {
            size++;
            traverse = traverse.next;
        }
        return size;
    }

    public int readySize() {
        Node<T> traverse = head;
        int carToBeCollected = 0;

        while (traverse != null) {
            if (traverse.data.getCar_Status() == "Ready for Collection") {
                carToBeCollected++;
                traverse = traverse.next;
            } else traverse = traverse.next;
        }
        return carToBeCollected;
    }

    public int currentProblems() {
        Node<T> traverse = head;
        int carNotToBeCollected = 0;

        while (traverse != null) {
            if (traverse.data.getCar_Status() != "Ready for Collection") {
                carNotToBeCollected++;
                traverse = traverse.next;
            } else traverse = traverse.next;
        }
        return carNotToBeCollected;
    }

    public int get_average() {
        int average = 0;
        Node<T> traverse = head;

        while (traverse != null) {
            average += traverse.data.getCost_Of_Fixing_The_Problem();
            traverse = traverse.next;
        }
        average = average / size();
        return average;
    }

    public void remove(String Registration) {
        Node<T> traverse = head;
        do {
            if (traverse.data.getRegistration() == Registration) {
                if (traverse.previous == null) {
                    removeFirst();
                    return;
                } else if (traverse.next == null) {
                    removeLast();
                    return;
                } else traverse.previous.next = traverse.next;
                return;
            } else traverse = traverse.next;
        } while (traverse != null);
        System.out.println("Registration number is not found");
        return;
    }

    public CarNode removeFirst() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // In case at least one node exists, extract the data at the head and move, the head pointer forwards one node
        CarNode data = head.data;
        head = head.next;

        // If the list is empty set the tail to null
        if (isEmpty()) head = tail = null;

            // Do a memory cleanup of the previous node
        else head.previous = null;

        // Return the data that was at the first node that was just removed
        return data;
    }

    public CarNode removeLast() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // In case at least one node exists (head = tail), extract the data at the tail and move and the tail pointer backwards one node
        CarNode data = tail.data;
        tail = tail.previous;

        // If the list is now empty set the head to null
        if (isEmpty()) head = tail = null;

            // Do a memory clean of the node that was just removed
        else tail.next = null;

        // Return the data that was in the last node which was just removed
        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> traverse = head;
        while (traverse != null) {
            sb.append(traverse.data);
            if (traverse.next != null) {
            }
            traverse = traverse.next;
        }
        sb.append("]");
        return sb.toString();
    }

}



