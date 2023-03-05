package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    static int answer;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[100001];
        dp[N] = 1;
        bfs(N,K);
        System.out.println(answer);
    }

    private static void bfs(int n, int k) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()){
            int chk = q.poll();

            if(chk == k) {
                answer = dp[chk] - 1;
                return;
            }
            if(chk - 1 >= 0 && dp[chk-1] == 0){
                dp[chk-1] = dp[chk] + 1;
                q.offer(chk-1);
            }
            if (chk + 1 <= 100000 && dp[chk+1] == 0){
                dp[chk+1] = dp[chk] + 1;
                q.offer(chk+1);
            }
            if(chk * 2 <= 100000 && dp[chk*2] == 0){
                dp[chk*2] = dp[chk] + 1;
                q.offer(chk*2);
            }

        }
    }
}
