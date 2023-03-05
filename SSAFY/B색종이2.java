package algorithm.SSAFY;

import java.util.Scanner;

public class B색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[x+j][y+k] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length-1; j++) {
				if(map[i][j] != map[i][j+1]) cnt++;		
			}
		}
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] != map[i+1][j]) cnt++;		
			}
		}
		sc.close();
		System.out.println(cnt);
	}
}
