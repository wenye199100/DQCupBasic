package dqcup.handel;

import dqcup.repair.Tuple;

public class Unit_Tuple {
	private String CUID;
	private String[][] tuples = new String[100][16];
	private int n = 0;
	
	public Unit_Tuple()
	{
		
	}
	
	public Unit_Tuple(Tuple tuple)
	{
		CUID = tuple.getValue(1);
		for(int i = 0; i < 15; i++)
			tuples[0][i] = tuple.getValue(i + 1);
		n++;
	}
	
	public void add(Tuple tuple) {
		for(int i = 0; i < 15; i++)
			tuples[n][i] = tuple.getValue(i + 1);
		n++;
	}
	
	public void run() {
		Regex regex = new Regex(tuples[0][3]);
		String[] Content = new String[10];
		int[][] line = new int[10][100];
		for(int i = 0; i < 15; i++)
		{
			boolean same = false;
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < Content.length; k++)
				{
					if(Content[k].equals(tuples[i][j]) )
					{
						line[][] = 
					}
				}
			}
		}
	}

	
	public String get_CUID()
	{
		return this.CUID;
	}
}
