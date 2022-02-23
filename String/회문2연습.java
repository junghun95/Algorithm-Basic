package algorithm.String;

import java.util.Scanner;

public class 회문2연습 {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			ans = 0;
			sc.nextInt();
			char[][] pal1 = new char[101][101]; // 가로데이터
			char[][] pal2 = new char[101][101]; // 세로데이터
			// 데이터 세팅
			for (int i = 1; i <= 100; i++) {
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
		// 체크하는 카운트를 100부터 처리하도록 한다.
		// 만약, 가장 먼저 회문이 가능한 케이스가 나오면 더이상 체크할 필요가 없다.
		for (int n = 100; n > 0; n--) {
			int half = n / 2;
			int rest = n % 2;
			for (int i = 1; i <= 100; i++) {
				outer:
					for (int j = half + rest; j <= (100 - half); j++) {
						for(int depth = 0; depth < half; depth++) {
							if(pal[i][j - depth - rest] != pal[i][j + depth + 1]) continue outer;
						}
						// 무조건 성공했을 때만 이자리에 올수있다.
						ans = Math.max(ans, n);
						return;
					}
			}
		}
	}
}
