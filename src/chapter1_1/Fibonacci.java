package chapter1_1;

public class Fibonacci {
	public static long F(int N)
	{
		if(N == 0) return 0;
		if(N == 1) return 1;
		return F(N-1)+F(N-2);
	}

	public static void main(String[] args)
	{
		long startTime=System.currentTimeMillis();
/*		long [] FF = new long [100];
		
		FF[1] = 1;
		for(int N = 0; N < 50; ++N)
		{
			if(N == 0)
				FF[0] = 0;
			else if(N == 1)
				FF[1] = 1;
			else
				FF[N] = FF[N-1]+FF[N-2];
			System.out.println(FF[N]);
		}
*/
		for(int N = 0;N < 50; N++)
			System.out.println(N + " " + F(N));
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}
}
