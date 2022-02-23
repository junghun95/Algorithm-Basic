package algorithm.Stack1;
class StackFullException extends RuntimeException{}
class StackEmptyException extends RuntimeException{}
public class Stack계산기 {
	static int[] stack = new int[10];
	static int top = -1;
	public static void main(String[] args) {
		
		push(1);
		push(2);
		push(3);
		
		System.out.println(peek());	//3
		System.out.println(peek());	//3
		while(!isEmpty()) {
			System.out.println(pop());
		}
		
	}
	
	public static boolean push(int num) {
		if(isFull()) {
			throw new StackFullException();
		}
		stack[++top] = num;
		return true;
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static int pop() {
		/*if(isEmpty()) {
			throw new StackEmptyException();
		}
		return stack[top--];*/
		int value = peek();
		top--;
		return value;
	}
	
	public static int peek() {
		if(isEmpty()) {
			throw new StackEmptyException();
		}
		return stack[top];
	}
	
	public static boolean isFull() {
		return top == stack.length-1;
	}
}
