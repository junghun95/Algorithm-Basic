package algorithm.Class2;

import com.sun.corba.se.spi.orbutil.fsm.InputImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "push":{
                    int a = Integer.parseInt(st.nextToken());
                    stack.push(a);
                    break;
                }
                case "pop":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else sb.append(stack.pop()).append("\n");
                    break;
                }
                case "size":{
                    sb.append(stack.size()).append("\n");
                    break;
                }
                case "empty":{
                    if (stack.isEmpty()){
                        sb.append(1).append("\n");
                    }else sb.append(0).append("\n");
                    break;
                }
                case "top":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
