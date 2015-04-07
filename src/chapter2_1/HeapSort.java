package chapter2_1;

import edu.princeton.cs.introcs.StdOut;

public class HeapSort {

	public static void sort(Comparable[] a) {
		int N = a.length-1;
		for (int k = N / 2; k >= 1; k--) {
			sink(a, k, N);
		}
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}

	}

	private static void sink(Comparable[] a, int k, int N) {

		while (k * 2 <= N) {
			int j = 2 * k;
			if (j < N && less(a[j], a[j + 1])) {
				j++;
			}

			if (!less(a[k], a[j])) {
				break;
			}
			exch(a, k, j);

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

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1, 21, 4, 8, 3, 7 };

		sort(a);
		show(a);
	}
}
