package algorithm.List;

import java.util.Scanner;

public class 최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int[] count = new int[101];
			int max = 0;
			int caseNum = sc.nextInt();
			
			// 1000명의 점수 입력받으면서 최빈값 구하기
			for(int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				count[score]++;
				max = Math.max(max, count[score]);
			}
			
			// 최빈값중 점수가 가장 큰값 출력하기 
			for(int i = count.length-1; i>=0; i--) {
				if(count[i] == max) {
					System.out.println("#" + caseNum + " " + i);
					break;
				}
			}
		}
		sc.close();
	}
}
