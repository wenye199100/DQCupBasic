package dqcup.exam;

import dqcup.repair.Tuple;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {

	private Tuple tuple;
	
	public Find(Tuple tuple)
	{
		this.tuple = tuple;
	}
	
	private void SSN_Exam(String s)
	{
		s.matches("[0-9]{9}");
	}
}
