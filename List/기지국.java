package algorithm.List;

import java.util.Scanner;

public class 기지국 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
					map[i] = sc.next().toCharArray();
			}
			int[] dx = {0, 0, -1, 1};
			int[] dy = {1, -1, 0, 0};
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == 'A' || map[i][j] == 'B' || map[i][j] == 'C') {
						for (int k = 0; k < 4; k++) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == 'H') {
								map[nx][ny] = 'X';
							}
						}
					}
					if(map[i][j] == 'B' || map[i][j] == 'C') {
						for (int k = 0; k < 4; k++) {
							int nx = i+dx[k]*2;
							int ny = j+dy[k]*2;
							if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == 'H') {
								map[nx][ny] = 'X';
							}
						}
					}
					if(map[i][j] == 'C') {
						for (int k = 0; k < 4; k++) {
							int nx = i+dx[k]*3;
							int ny = j+dy[k]*3;
							if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == 'H') {
								map[nx][ny] = 'X';
							}
						}
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == 'H') cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}
