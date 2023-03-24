package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
    static char[][] map;
    static int n,m, answer = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++){
            String str = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
            }
        }
        bfs();

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }

    private static void bfs() {
        boolean[][][] visited = new boolean[n][m][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            if (cur[0] == n - 1  && cur[1] == m - 1){
                answer = Math.min(answer, cur[2]);
                break;
            }

            for (int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (visited[nx][ny][cur[3]]) continue;

                if (map[nx][ny] == '1' && cur[3] == 0){
                    q.offer(new int[]{nx, ny, cur[2] + 1, cur[3] + 1});
                    visited[nx][ny][cur[3]] = true;
                    continue;
                }

                if (map[nx][ny] == '1' && cur[3] != 0) continue;

                q.offer(new int[]{nx, ny, cur[2] + 1, cur[3]});
                visited[nx][ny][cur[3]] = true;
            }
        }
    }
}
