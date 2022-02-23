package algorithm.String;

import java.util.Scanner;

public class 회문2 {
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			Integer.parseInt(sc.next());
			char[][] map = new char[100][100];
			for (int i = 0; i < map.length; i++) {
				map[i] = sc.next().toCharArray();
			}
			char[][] map2 = new char[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map2[i][j] = map[j][i];
				}
			}
			result = 1;
			for (int i = 0; i < 100; i++) {
				check(map[i]);
				check(map2[i]);
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}

	public static void check(char[] map) {
		// map[i] 에서 i가 회문검사의 기준점
		// i를 기준으로 만들수있는 가장 긴 회문의 길이를 max로 놓는다
		// max를 하나씩 낮추면서 i를 기준으로 max만큼의 회문이 있는지 검사한다
		// 현재의 가장 긴 회문길이보다 검사하고자하는 max값이 작다면 검사하지않고 건너뛴다.
		for (int i = 1; i < map.length - 1; i++) {
			int max = 99 - i >= i ? i * 2 : (99 - i) * 2;
			outer: for (int j = max; j > 1; j--) {
				if (result > j)
					break outer;
				if (j % 2 == 0) {
					for (int k = j / 2 - 1; k >= 0; k--) {
						if (map[i - k] != map[i + k + 1]) {
							continue outer;
						}
					}
					if (result < j) {
						result = j;
					}
				} else {
					for (int k = j / 2; k > 0; k--) {
						if (map[i - k] != map[i + k]) {
							continue outer;
						}
					}
					if (result < j) {
						result = j;
					}
				}
			}
		}
	}
}
