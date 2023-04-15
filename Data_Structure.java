import java.util.ArrayList;

public class Data_Structure {
    public static void main(String[] args) {
        ArrayList<Integer> myInts = new ArrayList <Integer>(25);

        for (int i=0;i<11;i++){
            myInts.add(3*i);
        }

        myInts.set(5,44);
        System.out.println(myInts.size());
        for (int i=0;i< myInts.size();i++){
            System.out.print(myInts.get(i));
        }
    }
}
