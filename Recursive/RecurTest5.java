package algorithm.Recursive;

public class RecurTest5 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(solve(arr,0));	// 배열에 있는 요소의 합을 구하기
		System.out.println(solve(arr,0, 0));	// 배열에 있는 요소의 합을 구하기
	}
	
	static int solve(int[] arr, int idx) {
		if(idx == arr.length) return 0;
		return arr[idx] + solve(arr,idx+1);
	}
	static int solve(int[] arr, int idx, int sum) {
		if(idx == arr.length) return sum;
		return solve(arr, idx+1, sum + arr[idx]);
	}
}
