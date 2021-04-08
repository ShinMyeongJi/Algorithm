import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[] inputs = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            String temp = st.nextToken();
            inputs[i] = temp.charAt(0);
        }

        Stack stack = new Stack();

        for(int i = 0; i < N; i++) {
            if(inputs[i] >= '0' && inputs[i] <= '9') {
                stack.push(Integer.parseInt(String.valueOf(inputs[i])));
            }else{
                int a = (int) stack.pop();
                int b = (int) stack.pop();
                if(inputs[i] == '+') {
                    stack.push(a+b);
                }else if(inputs[i] == '/') {
                    stack.push(b/a);
                }else if(inputs[i] == '*') {
                    stack.push(a*b);
                }else if(inputs[i] == '-') {
                    stack.push(b-a);
                }
            }
        }

        System.out.println(stack.pop());
    }
}
