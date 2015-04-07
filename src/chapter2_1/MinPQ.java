package chapter2_1;

import edu.princeton.cs.introcs.StdOut;

/**
 * С����ʵ�ֵ����ȶ���
 * 
 * @author liumiao
 * 
 * @param <Key>
 */
public class MinPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N = 0;

	public MinPQ(int capacity) {
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

	public Key delMin() {
		Key max = pq[1];
		exch(pq, 1, N--);
		sink(1);
		// pq[N + 1] = null;
		System.out.println(max);
		return max;
	}

	private void swim(int k) {
		while (k > 1 && less(pq[k], pq[k / 2])) {
			exch(pq, k / 2, k);
			k /= 2;
		}
	}

	private void sink(int k) {
		while (k * 2 <= N) {
			int j = k * 2;
			// ѡ�������ӽڵ��н�С��һ��
			if (j < N && less(pq[j + 1], pq[j])) {
				j++;
			}
			// �жϸ��ڵ�ͽϴ��ӽڵ�Ĵ�С�������Ƿ񽻻�
			if (!less(pq[j], pq[k]))
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
		MinPQ<String> maxPQ = new MinPQ<String>(10);
		maxPQ.insert("this");
		System.out.println(maxPQ);
		maxPQ.insert("is");
		System.out.println(maxPQ);
		maxPQ.insert("a");
		System.out.println(maxPQ);
		maxPQ.insert("test");
		System.out.println(maxPQ);
		while (!maxPQ.isEmpty()) {

			System.out.println(maxPQ.delMin());
			System.out.println(maxPQ);
		}

	}
}
