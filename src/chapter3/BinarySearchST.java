package chapter3;

import edu.princeton.cs.introcs.In;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] vals;

	private int N;

	public BinarySearchST(int capcity) {
		// keys = new Key[capcity]; error 在java中不允许创建泛型数组
		keys = (Key[]) new Comparable[capcity];
		vals = (Value[]) new Object[capcity];
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}

		int i = rank(key);

		// 判断的理由:rank()返回的并不一定是key所在的位置，而是返回表中小于给定键的键的数量,i有可能等于N
		if (i < N && keys[i].compareTo(key) == 0) {
			return vals[i];
		}
		return null;

	}

	public void put(Key key, Value value) {
		int i = rank(key);
		System.out.println("put rank = " + i);

		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = value;
			return;
		}

		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];

		}
		keys[i] = key;
		vals[i] = value;
		N++;

	}

	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}

		return lo;

	}

	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[N - 1];
	}

	public Key select(int k) {
		return keys[k];
	}

	// >=
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}

	// <=
	public Key floor(Key key) {
		// rank()前面的值，考虑多种情况
		int i = rank(key);
		int cmp = keys[i].compareTo(key);

		// =
		if (cmp == 0) {
			return keys[i];
		}

		// >
		if (i == 0) {
			return null;
		} else {
			return keys[i - 1];
		}

	}

	public void show() {
		for (int i = 0; i < N; i++) {
			System.out.println("key = " + keys[i] + ", value = " + vals[i]);
		}
	}

	public static void main(String[] args) {
		BinarySearchST<Integer, String> bsst = new BinarySearchST<Integer, String>(
				10);

		bsst.put(1, "this");
		bsst.put(3, "a");
		bsst.put(5, "is");

		bsst.put(4, "test");
		bsst.show();

		System.out.println(bsst.ceiling(6));
		System.out.println(bsst.floor(0));

		//System.out.println(bsst.rank(3));
	}

}
