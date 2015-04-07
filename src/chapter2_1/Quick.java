package chapter2_1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Quick {

	public static void sort(Comparable[] a) {

		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		// Ð¡ÐÄ³õÊ¼Öµ
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			while (less(a[++i], v)) {
				// System.out.println("×ó²àÖ¸ÕëÓÒÒÆ");
				if (i == hi)
					break;
			}

			while (less(v, a[--j])) {
				// System.out.println("ÓÒ²àÖ¸Õë×óÒÆ");
				if (j == lo)
					break;
			}

			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
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
		Integer a[] = { 7, 4, 7, 1, 4, 5, 2, 3, 9, 8 };
		sort(a);
		show(a);
	}

}
