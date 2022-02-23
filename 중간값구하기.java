package algorithm;

import java.util.Scanner;

public class 중간값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		// 입력 받기
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int temp;
		
		// 버블정렬로 정렬하기
		for(int i = N-1; i >=0; i--) {
			for(int j = 0; j<i; j++) {
				if(arr[j]> arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		// 중간값 출력하기
		System.out.println(arr[N/2]);
		sc.close();
	}
}
