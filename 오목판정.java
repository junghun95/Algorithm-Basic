package algorithm;

import java.util.Scanner;

public class 오목판정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				map[i] = sc.next().toCharArray();
			}
			boolean flag = false;
			// 가로방향 체크
			if (!flag) {
				outer:
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map.length - 4; j++) {
						if (map[i][j] == 'o') {
							int cnt = 0;
							while (true) {
								if (map[i][j] != 'o')
									break;
								else {
									j++;
									cnt++;
								}
								if (cnt >= 5) {
									System.out.println("#" + tc + " " + "YES");
									flag = true;
									break outer;
								}
							}
						}
					}
				}
			}
			// 세로방향 체크
			if (!flag) {
				outer:
				for (int j = 0; j < map.length; j++) {
					for (int i = 0; i < map.length - 4; i++) {
						if (map[i][j] == 'o') {
							int cnt = 0;
							while (true) {
								if (map[i][j] != 'o')
									break;
								else {
									i++;
									cnt++;
								}
								if (cnt >= 5) {
									System.out.println("#" + tc + " " + "YES");
									flag = true;
									break outer;
								}
							}
						}
					}
				}
			}
			// 오른쪽 아래로 가는 대각선방향 체크
			if (!flag) {
				outer:
				for (int i = 0; i < map.length - 4; i++) {
					for (int j = 0; j < map.length - 4; j++) {
						if (map[i][j] == 'o') {
							int tempI = i;
							int tempJ = j;
							int cnt = 0;
							while (true) {
								if (map[tempI][tempJ] != 'o')
									break;
								else {
									tempI++;
									tempJ++;
									cnt++;
								}
								if (cnt >= 5) {
									System.out.println("#" + tc + " " + "YES");
									flag = true;
									break outer;
								}
							}
						}
					}
				}
			}
			// 오른쪽 위로 가는 대각선방향 체크
			if (!flag) {
				outer:
				for (int i = 4; i < map.length; i++) {
					for (int j = 0; j < map.length - 4; j++) {
						if (map[i][j] == 'o') {
							int tempI = i;
							int tempJ = j;
							int cnt = 0;
							while (true) {
								if (map[tempI][tempJ] != 'o')
									break;
								else {
									tempI--;
									tempJ++;
									cnt++;
								}
								if (cnt >= 5) {
									System.out.println("#" + tc + " " + "YES");
									flag = true;
									break outer;
								}
							}
						}
					}
				}
			}

			// 다 돌았는데도 YES가 안나왔으면 NO출력
			if (!flag)
				System.out.println("#" + tc + " " + "NO");
		}
		sc.close();
	}
}
