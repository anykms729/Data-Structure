// Class definition
// Instance variables
// Constructor
// isEmpty method
// size method
// add an element
// remove an element
// toString method

 import java.util.Arrays;

public class ImplementArrayQueue<T> {
    public static void main(String[] args) {
        ImplementArrayQueue array_queue = new ImplementArrayQueue(5);
        array_queue.push("Aiso");
        array_queue.push("Biso");
        array_queue.push("Ciso");
        array_queue.push("Diso");

        System.out.println(array_queue.toString());
        System.out.println(array_queue.pop());
        System.out.println(array_queue.toString());
    }

    private int size;
    private int top;
    private T[] items;

    public ImplementArrayQueue(int size) {
        this.size = size;
        this.top = -1;
        this.items = (T[]) new Object[size];
    }

    public void reallocate() {
        size *= 2;
        items = Arrays.copyOf(items, size);
    }

    public void push(T elem) {
        if (top == size - 1) {
            reallocate();
        }
        top++;
        items[top] = elem;
    }

    public T pop() {
        int temp;
        if (top == -1) {
            throw new EmptyQueueException();
        } else {
            T value = items[0];
            for (int i=0; i<top;i++){
                items[i] = items[i+1];
            }
            items[top] = null;
            top--;
            return value;
        }
    }

    public T peek() {
        if (top == -1) {
            throw new EmptyQueueException();
        } else {
            T value = items[0];
            return value;
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i <=top; i++) {
            str += items[i] + " ";
        }
        return str;
    }
}


