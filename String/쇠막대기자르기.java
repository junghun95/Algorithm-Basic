package algorithm.String;

import java.util.Scanner;

public class 쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// '()'를 만나면 result에 cnt를 더해주고
		// '(' 이거면 cnt에 1더해주고
		// ')' 이거면 cnt에 1빼주고 result에 1 더해주면된다.
		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			int result = 0;
			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					if(str.charAt(i+1) ==  ')') {
						result += cnt;
						i++;
						continue;
					}
					cnt++;
				} else {
					cnt--;
					result++;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
