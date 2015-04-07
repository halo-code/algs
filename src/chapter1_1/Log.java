package chapter1_1;

public class Log {
	public static void main(String[] args)
	{
		int cur_num=1;
		int result = 0;
		int N = Integer.parseInt(args[0]);
		for (int i = 0;i < N ; i++)
		{
			if (cur_num *2 > N)
			{
				break;
			}
			else
			{
				result++;
				cur_num *= 2;
			}
		}		System.out.println(result);
	}
}
