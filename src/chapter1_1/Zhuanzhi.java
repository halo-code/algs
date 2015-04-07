package chapter1_1;

public class Zhuanzhi {
	public static void main(String[] args)
	{
		//final int M = 2,N = 2;
		int temp;
		int [][] elem = new int[][]{{1,3},{2,5}};
		for(int i = 0 ; i < 2 ; ++i)
			for(int j = 0; j < 2; ++j)
			{
				if(i < j)
				{
					temp = elem[j][i];
					elem[j][i] = elem[i][j];
					elem[i][j] = temp;
				}
			}
		for(int i = 0 ; i < 2 ; ++i)
		{
			for(int j = 0; j < 2; ++j)
			{
				System.out.print(elem[i][j]+" ");
			}
			System.out.println();
		}
	}
}
