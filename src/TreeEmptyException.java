public class TreeEmptyException extends RuntimeException{
    public TreeEmptyException(){
        super("There are no elements in the tree");
    }
}
