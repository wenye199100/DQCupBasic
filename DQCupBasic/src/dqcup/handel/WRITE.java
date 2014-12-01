package dqcup.handel;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WRITE {
BufferedWriter out = null; 

	public WRITE()
	{
		
	}

	public void method1(String file, String conent) {   
        BufferedWriter out = null;   
        try {   
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));   
            out.write(conent);   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
            	if(out != null){
            		out.close();   
                }
            } catch (IOException e) {   
                e.printStackTrace();   
            }   
        }   
    }  
	
	public void method2(String w1, String w2, String w3) {   
		
		String conent = w1 + "," + w2 + "," + w3 + '\n';
		String file = "input/test.txt";
        BufferedWriter out = null;   
        try {   
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));   
            out.write(conent);   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
            	if(out != null){
            		out.close();   
                }
            } catch (IOException e) {   
                e.printStackTrace();   
            }   
        }   
    }  
	
	
}
