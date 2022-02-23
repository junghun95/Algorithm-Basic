package algorithm.List;

public class Gravity {
	public static void main(String[] args) {
		int[] input = {7, 4, 2, 0, 0, 6, 0, 7, 0};
		int result = 0;
		for(int i = 0; i < input.length; i++) {
			int temp = 0;
			for(int j = i+1; j < input.length; j++) {
				if(input[i]>input[j]) {
					temp++;
				}
			}
			if(result<temp) result = temp;
		}
		System.out.println(result);
	}
}