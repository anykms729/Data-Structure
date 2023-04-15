public class CustomerSort<T> extends BinarySearchTree {


    public static void main(String[] args) {
        Customer student1 = new Customer("Aiso", 19);
        Customer student2 = new Customer("Biso", 22);
        Customer student3 = new Customer("Ciso", 32);
        Customer student4 = new Customer("Diso", 43);

        CustomerSort<Customer> studentSort = new CustomerSort<>();
        studentSort.insert(student1);
        studentSort.insert(student2);
        studentSort.insert(student3);
        studentSort.insert(student4);

        System.out.println("------------------");
        studentSort.display();
        System.out.println();
    }

    @Override
    public void insert(Comparable element) {
        super.insert(element);
    }

    @Override
    public void display() {
        super.display();
    }
}
