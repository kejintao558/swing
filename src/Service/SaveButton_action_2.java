package Service;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;

import Util.FileHanding;
import Util.FileLineNumber;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SaveButton_action_2 implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	private JTextField nonPointSourceDataTextField_1;
	private JTextField nonPointSourceDataTextField_2;
	private JPanel sourceOfPullutionPanel;
	
	private String source[]=new String[7];


	public SaveButton_action_2(JTable table, DefaultTableModel model, JTextField nonPointSourceDataTextField_1,         //面源过程文件
			                                                          JTextField nonPointSourceDataTextField_2,         //面源位置文件
			                                                          JPanel sourceOfPullutionPanel) {
		// TODO Auto-generated constructor stub
		this.table=table;
		this.model=model;
        this.nonPointSourceDataTextField_1=nonPointSourceDataTextField_1;
        this.nonPointSourceDataTextField_2=nonPointSourceDataTextField_2;
        this.sourceOfPullutionPanel=sourceOfPullutionPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{                                                                     //写入TIME_SIDEN_P.DAT文件
			File file = new File(FileHanding.getPath()+"/DATIN_ORG/TIME_SIDEN_P.DAT");     //点源过程文件
			File BAY_SIDE_file = new File(FileHanding.getPath()+"/DATIN_ORG/BAY_SIDE.DAT");// 创建文件对象
//			BufferedReader bufr2 = new BufferedReader(new InputStreamReader(new FileInputStream(nonPointSourceDataTextField_2.getText()), "gbk"));
			BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(FileHanding.getPath()+"/DATIN_ORG/TIME_QC_UP.dat"), "gbk"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
			BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(BAY_SIDE_file, false)));
			String s = bufr.readLine();
			String s1= "2"+" "+s.substring(2, 3);
			out.write(s1);
			out.newLine();
			s = bufr.readLine();
			String[] str =s.trim().split(" ");//使用正则表达式去掉空格
			String s2 = "1"+" "+"0"+" "+model.getValueAt(0, 3)+" ";    //s.substring(2,5)为取文件中的模拟时长，取三位
			out.write(s2);
			for(int i=0;i<model.getRowCount()-1;i++){                         //写入污染物浓度，表格最后一条不获取
				String s3="";
				for(int j=4;j<11;j++){
				if(model.getValueAt(i, j)!=null){
					s3=s3+model.getValueAt(i, j)+" ";
				}
				}
				out.write(s3);
			}
			out.write(str[str.length-1]);          //获取数组最后一个值，即 最后输入排放流量
			out.newLine();                         //第二条数据
			s = bufr.readLine();
			str =s.trim().split(" ");//使用正则表达式去掉空格
			s2 = "2"+" "+s.substring(2, 5)+" "+model.getValueAt(0, 3)+" ";    //s.substring(2,5)为取文件中的模拟时长，取三位
			out.write(s2);
			for(int i=0;i<model.getRowCount()-1;i++){                         //写入污染物浓度，表格最后一条不获取
				String s3="";
				for(int j=4;j<11;j++){
				if(model.getValueAt(i, j)!=null){
					s3=s3+model.getValueAt(i, j)+" ";
				}
				}
				out.write(s3);
			}
			out.write(str[str.length-1]);          //获取数组最后一个值，即 最后输入排放流量
			out.close();
			bufr.close();
			
			if(nonPointSourceDataTextField_2.getText()!=null&&model.getRowCount()-1!=0){          //写入BAY_SIDE.DAT文件
				s = "2";
			}else{
				s = "1";
			}
			out2.write(s);                         //写入点源位置数据
			out2.newLine();
			s = "1"+" "+(model.getRowCount()-1);
            out2.write(s);
            out2.newLine();
            for(int i=0;i<model.getRowCount()-1;i++){
            	s = (i+1)+" "+ model.getValueAt(i, 1)+" "+model.getValueAt(i, 2);
            	out2.write(s);
            	out2.newLine();
            }
            if(nonPointSourceDataTextField_2.getText()!=null){                     //写入面源位置信息
			Workbook workbook=Workbook.getWorkbook(new File(nonPointSourceDataTextField_2.getText()));        //获取导入实测数据
			Sheet sheet=workbook.getSheet(0);
            s = "2"+" "+sheet.getRows();
            out2.write(s);
            out2.newLine();
            for(int i=0;i<sheet.getRows();i++){
            	Cell cell_i=sheet.getCell(0,i);
	        	Cell cell_x=sheet.getCell(1,i);
	        	Cell cell_y=sheet.getCell(2,i);
            	s = cell_i.getContents()+" "+cell_x.getContents()+" "+cell_y.getContents();
            	out2.write(s);
            	out2.newLine();
            }	
		 }
            out2.close();
		}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		sourceOfPullutionPanel.setVisible(false);             //完成操作后将界面隐藏
		}
		
	}

