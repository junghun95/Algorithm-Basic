package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int[][][] map;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        map = new int[n][m][h];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < h; i++){
            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++){
                    int temp = Integer.parseInt(st.nextToken());
                    map[j][k][i] = temp;
                    if (temp == 1){
                        q.offer(new int[]{j, k, i, 0});

                    }
                }
            }
        }
        int answer = 0;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            if (cur[3] > answer) answer = cur[3];
            for (int i = 0; i < 6; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nh = cur[2] + dh[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nh < 0 || nh >= h) continue;

                if (map[nx][ny][nh] == 0){
                    map[nx][ny][nh] = 1;
                    q.offer(new int[]{nx, ny, nh, cur[3] + 1});
                }
            }
        }

        loop:
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = 0; k < h; k++){
                    if (map[i][j][k] == 0){
                        answer = -1;
                        break loop;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
