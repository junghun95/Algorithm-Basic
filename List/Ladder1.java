package algorithm.List;

import java.util.Scanner;

public class Ladder1 {
	static int[][] map = new int[100][100];
	static int[] dx = {-1, 1, 0};
	static int[] dy = {0, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc =1; tc <= T; tc++) {
			sc.nextInt();
			// 입력받기
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 100; i++) {
				if(map[0][i] == 1) {
					if(ladder(i, 0)) System.out.println("#" + tc + " " + i);					
				}
			}
		}
		sc.close();
	}
	
	public static boolean ladder(int x, int y) {
		for(int i = 0; i < dx.length; i++) {
			// 인데스 예외 잡아주기
			if(x+dx[i]>=0 && x+dx[i]<100) {
				if(map[x+dx[i]][y+dy[i]] == 1) return ladder(x+dx[i], y+dy[i]);
				else if(map[x+dx[i]][y+dy[i]] == 2) return true;				
			}
		}
		return false;
	}
}
