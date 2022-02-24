package algorithm;

import java.util.Scanner;

public class B직사각형을만드는방법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		int result = 0;
		
		for (int i = 1; i <= N/i; i++) {
			result += N/i - (i -1);
		}
		System.out.println(result);
	}
}
