package day1105;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1018_체스판다시칠하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] map = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String str = sc.next();
            for (int j = 0; j < M; j++){
                if(str.charAt(j) == 'B'){
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }
        sc.close();
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++){
            for (int j = 0; j <= M - 8; j++){
                int temp = 0;
                boolean flag = map[i][j];
                for (int k = 0; k < 8; k++){
                    for (int l = 0; l < 8; l++){
                        if(map[i+k][j+l] != flag){
                            temp++;
                        }
                        flag = !flag;
                    }
                    flag = !flag;
                }
                temp = Math.min(temp, 64 - temp);
                answer = Math.min(temp, answer);
                if(answer == 0) {
                    System.out.println(answer);
                    System.exit(0);
                }
            }
        }
        System.out.println(answer);
    }
}
