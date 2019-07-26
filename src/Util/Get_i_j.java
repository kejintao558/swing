package Util;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Get_i_j {
	private double d2=-1;
	public String[] get_i_j(ArrayList<String[]> gridlist,float x,float y) throws BiffException, IOException{
		String[] result = new String[3];
		for(int j=0;j<gridlist.size();j++){
		    String[] str = gridlist.get(j);
		    double d = Math.pow(x-Float.parseFloat(str[0]), 2)+
		    		   Math.pow(y-Float.parseFloat(str[1]), 2);		            
		    if(d<d2||d2==-1){
		    	d2=d;
		    	result[0]=String.valueOf(d2);
		    	result[1]=str[3];
		    	result[2]=str[4];
		    };
		}
		return result;
	}

}
