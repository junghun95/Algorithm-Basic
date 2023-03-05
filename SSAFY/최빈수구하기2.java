package algorithm.SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최빈수구하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			int[] count = new int[101];
			int max = 0;
			int caseNum = Integer.parseInt(br.readLine());
			// 1000명의 점수 입력받으면서 최빈값 구하기
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
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
	}
}
