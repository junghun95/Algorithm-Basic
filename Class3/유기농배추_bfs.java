package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_bfs {
    static int N,M;
    static int[][] map;
    static boolean[][] chk;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            chk = new boolean[N][M];
            for (int i = 0; i < num; i++){
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int count = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(map[i][j] == 1 && !chk[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        chk[i][j] = true;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i,j});

        while (!q.isEmpty()){
            int[] p = q.poll();

            for (int k = 0; k < 4; k++){
                int nx = p[0] + dx[k];
                int ny = p[1] + dy[k];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(map[nx][ny] == 1 && !chk[nx][ny]){
                        chk[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
