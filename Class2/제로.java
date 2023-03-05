package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int val = Integer.parseInt(br.readLine());

            if(val == 0){
                stack.pop();
            } else stack.add(val);

        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
