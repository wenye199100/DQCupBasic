package dqcup.repair.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.sun.javafx.collections.MappingChange.Map;

import dqcup.exam.Find;
import dqcup.exam.Fix;
import dqcup.handel.Unit_Tuple;
import dqcup.handel.WRITE;
import dqcup.repair.DatabaseRepair;
import dqcup.repair.DbFileReader;
import dqcup.repair.RepairedCell;
import dqcup.repair.Tuple;

public class DatabaseRepairImpl implements DatabaseRepair {

	@Override
	public Set<RepairedCell> repair(String fileRoute) {
		
		HashSet<RepairedCell> result = new HashSet<RepairedCell>();
		
		LinkedList<Tuple> tuples = DbFileReader.readFile(fileRoute);
		
		
		Unit_Tuple unit = new Unit_Tuple();
		
		Vector<Unit_Tuple> tuples_all = new Vector<Unit_Tuple>();
		
		
		for(Tuple tuple : tuples){
			//System.out.println("SSN: "+tuple.getValue(1)+" ZIP: "+tuple.getValue("ZIP"));
			if(!tuple.getValue(1).equals(unit.get_CUID()))
			{
				if(unit.exist())
				{
					result.addAll(unit.run2());
					tuples_all.add(unit);
				}
				unit = new Unit_Tuple(tuple);
			}
			else 
			{
				unit.add(tuple);
			}
			
		}
		
		
		
		
		
		String[] state = {"RI","VT","HI","VI","ME","VA","MI","DE","ID","IA","MD","MA","AR","UT","IL","IN","MN","AZ","MO","MT","MS","NH","NJ","PR","NM","AK","AL","NC","ND","NE","GA","NV","TN","OK","OH","WY","FM","FL","SD","SC","CT","WV","KY","KS","OR","LA","GU","WA","CO","PA"};
		//state, salary, tax, ruid
		HashMap<String, Vector<String[]>> stateHashMap = new HashMap<String, Vector<String[]>>();
		for(int i = 0; i < 50 ; i++)
		{
			stateHashMap.put(state[i], new Vector<String[]>());
		}
		for(Unit_Tuple ut : tuples_all)
		{
			Integer n = 0;
			
			for(int i = 0; i < ut.tuples_Vector.size(); i++)
			{
				
				String[] strings = new String[4];
				if(ut.t_tuple[14] == null)
					continue;
				strings[0] = ut.t_tuple[14]; //sa
				strings[1] = ut.t_tuple[15]; //tax
				strings[2] = (ut.tuples_Vector.get(i))[0];
				n = i;
				strings[3] = n.toString();
				//nSystem.out.println(n++  + " " + ut.t_tuple[10] + " "+ strings[0] +" " +strings[1]+" " +strings[2]);
				if(!(stateHashMap.get(ut.t_tuple[10]) == null))
					stateHashMap.get(ut.t_tuple[10]).add(strings);
			}
		}
		for(int i = 0; i < 50 ; i++)
		{
			
			String tempString = state[i];
			Vector<String[]> vt = stateHashMap.get(tempString);
			Comparator ct = new MyCompare();
			Collections.sort(stateHashMap.get(state[i]), ct);
			String[] strings = new String[3];
			strings[0] = vt.get(0)[3];
			Integer fisrt = 0;
			Integer second = 0;
			for (int j = 1; j < vt.size(); j++)
			{
				if(vt.get(j)[3].equals("0"))
				{
					second = j;
					break;
				}
			}
			
			for (int j = 1; j < vt.size(); j++)
			{
				if(vt.get(j)[2].equals("8802"))
				{
					System.out.println();
				}
				if(!vt.get(j)[3].equals("0"))
					continue;
				String[] s1 = vt.get(fisrt);
				String[] s2 = vt.get(second);
				String[] s3 = vt.get(j);
//				System.out.println(s1[0] + " " + s1[1] + " " + s1[2]);
//				System.out.println(s2[0] + " " + s2[1] + " " + s2[2]);
//				System.out.println(s3[0] + " " + s3[1] + " " + s3[2]);
//				System.out.println();
				fisrt = second;
				second = j;
				
				double ds1 = Double.parseDouble(s1[0]);
				double ds2 = Double.parseDouble(s2[0]);
				double ds3 = Double.parseDouble(s3[0]);
				
				double dt1 = Double.parseDouble(s1[1]);
				double dt2 = Double.parseDouble(s2[1]);
				double dt3 = Double.parseDouble(s3[1]);
				
				if(dt2 >= dt1 && dt2 <= dt3)
					continue;
				int n = 0;
				if(dt1 > dt2)
				{
					if(ds2 == ds1)
					{
						n = (int)dt1;
					}
					else 
					{
						if(ds2 == ds3)
						{
							n = (int)dt3;
						}
						else 
						{
							n = (int)((dt3 - dt1) / (ds3 - ds1) * (ds2 - ds1) + dt1);
						}
					}
				}
				
				if(dt2 > dt3)
				{
					if(dt3 > dt1)
					{
						n = (int)((dt3 - dt1) / (ds3 - ds1) * (ds2 - ds1) + dt1);
					}
					else 
					{
						if(dt3 == dt1)
						{
							if(ds1 == ds3)
								n = (int) dt2;
						}
						else 
						{
							continue;
						}
					}
				}
				Integer N = n;
				vt.get(fisrt)[1] = new String(N.toString());
				for(int m = fisrt; m < j; m++)
				{
					RepairedCell repairedCell = new RepairedCell(
							Integer.parseInt(vt.get(m)[2]), "TAX", N.toString());
					result.add(repairedCell);
				}
				
			}
		}
		
		
		
		
		
		//result.add(new RepairedCell(2, "ZIP", "97420"));
		//result.add(new RepairedCell(6, "ZIP", "88114"));
		
//		WRITE write = new WRITE();
//		for(RepairedCell cell:result)
//		{
//			int a = cell.getRowId();
//			String string = String.valueOf(a);
//			write.method2(string, cell.getColumnId(), cell.getValue());
//			
//		}
		return result;
	}

}
