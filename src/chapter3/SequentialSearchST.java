package chapter3;

/**
 * 由链表实现的符号表<Key, Value>
 * 
 * @author liumiao
 * 
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {

	private Node first;
	private int count;

	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public Value get(Key key) {
		if(isEmpty()){
			return null;
		}
		for (Node x = first; x != null; x = x.next) {
			if (x.key.equals(key)) {
				return x.val;
			}
		}
		return null;
	}

	public void put(Key key, Value val) {
		for (Node x = first; x != null; x = x.next) {
			if (x.key.equals(key)) {
				x.val = val;

				return;
			}
		}
		count++;
		first = new Node(key, val, first);
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	// 此处的设计是不是应该有返回值
	public void delete(Key key) {
		if (isEmpty()) {
			return;
		}

		// 如果删除表头节点
		if (first.key.equals(key)) {

			first = first.next;
			count--;
			System.out.println("delete first node");
			return;
		}

		// 如果不是表头节点
		Node pre_x = first; // 比较节点的前一个节点
		for (Node x = first.next; x != null; x = x.next, pre_x = pre_x.next) {

			if (x.key.equals(key)) {

				pre_x.next = x.next;
				x = null;
				count--;
				System.out.println("delete target node");
				return;

			}
		}
	}

	public void show() {
		System.out.println("size = " + count);
		for (Node x = first; x != null; x = x.next) {
			System.out.println("key = " + x.key + ", value = " + x.val);
		}
	}

	public static void main(String[] args) {
		SequentialSearchST<Integer, String> ssst = new SequentialSearchST<Integer, String>();
		ssst.put(1, "this");
		ssst.put(2, "is");
		ssst.put(3, "a");
		ssst.put(4, "test");

		ssst.show();

		ssst.delete(4);
		ssst.show();
		ssst.delete(1);
		ssst.show();
	}

}
