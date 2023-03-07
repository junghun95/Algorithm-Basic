package day1114;

import java.util.Scanner;

public class BOJ_14889_스타트와링크{
    static int N, answer;
    static boolean[] chk;
    static int[][] score;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        chk = new boolean[N];
        answer = Integer.MAX_VALUE;
        score = new int[N][N];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                score[i][j] = sc.nextInt();
            }
        }
//        for(int i = 0; i < N; i++){
//            for (int j = 0; j < N; j++){
//                System.out.println(score[i][j]);
//            }
//        }
        perm(0, 0);
        sc.close();
        System.out.println(answer);
    }

    private static void perm(int idx, int a) {
        if(idx == N/2) {
            // 점수 계산하는 메서드 호출하기
            cal(chk);
            return;
        }
        for (int i = a; i < N; i++){
            if(chk[i]) continue;
            if (answer == 0) return;
            chk[i] = true;
            perm(idx + 1, a + 1);
            chk[i] = false;
        }
    }

    private static void cal(boolean[] chk) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(chk[i] && chk[j]){
                    a += score[i][j];
                    a += score[j][i];
                }else if (!chk[i] && !chk[j]){
                    b += score[i][j];
                    b += score[j][i];
                }
            }
        }
        int temp = Math.abs(a-b);
        answer = temp < answer ? temp : answer;
        if(answer == 0){
            System.out.println(0);
            System.exit(0);
        }
    }
}