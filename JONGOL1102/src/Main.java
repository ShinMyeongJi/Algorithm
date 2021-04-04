import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] command = new String[N];

        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {

            String line = br.readLine();
            if(line.length() > 1) {
                StringTokenizer st = new StringTokenizer(line);
                command[i] = st.nextToken();
                stack.push(Integer.parseInt(st.nextToken()));
            }else{
                command[i] = line;
            }


            switch (command[i]) {
                case "c" : {
                    System.out.println(stack.size());
                    break;
                }
                case "o" : {
                    if(!stack.isEmpty())
                        System.out.println(stack.pop());
                    else System.out.println("empty");
                    break;
                }
            }
        }
    }
}
