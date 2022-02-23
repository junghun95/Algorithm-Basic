package algorithm;

import java.util.Scanner;

public class 파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i < map.length-M+1; i++) {
				for (int j = 0; j < map.length-M+1; j++) {
					int sum = 0;
					for (int k = i; k < i+M; k++) {
						for (int l = j; l < j+M; l++) {
							sum += map[k][l];
						}
					}
					result = Math.max(sum, result);
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
