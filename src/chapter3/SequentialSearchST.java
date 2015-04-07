package chapter3;

/**
 * ������ʵ�ֵķ��ű�<Key, Value>
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

	// �˴�������ǲ���Ӧ���з���ֵ
	public void delete(Key key) {
		if (isEmpty()) {
			return;
		}

		// ���ɾ����ͷ�ڵ�
		if (first.key.equals(key)) {

			first = first.next;
			count--;
			System.out.println("delete first node");
			return;
		}

		// ������Ǳ�ͷ�ڵ�
		Node pre_x = first; // �ȽϽڵ��ǰһ���ڵ�
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
