package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2xn타일링 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(func(n));
    }

    private static int func(int n) {
        if (dp[n] == null){
            dp[n] = (func(n-1) + func(n-2)) % 10007;
        }

        return dp[n];
    }
}
