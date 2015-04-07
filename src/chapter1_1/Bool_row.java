package chapter1_1;

public class Bool_row {
	public static void main(String[] agrs)
	{
		boolean[][] raw = new boolean[][]{{false,true},{true,true}};
		for(int i = 0 ;i < 2; ++i)
		{
			for(int j = 0; j < 2; ++j)
			{
				if (raw[i][j])
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
