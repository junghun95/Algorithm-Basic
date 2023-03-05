package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B123더하기 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            int target = Integer.parseInt(br.readLine());
            dp = new int[11];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            func(target);
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }

    private static int func(int target) {
        if (dp[target] == 0){
            dp[target] = func(target-1) + func(target - 2) + func(target - 3);
        }
        return dp[target];
    }
}
