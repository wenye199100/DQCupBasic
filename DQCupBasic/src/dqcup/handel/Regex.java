package dqcup.handel;



public class Regex {

	private String regex;
	private boolean STADD_FLAG = false;
	
	
	public Regex(String string)
	{
		STADD_FLAG = STADD(string);
	}
	
	private boolean SSN(String string)
	{
		regex = "[0-9]{9}";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	private boolean FNAME(String string)
	{
		regex = "[A-Z][a-zA-Z ,.]*";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	private boolean MINIT(String string)
	{
		regex = "[A-Z]?";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	private boolean LNAME(String string)
	{
		regex = "[A-Z][a-zA-Z ,.]*";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	private boolean STNUM(String string)
	{
		if(STADD_FLAG && string == null)
		{
			return true;
		}
		else
		{
			regex = "[0-9]{1,4}";
			if(string.matches(regex))
				return true;
			return false;
		}
		
	}
	
	private boolean STADD(String string)
	{
		regex = "PO Box [0-9]{1,4}|[a-zA-Z ,.]+";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	private boolean APMT(String string)
	{
		if(STADD_FLAG && string == null)
		{
			return true;
		}
		else
		{
			regex = "\\d[a-z]\\d";	
			if(string.matches(regex))
				return true;
			return false;
		}
		
	}
	
	private boolean CITY(String string)
	{
		regex = "[a-z'-/]+";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	private boolean STATE(String string)
	{
		
		return true;
	}
	
	private boolean ZIP(String string)
	{
		regex = "\\d{5}";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	private boolean BIRTH(String string)
	{
		regex = "";
		return true;
	}
	
	private boolean AGE(String string)
	{
		
		return true;
	}
	
	private boolean SALAY(String string)
	{
		
		return true;
	}
	
	private boolean TAX(String string)
	{
		
		return true;
	}
	
	public boolean select_regex(int i, String string)
	{
		boolean fact = false;
		if(i == 2)
			fact = SSN(string);
		if(i == 3)
			fact = FNAME(string);
		if(i == 4)
			fact = MINIT(string);
		if(i == 5)
			fact = STNUM(string);
		if(i == 6)
			fact = LNAME(string);
		if(i == 7)
			fact = STADD(string);
		if(i == 8)
			fact = APMT(string);
		if(i == 9)
			fact = CITY(string);
		if(i == 10)
			fact = STATE(string);
		if(i == 11)
			fact = ZIP(string);
		if(i == 12)
			fact = BIRTH(string);
		if(i == 13)
			fact = AGE(string);
		if(i == 14)
			fact = SALAY(string);
		if(i == 15)
			fact = TAX(string);
		
		return fact;
		
	}
	
}
