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
		//必须提取RUID
		//tuples[][0] ruid
		//tuples[][1] cuid
		
		CUID = tuple.getValue(1);
		for(int i = 0; i < 16; i++)
			tuples[0][i] = tuple.getValue(i);
		n++;
	}
	
	public void add(Tuple tuple) {
		for(int i = 0; i < 16; i++)
			tuples[n][i] = tuple.getValue(i);
		n++;
	}
	
	public void run() {
		if(this.CUID == null)
			return;
		
		Regex regex = new Regex(tuples[0][3]);
	
		String[] Content = new String[10];
		int Content_Num = 0;
		
		int line[][] = new int[10][100];
		int[] line_num = new int[10];
		for(int i = 2; i < 16; i++)
		{
			Content = new String[10];
			Content_Num = 0;

			for(int m = 0; m < 10; m++)
				for(int n = 0; n < 100; n++)
					line[m][n] = -1;
				
			line_num = new int[10];
			boolean same = false;
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < Content_Num; k++)
				{
					same = false;
					if(Content[k].equals(tuples[j][i]) )
					{
						same = true;
						line[k][line_num[k]++] = Integer.parseInt(tuples[j][0]); 
						break;
					}
				}
				if(!same)
				{
					
					Content[Content_Num] =  tuples[j][i];
					line[Content_Num][0] = Integer.parseInt(tuples[j][0]); 
					line_num[Content_Num++] = 1;
				}
			}
			int a = 1;
			int b = 2;
			a = a+b;
		}
		
		
		
	}

	
	public String get_CUID()
	{
		return this.CUID;
	}
}
