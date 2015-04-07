package chapter1_3;

import java.util.Iterator;
import java.util.Scanner;

class Queue<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()){
			first = last;
		}
		else{
			oldlast.next = last;
		}
		N ++;
	}
	
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(first == last){
			last = null;
		}
		N--;
		return item;
	}
	public Item deleteK(int k){
		Node n = first;
		if(k == 0){
			first = first.next;
			Item i = n.item;
			n = null;
			N--;
			return i;
			
		}
		else if(N == k){
			last=null;
			N--;
		}
		else if(N > k){
			for(int i = 0; i < k-1; i++){
				n = n.next;
			}
			Node temp = n.next;
			Item item = temp.item;
			n.next = temp.next;
			temp = null;
			N--;
			return item;
		}
		else{
			System.out.print("have elements less than k");
			
		}
		return null;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Iterator<Item> it = iterator();
		StringBuilder str = new StringBuilder();
		while(it.hasNext()){
			str = str.append(it.next().toString());
		}
		return str.toString();
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListQueueIterator();
	}
	private class ListQueueIterator implements Iterator<Item>{//将泛型放在所在位置的困惑

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}
		public Node getNode(){
			return current;
		}
	}
	
}
public class ListQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> q = new Queue<String>();
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			q.enqueue(in.next());
		}
		System.out.println(q.deleteK(0));
		System.out.println(q);
	}
	

}
