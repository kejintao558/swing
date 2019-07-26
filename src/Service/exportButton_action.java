package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Util.FileHanding;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class exportButton_action implements ActionListener{
	private JTable table;

	public exportButton_action(JTable table) {
		// TODO Auto-generated constructor stub
		this.table=table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			TableModel model = table.getModel();
			File file=new File(FileHanding.getPath()+"/point_source.xls");
			file.createNewFile();                                             //清空表格
			WritableWorkbook workbook=Workbook.createWorkbook(file);          //创建新的工作表
			WritableSheet sheet=workbook.createSheet("点源数据", 0);             //表名
			Label label=null;
			for(int i=0;i<model.getColumnCount()-1;i++){
				label=new Label(i,0,(String) table.getColumnName(i));
				sheet.addCell(label);
			}
			for(int i=0; i< model.getRowCount()-1; i++) {                        //将table中的数据写到Excel表中,最后一行不取
		            for(int j=0; j < model.getColumnCount()-1; j++) {
		            	label=new Label(j,i+1,(String) model.getValueAt(i, j));
		            	sheet.addCell(label);
		            }
		            }
			 workbook.write();
			 workbook.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	
}
