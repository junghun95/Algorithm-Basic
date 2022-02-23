package algorithm.Recursive;

import java.util.Scanner;

public class 부분수열의합 {
	static boolean[] sel;
	static int[] arr;
	static int K;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			sel = new boolean[N];
			cnt = 0;
			powerset(0);
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
	public static void powerset(int idx) {
		// basis 부분
		if(idx == arr.length) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if(sel[i]) {
					sum += arr[i];
				}
			}
			if(sum == K) {
				cnt++;
			}
			return;
		}
		
		// 재귀부분
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
	}
}
