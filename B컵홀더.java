package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B컵홀더 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		sc.close();
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 'S') queue.offer('S');
			else {
				queue.offer('L');
				i++;
			}
		}
		System.out.println(Math.min(queue.size()+1, N));
	}
}
