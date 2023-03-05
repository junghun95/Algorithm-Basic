package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.add('(');
                } else if(stack.isEmpty()){
                    flag = false;
                    break;
                } else stack.pop();
            }
            if(flag && stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
