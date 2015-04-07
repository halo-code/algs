package chapter2_1;

public class KendallTau {

	// 1....N分别填到数组中
	public static int[] permutation(int N) {
		int[] a = new int[N];

		for (int i = 0; i < N; i++) {
			int r = (int) (Math.random() * (i + 1));

			// 相当于交换
			a[i] = a[r];
			a[r] = i;

		}
		return a;

	}

	public static void show(int[] a) {
		for (int i : a) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// permutation(5);
		show(permutation(5));
		// System.out.println();
		show(permutation(5));
	}

}
