package chapter2_1;

import java.util.concurrent.Exchanger;

import edu.princeton.cs.introcs.In;

public class MyUnorderedArrayMaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N;

	public MyUnorderedArrayMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
		N = 0;
	}

	

	public void Insert(Key v) {
		pq[N++] = v;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Key max() {
		// 每次都排序不可取
		// Insertion.sort(pq);
		Key max = pq[0];
		for (int i = 1; i < N; i++) {
			if (less(max, pq[i])) {
				max = pq[i];
			}
		}
		return max;
	}

	public Key delMax() {

		int pos = 0;
		Key max = pq[0];
		for (int i = 1; i < N; i++) {
			if (less(max, pq[i])) {
				max = pq[i];
				pos = i;
			}
		}
		System.out.println("pos=" + pos);
		System.out.println("N=" + N);
		exch(pq, pos, N - 1);
		return pq[--N];
	}

	private void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private boolean less(Comparable a, Comparable b) {
		if (a.compareTo(b) < 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Integer a[] = new Integer[] { 2, 5, 4, 7, 9, 0, 2, 5 };
		// MyUnorderedArrayMaxPQ pq = new MyUnorderedArrayMaxPQ(a);
		MyUnorderedArrayMaxPQ pq = new MyUnorderedArrayMaxPQ(10);
		pq.Insert("this");
		pq.Insert("is");
		pq.Insert("a");
		pq.Insert("test");
		System.out.println("size = " + pq.size());

		while (!pq.isEmpty()) {
			System.out.println(pq.delMax());
		}

	}

}
