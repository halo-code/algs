package chapter2_1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N = 0;

	public MaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return pq.length;
	}

	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}

	public Key delMax() {
		Key max = pq[1];
		exch(pq, 1, N--);
		sink(1);
		// pq[N + 1] = null;
		System.out.println(max);
		return max;
	}

	

	private void swim(int k) {
		while (k > 1 && less(pq[k / 2], pq[k])) {
			exch(pq, k / 2, k);
			k /= 2;
		}
	}

	private void sink(int k) {
		while (k * 2 <= N) {
			int j = k * 2;
			// 选择两个子节点中较大的一个
			if (j < N && less(pq[j], pq[j + 1])) {
				j++;
			}
			// 判断父节点和较大子节点的大小，决定是否交换
			if (!less(pq[k], pq[j]))
				break;
			exch(pq, k, j);

			k = j;
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}

		StdOut.println();
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(i + "= " + pq[i] + "\n");

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MaxPQ<String> maxPQ = new MaxPQ<String>(10);
		maxPQ.insert("this");
		System.out.println(maxPQ);
		maxPQ.insert("is");
		System.out.println(maxPQ);
		maxPQ.insert("a");
		System.out.println(maxPQ);
		maxPQ.insert("test");
		System.out.println(maxPQ);
		while (!maxPQ.isEmpty()) {

			System.out.println(maxPQ.delMax());
			System.out.println(maxPQ);
		}

	}
}
