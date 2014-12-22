package dqcup.handel;

import java.util.HashMap;
import java.util.Iterator;
public class Unit_Bit {
	public HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	public Unit_Word uw;
	public Unit_Bit(Unit_Word uw){this.uw = uw;}
	
	public String right_all_num()
	{
 		String answer = new String();
		int n = uw.Cnt.get(0).length();
		Character key = null;
		for(int i = 0; i < n; i++)
		{
			map = new HashMap<Character, Integer>();
			for(int j = 0; j < uw.Cnt.size(); j++)
			{
				String temp = uw.Cnt.get(j);
				Character c = temp.charAt(i);
				key = null;
				if( c < '0' || c > '9')
					continue;
				key = c;
				
				if(map.containsKey(c))
				{
					map.put(c, map.get(c) + 1);
				}
				else  
				{
					map.put(c, 1);
				}
			}
			int num = 0;
			Iterator iter = map.keySet().iterator();
			while (iter.hasNext())
			{
				Character k = (Character) iter.next();
				int val = map.get(k);
				if(val > num)
				{
					key = k;
					num = val;
				}
			}
			if(key != null)
			answer += key;
			
		}
		
		
		
		
		
		return answer;
	}
	
	public String right_APMT()
	{
 		String answer = new String();
		int n = 3;
		Character key = null;
		for(int i = 0; i < n; i++)
		{
			map = new HashMap<Character, Integer>();
			for(int j = 0; j < uw.Cnt.size(); j++)
			{
				String temp = uw.Cnt.get(j);
				Character c = temp.charAt(i);
				key = null;
				if((i == 0 || i == 2)  && (c < '0' || c > '9') )
					continue;
				else 
				{
					if((i == 1) && c < 'a' || c > 'z')
						continue;
				}
				
				key = c;
				
				if(map.containsKey(c))
				{
					map.put(c, map.get(c) + 1);
				}
				else  
				{
					map.put(c, 1);
				}
			}
			int num = 0;
			Iterator iter = map.keySet().iterator();
			while (iter.hasNext())
			{
				Character k = (Character) iter.next();
				int val = map.get(k);
				if(val > num)
				{
					key = k;
					num = val;
				}
			}
			if(key != null)
			answer += key;
			
		}
		
		
		
		
		
		return answer;
	}
	
	public String right_all_alpha()
	{
 		String answer = new String();
		int n = uw.Cnt.get(0).length();
		Character key = null;
		for(int i = 0; i < n; i++)
		{
			map = new HashMap<Character, Integer>();
			for(int j = 0; j < uw.Cnt.size(); j++)
			{
				String temp = uw.Cnt.get(j);
				Character c = temp.charAt(i);
				key = null;
				if(! ( ( c >= 'a' && c <= 'z')  || ( c >= 'A' && c <= 'Z') || ( c == '\'') || ( c == '-')|| ( c == '/')|| ( c == '.')|| ( c == ' ')))
					continue;
				
				key = c;
				
				if(map.containsKey(c))
				{
					map.put(c, map.get(c) + 1);
				}
				else  
				{
					map.put(c, 1);
				}
			}
			int num = 0;
			Iterator iter = map.keySet().iterator();
			while (iter.hasNext())
			{
				Character k = (Character) iter.next();
				int val = map.get(k);
				if(val > num)
				{
					key = k;
					num = val;
				}
			}
			if(key != null)
			answer += key;
			
		}
		
		
		
		
		
		return answer;
	}
	public String right_state()
	{
 		String answer = new String();
		int n = 2;
		Character key = null;
		for(int i = 0; i < n; i++)
		{
			map = new HashMap<Character, Integer>();
			for(int j = 0; j < uw.Cnt.size(); j++)
			{
				String temp = uw.Cnt.get(j).toUpperCase();
				Character c = temp.charAt(i);
				key = null;
				if(! (  c >= 'A' && c <= 'Z'   ))
					continue;
				
				key = c;
				
				if(map.containsKey(c))
				{
					map.put(c, map.get(c) + 1);
				}
				else  
				{
					map.put(c, 1);
				}
			}
			int num = 0;
			Iterator iter = map.keySet().iterator();
			while (iter.hasNext())
			{
				Character k = (Character) iter.next();
				int val = map.get(k);
				if(val > num)
				{
					key = k;
					num = val;
				}
			}
			if(key != null)
			answer += key;
			
		}
		
		
		
		
		
		return answer;
	}
}
