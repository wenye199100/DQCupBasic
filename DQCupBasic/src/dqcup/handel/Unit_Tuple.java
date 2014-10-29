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
		int c =100;
		int d = 100;
		c= c+d;
	}

	
	public String get_CUID()
	{
		return this.CUID;
	}
}
