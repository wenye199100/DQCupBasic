package dqcup.repair.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import dqcup.exam.Find;
import dqcup.exam.Fix;
import dqcup.handel.Unit_Tuple;
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
		for(Tuple tuple : tuples){
			//System.out.println("SSN: "+tuple.getValue(1)+" ZIP: "+tuple.getValue("ZIP"));
			if(!tuple.getValue(1).equals(unit.get_CUID()))
			{
				unit.run();
				unit = new Unit_Tuple(tuple);
			}
			else 
			{
				unit.add(tuple);
			}
			
		}
		//result.add(new RepairedCell(2, "ZIP", "97420"));
		//result.add(new RepairedCell(6, "ZIP", "88114"));
		
		//����result����
		return result;
	}

}
