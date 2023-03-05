package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {
    static int N, white, blue;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int x, int y, int n) {
        if (n == 1) {
            if (paper[x][y] == 0) white++;
            else blue++;

            return;
        }

        int temp = paper[x][y];
        boolean flag = true;
        loop:
        for (int i = x; i < x + n; i++){
            for (int j = y; j < y + n; j++){
                if (paper[i][j] != temp){
                    flag = false;
                    break loop;
                }
            }
        }

        if (flag){
            if (temp == 0) white++;
            else blue++;
        } else {
            dfs(x, y, n/2);
            dfs(x, y + n/2, n/2);
            dfs(x + n/2, y, n/2);
            dfs(x + n/2, y + n/2, n/2);
        }
    }
}
