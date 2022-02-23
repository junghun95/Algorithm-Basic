package algorithm.String;

import java.util.Scanner;

public class 달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			boolean[][] flag = new boolean[N][N];
			int cnt = 1;
			int x = 0;
			int y = 0;
			int[] dr = {1,0,-1,0};
			int[] dc = {0,1,0,-1};
			while(cnt <= N*N) {
				map[y][x] = cnt;
				flag[y][x] = true;
				cnt++;
				outer:
				for (int k = 0; k < dc.length; k++) {
					int nx = x + dr[k];
					int ny = y + dc[k];
					if(nx<N && nx>=0 && ny<N && ny>=0 && !flag[ny][nx]) {
						x = nx;
						y = ny;
						break outer;
					}
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
