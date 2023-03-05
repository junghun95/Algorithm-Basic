package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {
    static int[] map, dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[101];
        dp = new int[101];
        visited = new boolean[101];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dp[1] = 0;
        visited[1] = true;

        while (!q.isEmpty()){
            int cur = q.poll();
            if (cur == 100){
                System.out.println(dp[100]);
                return;
            }

            for (int i = 1; i < 7; i++){
                int x = cur + i;
                if (x > 100) continue;
                if (visited[x]) continue;
                visited[x] = true;

                if (map[x] != 0){
                    if (!visited[map[x]]){
                        q.offer(map[x]);
                        visited[map[x]] = true;
                        dp[map[x]] = dp[cur] + 1;
                    }
                } else {
                    q.offer(x);
                    dp[x] = dp[cur] + 1;
                }
            }
        }
    }
}
