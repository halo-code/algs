package chapter1_3;

public class DeleteTail<Item> {

	private Node<Item> first;
	private int N;
	public int getN(){
		return N;
	}
	
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteTail<String> dt = new DeleteTail<String>();
		Node<String> p = new Node<String>();
		for(int i = 0; i < dt.getN()-1; i++){
			p = p.next;
		}
		Node<String> q = p.next;
		p.next = null;
	}
}

