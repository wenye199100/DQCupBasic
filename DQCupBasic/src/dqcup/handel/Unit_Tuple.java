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
		
		
	
		String[] Content = new String[10];
		int Content_Num = 0;
		
		int line[][] = new int[10][100];
		int[] line_num = new int[10];
		for(int i = 2; i < 16; i++)
		{
			Regex regex = null;
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
			//
			if(Content_Num == 1)
			{
				regex = new Regex(tuples[line[0][0]][7]);
				if(regex.select_regex(i, Content[0]))
				{
					
				}
			}
			else 
			{
				for(int k = 0; k < Content_Num; k++)
				{
					regex = new Regex(tuples[line[k][0]][7]);
					if(regex.select_regex(i, Content[k]))
					{
						
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
