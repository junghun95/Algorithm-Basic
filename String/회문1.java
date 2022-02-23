package algorithm.String;

import java.util.Scanner;

public class 회문1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T =10;
		for(int tc = 1; tc <= T; tc++) {
			char[][] map = new char[8][8];
			int len = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < 8; i++) {
				map[i] = sc.nextLine().toCharArray();
			}
			int cntR = 0;
			int cntC = 0;
			for(int k =0; k < 8; k++) {
				middle: for(int i = 0; i <= 8-len; i++) {
					for(int j = 0; j <len/2; j++) {
						if(map[k][i+j] != map[k][i+len-j-1]) {
							continue middle;
						} else if(j == len/2 -1) {
							cntR++;
							continue middle;
						}
					}
				}			
			}
			for(int k =0; k < 8; k++) {
				middle: for(int i = 0; i <= 8-len; i++) {
					for(int j = 0; j <len/2; j++) {
						if(map[i+j][k] != map[i+len-j-1][k]) {
							continue middle;
						} else if(j == len/2 -1) {
							cntC++;
							continue middle;
						}
					}
				}			
			}
			int result = cntR+cntC;
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
