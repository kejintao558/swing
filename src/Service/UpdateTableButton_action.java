package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UpdateTableButton_action implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	private JTextField sewageOutletNumberTextField2;
	private JTextField x_TextField2;
	private JTextField y_TextField2;
	private JTextField dischargeFlowTextField2;
	private JTextField cODTextField;
	private JTextField bODTextField;
	private JTextField tNTextField;
	private JTextField tPTextField;
	private JTextField nH3_NTextField;
	private JTextField nO3_NTextField;
	private JTextField dOTextField;
	private JDialog updateDialog;
	
	public UpdateTableButton_action(JTable table, DefaultTableModel model, JTextField sewageOutletNumberTextField2,
			                                                               JTextField x_TextField2, 
			                                                               JTextField y_TextField2, 
			                                                               JTextField dischargeFlowTextField2, 
			                                                               JTextField cODTextField, 
			                                                               JTextField bODTextField, 
			                                                               JTextField tNTextField, 
			                                                               JTextField tPTextField, 
			                                                               JTextField nH3_NTextField, 
			                                                               JTextField nO3_NTextField, 
			                                                               JTextField dOTextField,
			                                                               JDialog updateDialog){
		this.table=table;
		this.model=model;
		this.sewageOutletNumberTextField2=sewageOutletNumberTextField2;
		this.x_TextField2=x_TextField2;
		this.y_TextField2=y_TextField2;
		this.dischargeFlowTextField2=dischargeFlowTextField2;
		this.cODTextField=cODTextField;
		this.bODTextField=bODTextField;
		this.tNTextField=tNTextField;
		this.tPTextField=tPTextField;
		this.nH3_NTextField=nH3_NTextField;
		this.nO3_NTextField=nO3_NTextField;
		this.dOTextField=dOTextField;
		this.updateDialog=updateDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
		model.setValueAt(sewageOutletNumberTextField2.getText(), table.getSelectedRow(), 0);         //将更新的内容在table中修改更新
		model.setValueAt(x_TextField2.getText(), table.getSelectedRow(), 1);
		model.setValueAt(y_TextField2.getText(), table.getSelectedRow(), 2);
		model.setValueAt(dischargeFlowTextField2.getText(), table.getSelectedRow(), 3);
		model.setValueAt(cODTextField.getText(), table.getSelectedRow(), 4);
		model.setValueAt(bODTextField.getText(), table.getSelectedRow(), 5);
		model.setValueAt(tNTextField.getText(), table.getSelectedRow(), 6);
		model.setValueAt(tPTextField.getText(), table.getSelectedRow(), 7);
		model.setValueAt(nH3_NTextField.getText(), table.getSelectedRow(), 8);
		model.setValueAt(nO3_NTextField.getText(), table.getSelectedRow(), 9);
		model.setValueAt(dOTextField.getText(), table.getSelectedRow(), 10);
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		try{
			updateDialog.dispose();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
