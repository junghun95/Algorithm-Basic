package algorithm.SSAFY;

import java.util.Scanner;

public class 버블정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int temp = Integer.MIN_VALUE;
			for(int i = arr.length-1; i>0; i--) {
				for(int j = 0; j<i; j++) {
					if(arr[j] > arr[j+1]) {
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i = 0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
