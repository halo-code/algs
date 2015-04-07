package chapter2_1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

public class SortCompare {

	public static double time(String alg, Double[] a) {
		Stopwatch time = new Stopwatch();
		if (alg.equals("Selection"))
			Selection.sort(a);
		if (alg.equals("Insertion"))
			Insertion.sort(a);
		if (alg.equals("Shell"))
			Shell.sort(a);
		if (alg.equals("OneSideQuick"))
			OneSideQuick.sort(a);
		return time.elapsedTime();
	}

	public static double timeRandomInput(String args, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {

			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform();
			}

			total += time(args, a);
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String alg1 = args[0];
		String alg2 = args[1];

		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);

		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);

		System.out.println("time1= " + t1);
		System.out.println("time2= " + t2);
		StdOut.printf("For %d random doubles\n     %s is  %.1f faster than %s",
				N, alg1, t2 / t1, alg2);
	}
}
