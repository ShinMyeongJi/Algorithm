import java.util.ArrayList;

class Solution {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        for(int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }



        return answer;
    }

    public void dfs() {

    }
}
