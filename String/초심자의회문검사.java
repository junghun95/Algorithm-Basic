package algorithm.String;

import java.util.Scanner;

public class 초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int cnt = 0;
			for(int i = 0; i < str.length()/2; i++) {
				if(str.charAt(i) == str.charAt(str.length()-1-i)) {
					cnt++;
					if(str.length()/2 == cnt) {
						System.out.println("#" + tc + " " + 1);						
					}
					continue;
				}
				else {
					System.out.println("#" + tc + " " + 0);
					break;
				}
			}
		}
		sc.close();
	}
}
