// Generic class and type parameter relation?
// Node works as like pointer & why Type parameter is applied for the pointer not specific type of Data type

import java.util.ArrayList;

public class ImplementLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Internal Node class to represent data with type parameter of generic
    private class Node<T> {

        // Declare variable to which data info to be assigned and reference variables
        private T data;
        private Node<T> prev, next;

        // Declare constructor for "Node" class
        public Node(T data, Node<T> prev, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        // toString method to get data stored in each node
        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty the linkedList, O(n)
    public void clear() {
        Node<T> traverse = head;
        // null value indicates that the list is empty (has no nodes)
        while (traverse != null) {
            Node<T> next = traverse.next;
            traverse.prev = traverse.next = null;
            traverse.data = null;
            traverse = next;
        }

        head = null;
//      tail = traverse = null
        size = 0;
        System.out.println("All cleared");
    }

    // Return the size of this linked list
    public int size() {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
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
        size++;
    }

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem) {
        // If the LinkedList is empty, newly created node become head and tail at the same time
        // And it doesn't have any previous or next reference value
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // Add an element at a specific index
    public void addAt(int index, T data) throws Exception {
        // if index is out of range, system will throw error
        if (index < 0 || index > size) {
            throw new Exception("Illegal Index");
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }
        // if index to which new node will be inserted none of first, last index neither out of valid index range,
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    public T removeFirst() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the head and move
        // the head pointer forwards one node
        T data = head.data;
        head = head.next;
        --size;

        // If the list is empty set the tail to null
        if (isEmpty()) tail = null;

            // Do a memory cleanup of the previous node
        else head.prev = null;

        // Return the data that was at the first node we just removed
        return data;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public T removeLast() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the tail and move
        // the tail pointer backwards one node
        T data = tail.data;
        tail = tail.prev;
        --size;

        // If the list is now empty set the head to null
        if (isEmpty()) head = null;

            // Do a memory clean of the node that was just removed
        else tail.next = null;

        // Return the data that was in the last node we just removed
        return data;
    }

    // Remove an arbitrary node from the linked list, O(1)
    private T remove(Node<T> node) {
        // If the node to remove is somewhere either at the
        // head or the tail handle those independently
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        // Make the pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // Temporarily store the data we want to return
        T data = node.data;

        // Memory cleanup
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        // Return the data in the node we just removed
        return data;
    }

    // Remove a node at a particular index, O(n)
    public T removeAt(int index) {
        // Make sure the index provided is valid
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        int i;
        Node<T> trav;

        // Search from the front of the list
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
            // Search from the back of the list
        } else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            // Search for non-null object
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> traverse = head;

        // Support searching for null
        if (obj == null) {
            for (; traverse != null; traverse = traverse.next, index++) {
                if (traverse.data == null) {
                    return index;
                }
            }
            // Search for non-null object
        } else {
            for (; traverse != null; traverse = traverse.next, index++) {
                if (obj.equals(traverse.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    // Check is a value is contained within the linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    // Collection Interface extends Iterable Interface and "iterator() method" defined in the Iterable interface can be used
    // And "iterator() method" calls for Iterator Interface again
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> traverse = head;

            @Override
            public boolean hasNext() {
                return traverse != null;
            }

            @Override
            public T next() {
                T data = traverse.data;
                traverse = traverse.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // To print out Array elements
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> traverse = head;
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
