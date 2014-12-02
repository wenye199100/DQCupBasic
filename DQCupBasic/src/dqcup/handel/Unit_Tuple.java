package dqcup.handel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import com.sun.media.jfxmedia.events.MarkerEvent;
import com.sun.org.apache.bcel.internal.classfile.LineNumber;

import dqcup.exam.Fix;
import dqcup.repair.RepairedCell;
import dqcup.repair.Tuple;

public class Unit_Tuple {
	private String CUID;
	// private Vector<String[]> _tuples = new Vector<String[]>();

	private String[][] tuples = new String[100][16];
	private String[] t_tuple = new String[16];
	private int n = 0;
	private Set<RepairedCell> set = new HashSet();
	private String[] columnId = { "RUID", "CUID", "SSN", "FNAME", "MINIT",
			"LNAME", "STNUM", "STADD", "APMT", "CITY", "STATE", "ZIP", "BIRTH",
			"AGE", "SALARY", "TAX" };

	public Unit_Tuple() {

	}

	public Unit_Tuple(Tuple tuple) {
		// 必须提取RUID
		// tuples[][0] ruid
		// tuples[][1] cuid

		CUID = tuple.getValue(1);
		// String[] _tuple = new String[16];
		for (int i = 0; i < 16; i++) {
			tuples[0][i] = tuple.getValue(i);
			// _tuple[i] = tuple.getValue(i);
		}

		// _tuples.add(_tuple);
		n++;
		
		t_tuple[1] = tuples[0][1];
	}

	public void add(Tuple tuple) {
		// String[] _tuple = new String[16];
		for (int i = 0; i < 16; i++) {
			tuples[n][i] = tuple.getValue(i);
			// _tuple[i] = tuple.getValue(i);
		}
		// _tuples.add(_tuple);
		n++;
	}

	public boolean exist()
	{
		if (this.CUID == null)
			return false;
		else {
			return true;
		}
	}
	
	
	public Set<RepairedCell> run2() {
		
		
		//先处理STADD
		
		fix(7);
		
		for(int i = 0; i < n; i++)
		{
			if(Integer.parseInt(tuples[i][0]) == 14646)
			{
				int xxxx = 1;
				System.out.println(xxxx);
			}
		}
		
		Regex regex_7 = new Regex();
		boolean PO_flag = false;
		regex_7.STADD(t_tuple[7]);
		PO_flag = regex_7.STADD_FLAG;
		WRITE ww = new WRITE();
		
		// 判断STNUM，STADD和APMT,分别是tuple[][6,7,8]
		if(PO_flag)
		{
			for (int i = 0; i < n; i++) 
			{
				if(!tuples[i][6].equals(""))
				{
					RepairedCell repairedCell = new RepairedCell(
							Integer.parseInt(tuples[i][0]), columnId[6], null);
					set.add(repairedCell);
					ww.method2(tuples[i][0], columnId[6], null);
				}
				if(!tuples[i][8].equals(""))
				{
					RepairedCell repairedCell = new RepairedCell(
							Integer.parseInt(tuples[i][0]), columnId[8], null);
					set.add(repairedCell);
					ww.method2(tuples[i][0], columnId[6], null);
				}
			}
		}
		else 
		{
			//6 STNUM
			fix(6);
			//8 APMT
			fix(8);
		}
		
		//2 SSN
		fix(2);
		
		//3 FNAME
		fix(3);
		
		//4 MINIT
		fix(4);
		
		//5 LNAME
		fix(5);
		
		//9 CITY
		fix(9);
		
		//10 STATE
		fix(10);
		
		//11 ZIP
		fix(11);
		
		//12 BIRTH
		fix(12);
		
		//13 AGE
		fix(13);
		
		//14 SALARY
		fix(14);
		
		//15 TAX
		fix(15);
		
		

		return set;
	}

	private void fix(int x)
	{
		Unit_Word content = new Unit_Word();
		for (int i = 0; i < n; i++) 
			content.add_Content(tuples[i][x], Integer.parseInt(tuples[i][0]));
		Datafix datafix = new Datafix(content);
		set.addAll(datafix.select(x));
		t_tuple[x] = datafix.truthString;
	}
	
	

	public String get_CUID() {
		return this.CUID;
	}
}
