package Service;

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

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Util.FileChooser;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class findButton_action implements ActionListener{
	private File file;
	private JTextField coordinates_textField;
	String suffix;

	public findButton_action(File file, JTextField coordinates_textField, String suffix) {
		// TODO Auto-generated constructor stub
		this.file=file;
		this.coordinates_textField=coordinates_textField;
		this.suffix=suffix;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc=new FileChooser(suffix);
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File file1=jfc.getSelectedFile();
		if(file1.isDirectory()){
			System.out.println("文件夹:"+file1.getAbsolutePath());
		}else if(file1.isFile()){
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
				Workbook workbook=Workbook.getWorkbook(file1);
				Sheet sheet = workbook.getSheet(0);
				Cell cell_count = sheet.getCell(0,0);
				out.write(cell_count.getContents());
				out.newLine();
				for(int i=1;i<sheet.getRows();i++){
					Cell cell_number = sheet.getCell(0,1);
					Cell cell_x1 = sheet.getCell(2,i);
					Cell cell_y1 = sheet.getCell(3,i);
					Cell cell_x2 = sheet.getCell(4,i);
					Cell cell_y2 = sheet.getCell(5,i);
					Cell cell_x3 = sheet.getCell(6,i);
					Cell cell_y3 = sheet.getCell(7,i);
					Cell cell_x4 = sheet.getCell(8,i);
					Cell cell_y4 = sheet.getCell(9,i);
					Cell cell_type = sheet.getCell(10,i);
					String s = cell_number.getContents()+" "+cell_x1.getContents()+" "+cell_y1.getContents()+" "+
							   cell_x2.getContents()+" "+cell_y2.getContents()+" "+cell_x3.getContents()+" "+
							   cell_y3.getContents()+" "+cell_x4.getContents()+" "+cell_y4.getContents()+" "+
							   cell_type.getContents();
					out.write(s);
					out.newLine();
				}
				out.close();
				
			} catch (IOException | BiffException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("文件:"+file.getAbsolutePath());
			coordinates_textField.setText(file1.getAbsolutePath());
		}else{
			System.out.print("没有选择文件");
		}		
	}
		
	}



