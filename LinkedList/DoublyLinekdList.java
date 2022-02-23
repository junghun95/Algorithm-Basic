package algorithm.LinkedList;

public class DoublyLinekdList {
	private Node2 head;
	private Node2 tail;
	private int size;

	public DoublyLinekdList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// 위치 반환
	public Node2 search(int idx) {
		if (idx < 0 || idx >= size) {
			return null; // 예외 처리 가능
		}
		// 뒤에서부터 찾기
		Node2 curr;
		if (idx > size / 2) {
			curr = tail;
			for (int i = size - 1; i > idx; i--)
				curr = curr.prev;
		}
		// 앞에서부터 찾기
		else {
			curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.next;
			}
		}
		return curr;

	}
	
	public void addFirst(String data) {
		Node2 newNode = new Node2(data);
		
		newNode.next = head;
		
		//헤드가 널이 아니면 헤드이전을 새로운 노드로
		if(head != null)
			head.prev = newNode;
		
		head = newNode;
		size++;
		
		//노드가 새로운 노드 하나뿐이라면 시작이자 마지막노드
		if(head.next == null)
			tail = head;
	}
	
	public void addLast(String data) {
		Node2 newNode = new Node2(data);
		
		if(size == 0) {
			addFirst(data);
			return;
		}
		
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size++;
	}
	
	public void add(int idx, String data) {
		if(idx> size || idx < 0) return; //예외 처리 가능
		
		if(idx == 0) {
			addFirst(data);
			return;
		}
		if(idx == size) {
			addLast(data); 
			return;
		}
		
		
		Node2 preNode = search(idx-1);
		
		Node2 nextNode = preNode.next;
		
		Node2 newNode = new Node2(data);
		
		preNode.next = newNode;
		newNode.prev = preNode;
		
		newNode.next = nextNode;
		nextNode.prev = newNode;
		size++;
	}
	
	public String remove() {
		if(head == null) return "리스트공백";
		
		String data = head.data;
		
		Node2 nextNode = head.next;
		
		if(nextNode != null)
			nextNode.prev = null;
		
		head = head.next;
		size--;
		
		if(size == 0) tail = null;
		
		return data;
	}
	
	public String remove(int idx) {
		
		if(idx >= size || idx < 0) return "범위를 벗어났따";
		
		if(idx == 0) {
			String data = head.data;
			remove();
			return data;
		}
		
		Node2 preNode = search(idx-1);
		Node2 rmNode = preNode.next;
		Node2 nextNode = rmNode.next;
		
		String data = rmNode.data;
		
		if(nextNode != null) {
			nextNode.prev = null;
			nextNode.prev = preNode;
			preNode.next = nextNode;
		}else {
			tail = preNode;
		}
		size--;
		
		return data;
	}

}
