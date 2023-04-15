import java.io.*;
import java.util.Queue;
import java.util.Stack;

public class ExampleLinkedList3 {

    public static void main(String[] args) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int top = -1;

        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\Data_Structure\\src\\mypage.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str + "\n");
                stack.push(str);
                top++;
            }
            in.close();
        } catch (IOException e) {
        }
        String html = contentBuilder.toString();
        System.out.println(validateHTML(html));
    }


    public static boolean validateHTML(String html) {

        Stack<String> opening_Stack = new Stack<String>();
        Stack<String> closing_Stack = new Stack<String>();


        // Regular expression to match opening and closing tags
        String[] tags = html.split("\n");

        for (String tag : tags) {
            if (tag.startsWith("</")) {
                closing_Stack.push(tag);
            } else if (tag.startsWith("<")) {
                opening_Stack.push(tag);
            }
        }

        System.out.println("opening_Stack: " + opening_Stack);
        System.out.println("closing_Stack: "+ closing_Stack);
        String back_Slash = "/";
        String empty = "";

        Stack<String> updated_closing_Stack = new Stack<>();


        for (String closing_Tag : closing_Stack) {
            updated_closing_Stack.push(closing_Tag.replace(back_Slash, empty));
        }

        if (opening_Stack.containsAll(updated_closing_Stack) && (opening_Stack.size() == updated_closing_Stack.size())){
            opening_Stack.removeAllElements();
        }
        return opening_Stack.isEmpty();
            }
        }
