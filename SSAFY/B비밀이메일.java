package algorithm.SSAFY;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B비밀이메일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Queue<Character> list = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		sc.close();
		int R = 1;
		int C = list.size();
		int rtemp = R;
		while(true) {
			rtemp++;
			if(list.size() % rtemp == 0 && rtemp <= list.size() / rtemp) {
				R = rtemp;
				C = list.size() / rtemp;
			}
			if(rtemp >= C) break;
		}
		char[][] result = new char[R][C];
		for (int i = 0; i < result[0].length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[j][i] = list.poll();
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]);
			}
		}
		
	}
}
