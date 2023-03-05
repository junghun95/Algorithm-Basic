package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            Integer[] answer = fibonacci(num);
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static Integer[] fibonacci(int num) {
        if(dp[num][0] == null || dp[num][1] == null){
            dp[num][0] = fibonacci(num - 1 )[0] + fibonacci(num - 2)[0];
            dp[num][1] = fibonacci(num - 1 )[1] + fibonacci(num - 2)[1];
        }
        return dp[num];
    }
}
