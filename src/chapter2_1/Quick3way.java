package chapter2_1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Quick3way {

	public static void sort(Comparable[] a) {

		//StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		System.out.println("v=" + v);
		while (i <= gt) {

			int cmp = a[i].compareTo(v);

			if (cmp < 0) {
				// a[i] < v;
				System.out.println(a[i] + " < " + v);
				exch(a, i++, lt++);
				
				
				

			} else if (cmp > 0) {
				// a[i] > v;
				System.out.println(a[i] + " > " + v);
				exch(a, i, gt--);

			} else {
				System.out.println(a[i] + " = " + v);
				i++;
			}
		}

		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
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
