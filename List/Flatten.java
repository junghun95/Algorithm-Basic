package algorithm.List;

import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int[] box = new int[100];
			int dump = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}

			for (int i = 0; i < dump; i++) {
				int min = 101;
				int max = 0;
				int minIdx = -1;
				int maxIdx = -1;
				for (int j = 0; j < box.length; j++) {
					if (box[j] > max) {
						max = box[j];
						maxIdx = j;
					}
					if (box[j] < min) {
						min = box[j];
						minIdx = j;
					}
				}
				box[minIdx]++;
				box[maxIdx]--;
			}
			int max = 0;
			int min = 101;
			for(int i = 0; i < box.length; i++) {
				if(box[i] > max) max = box[i];
				if(box[i] < min) min = box[i];
			}
			int result = max - min;
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
