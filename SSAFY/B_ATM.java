package algorithm.SSAFY;

import java.util.Arrays;
import java.util.Scanner;

public class B_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		int[] result = new int[N];
		result[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result[i] = result[i-1] + arr[i];
		}
		for (int i = 1; i < result.length; i++) {
			result[i] += result[i-1];
		}
		System.out.println(result[N-1]);
	}
}
