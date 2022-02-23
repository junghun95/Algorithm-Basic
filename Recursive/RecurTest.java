package algorithm.Recursive;

public class RecurTest {
	public static void main(String[] args) {
		solve2(10);
	}
	
	static void solve2(int n) {
		if(n == 0) {
			return;
		}
		System.out.println(n);
		solve2(n-1);
	}
}
