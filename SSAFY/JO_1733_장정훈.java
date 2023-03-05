package algorithm.SSAFY;

import java.util.Scanner;

public class JO_1733_장정훈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[20][20];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		// 팔방탐색
		int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1};
		int[] dc = {1, 1, 1, 0, -1, -1, -1, 0};
		boolean flag = false;
		outer:
		for (int j = 1; j < map.length; j++) {
			for (int i = 1; i < map.length; i++) {
				if(map[i][j] != 0) {
					int temp = map[i][j];
					for (int k = 0; k < dc.length /2; k++) {
						int r = i;
						int c = j;
						int cnt = 1;
						while(true) {
							r += dr[k];
							c += dc[k];
							if(r<=0 || r>=20 || c<=0 || c>=20 || map[r][c] != temp) {
								break;
							}
							cnt++;
						}
						r = i;
						c = j;
						while(true) {
							r += dr[k+4];
							c += dc[k+4];
							if(r<=0 || r>=20 || c<=0 || c>=20 || map[r][c] != temp) {
								break;
							}
							cnt++;
						}
						if(cnt == 5) {
							System.out.println(temp);
							System.out.println(i + " " + j);
							flag = true;
							break outer;
						}
					}
				}
			}
		}
		if(!flag) System.out.println(0);
	}
}
