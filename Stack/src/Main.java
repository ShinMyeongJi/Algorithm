import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] command = new String[N];

        Stack stack = new Stack();
        for(int i = 0; i < N + 1; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            if(st.hasMoreTokens())
                command[i] = st.nextToken();


            /*switch (command[i]) {

                case "i" : {
                    stack.push(st.nextToken());
                    break;
                }
                case "c" : {
                    System.out.println(stack.size());
                    break;
                }
                case "o" : {
                    System.out.println(stack.peek());
                    stack.pop();
                    break;
                }
            }*/
        }

    }
     static class Stack {
        private Node top;
        private int count = 0;

        public Stack() {
            this.top = null;
        }

        class Node{
            private Object data;
            private Node nextNode;

            public Node(Object data){
                this.data = data;
                this.nextNode = null;
            }
        }

        public void push(Object data) {
            Node newNode = new Node(data);
            newNode.nextNode = top;
            top = newNode;
            count++;
        }

        public Object pop() {
            Object data = peek();
            if(top != null) {
                top = top.nextNode;
                count--;
                return data;
            }
            return "empty";
        }

        public Object peek() {
            if(top == null)
                return null;
            return top.data;
        }

        public boolean isEmpty() {
            if(top == null) return true;
            return false;
        }

        public int size() {
            return count;
        }
    }


}

