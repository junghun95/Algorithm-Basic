package algorithm.String;

import java.util.Scanner;

public class 간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int cnt = 1;
			int num = i;
			while (true) {
				if (num / 10 != 0) {
					cnt++;
					num /= 10;
				} else {
					break;
				}
			}
			int cnt1 = 0;
			for (int j = 0; j < cnt; j++) {
				char c = Integer.toString(i).charAt(j);
				if (c == '3' || c == '6' || c == '9') { // 3,6,9들어있으면 '-'출력하기
					cnt1++;
				}
			}
			if(cnt1 == 0) {
				System.out.print(i);
			} else {
				for (int j = 0; j < cnt1; j++) {
					System.out.print('-');
				}
			}
			System.out.print(" ");
		}
		sc.close();
	}
}