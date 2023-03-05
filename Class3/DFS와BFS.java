package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
    static int[][] edge;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        edge = new int[N+1][N+1];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x][y] = 1;
            edge[y][x] = 1;
        }
        chk = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        chk = new boolean[N+1];
        bfs(V);
        System.out.println(sb);


    }

    private static void bfs(int v) {
        chk[v] = true;
        sb.append(v).append(" ");
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        while (!q.isEmpty()){
            int t = q.poll();
            for (int i = 1; i <= N; i++){
                if(edge[t][i] != 0 && !chk[i]){
                    q.offer(i);
                    chk[i] = true;
                    sb.append(i).append(" ");
                }
            }

        }


    }

    private static void dfs(int v) {
        chk[v] = true;
        sb.append(v).append(" ");
        for (int i = 1; i <= N; i++){
            if(edge[v][i] != 0 && !chk[i]){
                dfs(i);
            }
        }
    }
}
