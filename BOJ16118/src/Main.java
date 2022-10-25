import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] distF = new int[N + 1];
        int[][] distW = new int[2][N + 1];
        boolean[] visited = new boolean[N + 1];


        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            distF[i] = Integer.MAX_VALUE;
            distW[0][i] = Integer.MAX_VALUE;
            distW[1][i] = Integer.MAX_VALUE; // 빠른 속도
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(d, v * 2));
        }


        distF[1] = 0;
        distW[0][1] = 0;
        distW[1][1] = 0;

        for(int i = 0; i < N; i++) {
            int minNodeF = Integer.MAX_VALUE;
            int minIndexF = 0;

            for(int j = 1; j <= N; j++) {
                if(!visited[j] && distF[j] < minNodeF) {
                    minNodeF = distF[j];
                    minIndexF = j;
                }
            }

            visited[minIndexF] = true;
            int nLen = graph.get(minIndexF).size();
            for (int j = 0; j < nLen; j++) {
                Node n = graph.get(minIndexF).get(j);
                distF[n.des] = Math.min(distF[n.des], distF[minIndexF] + n.val);
            }
        }

        visited = new boolean[N+1];

        for(int i = 0; i < N; i++) {
            int minNodeW = Integer.MAX_VALUE;
            int minIndexW = 0;

            for(int j = 1; j <= N; j++) {
                if(!visited[j] && distF[j] < minNodeW) {
                    minNodeW = distF[j];
                    minIndexW = j;
                }
            }

            visited[minIndexW] = true;
            int nLen = graph.get(minIndexW).size();
            for (int j = 0; j < nLen; j++) {
                Node n = graph.get(minIndexW).get(j);
                distW[0][n.des] = Math.min(distW[0][n.des], distW[0][minIndexW] + n.val/2);

            }
        }

        int cnt = 0;

        /*for (int i = 1; i <= N; i++) {
            if (distF[i] > distW[i]) {
                cnt++;
            }
        }*/

        System.out.println(cnt);

    }

}

class Node {
    int des, val;

    Node(int des, int val) {
        this.des = des;
        this.val = val;
    }
}