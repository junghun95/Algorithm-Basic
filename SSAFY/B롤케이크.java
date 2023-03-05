package algorithm.SSAFY;

import java.util.Scanner;

public class B롤케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int[] roll = new int[L+1];
		int N = sc.nextInt();
		int[][] arr = new int[N+1][2];
		int result1 = 0;
		int temp = 0;
		int result2 = 0;
		int temp2 = 0;
		for (int i = 1; i <= N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			if(temp < arr[i][1] - arr[i][0]) {	// 같은 값일때 아이디가 작은 사람이 나오게
				 temp = arr[i][1] - arr[i][0];
				 result1 = i;
			}
			int cnt = 0;
			for (int j = arr[i][0]; j <= arr[i][1]; j++) {
				if(roll[j] == 0) {
					roll[j] = i;
					cnt++;
				}
			}
			if(temp2 < cnt) {
				temp2 = cnt;
				result2 = i;
			}
		}
		sc.close();
		System.out.println(result1);
		System.out.println(result2);
	}
}
