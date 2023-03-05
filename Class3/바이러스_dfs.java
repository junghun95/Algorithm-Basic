package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_dfs {
    static boolean[] defect, chk;
    static int N, M;
    static int[][] connect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        defect = new boolean[N];
        connect = new int[N][N];
        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            connect[a][b] = 1;
            connect[b][a] = 1;
        }
        dfs(0);
        int answer = 0;
        for (int i = 0; i < N; i++){
            if (defect[i]) answer++;
        }
        System.out.println(answer - 1);
    }

    private static void dfs(int node) {
        defect[node] = true;

        for (int i = 0; i < N; i++){
            if (connect[node][i] == 1){
                if (!defect[i]){
                    dfs(i);
                }
            }
        }
    }
}
