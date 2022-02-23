package algorithm.List;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T; tc ++) {
			int[][] map = new int[100][100];
			sc.nextInt();
			// 입력받기
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int sum = 0;
			
			// 행, 열 돌면서 최대값찾기
			for(int i = 0; i < 100; i++) {
				int tempR = 0;
				int tempC = 0;
				for(int j = 0; j < 100; j++) {
					tempR += map[i][j];
					tempC += map[j][i];
				}
				if(sum < tempR) sum = tempR;
				if(sum < tempC) sum = tempC;
			}

			// 대각선돌면서 최대값찾기
			int tempRc = 0;
			int tempLc = 0;
			for(int i =0; i <100; i++) {
				tempRc += map[i][i];
				tempLc += map[i][99-i];
			}
			if(sum < tempRc) sum = tempRc;
			if(sum < tempLc) sum = tempLc;

			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}
