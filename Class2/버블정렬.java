package algorithm.Class2;

import java.util.Scanner;

public class 버블정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = i+1;
        }

        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {

    }
}
