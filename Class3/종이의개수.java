package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수 {
    static int[] answer;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[3];
        int startX = 0, startY = 0;
        recur(N, startX, startY);

        for (int i : answer){
            System.out.println(i);
        }
    }

    private static void recur(int n, int startX, int startY) {
        if(n == 0) return;

        boolean flag = true;
        int chk = paper[startX][startY];
        loop:
        for (int i = startX; i < startX + n; i++){
            for (int j = startY; j < startY + n; j++){
                if(paper[i][j] != chk){
                    flag = false;
                    break loop;
                }
            }
        }

        if(flag){
            answer[chk+1] += 1;
        } else {
            for (int k = 0; k < 3; k++){
                for (int l = 0; l < 3; l++){
                    recur(n/3, startX + k*(n/3), startY + l*(n/3));
                }
            }
        }

    }
}
