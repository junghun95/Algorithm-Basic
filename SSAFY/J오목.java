package algorithm.SSAFY;

import java.util.Scanner;

public class J오목 {
	static int[][] map = new int[20][20];
	static boolean[][] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length-4; j++) {
				if(map[i][j] != 0) {
					if(rowSearch(i,j)) {
						System.out.println(map[i][j]);
						System.out.println(i + " " + j);
						return;
					}
					while(map[i][j] == map[i][j+1]) {
						j++;
						if(j>= 19)break;
					}
				}
			}
		}
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length-4; j++) {
				if(map[j][i] != 0) {
					if(colSearch(j,i)) {
						System.out.println(map[j][i]);
						System.out.println(j + " " + i);
						return;
					}
					while(map[j][i] == map[j+1][i]) {
						j++;
						if(j>= 19)break;
					}
				}
			}
		}
		flag = new boolean[20][20];
		for (int i = 1; i < map.length - 4; i++) {
			for (int j = 1; j < map.length-4; j++) {
				if(map[i][j] != 0) {
					if(dCrossSearch(i,j)) {
						System.out.println(map[i][j]);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		flag = new boolean[20][20];
		for (int i = 5; i < map.length; i++) {
			for (int j = 1; j < map.length-4; j++) {
				if(map[i][j] != 0) {
					if(uCrossSearch(i,j)) {
						System.out.println(map[i][j]);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		System.out.println(0);
		
	}

	private static boolean uCrossSearch(int i, int j) {
		int cnt = 1;
		flag[i][j] = true;
		while(map[i][j] == map[i-1][j+1] && !flag[i-1][j+1]) {
				flag[i-1][j+1] = true;
				cnt++;
				i--;
				j++;
				if(i<0 || j>= 19) break;
		}
		if(cnt == 5) return true;
		return false;
	}

	private static boolean dCrossSearch(int i, int j) {
		int cnt = 1;
		flag[i][j] = true;
		while(map[i][j] == map[i+1][j+1] && !flag[i+1][j+1]) {
				flag[i+1][j+1] = true;
				cnt++;
				i++;
				j++;
				if(i>=19 || j>=19) break;
		}
		if(cnt == 5) return true;
		return false;
	}

	private static boolean colSearch(int j, int i) {
		int cnt = 1;
		while(map[j][i] == map[j+1][i]) {
				cnt++;
				j++;
				if(j>=19) break;
		}
		if(cnt == 5) return true;
		return false;
	}

	private static boolean rowSearch(int i, int j) {
		int cnt = 1;
		while(map[i][j] == map[i][j+1]) {
				cnt++;
				j++;
				if(j >= 19) break;
		}
		if(cnt == 5) return true;
		return false;
	}
}
