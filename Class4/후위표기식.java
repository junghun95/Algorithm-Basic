package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        char temp;
        for (int i = 0; i < command.length(); i++){
            temp = command.charAt(i);

            switch (temp){
                case '-':
                case '+':
                case '*':
                case '/': {
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(temp)){
                        sb.append(stack.pop());
                    }
                    stack.add(temp);
                    break;
                }
                case '(':{
                    stack.add(temp);
                    break;
                }
                case ')':{
                    while (!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                }
                default:{
                    sb.append(temp);
                }
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    private static int priority(Character C) {
        if (C == '*' || C == '/'){
            return 1;
        } else if (C == '+' || C == '-'){
            return 0;
        } else if (C == '(' || C == ')'){
            return -1;
        }
        return -2;
    }
}
