package dqcup.handel;

public class Regex {

	private String regex;
	
	public Regex()
	{
		
	}
	
	public boolean SSN()
	{
		regex = "[0-9]{9}";
		return true;
	}
	
	public boolean FNAME()
	{
		regex = "[A-Z][a-zA-Z ,.]*";
		return true;
	}
	
	public boolean MINIT()
	{
		regex = "[A-Z]?";
		return true;
	}
	
	public boolean LNAME()
	{
		regex = "[A-Z][a-zA-Z ,.]*";
		return true;
	}
	
	public boolean STNUM()
	{
		if()
		{
			
		}
		else
		{
			regex = "[0-9]{1,4}";	
		}
		return true;
	}
	
	public boolean STADD()
	{
		regex = "PO Box [0-9]{1,4}|[a-zA-Z ,.]+";
		return true;
	}
	
	public boolean APMT()
	{
		if()
		{
			
		}
		else
		{
			regex = "\\d[a-z]\\d";	
		}
		return true;
	}
	
	public boolean CITY()
	{
		regex = "[a-z'-/]+";
		return true;
	}
	
	public boolean STATE()
	{
		
		return true;
	}
	
	public boolean ZIP()
	{
		regex = "\\d{5}";
		return true;
	}
	
	public boolean BIRTH()
	{
		regex = "";
		return true;
	}
	
	public boolean AGE()
	{
		
		return true;
	}
	
	public boolean SALAY()
	{
		
		return true;
	}
	
	public boolean TAX()
	{
		
		return true;
	}
}
