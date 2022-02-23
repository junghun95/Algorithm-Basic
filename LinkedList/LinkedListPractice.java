package algorithm.LinkedList;

public class LinkedListPractice {
	private Node1 head;
	private int size;

	public LinkedListPractice() {
		this.head = null;
		this.size = 0;
	}
	
	public Node1 search(int idx) {
		if(idx < 0 || idx >= size) {
			return null;
		}
		
		Node1 curr = head;
		
		for (int i = 0; i < idx; i++) {
			curr = curr.next;
		}
		return curr;
	}
	
	public void addFirst(int data) {
		Node1 newNode = new Node1(data);
		
		newNode.next = head;
		
		head = newNode;
		
		size++;
	}
	
	public void addLast(int data) {
		Node1 newNode = new Node1(data);
		
		if(size == 0) {
			addFirst(data);
			return;
		}
		
		Node1 curr = head;
		
		for(int i = 0; i < size; i++) {
			curr = curr.next;
		}
		curr.next = newNode;
		size++;
	}
	
	public void add(int idx, int data) {
		if(idx < 0 || idx >size) {
			return;
		}
		if(idx == 0) {
			addFirst(data);
			return;
		}
		if(idx == size) {
			addLast(data);
			return;
		}
		
		Node1 newNode = new Node1(data);
		
		Node1 pre = search(idx - 1);
		
		newNode.next = pre.next;
		
		pre.next = newNode;
		
		size++;
	}
	
	public int remove() {
		if(head == null) {
			return -1;
		}
		int data = head.data;
		
		head = head.next;
		size--;
		return data;
	}

	public int remove(int idx) {
		if(idx < 0 || idx > size) {
			return -1;
		}
		
		if(idx == 1) {
			return remove();
		}
		
		if(idx == size) {
			int data = search(size).data;
			search(size-1).next = null;
			size--;
			return data;
		}
		
		Node1 pre = search(idx - 1);
		int data = pre.next.data;
		pre.next = pre.next.next;
		size--;
		return data;
	}
	
	public void printList() {
		Node1 curr = head;
		if(head == null) {
			System.out.println("공백 리스트 입니다.");
			return;
		}
		for (int i = 0; i < size; i++) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();
	}
}
