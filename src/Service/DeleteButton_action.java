package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteButton_action implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	public DeleteButton_action(JTable table, DefaultTableModel model){
		this.table=table;
		this.model=model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(table.getSelectedRow()!=table.getRowCount()-1){        //假如不是最后一行
		model.removeRow(table.getSelectedRow());                  //删除选中的行
		System.out.print(table.getSelectedRow());
		model.fireTableDataChanged();                             //更新表格
		}
		
	}

}
