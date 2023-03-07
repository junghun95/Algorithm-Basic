package day0409;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int N = (int) Math.pow(2, n);
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		answer = 0;
		find(r + 1, c + 1, N);
		System.out.println(answer);
	}

	private static void find(int r, int c, int N) {
		if(N == 1) return;
		// 1번 영역 
		if(r <= (N / 2) && c <= (N / 2)) {
			find(r, c, N / 2);
		}
		if(r <= (N / 2) && c > (N / 2)) {
			answer += (int) Math.pow(N / 2, 2);
			find(r, c - (N /2), N / 2);
		}
		if(r > (N / 2) && c <= (N / 2)) {
			answer += (int) Math.pow(N / 2, 2) * 2;
			find(r - (N / 2), c, N / 2);
		}
		if(r > (N / 2) && c > (N / 2)) {
			answer += (int) Math.pow(N / 2, 2) * 3;
			find(r - (N / 2), c - (N / 2), N / 2);
 		}
	}
}
