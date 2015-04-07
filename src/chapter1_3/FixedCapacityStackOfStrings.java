package chapter1_3;

public class FixedCapacityStackOfStrings {

	private String[] a ;
	int N;
	int cap;
	public FixedCapacityStackOfStrings(int cap){
		N = 0;
		this.cap = cap;
		a = new String[cap];
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public boolean isFull(){
		return N == cap;
	}
	public void push(String item){
		if(!isFull())
			a[N++] = item;
		else
			return;
	}
	public String pop(){
		if(!isEmpty())
			return a[N--];
		else
			return null;
	}
	
	public static void main(String[] args){
		FixedCapacityStackOfStrings fcs = new FixedCapacityStackOfStrings(3);
		fcs.push("not");
		fcs.push("to");
		fcs.push("be");
		System.out.println(fcs.isFull());
	}
}
