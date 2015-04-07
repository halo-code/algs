package chapter1_1;

public class Ln {
	public static double fac(int N){
		if (N == 1) return 0;
		return Math.log(N) + fac(N-1);
	}
	public static void main(String[] args){
		int N = 10;
		System.out.println(fac(N));
	}
}
