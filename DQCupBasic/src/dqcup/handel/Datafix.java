package dqcup.handel;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import dqcup.repair.RepairedCell;

public class Datafix {

	private Unit_Word word;
	private Set<RepairedCell> set = new HashSet();
	private String[] columnId = { "RUID", "CUID", "SSN", "FNAME", "MINIT",
			"LNAME", "STNUM", "STADD", "APMT", "CITY", "STATE", "ZIP", "BIRTH",
			"AGE", "SALARY", "TAX" };
	String truthString = new String();
	WRITE w = new WRITE();
	
	public Datafix(Unit_Word uWord)
	{
		this.word = uWord;
	}
	
	public Set<RepairedCell> select(int i)
	{
		if(i == 2) return fix_SSN();
		if(i == 3) return fix_FNAME();
		if(i == 4) return fix_MINIT();
		if(i == 5) return fix_LNAME();
		if(i == 6) return fix_STNUM();
		if(i == 7) return fix_STADD();
		if(i == 8) return fix_APMT();
		if(i == 9) return fix_CITY();
		if(i == 10) return fix_STATE();
		if(i == 11) return fix_ZIP();
		if(i == 12) return fix_BIRTH();
		if(i == 13) return fix_AGE();
		if(i == 14) return fix_SALARY();
		if(i == 15) return fix_TAX();
//		
		return null;
		
	}
	
	
	
	
	//2
	public Set<RepairedCell> fix_SSN()
	{
		int Column = 2;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.SSN(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
			{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_all_num();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
					set.add(repairedCell);
				}
			}
		}
		
		return  set;
	}
	//3
	public Set<RepairedCell> fix_FNAME()
	{
		int Column = 3;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.FNAME(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = word.Cnt.get(0);
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//4
	public Set<RepairedCell> fix_MINIT()
	{
		int Column = 4;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.MINIT(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = word.Cnt.get(0);
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//5
	public Set<RepairedCell> fix_LNAME()
	{
		int Column = 5;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.LNAME(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = word.Cnt.get(0);
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//7
	public Set<RepairedCell> fix_STADD()
	{
		int Column = 7;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.STADD(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = word.Cnt.get(0);
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//6
	public Set<RepairedCell> fix_STNUM()
	{
		int Column = 6;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.STNUM_2(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_all_num();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//8
	public Set<RepairedCell> fix_APMT()
	{
		int Column = 8;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.APMT_2(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_APMT();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//9
	public Set<RepairedCell> fix_CITY()
	{
		int Column = 9;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.CITY(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_all_alpha();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	
	
	private String state(String string)
	{
		String[] state = {"RI","VT","HI","VI","ME","VA","MI","DE","ID","IA","MD","MA","AR","UT","IL","IN","MN","AZ","MO","MT","MS","NH","NJ","PR","NM","AK","AL","NC","ND","NE","GA","NV","TN","OK","OH","WY","FM","FL","SD","SC","CT","WV","KY","KS","OR","LA","GU","WA","CO","PA"};
		String truthString = new String();
		Character[] ch = new Character[2];
		ch[0] = string.charAt(0);
		ch[1] = string.charAt(1);
		Character[] ch_t = new Character[2];
		int max = 50;
		for(int i = 0; i < 50; i++)
		{
			Character c = state[i].charAt(0);
			if(Math.abs(ch[0] - c) < max)
			{
				max = Math.abs(ch[0] - c);
				ch_t[0] = c;
			}
		}
		 max = 50;
		for(int i = 0; i < 50; i++)
		{
			if(state[i].charAt(0) == ch_t[0])
			{
				Character c = state[i].charAt(1);
				if(Math.abs(ch[1] - c) < max)
				{
					max = Math.abs(ch[1] - c);
					truthString = state[i];
				}
			}
		}
		return truthString;
	}
	//10
	public Set<RepairedCell> fix_STATE()
	{
		int Column = 10;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.STATE(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		if(word.Cnt.size() == 1 && !exist_one)
		{
			boolean t = regex.STATE(word.Cnt.get(0).toUpperCase());
			if(t)
				truthString = word.Cnt.get(0).toUpperCase();
			else 
				truthString = state(word.Cnt.get(0).toUpperCase());
		}
		//如果没有一个有符合正则
		if(word.Cnt.size() > 1 && !exist_one) 
		{
			truthString = new Unit_Bit(word).right_state();
			boolean t = regex.STATE(truthString);
			if(t)
				truthString = word.Cnt.get(0).toUpperCase();
			else 
				truthString = state(word.Cnt.get(0).toUpperCase());
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//11
	public Set<RepairedCell> fix_ZIP()
	{
		int Column = 11;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.ZIP(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_all_num();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//12
	public Set<RepairedCell> fix_BIRTH()
	{
		int Column = 12;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.BIRTH(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = word.Cnt.get(0);
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//13
	public Set<RepairedCell> fix_AGE()
	{
		int Column = 13;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.AGE(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_all_num();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//14
	public Set<RepairedCell> fix_SALARY()
	{
		int Column = 14;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.SALARY(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_all_num();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}
	//15
	public Set<RepairedCell> fix_TAX()
	{
		int Column = 15;
		Regex regex = new Regex();
		//truth 表示符合正则
		boolean[] truth = new boolean[word.Cnt.size()];
		//truthStirng代表正确的内容
		
		//truthT 代表最终正确的类
		int truthT = -1;
		boolean exist_one = false;
		int max = -1;
		
		
		for(int i = 0; i < word.Cnt.size(); i++)
		{
			truth[i] = regex.TAX(word.Cnt.get(i));
			if(truth[i])
				exist_one = true;
		}
		if(word.Cnt.size() == 1 && exist_one)
		{truthString = word.Cnt.get(0);return set;}
		//如果没有一个有符合正则
		if(!exist_one) 
		{
			truthString = new Unit_Bit(word).right_all_num();
		} 
		//多个符合正则
		else 
		{
			int first = -1;
			for (int i = 0; i < word.Cnt.size(); i++) 
			{
				if (truth[i]) 
				{
					truthString = word.Cnt.get(i);
					first = i;
					max = word.Mark.get(i).size();
					truthT = i;
					break;
				}
			}
			
			
			for (int i = first; i < word.Cnt.size(); i++) 
			{
				if(i == first)
					continue;
				if (truth[i]) 
				{
					if (word.Mark.get(i).size() > max) 
					{
						max = word.Mark.get(i).size();
						truthString = word.Cnt.get(i);
						truthT = i;
					}
				}
			}
		}
		
		for (int i = 0; i < word.Cnt.size(); i++) 
		{
			if (i != truthT) 
			{
				for (int j = 0; j < word.Mark.get(i).size(); j++) 
				{
					RepairedCell repairedCell = new RepairedCell(
							word.Mark.get(i).get(j), columnId[Column], truthString);
					set.add(repairedCell);
					//w.method2(word.Mark.get(i).get(j).toString(), columnId[Column], truthString);
				}
			}
		}
		
		return  set;
	}

}
