package algorithm.List;

import java.util.Scanner;

public class 최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int[] arr = new int[10];
			//입력
			for(int j = 0; j<10; j++) {
				arr[j] = sc.nextInt();
			}
			int max = Integer.MIN_VALUE;
			for(int j = 0; j<arr.length; j++) {
				if(max<arr[j]) max = arr[j];
			}
			System.out.println("#"+i+" "+max);
		}
		sc.close();
	}
}
