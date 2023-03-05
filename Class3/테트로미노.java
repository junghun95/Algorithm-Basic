package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
    static int[][] map;
    static int answer = Integer.MIN_VALUE, n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                exception(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void exception(int x, int y) {
        if (x-1 >= 0 && y-1 >= 0 && x+1 < n && y+1 < m){
            int sum = map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x + 1][y] + map[x][y + 1];
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                int temp = sum - map[nx][ny];

                answer = temp > answer ? temp : answer;
            }

        }
    }

    static void dfs(int i, int j, int cnt, int sum) {
        if (cnt == 4){
            answer = Math.max(sum, answer);
            return;
        }

        for (int k = 0; k < 4; k ++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]){

                if (cnt == 2){
                    visited[nx][ny] = true;
                    dfs(nx, ny, cnt+1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }

        }
    }
}
