package algorithm.Recursive;

public class RecurTest4 {
	public static void main(String[] args) {
		System.out.println(solve1(12345));	// 각 자릿수의 합을 구하라
		System.out.println(solve2(12345));	// 각 자릿수의 합을 구하라
	}
	
	static int solve1(int n) {
		int ans = 0;
		while(true) {
			ans += n%10;
			if(n < 10) break;
			n = n/10;
			
		}
		return ans;
	}
	
	static int solve2(int n) {
		if(n/10 == 0) {
			return n%10;
		}
		
		return n%10 + solve2(n/10);
	}
}
