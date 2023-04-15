import java.util.ArrayList;

public class ImplementArrayList<T> {
    public static void main(String[] args) {
        ArrayList<Integer> integer_ArrayList = new ArrayList<>();
        integer_ArrayList.add(1);
        integer_ArrayList.add(2);
        integer_ArrayList.add(3);
        integer_ArrayList.add(1,20);

        ArrayList<Integer> integer_ArrayList2 = new ArrayList<>();
        integer_ArrayList2.addAll(integer_ArrayList);

        ArrayList<String> string_ArrayList = new ArrayList<>();
        string_ArrayList.add("Aiso");
        string_ArrayList.add("Biso");
        string_ArrayList.add("Ciso");
    }

}
