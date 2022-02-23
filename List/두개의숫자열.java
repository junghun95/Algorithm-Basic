package algorithm.List;

import java.util.Scanner;

public class 두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] a = new int[N];
			int[] b = new int[M];
			int temp = Integer.MIN_VALUE;
			for(int i =0; i<N; i++) {
				a[i] = sc.nextInt();
			}
			for(int i =0; i<M; i++) {
				b[i] = sc.nextInt();
			}
			if(N<=M) {
				int round = M-N;
				for(int i = 0; i <= round; i++) {
					int sum = 0;
					for(int j = 0; j<N; j++) {
						sum += a[j]*b[j+i];
					}
					if(sum>temp) temp = sum;
				}
				System.out.println("#" + tc + " " + temp);
				continue;
			} else {
				int round = N-M;
				for(int i = 0; i <= round; i++) {
					int sum = 0;
					for(int j = 0; j<M; j++) {
						sum += a[j+i]*b[j];
					}
					if(sum>temp) temp = sum;
				}
				System.out.println("#" + tc + " " + temp);
				continue;
			}
		}
		sc.close();
	}
}
