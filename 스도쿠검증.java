package algorithm;

import java.util.Scanner;

public class 스도쿠검증 {
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			map = new int[9][9];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			if(row() && col() && section()) result = 1;
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
	
	static boolean row() {
		for (int i = 0; i < map.length; i++) {
			boolean[] check = new boolean[map.length];
			for (int j = 0; j < map.length; j++) check[map[i][j]-1] = true;
			for (int j = 0; j < check.length; j++) {
				if(!check[j]) {
					return false;
				}
			}
		}
		return true;
	}
	static boolean col() {
		for (int i = 0; i < map.length; i++) {
			boolean[] check = new boolean[map.length];
			for (int j = 0; j < map.length; j++) check[map[j][i]-1] = true;
			for (int j = 0; j < check.length; j++) {
				if(!check[j]) {
					return false;
				}
			}
		}
		return true;
	}
	static boolean section() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boolean[] check = new boolean[map.length];
				for (int k = 3*i; k < 3*i + 3; k++) {
					for (int l = 3*j; l < 3*j + 3; l++) {
						check[map[k][l]-1] = true;
					}
				}
				for (int k = 0; k < check.length; k++) {
					if(!check[k]) {
						return false;
					}
				}
			}
			
		}
		return true;
	}
}
