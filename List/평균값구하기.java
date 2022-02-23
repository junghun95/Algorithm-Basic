package algorithm.List;

import java.util.Scanner;

public class 평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			System.out.println(1);
			int[] arr = new int[10];
			for(int k = 0; k<10; k++) {
				arr[k] = sc.nextInt();
			}
			int sum = 0;
			int result = 0;
			for(int j=0; j<10; j++) {
				sum += arr[j];
			}
			result = (int) Math.round(sum/10.0);

			System.out.println("#"+i+" "+result);
		}
		sc.close();
	}
}
