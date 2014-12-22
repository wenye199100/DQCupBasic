package dqcup.handel;


public class Regex {

	private String regex;
	private String regex1;
	public boolean STADD_FLAG = false;
	public boolean SALARY_FLAG = false;
	
	public Regex()
	{
		
	}
	
	public Regex(String string)
	{
		STADD(string);
	}
	
	public boolean SSN(String string)
	{
		regex = "[0-9]{9}";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	public boolean FNAME(String string)
	{
		regex = "[A-Z][a-z ,.]*";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	public boolean MINIT(String string)
	{
		regex = "[A-Z]?";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	public boolean LNAME(String string)
	{
		regex = "[A-Z][a-z ,.]*";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	public boolean STNUM(String string)
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
	public boolean STNUM_2(String string)
	{
		
			regex = "[0-9]{1,4}";
			if(string.matches(regex))
				return true;
			return false;
	}
		
	
	public boolean STADD(String string)
	{
		regex = "PO Box [0-9]{1,4}|[a-zA-Z ,.]+";
		if(string.matches(regex))
		{
			if(string.contains("PO Box"))
				STADD_FLAG = true;
			return true;
		}
		return false;
	}
	
	public boolean APMT(String string)
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
	public boolean APMT_2(String string)
	{
		
		regex = "\\d[a-z]\\d";
		if (string.matches(regex))
			return true;
		return false;
		
		
	}
	
	public boolean CITY(String string)
	{
		regex = "[a-zA-Z'-/ ]+";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	public boolean STATE(String string)
	{
		regex="^(RI|VT|HI|VI|ME|VA|MI|DE|ID|IA|MD|MA|AR|UT|IL|IN|MN|AZ|MO|MT|MS|NH|NJ|PR|NM|AK|AL|NC|ND|NE|GA|NV|TN|OK|OH|WY|FM|FL|SD|SC|CT|WV|KY|KS|OR|LA|GU|WA|CO|PA)$";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	public boolean ZIP(String string)
	{
		regex = "\\d{5}";
		if(string.matches(regex))
			return true;
		return false;
	}
	
	public boolean BIRTH(String string)
	{
		regex = "^(1|3|5|7|8|10|12)\\-(([0-9])|(1[0-9])|(2[0-9])|(3[01]))\\-(19[3-8][0-9]$)";
		regex1 = "^(4|6|8|9|11)\\-(([0-9])|(1[0-9])|(2[0-9])|(30))\\-(19[3-8][0-9]$)";
		
		if(string.matches(regex)||string.matches(regex1)) return true;
		else
		{
			String[] dataArray = string.split("-");
			try {
				Integer.valueOf(dataArray[0]);
				Integer.valueOf(dataArray[1]);
				Integer.valueOf(dataArray[2]);
			} catch (Exception e) {
				return false;
			}
	        int year,month,day;
	        month = Integer.parseInt(dataArray[0]);
	        day = Integer.parseInt(dataArray[1]);
	        year = Integer.parseInt(dataArray[2]);
	        if(month == 2)
	        {
	        	if(( year%4 == 0 && year%100 != 0 || year%400 == 0) )  
    			{if(day <= 29 )return true;  }      		
	        	else
    			{if(day <= 28 )return true;  }        
	        }     
	        return false;
		}
//		String[] dataArray = string.split("-");
//        int year,month,day;
//        month = Integer.parseInt(dataArray[0]);
//        day = Integer.parseInt(dataArray[1]);
//        year = Integer.parseInt(dataArray[2]);
//
//        if (year>1989 || year<1930 || month<0 || month>12 || day<0 || day>31) return false;
// 
//        if ((month == 4 || month == 6 || month == 9 || month == 11 ) && day>30) return false;
//        if (month ==2)
//        {
//        	if((year%4 == 0 && year%100 != 0) || year%400 == 0)  
//        			if(day > 29 )return false;        		
//        	else
//        			if(day > 28)return false;        		
//        }
//		return true;
	}
	
	public boolean AGE(String string)
	{
		// 24-83岁 24-29 30-39...70-79 80-83
		regex = "(2[4-9])|([3-7][0-9])|(8[0-3])";
		if (string.matches(regex))
			return true;
		return false;
	}
	
	public boolean SALARY(String string)
	{
		//500-999  1000-9999  10000-19999  20000-20499  20500
		try {
			Integer.valueOf(string);
		} catch (Exception e) {
			return false;
		}
		regex = "(0|[5-9][0-9][0-9])|([1-9][0-9][0-9][0-9])|(1[0-9][0-9][0-9][0-9])|(20[0-4][0-9][0-9])|20500";
		if (string.matches(regex)) {
			if (Integer.parseInt(string) <= 1500)
				SALARY_FLAG = true;
			// <1500
			return true;
		}

		return false;
	}
	
	public boolean TAX(String string)
	{
		try {
			Integer.valueOf(string);
		} catch (Exception e) {
			return false;
		}
		if(SALARY_FLAG && Integer.parseInt(string)!=0)
			return false;	
		return true;
	}
	
	public boolean select_regex(int i, String string)
	{
		boolean fact = false;
		if(i == 3)
			fact = SSN(string);
		if(i == 4)
			fact = FNAME(string);
		if(i == 5)
			fact = MINIT(string);
		if(i == 6)
			fact = STNUM(string);
		if(i == 7)
			fact = LNAME(string);
		if(i == 8)
			fact = STADD(string);
		if(i == 9)
			fact = APMT(string);
		if(i == 10)
			fact = CITY(string);
		if(i == 11)
			fact = STATE(string);
		if(i == 12)
			fact = ZIP(string);
		if(i == 13)
			fact = BIRTH(string);
		if(i == 14)
			fact = AGE(string);
		if(i == 15)
			fact = SALARY(string);
		if(i == 16)
			fact = TAX(string);
		
		return fact;
		
	}
	
}
