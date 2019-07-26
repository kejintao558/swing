package Service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Util.FileHanding;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class simulationVerificationButton_action implements ActionListener{
	private JTextField measuredDataTextField;
	private JComboBox<?> simulationPreLacisionComboBox;
	private JDialog updateDialog;
	private JFrame frame;
	private ArrayList<String[]> gridlist;
	private String[] result = new String[3];
	private DefaultComboBoxModel<?>precision_model;
	private JLabel resultLabel;
	private double precision;
	private int count = 0;

	public simulationVerificationButton_action(JFrame frame,JTextField measuredDataTextField, JComboBox<?> simulationPreLacisionComboBox, 
			                                                                                  DefaultComboBoxModel<?>precision_model,
			                                                                                  JLabel resultLabel) {
		// TODO Auto-generated constructor stub
		this.measuredDataTextField=measuredDataTextField;
		this.simulationPreLacisionComboBox=simulationPreLacisionComboBox;
		this.frame=frame;
		this.precision_model=precision_model;
		this.resultLabel=resultLabel;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Process p;                                                //执行  MAIN程序
//	     String cmd="cmd /c start "+FileHanding.getAbsolutePath("exe/3/MAIN.exe")+" "+FileHanding.getAbsolutePath("path");    
//	            //执行命令    
//	      try {
//	    	  p = Runtime.getRuntime().exec(cmd);
//	    	  } catch (IOException e1) {
//	    	  // TODO Auto-generated catch block 
//	    		  e1.printStackTrace();
//	    		  } 
		if(measuredDataTextField.getText().equals("")){          //验证实测数据是否导入,给出提示框
			updateDialog = new JDialog(frame,"提示信息",true);
			updateDialog.setLayout(null);
			updateDialog.setBounds(600, 300, 230, 150);
			
			JLabel label = new JLabel("请先选择实测数据");
			label.setBounds(70, 20, 120, 40);
			label.setFont(new Font("宋体", Font.PLAIN, 10));
			updateDialog.add(label);
			
			JButton button = new JButton("OK");
			button.setBounds(75, 75, 60, 40);
			button.setFont(new Font("宋体", Font.PLAIN, 10));
			button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					updateDialog.dispose();
				}
			});
			updateDialog.add(button);
			updateDialog.setVisible(true);
			updateDialog.pack();
		}
		
		
		FileHanding fileHanding = new FileHanding();           
		gridlist = fileHanding.getGrid();                         //获取x，y，i，j对应List
		File ij_file = new File(FileHanding.getPath()+"/DAT_ORG/SUB_POINT.DAT");     //保存对应i,j号
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ij_file, false)));
			Workbook workbook=Workbook.getWorkbook(new File(measuredDataTextField.getText()));        //获取导入实测数据
			Sheet sheet=workbook.getSheet(0);
			out.write(String.valueOf(sheet.getRows()-1));
			out.newLine();
	        for(int i=0;i<sheet.getRows()-1;i++){
                double d2 = 1;
	            for(int j=0;j<gridlist.size();j++){
		        	Cell cell_x=sheet.getCell(0,i+1);
		        	Cell cell_y=sheet.getCell(1,i+1);
		            String[] str = gridlist.get(j);
		            double d = Math.pow(Float.parseFloat(cell_x.getContents())-Float.parseFloat(str[0]), 2)+
		            		   Math.pow(Float.parseFloat(cell_y.getContents())-Float.parseFloat(str[1]), 2);		            
		            if(d<d2){
		            	d2=d;
		            	result[0]=String.valueOf(d2);
		            	result[1]=str[3];                  //获取i
		            	result[2]=str[4];                  //获取j
		            };
	            }
	            String s =(i+1)+" "+result[1]+" "+result[2];
	            out.write(s);
	            out.newLine();
	        }
	        out.close();
		} catch (BiffException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File OUT_SL_file = new File(FileHanding.getPath()+"/RES_TIME/OUT_SL.DAT");
		try{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(OUT_SL_file.getPath()), "gbk"));
			String s = bufr.readLine();
			String[] str =s.trim().split("\\s+ ");//使用正则表达式去掉空格
			Workbook workbook=Workbook.getWorkbook(new File(measuredDataTextField.getText()));
			WritableWorkbook workbook2=Workbook.createWorkbook(new File("D:/Datain/指标系数展示.xls"));   //新建结果展示表
			Sheet sheet=workbook.getSheet(0);
			WritableSheet sheet2=workbook2.createSheet("详细结果", 0);
			Label label=null;
			label=new Label(0,0,"x");                          //写入结果表第一行标题
			sheet2.addCell(label);
			label=new Label(1,0,"y");
			sheet2.addCell(label);
			label=new Label(2,0,"COD");
			sheet2.addCell(label);
			label=new Label(3,0,"");
			sheet2.addCell(label);
			label=new Label(4,0,"");
			sheet2.addCell(label);
			label=new Label(5,0,"BOD");
			sheet2.addCell(label);
			label=new Label(6,0,"");
			sheet2.addCell(label);
			label=new Label(7,0,"");
			sheet2.addCell(label);
			label=new Label(8,0,"TN");
			sheet2.addCell(label);
			label=new Label(9,0,"");
			sheet2.addCell(label);
			label=new Label(10,0,"");
			sheet2.addCell(label);
			label=new Label(11,0,"TP");
			sheet2.addCell(label);
			label=new Label(12,0,"");
			sheet2.addCell(label);
			label=new Label(13,0,"");
			sheet2.addCell(label);
			label=new Label(14,0,"NH3-N");
			sheet2.addCell(label);
			label=new Label(15,0,"");
			sheet2.addCell(label);
			label=new Label(16,0,"");
			sheet2.addCell(label);
			label=new Label(17,0,"NO3-N");
			sheet2.addCell(label);
			label=new Label(18,0,"");
			sheet2.addCell(label);
			label=new Label(19,0,"");
			sheet2.addCell(label);
			label=new Label(20,0,"DO");
			sheet2.addCell(label);
			label=new Label(21,0,"");
			sheet2.addCell(label);
			label=new Label(22,0,"");
			sheet2.addCell(label);
			
			label=new Label(2,1,"实测数据");          //结果表第二行标题
			sheet2.addCell(label);
			label=new Label(3,1,"模拟数据");
			sheet2.addCell(label);
			label=new Label(4,1,"%");
			sheet2.addCell(label);
			label=new Label(5,1,"实测数据");
			sheet2.addCell(label);
			label=new Label(6,1,"模拟数据");
			sheet2.addCell(label);
			label=new Label(7,1,"%");
			sheet2.addCell(label);
			label=new Label(8,1,"实测数据");
			sheet2.addCell(label);
			label=new Label(9,1,"模拟数据");
			sheet2.addCell(label);
			label=new Label(10,1,"%");
			sheet2.addCell(label);
			label=new Label(11,1,"实测数据");
			sheet2.addCell(label);
			label=new Label(12,1,"模拟数据");
			sheet2.addCell(label);
			label=new Label(13,1,"%");
			sheet2.addCell(label);
			label=new Label(14,1,"实测数据");
			sheet2.addCell(label);
			label=new Label(15,1,"模拟数据");
			sheet2.addCell(label);
			label=new Label(16,1,"%");
			sheet2.addCell(label);
			label=new Label(17,1,"实测数据");
			sheet2.addCell(label);
			label=new Label(18,1,"模拟数据");
			sheet2.addCell(label);
			label=new Label(19,1,"%");
			sheet2.addCell(label);
			label=new Label(20,1,"实测数据");
			sheet2.addCell(label);
			label=new Label(21,1,"模拟数据");
			sheet2.addCell(label);
			label=new Label(22,1,"%");
			sheet2.addCell(label);
			
			if(simulationPreLacisionComboBox.getSelectedItem()=="10%"){          //判断精度数值
			this.precision= 10;  //%
		}else if(simulationPreLacisionComboBox.getSelectedItem()=="20%"){
			this.precision= 20;  //%
		}else if(simulationPreLacisionComboBox.getSelectedItem()=="30%"){
			this.precision= 30;  //%
		}
		    System.out.print(precision);
			
			for(int i=0;i<sheet.getRows()-2;i++){              
				Cell cell_cod=sheet.getCell(2,i+1);
				Cell cell_bod=sheet.getCell(3,i+1);
				Cell cell_tn=sheet.getCell(4,i+1);
				Cell cell_tp=sheet.getCell(5,i+1);
//				Cell cell_nh3_n=sheet.getCell(6,i+1);           //暂时4个指标
//				Cell cell_no3_n=sheet.getCell(7,i+1);
//				Cell cell_do=sheet.getCell(8,i+1);
				label=new Label(0,i+2,sheet.getCell(0,i+1).getContents());       //写入结果表x坐标
				sheet2.addCell(label);
				label=new Label(1,i+2,sheet.getCell(1,i+1).getContents());       //写入结果表y坐标
				sheet2.addCell(label);
				Double a= Double.parseDouble(cell_cod.getContents());   //计算COD系数
				Double b= Double.parseDouble(str[7*i+4]);
				int result = (int) ((Math.abs((a-b))*100/a+0.5));
                if(result>precision){                                  //判断精度是否符合
                	count++;
					label=new Label(2,i+2,sheet.getCell(2,i+1).getContents());
					sheet2.addCell(label);
					label=new Label(3,i+2,str[7*i+4]);
					sheet2.addCell(label);
					label=new Label(4,i+2,String.valueOf(result));
					sheet2.addCell(label);
				}else{
//					System.out.print(result);
				}
				a= Double.parseDouble(cell_bod.getContents());   //计算BOD系数
				b= Double.parseDouble(str[7*i+5]);
				result = (int) ((Math.abs((a-b))/a)*100+0.5);
                if(result>precision){
                     count++;
				     label=new Label(5,i+2,sheet.getCell(3,i+1).getContents());
				     sheet2.addCell(label);
				     label=new Label(6,i+2,str[7*i+5]);
				     sheet2.addCell(label);
				     label=new Label(7,i+2,String.valueOf(result));
				     sheet2.addCell(label);
				}else{

				}
				a= Double.parseDouble(cell_tn.getContents());   //计算TN系数
				b= Double.parseDouble(str[7*i+6]);
				result = (int) ((Math.abs((a-b))/a)*100+0.5);
                if(result>precision){
                	count++;
				    label=new Label(8,i+2,sheet.getCell(4,i+1).getContents());
				    sheet2.addCell(label);
				    label=new Label(9,i+2,str[7*i+6]);
				    sheet2.addCell(label);
				    label=new Label(10,i+2,String.valueOf(result));
				    sheet2.addCell(label);
				}else{
					
				}
                a= Double.parseDouble(cell_tp.getContents());   //计算TP系数
				b= Double.parseDouble(str[7*i+7]);
				result = (int) ((Math.abs((a-b))/a)*100+0.5);
                if(result>precision){
                	count++;
				    label=new Label(11,i+2,sheet.getCell(5,i+1).getContents());
				    sheet2.addCell(label);
				    label=new Label(12,i+2,str[7*i+7]);
				    sheet2.addCell(label);
				    label=new Label(13,i+2,String.valueOf(result));
				    sheet2.addCell(label);
				}else{
					
				}
//                a= Double.parseDouble(cell_bod.getContents());   //计算NH3-N系数
//				b= Double.parseDouble(str[7*i+8]);
//				result = (int) ((Math.abs((a-b))/a)*100+0.5);
//                if(result>precision){
//					count++;
//				label=new Label(14,i+2,sheet.getCell(6,i+1).getContents());
//				sheet2.addCell(label);
//				label=new Label(15,i+2,str[7*i+8]);
//				sheet2.addCell(label);
//				label=new Label(16,i+2,String.valueOf(result));
//				sheet2.addCell(label);
//				}else{
//					System.out.print(a);
//				}
//                a= Double.parseDouble(cell_bod.getContents());   //计算NO3-N系数
//				b= Double.parseDouble(str[7*i+9]);
//				result = (int) ((Math.abs((a-b))/a)*100+0.5);
//                if(result>precision){
//					count++;
//				label=new Label(17,i+2,sheet.getCell(7,i+1).getContents());
//				sheet2.addCell(label);
//				label=new Label(18,i+2,str[7*i+9]);
//				sheet2.addCell(label);
//				label=new Label(19,i+2,String.valueOf(result));
//				sheet2.addCell(label);
//				}else{
//					System.out.print(a);
//				}
//                a= Double.parseDouble(cell_bod.getContents());   //计算DO系数
//				b= Double.parseDouble(str[7*i+10]);
//				result = (int) ((Math.abs((a-b))/a)*100+0.5);
//                if(result>precision){
//					count++;
//				label=new Label(20,i+2,sheet.getCell(8,i+1).getContents());
//				sheet2.addCell(label);
//				label=new Label(21,i+2,str[7*i+10]);
//				sheet2.addCell(label);
//				label=new Label(22,i+2,String.valueOf(result));
//				sheet2.addCell(label);
//				}else{
//					System.out.print(a);
//				}
			}
			sheet2.mergeCells(2, 0, 4, 0);             //合并单元格
			sheet2.mergeCells(5, 0, 7, 0);
			sheet2.mergeCells(8, 0, 10, 0);
			sheet2.mergeCells(11, 0, 13, 0);
			sheet2.mergeCells(14, 0, 16, 0);
			sheet2.mergeCells(17, 0, 19, 0);
			sheet2.mergeCells(20, 0, 22, 0);
			workbook2.write();
			workbook2.close();
			bufr.close();
			if(count>0){                                          //展示验证结果
				resultLabel.setForeground(Color.RED);
			    resultLabel.setText("错误数量为:"+count);
			}else{
				resultLabel.setForeground(Color.BLUE);
				resultLabel.setText("验证合格");
			}
			count=0;                                          //错误数量重新清零
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

			 
	}

}
