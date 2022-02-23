package algorithm.Recursive;

import java.util.Scanner;

public class 햄버거다이어트 {
	static int[][] list;
	static int result;
	static boolean[] sel;
	static int L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			result = 0;
			L = sc.nextInt();
			list = new int[N][2];
			for (int i = 0; i < N; i++) {
				list[i][0] = sc.nextInt();
				list[i][1] = sc.nextInt();
			}
			sel = new boolean[N];
			powerset(0);
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
	
	public static void powerset(int idx) {
		// basis부분
		if(idx == list.length) {
			int score = 0;
			int cal = 0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					score += list[i][0];
					cal += list[i][1];
				}
			}
			if(cal <= L) result = Math.max(result, score);
			return;
		}
		
		// 재귀부분
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
	}
}
