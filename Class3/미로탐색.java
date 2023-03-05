package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            String str = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));

    }

    private static int bfs(int x, int y) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        int answer = 0;
        while (!q.isEmpty()){
            int[] temp = q.poll();
            if (temp[0] == N - 1 && temp[1] == M - 1){
                answer = temp[2];
                break;
            }

            for (int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if (!visited[nx][ny] && map[nx][ny] == 1){
                        q.offer(new int[]{nx, ny, temp[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return answer;
    }
}
