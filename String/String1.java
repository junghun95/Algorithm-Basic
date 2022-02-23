package algorithm.String;

import java.util.Scanner;

public class String1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc =1; tc <= T; tc++) {
			sc.next();
			
			char[] target = sc.next().toCharArray();
			char[] str = sc.next().toCharArray();
			int cnt = 0;
			outer: for(int i = 0; i <= str.length - target.length; i++) {
				for(int j = 0; j<target.length; j++) {
					if(str[i+j] != target[j]) {
						continue outer;
					} else if(j == target.length-1) {
						cnt++;
						continue outer;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}
