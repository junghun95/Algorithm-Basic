package algorithm.List;

import java.util.Arrays;
import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case < T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int count = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i = 2; i < N-2; i++) {
				if(arr[i]>arr[i-1] && arr[i]> arr[i-2] && arr[i]>arr[i+1] && arr[i] > arr[i+2]) {
					int[] comp = new int[4];
					comp[0] = arr[i-2];
					comp[1] = arr[i-1];
					comp[2] = arr[i+1];
					comp[3] = arr[i+2];
					Arrays.sort(comp);
					count += arr[i] - comp[3];
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
		sc.close();
	}
}
