package day0409;

import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	public static StringBuilder sb = new StringBuilder();
	public static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++){
			String str = sc.next();
			for (int j = 0; j < N; j++){
				map[i][j] = str.charAt(j) - '0';
			}
		}
		sc.close();

		Tree(0, 0, N);
		System.out.println(sb);
	}

	public static void Tree(int x, int y, int size){
		// 처음엔 해당하는 범위를 모두 탐색하며 다른 값이 있는지 체크하기
		// 없다면 그냥 해당하는 숫자를 출력하고 리턴
		// 있다면 괄호를 추가해주고 다시 재귀호출
		// 출력을 스트링빌더를 사용해서 편하게 이용하기(?)

		// 범위를 가져오려면 매개변수를 어떻게 설정해야 할까?
		// 몇 사분면인지를 매개변수로 받아야 될거 같다 -> 각 사분면의 시작점 좌표를 매개변수로 주고 size를 주면
		// 해당하는 곳의 탐색을 할 수 있다.
		if(isPossible(x, y, size)){
			sb.append(map[x][y]);
			return;
		}

		sb.append('(');

		Tree(x, y, size / 2);
		Tree(x, y + (size / 2), size / 2);
		Tree(x + (size / 2), y, size / 2);
		Tree(x + (size / 2), y + (size / 2), size / 2);

		sb.append(')');
	}

	public static boolean isPossible(int x, int y, int size) {
		int chk = map[x][y];
		for(int i = x; i < x + size; i++){
			for (int j = y; j < y + size; j++){
				if(map[i][j] != chk){
					return false;
				}
			}
		}
		return true;
	}
}
