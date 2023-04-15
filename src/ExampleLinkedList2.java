//public class ExampleLinkedList2<T extends Cache_Node> {
//    public static void main(String[] args) {
//        Cache_Node cache_node1 = new Cache_Node(11111, 22222, 33333, "D10000", "String");
//        Cache_Node cache_node2 = new Cache_Node(11112, 22223, 33334, "D10001", "int");
//        Cache_Node cache_node3 = new Cache_Node(11113, 22224, 33335, "D10002", "Object");
//    }
//
//    Node<T> Last_Recently_visited;
//    Node<T> Most_Recently_visited;
//
//    class Node<T extends Cache_Node> {
//        T cache_info;
//        Node<T> previous;
//        Node<T> next;
//
//        public Node(T cache_info) {
//            this.previous = null;
//            this.cache_info = cache_info;
//            this.next = null;
//        }
//
//        public Node(T cache_info, Node<T> previous, Node<T> next) {
//            this.cache_info = cache_info;
//            this.previous = previous;
//            this.next = next;
//        }
//    }
//
//    public String toString() {
//        Node<T> traverse = Last_Recently_visited;
//        String str = "";
//        while (Last_Recently_visited != null) {
//            str = Last_Recently_visited.cache_info + "\n";
//        }
//        return str;
//    }
//
//    public boolean isEmpty() {
//        return Last_Recently_visited == null;
//    }
//
//    public int cache_Size() {
//        int size = 0;
//        Node<T> traverse = Last_Recently_visited;
//        while (traverse != null) {
//            size++;
//            traverse = traverse.next;
//        }
//        return size;
//    }
//
//    public void add(T elem) {
//        addLast(elem);
//    }
//
//    public void addLast(T elem) {
//        if (isEmpty()) {
//            Most_Recently_visited = Last_Recently_visited = new Node<T>(elem);
//        } else
//            Most_Recently_visited.next = new Node<T>(elem);
//    }
//
//    public void addFirst(T elem) {
//        if (isEmpty()) {
//            Most_Recently_visited = Last_Recently_visited = new Node<T>(elem);
//        } else {
//            Node<T> New_Last_Recently_visited = new Node<T>(elem);
//            Last_Recently_visited.previous = New_Last_Recently_visited;
//        }
//    }
//
//    public T removeFirst() {
//        if (isEmpty()) {
//            throw new IndexOutOfBoundsException();
//        } else Last_Recently_visited.next.previous = null;
//        Last_Recently_visited = Last_Recently_visited.next;
//        return Last_Recently_visited.cache_info;
//    }
//
//    public T removeLast() {
//        if (isEmpty()) {
//            throw new IndexOutOfBoundsException();
//        } else Most_Recently_visited = Most_Recently_visited.next;
//        return Most_Recently_visited.cache_info;
//    }
//
//    public void removeAll() {
//        Node<T> traverse = Last_Recently_visited;
//        while (traverse != null) {
//            traverse.cache_info = null;
//            traverse = traverse.next;
//        }
//    }
//}

