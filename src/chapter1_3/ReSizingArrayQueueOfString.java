package chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReSizingArrayQueueOfString<Item> implements Iterable<Item> {

	private Item[] array;
	private int N;
	private int start, end;
	
	public ReSizingArrayQueueOfString() {
		array = (Item[])new Object[2];
		start = 0;
		end = 0;
		N = 0;
	}
	public boolean isEmpty(){
		if(N == 0){
			return true;
		}
		return false;
	}
	public int size(){
		return N;
	}
	public void resize(int max){
		assert max >= N;
		Item[] temp = (Item[])new Object[max];
		for(int i = 0; i < N; i++){
			temp[i] = array[(start + i)%array.length];
		}
		array = temp;
		start = 0;
		end = N;
	}
	
	public void enqueue(Item item){
		
		if(N == array.length){
			resize(2 * array.length);
		}
		array[end ++] = item;
		if(end == array.length) end = 0;
		N++;
	}
	public Item dequeue(){
		if(isEmpty())throw new NoSuchElementException("Queue underflow");
		Item item = array[start];
		array[start] = null;
		N--;
		if(start == array.length) start = 0;
		if(N > 0 && N == array.length/4){
			resize(array.length/2);
		}
		return item;
	}
	public Item peek(){
		if(isEmpty())throw new NoSuchElementException("Queue underflow");
		return array[start];
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item>{
		private int i = 0;
		public boolean hasNext(){
			return i < N;
		}
		public Item next(){
			if(!hasNext())throw new NoSuchElementException();
			Item item = array[(i+start)/array.length];
			i++;
			return item;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReSizingArrayQueueOfString<String> q = new ReSizingArrayQueueOfString<String>();
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String item = in.next();
			if(!item.equals("-")) q.enqueue(item);
			else if(!q.isEmpty()) q.dequeue();
			
		}
		System.out.println(q.size());
		
	}
}
