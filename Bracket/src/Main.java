import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String statement = br.readLine();
        System.out.println(checkBracket(statement));
    }

    public static boolean checkBracket(String statement) {
        for (int i = 0; i < statement.length(); i++) {
            if(statement.charAt(i) == '{' || statement.charAt(i) == '[' || statement.charAt(i) == '(') {
                stack.push(statement.charAt(i));
            }else{
                switch (statement.charAt(i)) {
                    case '}' :
                        if(stack.peek() =='{') stack.pop();
                        break;
                    case ']' :
                        if(stack.peek() == '[') stack.pop();
                        break;
                    case ')' :
                        if(stack.peek() == '(') stack.pop();
                        break;
                    default :
                        break;
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
