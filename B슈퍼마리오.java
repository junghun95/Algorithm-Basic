package algorithm;

import java.util.Scanner;

public class B슈퍼마리오 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		for (int i = 0; i < 10; i++) {
			int temp = sc.nextInt();
			if(Math.abs(result-100) >= Math.abs(result+temp -100)) {
				result += temp;
			} else {
				break;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
