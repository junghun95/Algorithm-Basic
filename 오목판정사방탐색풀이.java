package algorithm;

import java.util.Scanner;

public class 오목판정사방탐색풀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				map[i] = sc.next().toCharArray();
			}
			int[] dr = { 0, 1, 1, -1 };
			int[] dc = { 1, 0, 1, 1 };
			boolean flag = false;
			outer:
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 'o') {
						for (int k = 0; k < dc.length; k++) {
							int r = i;
							int c = j;
							int cnt = 1;
							for (int l = 0; l < 4; l++) {
								r = r + dr[k];
								c = c + dc[k];
								if (r >= 0 && r < N && c >= 0 && c < N && map[r][c] == 'o') {
									cnt++;
								} else break;
							}
							if(cnt >= 5) {
								System.out.println("#" + tc + " " + "YES");
								flag = true;
								break outer;
							}
						}
					}
				}
			}
			if(!flag) System.out.println("#" + tc + " " + "NO");

		}
		sc.close();
	}
}
