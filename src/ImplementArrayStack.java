import java.lang.reflect.Array;
import java.util.Arrays;

public class ImplementArrayStack<T> implements StackInterface<T> {
    public static void main(String[] args) {
        ImplementArrayStack array_stack = new ImplementArrayStack(5);
        array_stack.push("Aiso");
        array_stack.push("Biso");
        array_stack.push("Ciso");
        array_stack.push("Diso");

        System.out.println(array_stack.toString());
        System.out.println(array_stack.pop());
        System.out.println(array_stack.toString());
    }

    private int size;
    private int top;
    private T[] items;

    public ImplementArrayStack(int size) {
        this.size = size;
        this.top = -1;
        this.items = (T[]) new Object[size];
    }

    public void reallocate() {
        size *= 2;
        items = Arrays.copyOf(items, size);
    }

    @Override
    public void push(T elem) {
        if (top == size - 1) {
            reallocate();
        }
        top++;
        items[top] = elem;
    }

    @Override
    public T pop() {
        if (top == -1){
            throw new IndexOutOfBoundsException();
        }
        else {
            T value = items[top];
            top--;
            return value;
        }
    }

    @Override
    public T peek() {
        if (top ==-1){
            throw new IndexOutOfBoundsException();
        }
        else {
            T value = items[top];
            return value;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i=top; i>=0;i--){
            str += items[i]+" ";
        }
        return str;
    }
}
