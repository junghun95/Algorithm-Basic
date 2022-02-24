package algorithm;

import java.util.Scanner;

public class 상호의배틀필드 {
	static char[][] map;
	static int posH;
	static int posW;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			map = new char[H][W];
			
			// 입력 받으면서 전차의 위치 찾기
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '<'||map[i][j] == '>'||map[i][j] == '^'||map[i][j] == 'v') {
						posH = i;
						posW = j;
					}
				}
			}
			sc.nextInt();	 // N 입력 받기
			char[] command = sc.next().toCharArray();

			for (int i = 0; i < command.length; i++) {
				if(command[i] == 'U') {
					rotate(1);
				} else if(command[i] == 'D') {
					rotate(2);
				} else if(command[i] == 'L') {
					rotate(3);
				} else if(command[i] == 'R') {
					rotate(4);
				}  else if(command[i] == 'S') {
					shoot();
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
	
	public static void rotate(int idx) {
		// idx 를 통해 먼저 전차의 방향을 바꿔준다.
		if(idx == 1) map[posH][posW] = '^';
		else if(idx == 2) map[posH][posW] = 'v';
		else if(idx == 3) map[posH][posW] = '<';
		else if(idx == 4) map[posH][posW] = '>';
		
		// idx에 따라 방향의 한칸 앞에 있는 지형을 확인한다.(맵 밖으로 나가는건 제외해야 한다)
		if(posH + dx[idx] >= 0 && posH + dx[idx] < map.length && posW + dy[idx] >= 0 && posW + dy[idx] < map[0].length) {			
			if(map[posH + dx[idx]][posW + dy[idx]] == '.') {	// 한칸앞이 평지일 경우
				map[posH + dx[idx]][posW + dy[idx]] = map[posH][posW];
				map[posH][posW] = '.';
				posH += dx[idx];	// 전차의 위치를 변경해준다.
				posW += dy[idx];
			}
		}
	}
	
	public static void shoot() {
		// 현재 전차의 방향에 따라 idx를 구해준다
		int idx = 0;
		if(map[posH][posW] == '^') {
			idx = 1;
		} else if(map[posH][posW] == 'v') {
			idx = 2;
		} else if(map[posH][posW] == '<') {
			idx = 3;
		} else if(map[posH][posW] == '>') {
			idx = 4;
		} 
		
		// 전차의 방향(idx)에 따라 조건에 만족하는 한 반복을 돌린다.
		int i = 1;
		while(true) {
			// 먼저 map밖으로 나가지 않는지 확인한다.
			if(posH + dx[idx] * i < 0 || posH + dx[idx] * i >= map.length || posW + dy[idx] * i < 0 || posW + dy[idx] * i >= map[0].length) {
				break;
			}
			if(map[posH+dx[idx]*i][posW+dy[idx]*i] == '#') break;
			if(map[posH+dx[idx]*i][posW+dy[idx]*i] == '*') {
				map[posH+dx[idx]*i][posW+dy[idx]*i] = '.';
				break;
			}
			i++;
		}
	}
}
