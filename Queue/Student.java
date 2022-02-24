package algorithm.Queue;

public class Student implements Comparable<Student>{
	int no;
	int score;

	Student() {}

	public Student(int no, int score) {
		this.no = no;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.score - o.score;	// 음수일때 앞에 양수 일때 뒤에 이므로 이건 오름차순 // 내림차순할거면 -1 곱해주거나 빼주는 순서를 바꾼다
	}
}
