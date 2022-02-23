package algorithm.LinkedList;

public class Node2 {
	
	public String data;
	public Node2 prev;
	public Node2 next;
	
	public Node2(String data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	@Override
	public String toString() {
		return "Node2 [data=" + data + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
}
