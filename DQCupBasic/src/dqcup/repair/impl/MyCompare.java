package dqcup.repair.impl;

import java.util.Comparator;

public class MyCompare implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		int n1 = Integer.parseInt(((String[])o1)[0]);
		int n2 = Integer.parseInt(((String[])o2)[0]);
		
		if(n1 > n2)
			return 1;
		else if(n1 < n2)
			return -1;
		else {
			return 0;
		}
	}
}
