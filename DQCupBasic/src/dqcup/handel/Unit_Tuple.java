package dqcup.handel;

import java.util.HashSet;
import java.util.Set;

import dqcup.repair.RepairedCell;
import dqcup.repair.Tuple;

public class Unit_Tuple {
	private String CUID;
	private String[][] tuples = new String[100][16];
	private int n = 0;
	private Set<RepairedCell> set = new HashSet();
	private String[] columnId = {"RUID","CUID","SSN","FNAME","MINIT","LNAME","STNUM","STADD","APMT","CITY","STATE","ZIP","BIRTH","AGE","SALARY","TAX"};
	
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
	
	public Set<RepairedCell> run() {
		if(this.CUID == null)
			return null;
		
		
	
		String[] Content = new String[10];
		int Content_Num = 0;
		
		int line[][] = new int[10][100];
		int[] line_num = new int[10];
		
		//遍历所有的属性，列
		for(int i = 2; i < 16; i++)
		{
			
			Regex regex = null;
			Content = new String[10];
			Content_Num = 0;

			//初始化
			for(int m = 0; m < 10; m++)
				for(int n = 0; n < 100; n++)
					line[m][n] = -1;
				
			line_num = new int[10];
			boolean same = false;
			//遍历相同cuid的人
			for(int j = 0; j < n; j++)
			{
				
				//遍历不同的值，行
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
			//只有一个值的时候,暂时无处理
			if(Content_Num == 1)
			{
//				regex = new Regex(tuples[line[0][0]][7]);
//				if(regex.select_regex(i, Content[0]))
//				{
//					
//				}
			}
			//将少数标记为错
			if(Content_Num > 1)
			{
				int max = -1;
				int m = -1;
				String string = "";
				for(int j = 0 ; j < Content_Num; j++)
				{
					if(line_num[j] > max)
					{
						max = line_num[j];
						m = j;
						string = Content[j];
					}
				}
				for(int j = 0 ; j < Content_Num; j++)
				{
					if(j != m)
					{
						RepairedCell repairedCell = new RepairedCell(line[j][0], columnId[i], string);
						set.add(repairedCell);
					}
				}

			}
			
			
			
			
			
		}
		
		return set;
		
	}

	
	public String get_CUID()
	{
		return this.CUID;
	}
}
