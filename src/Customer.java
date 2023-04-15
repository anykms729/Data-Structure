import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer implements Comparable<Customer> {
    // Declare variables
    String name;
    int age;

    // Create constructor
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer() {
    }

    // Create getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Create setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        System.out.println("");
        return "Customer {" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}";
    }

    @Override
    public int compareTo(Customer student) {
        if (age == student.age) {
            return 0;
        } else if (age > student.age){
            return 1;
        }
        else return -1;
    }
}
