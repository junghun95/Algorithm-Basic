package algorithm.Recursive;

public class RecurTest03 {
	public static void main(String[] args) {
		System.out.println(solve1(10,4));	// 10의 4승을 구하라
		System.out.println(solve2(10,4));	// 10의 4승을 구하라
	}
	
	static int solve1(int n, int cnt) {
		int ans = 1;
		for (int i = 1; i <= cnt; i++) {
			ans *= n;
		}
		return ans;
	}
	
	static int solve2(int n, int cnt) {
		if(cnt == 0) {
			return 1;
		}
		return n * solve2(n,cnt-1);
	}
}
