package day0417;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2437_저울 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] w = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++){
            w[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(w);

        for(int i = 0; i < N; i++){
            if(sum + 1 < w[i]){
                break;
            }
            sum += w[i];
        }
        System.out.println(sum + 1);
    }
}