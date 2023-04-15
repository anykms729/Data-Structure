import javax.xml.crypto.Data;
import java.util.*;

public class DataStructureGeneral {
    public static void main(String[] args) {
        DataStructureGeneral data_structure = new DataStructureGeneral();
//        data_structure.generic_Implementation("String 1");
//        data_structure.generic_Implementation('B');
//        data_structure.generic_Implementation(3);
//        data_structure.linkedList_Implementation();
        ImplementLinkedList linkedList_logic = new ImplementLinkedList();
        linkedList_logic.addFirst("Miso");
        linkedList_logic.add("Biso");
        linkedList_logic.addFirst("Aiso");
        linkedList_logic.add(null);
        System.out.println(linkedList_logic.indexOf(null));
        System.out.println(linkedList_logic.toString());
    }

    public void linkedList_Implementation() {
        ImplementLinkedList linkedList_logic = new ImplementLinkedList();
        linkedList_logic.add("Miso");
        linkedList_logic.add("C");
        linkedList_logic.add(1234);
        linkedList_logic.add(3.6);

        System.out.println(linkedList_logic.toString());
    }

    public <T> void generic_Implementation(T any_Type_Parameter) {
         // Generic enables user to use "type parameter" concept, which are symbols that can be substituted for any concrete type
        // Type-Parameter can be extended using inheritance characters or interface
        // Once it is extended as bounded generic <T extends Animal> or <T extends Animal & Serializable> or <T extends Interface>, we can use user-defined data type as Parameter such as <Cat class extends Animal>
        // Warning : Raw use of parameterized class which has formal parameters that will be replaced by one or more class-names or interface-names. When it is expanded by substituting specific class-names or interface-names as actual parameters, a class is created that functions as a non-parameterized class

        System.out.println("Any type of Parameter: " + any_Type_Parameter);
    }

    // User can have multiple generic types
    public <F, S> void generic_Implementation_2(F firstTypeParameter, S secondTypeParameter) {
        System.out.println("First Type Parameter: " + firstTypeParameter);
        System.out.println("Second Type Parameter: " + secondTypeParameter);
    }

    public void interface_Implementation() {
        // All Collection is implemented based on each underlying data structure
        // Collection consists of List(I),Set(I),Queue(I)
        // cf) Collections: include pre-defined class in java util package
        // Available Methods in Collection : add(object O), addAll(Collection C), remove(object O), removeAll(Collection C), retain(Collection C)

        // List(I) : Implemented by ArrayList(C), LinkedList(C) and duplication is allowed and insertion order is preserved.
        // Available Methods in List(I) : general methods + get(), set()
        // LinkedList(C) also implements Dequeue(I)
        // Available Methods in List(I) : general methods + addFirst(), addLast(),getFirst(),getLast()


        // Set(I) : Implemented by Hashset(C), LinkedHashSet(C) and duplication is not allowed and insertion order is not preserved.
        // Queue(I) : Implemented by PriorityQueue(C), LinkedList(C)

        // Map(I) : Implemented by Hashmap(C), LinkedHashmap(C), HashTable(C)

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            arrayList.add(i);
        }

        System.out.print("Elements before shuffle: ");
        for (Object element : arrayList) {
            System.out.print(element + " ");
        }
        System.out.println("");
        Collections.shuffle(arrayList);

        System.out.print("Elements after shuffle: ");
        for (Object element : arrayList) {
            System.out.print(element + " ");
        }
    }
}
