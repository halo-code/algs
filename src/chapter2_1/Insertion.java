package chapter2_1;

import edu.princeton.cs.introcs.StdOut;

public class Insertion {

	public static void sort(Comparable[] a) {

		// i 表示索引 前i个事有序的
		for (int i = 1; i < a.length; i++) {

			// 当后一个数据小于前一个，交换 否则，结束比较
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
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

}
