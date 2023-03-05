package algorithm.SSAFY;

import java.util.Scanner;

public class B스위치켜고끄기 {
	static int[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		int N = sc.nextInt();
		list = new int[N+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[][] student = new int[M][2];
		for (int i = 0; i < student.length; i++) {
			student[i][0] = sc.nextInt();
			student[i][1] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < M; i++) {
			if(student[i][0]==1) {	// 남학생인 경우
				int a = student[i][1];
				for (int j = a; j <= N; j += a) {
					onOff(j);
				}
			}else {					// 여학생인 경우
				int a = student[i][1];
				if(a==1 || a==N) {
					onOff(a);
				}else {
					onOff(a);
					int j =1;
					while(a-j>0 && a+j<=N) {
						if(list[a-j] == list[a+j]) {
							onOff(a-j);
							onOff(a+j);
							j++;
						} else {
                            break;
                        }
					}
					
				}
			}
		}
		for (int i = 1; i < list.length; i++) {
			System.out.print(list[i] + " ");
			if(i%20 == 0) System.out.println();
		}
		
		
	}
	
	public static void onOff(int i) {
		if(list[i] == 0) {
			list[i] = 1;
		} else {
			list[i] = 0;
		}
	}
}
