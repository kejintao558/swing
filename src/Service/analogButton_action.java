package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Util.FileHanding;

public class analogButton_action implements ActionListener{
	private JCheckBox subsectionCheckBox_1;
	private JCheckBox subsectionCheckBox_3;
	private JComboBox<?> degradationCoefficientComboBox;
	private JTextField riverTextField_1;
	private JTextField riverTextField_2;
	private JTextField riverTextField_3;
	private JTextField riverTextField_4;
	private JTextField riverTextField_5;
	private JTextField degradationCoefficientTextField_1;
	private JTextField degradationCoefficientTextField_2;
	private JTextField degradationCoefficientTextField_3;
	private JTextField degradationCoefficientTextField_4;
	private JTextField degradationCoefficientTextField_5;
	private JTextField sedimentCoefficientTextField_1;
	private JTextField sedimentCoefficientTextField_2;
	private JTextField sedimentCoefficientTextField_3;
	private JTextField sedimentCoefficientTextField_4;
	private JTextField sedimentCoefficientTextField_5;
	private JTextField controlObjectiveTextField_1;
	private JTextField controlObjectiveTextField_2;
	private JTextField controlObjectiveTextField_3;
	private JTextField controlObjectiveTextField_4;
	private JTextField controlObjectiveTextField_5;
	private JTextField roughnessCoefficientTextField_1;
	private JTextField roughnessCoefficientTextField_2;
	private JTextField roughnessCoefficientTextField_3;
	private JTextField roughnessCoefficientTextField_4;
	private JTextField roughnessCoefficientTextField_5;
	private String[][] data=new String[6][8];
	private String[][] data2=new String[6][26];

	public analogButton_action(JCheckBox subsectionCheckBox_1, JCheckBox subsectionCheckBox_2,
			                                                   JComboBox<?> degradationCoefficientComboBox,
			                                                   JTextField riverTextField_1, 
			                                                   JTextField riverTextField_2,
			                                                   JTextField riverTextField_3, 
			                                                   JTextField riverTextField_4, 
			                                                   JTextField riverTextField_5,
			                                                   JTextField degradationCoefficientTextField_1, 
			                                                   JTextField degradationCoefficientTextField_2,
			                                                   JTextField degradationCoefficientTextField_3, 
			                                                   JTextField degradationCoefficientTextField_4,
			                                                   JTextField degradationCoefficientTextField_5, 
			                                                   JTextField sedimentCoefficientTextField_1,
			                                                   JTextField sedimentCoefficientTextField_2, 
			                                                   JTextField sedimentCoefficientTextField_3,
			                                                   JTextField sedimentCoefficientTextField_4, 
			                                                   JTextField sedimentCoefficientTextField_5,
			                                                   JTextField controlObjectiveTextField_1,
			                                                   JTextField controlObjectiveTextField_2,
			                                                   JTextField controlObjectiveTextField_3,
			                                                   JTextField controlObjectiveTextField_4,
			                                                   JTextField controlObjectiveTextField_5,
			                                                   JTextField roughnessCoefficientTextField_1,
			                                                   JTextField roughnessCoefficientTextField_2,
			                                                   JTextField roughnessCoefficientTextField_3,
			                                                   JTextField roughnessCoefficientTextField_4,
			                                                   JTextField roughnessCoefficientTextField_5) {
		// TODO Auto-generated constructor stub
		this.subsectionCheckBox_1=subsectionCheckBox_1;
		this.subsectionCheckBox_3=subsectionCheckBox_3;
		this.degradationCoefficientComboBox=degradationCoefficientComboBox;
		this.riverTextField_1=riverTextField_1;
		this.riverTextField_2=riverTextField_2;
		this.riverTextField_3=riverTextField_3;
		this.riverTextField_4=riverTextField_4;
        this.riverTextField_5=riverTextField_5;
        this.degradationCoefficientTextField_1=degradationCoefficientTextField_1;
        this.degradationCoefficientTextField_2=degradationCoefficientTextField_2;
        this.degradationCoefficientTextField_3=degradationCoefficientTextField_3;
        this.degradationCoefficientTextField_4=degradationCoefficientTextField_4;
        this.degradationCoefficientTextField_5=degradationCoefficientTextField_5;
        this.sedimentCoefficientTextField_1=sedimentCoefficientTextField_1;
        this.sedimentCoefficientTextField_2=sedimentCoefficientTextField_2;
        this.sedimentCoefficientTextField_3=sedimentCoefficientTextField_3;
        this.sedimentCoefficientTextField_4=sedimentCoefficientTextField_4;
        this.sedimentCoefficientTextField_5=sedimentCoefficientTextField_5;
        this.controlObjectiveTextField_1=controlObjectiveTextField_1;
        this.controlObjectiveTextField_2=controlObjectiveTextField_2;
        this.controlObjectiveTextField_3=controlObjectiveTextField_3;
        this.controlObjectiveTextField_4=controlObjectiveTextField_4;
        this.controlObjectiveTextField_5=controlObjectiveTextField_5;
        this.roughnessCoefficientTextField_1=roughnessCoefficientTextField_1;
        this.roughnessCoefficientTextField_2=roughnessCoefficientTextField_2;
        this.roughnessCoefficientTextField_3=roughnessCoefficientTextField_3;
        this.roughnessCoefficientTextField_4=roughnessCoefficientTextField_4;
        this.roughnessCoefficientTextField_5=roughnessCoefficientTextField_5;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<String[]> list = new FileHanding().getGrid();//获取坐标
		int size1 = 0;//I
		int size2= 0;//J
		int size = list.size();//点的总数
		for(int i = 0;i<list.size();i++){
			if(Integer.valueOf(list.get(i)[4])>size2){
				size2 = Integer.valueOf(list.get(i)[4]);//获取J的最大值
			}
		}
		size1 = size/size2;//获取I的最大值

		if(subsectionCheckBox_1.isSelected()==false){             //河流糙率不分段时
			File river_file = new File(FileHanding.getPath()+"/PARA_ORG/RIVER_CN.DAT");
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(river_file, false)));
				data[0][0]="1";                 //不写入文件
				data[0][1]=" 1";                //x,y坐标
				data[0][2]=" 1";
				data[0][3]=" "+size1;           //最大点坐标
				data[0][4]=" "+size2;
				data[0][5]=" "+"1";             //固定数字
				data[0][6]=" "+riverTextField_1.getText();
				data[0][7]=" "+roughnessCoefficientTextField_1.getText();
				String s=data[0][1]+data[0][2]+data[0][3]+data[0][4]+data[0][5]+data[0][6]+data[0][7];         
				out.write(s);
				out.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(subsectionCheckBox_3.isSelected()==false){ //降解系数，底泥系数不分段
		try{
			File river_file2 = new File(FileHanding.getPath()+"/PARA_ORG/RIVER_KP.DAT");
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(river_file2, false)));
				String s="1"+" "+degradationCoefficientComboBox.getItemCount()+" ";
				out.write(s);
				for(int i=0;i<degradationCoefficientComboBox.getItemCount();i++){
					out.write("2"+" ");
				}
				out.newLine();
				data2[0][0]=    "1";                                                    //将数据先存到数组中，每次覆盖重新写入
				data2[0][1]=" "+"1";
				data2[0][2]=" "+"1";
				data2[0][3]=" "+size2;
				data2[0][4]=" "+size1;
				if(degradationCoefficientComboBox.getSelectedItem().equals("COD")){
					data2[0][5]=" "+degradationCoefficientTextField_1.getText();
					data2[0][6]=" "+sedimentCoefficientTextField_1.getText();
					data2[0][7]=" "+controlObjectiveTextField_1.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("BOD")){
					data2[0][8]=" "+degradationCoefficientTextField_1.getText();
					data2[0][9]=" "+sedimentCoefficientTextField_1.getText();
					data2[0][10]=" "+controlObjectiveTextField_1.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("TN")){
					data2[0][11]=" "+degradationCoefficientTextField_1.getText();
					data2[0][12]=" "+sedimentCoefficientTextField_1.getText();
					data2[0][13]=" "+controlObjectiveTextField_1.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("TP")){
					data2[0][14]=" "+degradationCoefficientTextField_1.getText();
					data2[0][15]=" "+sedimentCoefficientTextField_1.getText();
					data2[0][16]=" "+controlObjectiveTextField_1.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("NH3-N")){
					data2[0][17]=" "+degradationCoefficientTextField_1.getText();
					data2[0][18]=" "+sedimentCoefficientTextField_1.getText();
					data2[0][19]=" "+controlObjectiveTextField_1.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("NO3-N")){
					data2[0][20]=" "+degradationCoefficientTextField_1.getText();
					data2[0][21]=" "+sedimentCoefficientTextField_1.getText();
					data2[0][22]=" "+controlObjectiveTextField_1.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("DO")){
					data2[0][23]=" "+degradationCoefficientTextField_1.getText();
					data2[0][24]=" "+sedimentCoefficientTextField_1.getText();
					data2[0][25]=" "+controlObjectiveTextField_1.getText();
				}
				s="";
				for(int i=1;i<26;i++){
					if(data2[0][i]!=null){
					s=s+data2[0][i];
					}
				}
				out.write(s);
				out.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		}
		
		if(subsectionCheckBox_1.isSelected()==true){     //河流糙率分段
			File river_file = new File(FileHanding.getPath()+"/PARA_ORG/RIVER_CN.DAT");
			try{
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(river_file, false)));
				data[1][0]="2";                      //不写入数组中
				data[1][1]=" "+"1";
				data[1][2]=" "+"1";
				data[1][3]=" "+size1/5;
				data[1][4]=" "+size2;
				data[1][5]=" "+"1";                   //固定数字
				data[1][6]=" "+riverTextField_1.getText();
				data[1][7]=" "+roughnessCoefficientTextField_1.getText();
				String s= data[1][1]+data[1][2]+data[1][3]+data[1][4]+data[1][5]+data[1][6]+data[1][7];		  
				out.write(s);
				out.newLine();
				data[2][0]="3";
				data[2][1]=" "+((size1/5)+1);
				data[2][2]=" "+"1";
				data[2][3]=" "+(size1*2)/5;
				data[2][4]=" "+size2;
				data[2][5]=" "+"1";
				data[2][6]=" "+riverTextField_2.getText();
				data[2][7]=" "+roughnessCoefficientTextField_2.getText();
				s=        data[2][1]+data[2][2]+data[2][3]+data[2][4]+data[2][5]+data[2][6]+
						  data[2][7];
				out.write(s);
				out.newLine();
				data[3][0]="4";
				data[3][1]=" "+(((size1*2)/5)+1);
				data[3][2]=" "+"1";
				data[3][3]=" "+(size1*3)/5;
				data[3][4]=" "+size2;
				data[3][5]=" "+"1";
				data[3][6]=" "+riverTextField_3.getText();
				data[3][7]=" "+roughnessCoefficientTextField_3.getText();
				s=        data[3][1]+data[3][2]+data[3][3]+data[3][4]+data[3][5]+data[3][6]+
						  data[3][7];
				out.write(s);
				out.newLine();
				data[4][0]="5";
				data[4][1]=" "+(((size1*3)/5)+1);
				data[4][2]=" "+"1";
				data[4][3]=" "+(size1*4)/5;
				data[4][4]=" "+size2;
				data[4][5]=" "+"1";
				data[4][6]=" "+riverTextField_4.getText();
				data[4][7]=" "+roughnessCoefficientTextField_4.getText();
				s=        data[4][1]+data[4][2]+data[4][3]+data[4][4]+data[4][5]+data[4][6]+
						  data[4][7];
				out.write(s);
				out.newLine();
				data[5][0]="6";
				data[5][1]=" "+(((size1*4)/5)+1);
				data[5][2]=" "+"1";
				data[5][3]=" "+size1;
				data[5][4]=" "+size2;
				data[5][5]=" "+"1";
				data[5][6]=" "+riverTextField_5.getText();
				data[5][7]=" "+roughnessCoefficientTextField_5.getText();
				s=        data[5][1]+data[5][2]+data[5][3]+data[5][4]+data[5][5]+data[5][6]+
						  data[5][7];
				out.write(s);
				out.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(subsectionCheckBox_3.isSelected()==true){  //降解系数，底泥系数分段
			File river_file2 = new File(FileHanding.getPath()+"/PARA_ORG/RIVER_KP.DAT");
			try{
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(river_file2, false)));
				String s="1"+" "+degradationCoefficientComboBox.getItemCount()+" ";
				out.write(s);
				for(int i=0;i<degradationCoefficientComboBox.getItemCount();i++){
					out.write("2"+" ");
				}
				out.newLine();
				data2[1][0]="2";
				data2[1][1]=" "+"1";
				data2[1][2]=" "+"1";
				data2[1][3]=" "+size1/5;
				data2[1][4]=" "+size2;
				if(degradationCoefficientComboBox.getSelectedItem().equals("COD")){
						data2[1][5]=" "+degradationCoefficientTextField_1.getText();
						data2[1][6]=" "+sedimentCoefficientTextField_1.getText();
						data2[1][7]=" "+controlObjectiveTextField_1.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("BOD")){
						data2[1][8]=" "+degradationCoefficientTextField_1.getText();
						data2[1][9]=" "+sedimentCoefficientTextField_1.getText();
						data2[1][10]=" "+controlObjectiveTextField_1.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("TN")){
						data2[1][11]=" "+degradationCoefficientTextField_1.getText();
						data2[1][12]=" "+sedimentCoefficientTextField_1.getText();
						data2[1][13]=" "+controlObjectiveTextField_1.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("TP")){
						data2[1][14]=" "+degradationCoefficientTextField_1.getText();
						data2[1][15]=" "+sedimentCoefficientTextField_1.getText();
						data2[1][16]=" "+controlObjectiveTextField_1.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("NH3-N")){
						data2[1][17]=" "+degradationCoefficientTextField_1.getText();
						data2[1][18]=" "+sedimentCoefficientTextField_1.getText();
						data2[1][19]=" "+controlObjectiveTextField_1.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("NO3-N")){
						data2[1][20]=" "+degradationCoefficientTextField_1.getText();
						data2[1][21]=" "+sedimentCoefficientTextField_1.getText();
						data2[1][22]=" "+controlObjectiveTextField_1.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("DO")){
						data2[1][23]=" "+degradationCoefficientTextField_1.getText();
						data2[1][24]=" "+sedimentCoefficientTextField_1.getText();
						data2[1][25]=" "+controlObjectiveTextField_1.getText();
					}
				s="";
				for(int i=1;i<26;i++){
					if(data2[1][i]!=null){
					s=s+data2[1][i];
					}
				}
				out.write(s);
				out.newLine();
				data2[2][0]="3";
				data2[2][1]=" "+((size1/5)+1);
				data2[2][2]=" "+"1";
				data2[2][3]=" "+(size1*2)/5;
				data2[2][4]=" "+size2;
					if(degradationCoefficientComboBox.getSelectedItem().equals("COD")){
						data2[2][5]=" "+degradationCoefficientTextField_2.getText();
						data2[2][6]=" "+sedimentCoefficientTextField_2.getText();
						data2[2][7]=" "+controlObjectiveTextField_2.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("BOD")){
						data2[2][8]=" "+degradationCoefficientTextField_2.getText();
						data2[2][9]=" "+sedimentCoefficientTextField_2.getText();
						data2[2][10]=" "+controlObjectiveTextField_2.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("TN")){
						data2[2][11]=" "+degradationCoefficientTextField_2.getText();
						data2[2][12]=" "+sedimentCoefficientTextField_2.getText();
						data2[2][13]=" "+controlObjectiveTextField_2.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("TP")){
						data2[2][14]=" "+degradationCoefficientTextField_2.getText();
						data2[2][15]=" "+sedimentCoefficientTextField_2.getText();
						data2[2][16]=" "+controlObjectiveTextField_2.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("NH3-N")){
						data2[2][17]=" "+degradationCoefficientTextField_2.getText();
						data2[2][18]=" "+sedimentCoefficientTextField_2.getText();
						data2[2][19]=" "+controlObjectiveTextField_2.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("NO3-N")){
						data2[2][20]=" "+degradationCoefficientTextField_2.getText();
						data2[2][21]=" "+sedimentCoefficientTextField_2.getText();
						data2[2][22]=" "+controlObjectiveTextField_2.getText();
					}else if(degradationCoefficientComboBox.getSelectedItem().equals("DO")){
						data2[2][23]=" "+degradationCoefficientTextField_2.getText();
						data2[2][24]=" "+sedimentCoefficientTextField_2.getText();
						data2[2][25]=" "+controlObjectiveTextField_2.getText();
					}
					s="";
				for(int i=1;i<26;i++){
					if(data2[2][i]!=null){
					s=s+data2[2][i];
					}
				}
				out.write(s);
				out.newLine();
				data2[3][0]="4";
				data2[3][1]=" "+(((size1*2)/5)+1);
				data2[3][2]=" "+"1";
				data2[3][3]=" "+(size1*3)/5;
				data2[3][4]=" "+size2;
							if(degradationCoefficientComboBox.getSelectedItem().equals("COD")){
								data2[3][5]=" "+degradationCoefficientTextField_3.getText();
								data2[3][6]=" "+sedimentCoefficientTextField_3.getText();
								data2[3][7]=" "+controlObjectiveTextField_3.getText();
							}else if(degradationCoefficientComboBox.getSelectedItem().equals("BOD")){
								data2[3][8]=" "+degradationCoefficientTextField_3.getText();
								data2[3][9]=" "+sedimentCoefficientTextField_3.getText();
								data2[3][10]=" "+controlObjectiveTextField_3.getText();
							}else if(degradationCoefficientComboBox.getSelectedItem().equals("TN")){
								data2[3][11]=" "+degradationCoefficientTextField_3.getText();
								data2[3][12]=" "+sedimentCoefficientTextField_3.getText();
								data2[3][13]=" "+controlObjectiveTextField_3.getText();
							}else if(degradationCoefficientComboBox.getSelectedItem().equals("TP")){
								data2[3][14]=" "+degradationCoefficientTextField_3.getText();
								data2[3][15]=" "+sedimentCoefficientTextField_3.getText();
								data2[3][16]=" "+controlObjectiveTextField_3.getText();
							}else if(degradationCoefficientComboBox.getSelectedItem().equals("NH3-N")){
								data2[3][17]=" "+degradationCoefficientTextField_3.getText();
								data2[3][18]=" "+sedimentCoefficientTextField_3.getText();
								data2[3][19]=" "+controlObjectiveTextField_3.getText();
							}else if(degradationCoefficientComboBox.getSelectedItem().equals("NO3-N")){
								data2[3][20]=" "+degradationCoefficientTextField_3.getText();
								data2[3][21]=" "+sedimentCoefficientTextField_3.getText();
								data2[3][22]=" "+controlObjectiveTextField_3.getText();
							}else if(degradationCoefficientComboBox.getSelectedItem().equals("DO")){
								data2[3][23]=" "+degradationCoefficientTextField_3.getText();
								data2[3][24]=" "+sedimentCoefficientTextField_3.getText();
								data2[3][25]=" "+controlObjectiveTextField_3.getText();
							}
							s="";
							for(int i=1;i<26;i++){
								if(data2[3][i]!=null){
								s=s+data2[3][i];
								}
							}
				out.write(s);
				out.newLine();
				data2[4][0]="5";
				data2[4][1]=" "+(((size1*3)/5)+1);
				data2[4][2]=" "+"1";
				data2[4][3]=" "+(size1*4)/5;
				data2[4][4]=" "+size2;
				if(degradationCoefficientComboBox.getSelectedItem().equals("COD")){
					data2[4][5]=" "+degradationCoefficientTextField_4.getText();
					data2[4][6]=" "+sedimentCoefficientTextField_4.getText();
					data2[4][7]=" "+controlObjectiveTextField_4.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("BOD")){
					data2[4][8]=" "+degradationCoefficientTextField_4.getText();
					data2[4][9]=" "+sedimentCoefficientTextField_4.getText();
					data2[4][10]=" "+controlObjectiveTextField_4.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("TN")){
					data2[4][11]=" "+degradationCoefficientTextField_4.getText();
					data2[4][12]=" "+sedimentCoefficientTextField_4.getText();
					data2[4][13]=" "+controlObjectiveTextField_4.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("TP")){
					data2[4][14]=" "+degradationCoefficientTextField_4.getText();
					data2[4][15]=" "+sedimentCoefficientTextField_4.getText();
					data2[4][16]=" "+controlObjectiveTextField_4.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("NH3-N")){
					data2[4][17]=" "+degradationCoefficientTextField_4.getText();
					data2[4][18]=" "+sedimentCoefficientTextField_4.getText();
					data2[4][19]=" "+controlObjectiveTextField_4.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("NO3-N")){
					data2[4][20]=" "+degradationCoefficientTextField_4.getText();
					data2[4][21]=" "+sedimentCoefficientTextField_4.getText();
					data2[4][22]=" "+controlObjectiveTextField_4.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("DO")){
					data2[4][23]=" "+degradationCoefficientTextField_4.getText();
					data2[4][24]=" "+sedimentCoefficientTextField_4.getText();
					data2[4][25]=" "+controlObjectiveTextField_4.getText();
				}
				s="";
				for(int i=1;i<26;i++){
					if(data2[4][i]!=null){
					s=s+data2[4][i];
					}
				}
				out.write(s);
				out.newLine();
				data2[5][0]="6";
				data2[5][1]=" "+(((size1*4)/5)+1);
				data2[5][2]=" "+"1";
				data2[5][3]=" "+size1;
				data2[5][4]=" "+size2;
				if(degradationCoefficientComboBox.getSelectedItem().equals("COD")){
					data2[5][5]=" "+degradationCoefficientTextField_5.getText();
					data2[5][6]=" "+sedimentCoefficientTextField_5.getText();
					data2[5][7]=" "+controlObjectiveTextField_5.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("BOD")){
					data2[5][8]=" "+degradationCoefficientTextField_5.getText();
					data2[5][9]=" "+sedimentCoefficientTextField_5.getText();
					data2[5][10]=" "+controlObjectiveTextField_5.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("TN")){
					data2[5][11]=" "+degradationCoefficientTextField_5.getText();
					data2[5][12]=" "+sedimentCoefficientTextField_5.getText();
					data2[5][13]=" "+controlObjectiveTextField_5.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("TP")){
					data2[5][14]=" "+degradationCoefficientTextField_5.getText();
					data2[5][15]=" "+sedimentCoefficientTextField_5.getText();
					data2[5][16]=" "+controlObjectiveTextField_5.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("NH3-N")){
					data2[5][17]=" "+degradationCoefficientTextField_5.getText();
					data2[5][18]=" "+sedimentCoefficientTextField_5.getText();
					data2[5][19]=" "+controlObjectiveTextField_5.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("NO3-N")){
					data2[5][20]=" "+degradationCoefficientTextField_5.getText();
					data2[5][21]=" "+sedimentCoefficientTextField_5.getText();
					data2[5][22]=" "+controlObjectiveTextField_5.getText();
				}else if(degradationCoefficientComboBox.getSelectedItem().equals("DO")){
					data2[5][23]=" "+degradationCoefficientTextField_5.getText();
					data2[5][24]=" "+sedimentCoefficientTextField_5.getText();
					data2[5][25]=" "+controlObjectiveTextField_5.getText();
				}
				s="";
				for(int i=1;i<26;i++){
					if(data2[5][i]!=null){
					s=s+data2[5][i];
					}
				}
				out.write(s);
				out.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}	



	 }
		
		
	}


