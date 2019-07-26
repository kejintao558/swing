package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;


//文件处理
public class FileHanding {
	
	//获取GoogleEarth文件中的x,y,z
	public static String getStr(String str){
		String temp = new String(); 
		String[] all = str.split(","); //用","分隔字符串
		for(int j = 2;j<all.length;j++){ 
			temp = temp +all[j]+"    ";
		}
		temp=temp.substring(0, temp.length()-1);
		return temp;
	}
	
	//获取GoogleEarth文件中的x,y
	public static String getStr_line(String str){
		String temp = new String(); 
		String[] all = str.split(","); //用","分隔字符串
		temp = all[2]+"    "+all[3];
		return temp;
		}
	
	//提取grid_fig文件的坐标
	public  ArrayList<String[]> getGrid(){
		ArrayList<String[]> gridlist = null;
		try {
			String path = getPath()+"/GRID/GRID_FIG.DAT";
			BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
			String s = null; // 创建字符串对象
			ArrayList<String[]> list = new ArrayList<String[]>();
			bufr.readLine();
			bufr.readLine();
			bufr.readLine();//跳过grid_fig.dat文件说明
			while ((s = bufr.readLine()) != null) {
				String[] str =s.trim().split("\\s+ ");//使用正则表达式去掉空格
				if(str.length == 6){
					list.add(str);
				}
				if(str.length < 6){
					break;
				}
			}
			bufr.close();
			gridlist = list;
		        
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return gridlist;
		
		
	}

	//写bay_line文件
	public static void get_bay_line(File write_file,File read_file,Boolean flag){
		try {
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(write_file, flag))); 
			BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(read_file.getPath()), "gbk"));
			String s = null; // 创建字符串对象
			Long count = new FileLineNumber().getLineNumber(read_file);//获取散点总数
			if(flag){ //写入左岸数据时不覆盖原有文件
				bufw.write("2"+"    "+String.valueOf(count-1));
				bufw.newLine();
			}else{
				bufw.write("1"+"    "+String.valueOf(count-1));
				bufw.newLine();
			}
			int i = 0;
			// 如果文件的文本行数不为null,则进入循环
			while ((s = bufr.readLine()) != null) {
				i++;
				String temp = getStr_line(s);
				bufw.write(String.valueOf(i)+"    "+temp);
				bufw.newLine();
			}			
			//关闭流
			bufr.close(); 
			bufw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//写geo文件
	public static void get_geo(File write_file,File read_file){
		try {
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(write_file,false))); 
			if(read_file.isDirectory()){
				File next[]=read_file.listFiles();
				long countfile = next.length;//获取断面数
				bufw.write(String.valueOf(countfile)+" "+"2");
				bufw.newLine();
				String s = null; // 创建字符串对象
				for(int i = 0; i < next.length; i++){
					BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(next[i].getPath()), "gbk"));
					int j = 0;
					Long count = new FileLineNumber().getLineNumber(next[i]);//获取每个断面的散点总数
					bufw.write(String.valueOf(i+1)+" "+String.valueOf(count-1));
					bufw.newLine();
					while ((s = bufr.readLine()) != null) {
						j++;
						String temp = getStr(s);
						bufw.write(String.valueOf(j)+" "+temp);
						bufw.newLine();
					}
					bufr.close(); 
				}	
			}
			//关闭流
			bufw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//复制文件
	public static void copyFile(File write_file,File read_file){
		try {
			if(write_file.exists()){
				write_file.delete();
			}
				Files.copy(read_file.toPath(), write_file.toPath());
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//写grid_cont文件
	public static void getGrid_cont(ArrayList<int[]> xy,Double[] pro){
		// TODO Auto-generated method stub
				String path= getPath()+"/GEO_ORG/GRID_CONT.DAT";
				File write_file = new File(path);
				String str = null;
				int[] point_xy = null;
				try {
					BufferedWriter bufw = new BufferedWriter(new FileWriter(write_file));
					bufw.write(String.valueOf(xy.size()));//统计线条数
					
					//坐标转换参数
					Double proportion = pro[0]; 
					Double L = pro[1];
					Double B = pro[2];
					Double proportionH = pro[3];
					Double proportionW = pro[4];
					Double minx = pro[5];
					Double maxy = pro[6];
					
					for(int i = 0;i<xy.size();i++){
						point_xy = xy.get(i);
						bufw.newLine();
						DecimalFormat df = new DecimalFormat("0.0000");
						
						//坐标转换
						String x1 = df.format( (point_xy[0]/proportionW -(int)(150-L/2)-1)*proportion+minx);
						String y1 = df.format( maxy-(point_xy[1]/proportionH-(int)(100-B/2)-1)*proportion);
						String x2 = df.format( (point_xy[2]/proportionW -(int)(150-L/2)-1)*proportion+minx);
						String y2 = df.format( maxy-(point_xy[3]/proportionH-(int)(100-B/2)-1)*proportion);
						
						str =(i+1)+"\t"+x1+"\t"+y1+"\t"+x2+"\t"+y2;
						System.out.println(str);
						bufw.write(str);
						
					}
					bufw.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
	//写path文件
	public static void setPath(String pathFile) {
		String[] str = pathFile.split("\\\\");
		String path = "";
		for(int i=1;i<str.length;i++){
			path = path+ str[i]+"\\";
		}
		path= path.substring(0, path.length()-1);//去掉最后一个反斜杠
		path ="  '"+str[0]+"\\"+"'"+" '"+path+"'";
		System.out.println("path设置为:"+path);
		try {
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./path/ORG_DAT/PATH.DAT",false)));
			try {
				bufw.write(path);
				bufw.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//读Path文件，获取path
	public static String getPath() {
		String path = null;
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("./path/ORG_DAT/PATH.DAT"),"utf-8"));
			String[] str = bufr.readLine().replace("\\", "/").split("'");//替换反斜杠为正斜杠并分割
			path = str[1]+str[str.length-1];
			bufr.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
		
	}
	
	public static String getAbsolutePath(String filePath){
		String str = new File(filePath).getAbsolutePath();
		return str;
		
	}

	public static void main(String[] args) {
		System.out.println(getPath());
		System.out.println(getAbsolutePath("path"));
//		ArrayList<String[]> ger= getGrid();
		
	}
	
	
}
