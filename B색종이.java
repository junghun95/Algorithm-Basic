package algorithm;

import java.util.Scanner;

public class B색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[1001][1001];
		int N = sc.nextInt();
		int[] cnt = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for (int j = r; j < r+w; j++) {
				for (int k = c; k < c+h; k++) {
					if(map[j][k] != 0) {
						cnt[map[j][k]]--;
					}
					map[j][k] = i;
					cnt[i]++;
				}
			}
		}
		
		for (int i = 1; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
		sc.close();
	}
}
