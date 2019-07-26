package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jfree.data.category.DefaultCategoryDataset;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import Util.FileHanding;
import Util.barGraph;

public class countButton_action implements ActionListener{
	private JTable table;
	private JTextField coordinates_textField;
	private DefaultCategoryDataset dataset;

	public countButton_action(JTable table, JTextField coordinates_textField, DefaultCategoryDataset dataset) {
		// TODO Auto-generated constructor stub
		this.table=table;
		this.coordinates_textField=coordinates_textField;
		this.dataset=dataset;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		File file1 = new File(FileHanding.getPath()+"/容量计算结果.DAT");
		File file2 = new File(coordinates_textField.getText());
		Workbook workbook;
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file1.getPath()), "gbk"));
			workbook = Workbook.getWorkbook(file2);
			Sheet sheet=workbook.getSheet(0);
			for(int i=1;i<sheet.getRows();i++){
				Cell cell_name = sheet.getCell(1, i);
				String s=bufr.readLine();
				String[] str =s.trim().split(" ");//使用正则表达式去掉空格
				table.setValueAt(cell_name.getContents(), i-1, 0);
				table.setValueAt(str[1], i-1, 1);
				table.setValueAt(str[2], i-1, 2);
				table.setValueAt(str[3], i-1, 3);
				dataset.setValue(Integer.parseInt(str[1]),"COD",cell_name.getContents());
				dataset.setValue(Integer.parseInt(str[2]),"TN",cell_name.getContents());
				dataset.setValue(Integer.parseInt(str[3]),"TP",cell_name.getContents());
			}
			workbook.close();
			bufr.close();
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}        
	}

}
