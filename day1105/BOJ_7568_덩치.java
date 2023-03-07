package day1105;

import java.util.Scanner;

public class BOJ_7568_덩치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        sc.close();
        int[] answer = new int[N];
        for (int i = 0; i < N - 1; i++){
            for (int j = i + 1; j < N; j++){
                if(arr[i][0] > arr[j][0]){
                    if(arr[i][1] > arr[j][1]){
                        answer[j]++;
                    }
                }else if(arr[i][0] < arr[j][0]){
                    if(arr[i][1] < arr[j][1]){
                        answer[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++){
            System.out.print(answer[i] + 1);
            if(i==N-1) break;
            System.out.print(" ");
        }
    }
}
