/**
 * DFS 복습
 */
public class Main {

    static int[][] graph = {
            {},
            {2,3,8},
            {1,6,8},
            {1,5},
            {5,7},
            {3,4,7},
            {2},
            {4,5},
            {1,2}
    };

    static boolean[] isVisited = new boolean[graph.length];

    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int start) {
        isVisited[start] = true;

        System.out.print(start + " ");

        for (int i : graph[start]){
            if(!isVisited[i]) dfs(i);
        }

    }
}
