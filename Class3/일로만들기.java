package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        dfs(N, 0);
        System.out.println(answer);
    }

    private static void dfs(int n, int i) {
        if(n == 1) {
            if(i < answer) answer = i;
            return;
        }

        if(i >= answer) return;

        if (n % 3 == 0) dfs(n/3, i+1);
        if (n % 2 == 0) dfs(n/2, i+1);
        dfs(n-1, i+1);


    }
}
