import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] command = new String[N];

        Queue queue = new LinkedList();
        for (int i = 0; i < N; i++) {

            String line = br.readLine();
            if(line.length() > 1) {
                StringTokenizer st = new StringTokenizer(line);
                command[i] = st.nextToken();
                queue.add(Integer.parseInt(st.nextToken()));
            }else{
                command[i] = line;
            }


            switch (command[i]) {
                case "c" : {
                    System.out.println(queue.size());
                    break;
                }
                case "o" : {
                    if(!queue.isEmpty())
                        System.out.println(queue.poll());
                    else System.out.println("empty");
                    break;
                }
            }
        }
    }
}
