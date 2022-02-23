package algorithm.String;

import java.util.Scanner;

public class 회문1연습 {
	static int ans, palinCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			ans = 0;
			palinCnt = sc.nextInt();
			char[][] pal1 = new char[9][9]; // 가로데이터
			char[][] pal2 = new char[9][9]; // 세로데이터
			// 데이터 세팅
			for (int i = 1; i <= 8; i++) {
				String line = sc.next();
				for (int j = 1; j <= 8; j++) {
					pal1[i][j] = pal2[j][i] = line.charAt(j-1);
				}
			}	
			// 회문 카운트 세기
			countPalin(pal1);
			countPalin(pal2);
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
	
	private static void countPalin(char[][] pal) {
		int half = palinCnt / 2;
		int rest = palinCnt % 2;
		for (int i = 1; i <= 8; i++) {
			outer:
			for (int j = half + rest; j <= (8 - half); j++) {
				for(int depth = 0; depth < half; depth++) {
					if(pal[i][j - depth - rest] != pal[i][j + depth + 1]) continue outer;
				}
				// 무조건 성공했을 때만 이자리에 올수있다.
				ans++;
				
			}
		}
	}
}
