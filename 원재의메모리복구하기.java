package algorithm;

import java.util.Scanner;

public class 원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] arr = sc.next().toCharArray();
			char[] test = new char[arr.length];
			for (int i = 0; i < test.length; i++) {
				test[i] = '0';
			}
			int cnt = 0;
			for (int i = 0; i < test.length; i++) {
				if(test[i] != arr[i]) {
					for (int j = i; j < test.length; j++) {
						test[j] = arr[i];
					}
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}
