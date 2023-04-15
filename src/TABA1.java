public class TABA1 {
    public static void main(String[] args) {

    }

    public class stacksFunction {
        public void pop() {

        }

        public void push() {

        }

        public void peek() {

        }

        public void clear() {

        }

        public void list() {

        }

        // Adds a new website to the data structure
        public void browse() {

        }

        // Goes back to previous website
        public void goBack() {

        }

        // Goes forward to next website
        public void goForward() {

        }

        // Prints the contents of the data structure
        public void printDS() {

        }
    }

    public class doublyLinkedList {
        // Adds a new website to the data structure
        public void add() {

        }

        public void remove() {

        }

        public void get() {

        }

        public void clear() {

        }

        public void list() {

        }

        // Goes back to previous website
        public void goBack() {

        }

        // Goes forward to next website
        public void goForward() {

        }

        // Prints the contents of the data structure
        public void printDS() {

        }
    }

    public class Website {
        String Title;
        int dataAccessed;
        int timeAccessed;
        String websiteURL;

        public Website() {
        }

        public Website(String title, int dataAccessed, int timeAccessed, String websiteURL) {
            Title = title;
            this.dataAccessed = dataAccessed;
            this.timeAccessed = timeAccessed;
            this.websiteURL = websiteURL;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public int getDataAccessed() {
            return dataAccessed;
        }

        public void setDataAccessed(int dataAccessed) {
            this.dataAccessed = dataAccessed;
        }

        public int getTimeAccessed() {
            return timeAccessed;
        }

        public void setTimeAccessed(int timeAccessed) {
            this.timeAccessed = timeAccessed;
        }

        public String getWebsiteURL() {
            return websiteURL;
        }

        public void setWebsiteURL(String websiteURL) {
            this.websiteURL = websiteURL;
        }
    }
}

/*
1) Structure:
 - Stack: A stack is a Last-In, First-Out (LIFO) data structure, where elements are inserted and removed from the same end, known as the "top" of the stack. It follows the principle of "last in, first out," meaning that the most recently added element is the first one to be removed.
 - Doubly Linked List: A doubly linked list is a linear data structure in which each node contains a value and two pointers, one pointing to the next node (often called "next" pointer) and one pointing to the previous node (often called "prev" pointer). It allows for traversal in both forward and backward directions.

2) Insertion and Removal:
 - Stack: In a stack, elements are added to the top of the stack using the "push" operation, and removed from the top using the "pop" operation. This makes stack operations efficient and constant time complexity, O(1).
 - Doubly Linked List: In a doubly linked list, elements can be inserted or removed from either end (i.e., the head or tail) or at any specific position in the list. However, insertion or removal at a specific position may require traversal of the list to find the desired position, resulting in a time complexity of O(n), where n is the number of elements in the list.

3) Traversal:
 - Stack: Since a stack follows LIFO, only the top element is accessible for reading or removal, and other elements below the top are not directly accessible. To access an element in the middle of the stack, you would need to sequentially pop off elements until you reach the desired element, which may not be efficient.
 - Doubly Linked List: A doubly linked list allows for efficient traversal in both forward and backward directions. Starting from the head or tail, you can traverse the list in constant time O(1) to reach any node, making it more suitable for operations that require frequent traversal or access to arbitrary nodes in the list.

4) Memory Overhead:
 - Stack: A stack usually has lower memory overhead compared to a doubly linked list as it typically only requires a single pointer (top) to keep track of the elements.
 - Doubly Linked List: A doubly linked list requires additional memory for the "prev" pointer in each node, making it relatively more memory-intensive compared to a stack.

5) Usage:
 - Stack: Stacks are commonly used in scenarios where elements need to be added and removed in a last-in, first-out (LIFO) fashion, such as in function call stacks, expression evaluation, and backtracking algorithms.
 - Doubly Linked List: Doubly linked lists are commonly used in scenarios where elements need to be inserted or removed at both ends frequently, or where bidirectional traversal is required, such as in certain caching algorithms, undo/redo functionality in software applications, or when maintaining a history of visited web pages.
 */
