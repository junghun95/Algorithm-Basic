package algorithm.SSAFY;

import java.util.Scanner;

public class 중간값구하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int temp = 0;
		
		// 선택정렬
		for(int i = 0; i < N-1; i++) {
			int index = i;
			for(int j = i+1; j<N; j++) {
				if(arr[index] > arr[j]) {
					index = j;
					temp = arr[j];
				}
			}
			arr[index] = arr[i];
			arr[i] = temp;
		}
		System.out.println(arr[N/2]);
		sc.close();
	}
}
