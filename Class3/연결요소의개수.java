package algorithm.Class3;

import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연결요소의개수 {
    static int n;
    static boolean[][] connect;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connect = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a][b] = true;
            connect[b][a] = true;
        }
        int answer = 0;
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int i) {
        visited[i] = true;

        for (int j = 1; j <= n; j++){
            if (connect[i][j]){
                if (!visited[j]){
                    dfs(j);
                }
            }
        }
    }
}
