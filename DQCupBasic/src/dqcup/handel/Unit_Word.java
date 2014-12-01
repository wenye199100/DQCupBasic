package dqcup.handel;


import java.util.Vector;

public class Unit_Word {

	public Vector<String> Cnt = new Vector<String>();
	public Vector<Vector<Integer>> Mark = new Vector<Vector<Integer>>();
	
	public Unit_Word(){}
	
	public void add_Content(String string, int RUID)
	{
		int num = Cnt.indexOf(string);
		if(num >= 0)
		{
			Mark.get(num).add(RUID);
		}
		else 
		{
			Cnt.add(string);
			Vector<Integer> tmp = new Vector<Integer>();
			tmp.add(RUID);
			Mark.add(tmp);
		}
		
		
	}
	
}
