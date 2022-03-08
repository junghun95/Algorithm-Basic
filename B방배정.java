package algorithm;

import java.util.Scanner;

public class B방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[2][6];
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int g = sc.nextInt();
			arr[s][g-1]++;
		}
		int result = 0;
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][i] == 0) continue;
				else {
					if(arr[j][i] % K != 0) {
						result += arr[j][i]/K + 1;						
					}else {
						result += arr[j][i]/K;						
					}
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
