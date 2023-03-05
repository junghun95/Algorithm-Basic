package algorithm.SSAFY;

import java.util.Scanner;

public class 준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if(M==N) {
				System.out.print("#" + tc + " " + (M+1));
			}else if(M>N) {
				System.out.print("#" + tc + " ");
				for (int i = 0; i < M-N+1; i++) {
					System.out.print(N+i+1 + " ");
				}
			} else {
				System.out.print("#" + tc + " ");
				for (int i = 0; i < N-M+1; i++) {
					System.out.print(M+i+1 + " ");
				}		
			}
			System.out.println();
		}
		sc.close();
	}
}
