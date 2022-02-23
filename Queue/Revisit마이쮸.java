package algorithm.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Revisit마이쮸 {
	public static void main(String[] args) {
		int myChew = 20;
		Queue<Integer> queue = new LinkedList<>();
		int[] num = new int[20];	// 사람마다 다음번에 가져갈 마이쮸의 갯수
		int nextP = 1;				// 다음번에 새로 들어올 사람의 번호
		while(true) {
			// 초기화 조건
			if(queue.isEmpty()) {
				queue.add(nextP);
				num[nextP]++;
				nextP++;
				System.out.println("큐에 들어가 있는 사람의 번호 순서 : " + queue.peek());
				System.out.println();
				continue;
			}
			
			int temp = queue.peek();
			myChew = myChew - num[queue.poll()];	// 큐의 제일 앞에 있는 번호의 마이쮸만큼 전체에서 빼주고 큐에서 삭제한다.
			if(myChew <= 0) {		// 종료조건
				System.out.println(temp + "번이 마지막 마이쮸를 가져갔습니다.");
				break;
			}
			System.out.println(temp + "번이 "+ num[temp] +" 개의 마이쮸를 받는다.");

			// 다시 줄을 서게 한다.
			queue.add(temp);
			num[temp]++;
			
			// 새로운 사람이 들어온다.
			queue.add(nextP);
			num[nextP]++;
			nextP++;
			
			
			System.out.print("큐에 들어가 있는 사람의 번호 순서 : ");
			Iterator<Integer> iter = queue.iterator();
			while(iter.hasNext()) System.out.print(iter.next() + " ");
			System.out.println();
			System.out.println(Arrays.toString(num));
			System.out.println();
		}
	}
}
