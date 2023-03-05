package day0417;

import java.util.Scanner;

public class BOJ_11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int ans = 0;
        for(int i = N - 1; i >= 0; i--){
            while(true){
                if(K - arr[i] >= 0){
                    ans++;
                    K -= arr[i];
                }
                else{
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
