public class ImplementLinkedListStack<T> implements StackInterface<T> {

    Node<T> first;

    public class Node<T> {

        public T elem;
        public Node<T> next;

        public Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    // Constructor
    public ImplementLinkedListStack() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void push(T data) {
        if (isEmpty()) {
            this.first = new Node<>(data, null);
        } else {
            Node<T> oldFirst = first;
            this.first = new Node<T>(data, oldFirst);
        }
    }

    @Override
    public T pop() {
        // Base case
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            T top_Element = first.elem;
            first = first.next;
            return top_Element;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            T top_Element = first.elem;
            return top_Element;
        }
    }

    @Override
    public String toString() {
        String str = "From first (";

        Node<T> traverse = first;
        while (traverse != null) {
            str += traverse.elem + " ";
            traverse = traverse.next;
        }

        return str;
    }

    public static void main(String[] args) {
        ImplementLinkedListStack linkedList_stack = new ImplementLinkedListStack<>();
        linkedList_stack.push(1);
        linkedList_stack.push(2);
        linkedList_stack.push(3);

        System.out.println(linkedList_stack.toString());
        System.out.println(linkedList_stack.first.elem);
        System.out.println(linkedList_stack.isEmpty());
    }
}
