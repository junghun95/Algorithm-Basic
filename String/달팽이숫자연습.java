package algorithm.String;

import java.util.Scanner;

public class 달팽이숫자연습 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			int k = N; // 반복횟수
			int change = 1;  // 증감
			int x = 0, y = -1;
			int num = 1;
			//  숫자입력
			while(true) {
				for (int i = 0; i < k; i++) {	// 수평
					y += change;
					snail[x][y] = ++num; 
				}
				k--;
				if(k == 0) break;
				for (int i = 0; i < k; i++) {	// 수직
					x += change;
					snail[x][y] = ++num; 					
				}
				change *= -1;	// 수평-수직 이후에 값을 증감변경
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			
		}
		sc.close();
	}
}
