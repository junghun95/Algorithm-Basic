package day0113;

import java.util.Scanner;

public class BOJ_1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();

        boolean[] chk = new boolean[N+1];
        chk[0] = chk[1] = true;
        for(int i = 2; i <= Math.sqrt(N); i++){
            int cnt = 2;
            if(chk[i]) continue;
            while (true){
                if(cnt * i > N) break;

                chk[cnt * i] = true;
                cnt++;
            }
        }

        for (int i = M; i <= N; i++){
            if(!chk[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
