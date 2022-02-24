package algorithm;

import java.util.Scanner;

public class 숫자배열회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] arr1 = rotate(arr);
			int[][] arr2 = rotate(arr1);
			int[][] arr3 = rotate(arr2);
			
			System.out.println("#" + tc);
			for (int i = 0; i < arr.length; i++) { // 출력 한줄씩
				for (int j = 0; j < 3; j++) { // arr1,2,3 돌아가면서
					if(j == 0) { // arr1
						for (int k = 0; k < arr1.length; k++) {
							System.out.print(arr1[i][k]);
						}
					}else if(j == 1) {
						for (int k = 0; k < arr2.length; k++) {
							System.out.print(arr2[i][k]);
						}
					}else {
						for (int k = 0; k < arr3.length; k++) {
							System.out.print(arr3[i][k]);
						}						
					}
					System.out.print(" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
	
	public static int[][] rotate(int[][] arr){	// 90도 씩 회전
		int[][] result = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				result[i][j] = arr[arr.length-1-j][i];
			}
		}
		return result;
	}
}
