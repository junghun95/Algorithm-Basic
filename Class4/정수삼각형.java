package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + tri[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + tri[i][j], dp[i-1][j] + tri[i][j]);
                }
            }
        }

        int[] answer = dp[n-1];

        Arrays.sort(answer);

        System.out.println(answer[n-1]);
    }
}
