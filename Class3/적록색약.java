package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
    static char[][] map;
    static boolean[][] chk1, chk2;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++){
            String str = br.readLine();
            for (int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }
        chk1 = new boolean[N][N];
        chk2 = new boolean[N][N];
        int answer1 = 0, answer2 = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!chk1[i][j]){
                    dfs1(i, j, map[i][j]);
                    answer1++;
                }
                if (!chk2[i][j]){
                    dfs2(i, j, map[i][j]);
                    answer2++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer1).append(" ").append(answer2);
        System.out.println(sb);
    }

    private static void dfs2(int i, int j, char c) {
        chk2[i][j] = true;
        if (c == 'B'){
            for (int k = 0; k < 4; k++){
                int nx = i + dx[k];
                int ny = j + dy[k];

                if (valid(nx, ny)){
                    if (!chk2[nx][ny] && map[nx][ny] == c){
                        dfs2(nx, ny, c);
                    }
                }
            }
        } else {
            for (int k = 0; k < 4; k++){
                int nx = i + dx[k];
                int ny = j + dy[k];

                if (valid(nx, ny)){
                    if (!chk2[nx][ny]){
                        if (map[nx][ny] == 'G' || map[nx][ny] == 'R'){
                            dfs2(nx, ny, c);
                        }
                    }
                }
            }
        }
    }

    private static void dfs1(int i, int j, char c) {
        chk1[i][j] = true;

        for (int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (valid(nx, ny)){
                if (!chk1[nx][ny] && map[nx][ny] == c){
                    dfs1(nx, ny, c);
                }
            }
        }
    }

    private static boolean valid(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < N && ny < N){
            return true;
        }
        return false;
    }
}
