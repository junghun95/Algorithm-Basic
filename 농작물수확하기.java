package algorithm;

import java.util.Scanner;

public class 농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				String[] ss1 = s.split("");
				for (int j = 0; j < ss1.length; j++) {
					map[i][j] = Integer.parseInt(ss1[j]);
				}
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(i<=N/2) {
					for (int j = N/2-i; j <= N/2+i; j++) {
						sum += map[i][j];
					}
				} else {
					for (int j = i-N/2; j < N/2+N-i; j++) {
						sum += map[i][j];
					}
					
				}
				
			}
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}
