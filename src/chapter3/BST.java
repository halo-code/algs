package chapter3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private class Node{
		private Key key;
		private Value value;
		private Node left, right;
		private int N;
		
		public Node(Key key, Value value, int N){
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
	
	public int size(){
		return size(root);
	}
	
	public int size(Node x){
		
		if(x == null){
			return 0;
		}else{
			return x.N;
		}
	}
	
	public Value get(Key key){
		return get(root, key);
	}
	
	private Value get(Node x, Key key){
		if(x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			return get(x.left, key);
		}else if(cmp > 0){
			return get(x.right, key);
		}else{
			return x.value;
		}
	}
	
	public void put(Key key, Value value){
		root = put(root, key, value);
	}
	
	public Node put(Node x, Key key, Value value){
		if(x == null){
			return new Node(key, value, 1);
			
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			put(x.left, key, value);
		}else if(cmp > 0){
			put(x.right, key, value);
		}else{
			x.value = value;
				
			
		}
		
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min(){
		return min(root).key;
	}
	
	public Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
	}
	
	public Key max(){
		return max(root).key;
	}
	
	public Node max(Node x){
		if(x.right == null) return x;
		return max(x.right);
	}
	
	
	public Key ceiling(Key key){
		Node x = ceilling(root, key);
		if(x == null) return null;
		return x.key;
		
	}
	
	private Node ceilling(Node x, Key key){
		int cmp = key.compareTo(x.key);
		if(cmp > 0) return ceilling(x.right, key);
		if(cmp == 0) return x;
		Node node = ceilling(x.left, key);
		if(node == null) return x;
		return node;
		
	}
	
	public Key floor(Key key){
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key){
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left, key);
		//
		Node node = floor(x.right, key);
		if (node == null) return x;
		return node;
		
	}
	
	public Key select(int k){
		return select(root, k).key;
	}
	
	private Node select(Node x, int k){
		if(x == null) return null;
		int t = size(x.left);
		if(t == k) return x;
		if(t > k) return select(x.left, k);
		return select(x.right, k-t-1);
	
	}
	
	
	public int rank(Key key){
		return rank(root, key);
	}
	
	private int rank(Node x, Key key){
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return size(x.left);
		if(cmp < 0) return rank(x.left, key);
		
		return size(x.left) + 1 + rank(x.right, key);
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	//返回删除最小元素之后剩下的元素中树的root元素，保持查找树的特点
	private Node deleteMin(Node x){
		//不用判断
		//if(x == null) return null;
		
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key){
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return delete(x.left, key);
		else if(cmp > 0 ) return delete(x.right, key);
		else{
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			Node t = x;
			x = min(x.right);
			x.right = deleteMin(x.right);
			x.left = t.left;
			t = null;
			
			
		}
		
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Iterable<Key> keys(){
		return keys(min(), max());
	}
	
	private Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> queue = new LinkedList<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {

		if(x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		
		
		//重点理解，递归过程
		if(cmplo < 0) keys(x.left, queue, lo, hi);
		if(cmplo <= 0 && cmphi >= 0) queue.add(x.key);
		if(cmphi > 0) keys(x.right, queue, lo, hi);
		
	}
	
	
	
	
	
	
	
}
