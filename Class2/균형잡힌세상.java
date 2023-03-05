package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String str = br.readLine();
            if(str.charAt(0) == '.') break;
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.add('(');
                } else if (str.charAt(i) == ')'){
                    if(!stack.isEmpty() && stack.pop() == '('){
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (str.charAt(i) == '['){
                    stack.add('[');
                } else if (str.charAt(i) == ']'){
                    if(!stack.isEmpty() && stack.pop() == '['){
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty()){
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
