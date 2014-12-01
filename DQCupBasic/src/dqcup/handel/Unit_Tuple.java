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
			if(Integer.parseInt(tuples[i][0]) == 189)
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
	
	@SuppressWarnings("null")
	public Set<RepairedCell> run() {
		if (this.CUID == null)
			return null;

		// 首先先判断STNUM，STADD和

		String[] Content = new String[10];
		// Vector<String> _Content = new Vector<String>();

		int Content_Num = 0;

		int line[][] = new int[10][100];
		// Vector<Vector<Integer>> _line = new Vector<Vector<Integer>>();
		int[] line_num = new int[10];

		// 遍历所有的属性，列
		for (int i = 2; i < 16; i++) {
			// Content里存的是不同的值
			// Content_num里是由几种
			// line[i]存的是Content[i]的CUID

			Regex regex = new Regex();

			Content = new String[10];

			Content_Num = 0;

			// 初始化
			for (int m = 0; m < 10; m++)
				for (int n = 0; n < 100; n++)
					line[m][n] = -1;

			line_num = new int[10];
			boolean same = false;
			// 遍历相同cuid的人
			for (int j = 0; j < n; j++) {

				Vector<Integer> tmp = new Vector<Integer>();
				// 遍历不同的值，行
				for (int k = 0; k < Content_Num; k++) {
					same = false;
					if (Content[k].equals(tuples[j][i])) {
						same = true;

						line[k][line_num[k]++] = Integer.parseInt(tuples[j][0]);
						break;
					}
					// if(_Content.get(k).equals(_tuples.get(j)[i]))
					// {
					// same = true;
					// _line.get(k).add(Integer.parseInt(_tuples.get(j)[0]));
					// break;
					// }
				}
				if (!same) {

					Content[Content_Num] = tuples[j][i];
					line[Content_Num][0] = Integer.parseInt(tuples[j][0]);
					line_num[Content_Num++] = 1;

					// _Content.add(_tuples.get(j)[i]);
					// tmp.add(Integer.parseInt(_tuples.get(j)[0]));
					// _line.add(tmp);
					// tmp = new Vector<Integer>();

				}
			}

			// 添加修改修复类
			// Datafix datafix = new Datafix(_Content, Content_Num, _line, i);
			// RepairedCell repairedCell = datafix.fix();
			// if(repairedCell != null)
			// set.add(repairedCell);

			// SSN

			boolean[] truth = new boolean[Content_Num];
			boolean exist_one = false;
			if (columnId[i].equals("SSN")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.SSN(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						for (int k = 0; k < line_num[j]; k++) {
							RepairedCell repairedCell = new RepairedCell(
									line[j][k], columnId[i], truthString);
							set.add(repairedCell);
						}
					}
				}

			}

			if (columnId[i].equals("FNAME")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.FNAME(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						for (int k = 0; k < line_num[j]; k++) {
							RepairedCell repairedCell = new RepairedCell(
									line[j][k], columnId[i], truthString);
							set.add(repairedCell);
						}
					}
				}
			}

			if (columnId[i].equals("MINIT")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.MINIT(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						for (int k = 0; k < line_num[j]; k++) {
							RepairedCell repairedCell = new RepairedCell(
									line[j][k], columnId[i], truthString);
							set.add(repairedCell);
						}
					}
				}
			}
			if (columnId[i].equals("LNAME")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.LNAME(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						for (int k = 0; k < line_num[j]; k++) {
							RepairedCell repairedCell = new RepairedCell(
									line[j][k], columnId[i], truthString);
							set.add(repairedCell);
						}
					}
				}
			}
			if (columnId[i].equals("STNUM")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.STNUM(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						for (int k = 0; k < line_num[j]; k++) {
							RepairedCell repairedCell = new RepairedCell(
									line[j][k], columnId[i], truthString);
							set.add(repairedCell);
						}
					}
				}
			}
			if (columnId[i].equals("STADD")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.STADD(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						for (int k = 0; k < line_num[j]; k++) {
							RepairedCell repairedCell = new RepairedCell(
									line[j][k], columnId[i], truthString);
							set.add(repairedCell);
						}
					}
				}
			}
			if (columnId[i].equals("APMT")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.APMT(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						for (int k = 0; k < line_num[j]; k++) {
							RepairedCell repairedCell = new RepairedCell(
									line[j][k], columnId[i], truthString);
							set.add(repairedCell);
						}
					}
				}
			}
			if (columnId[i].equals("CITY")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.CITY(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						RepairedCell repairedCell = new RepairedCell(
								line[j][0], columnId[i], truthString);
						set.add(repairedCell);
					}
				}
			}
			if (columnId[i].equals("STATE")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.STATE(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						RepairedCell repairedCell = new RepairedCell(
								line[j][0], columnId[i], truthString);
						set.add(repairedCell);
					}
				}
			}
			if (columnId[i].equals("ZIP")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.ZIP(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						RepairedCell repairedCell = new RepairedCell(
								line[j][0], columnId[i], truthString);
						set.add(repairedCell);
					}
				}
			}
			if (columnId[i].equals("BIRTH")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.BIRTH(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						RepairedCell repairedCell = new RepairedCell(
								line[j][0], columnId[i], truthString);
						set.add(repairedCell);
					}
				}
			}
			if (columnId[i].equals("AGE")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.AGE(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						RepairedCell repairedCell = new RepairedCell(
								line[j][0], columnId[i], truthString);
						set.add(repairedCell);
					}
				}
			}
			if (columnId[i].equals("SALARY")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.SALARY(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						RepairedCell repairedCell = new RepairedCell(
								line[j][0], columnId[i], truthString);
						set.add(repairedCell);
					}
				}
			}
			if (columnId[i].equals("TAX")) {
				String truthString = "";
				int max = -1;
				int m = -1;
				for (int j = 0; j < Content_Num; j++) {
					truth[j] = regex.TAX(Content[j]);
					if (truth[j])
						exist_one = true;
				}
				if (exist_one) {
					truthString = Content[0];
				} else {
					for (int j = 0; j < Content_Num; j++) {
						if (truth[j]) {
							if (line_num[j] > max) {
								max = line_num[j];
								truthString = Content[j];
							}
						}
					}
				}

				for (int j = 0; j < Content_Num; j++) {
					if (!truth[j]) {
						RepairedCell repairedCell = new RepairedCell(
								line[j][0], columnId[i], truthString);
						set.add(repairedCell);
					}
				}
			}

			// 只有一个值的时候,暂时无处理
			// if(Content_Num == 1)
			// {
			// // regex = new Regex(tuples[line[0][0]][7]);
			// // if(regex.select_regex(i, Content[0]))
			// // {
			// //
			// // }
			// }
			// //将少数标记为错
			// if(Content_Num > 1)
			// {
			// int max = -1;
			// int m = -1;
			// String string = "";
			// for(int j = 0 ; j < Content_Num; j++)
			// {
			// if(line_num[j] > max)
			// {
			// max = line_num[j];
			// m = j;
			// string = Content[j];
			// }
			// }
			// for(int j = 0 ; j < Content_Num; j++)
			// {
			// if(j != m)
			// {
			// RepairedCell repairedCell = new RepairedCell(line[j][0],
			// columnId[i], string);
			// set.add(repairedCell);
			// }
			// }
			//
			// }

		}

		return set;

	}

	public String get_CUID() {
		return this.CUID;
	}
}
