package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class UpdateButton_action implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	private JFrame frame;
	private JDialog updateDialog;
	public UpdateButton_action(JTable table, DefaultTableModel model, JFrame frame) {
		// TODO Auto-generated constructor stub
		this.table=table;
		this.model=model;
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(table.getSelectedRow()!=table.getRowCount()-1){           //假如不是最后一行
		updateDialog = new JDialog(frame,"更新信息",true);
		updateDialog.setLayout(null);
		updateDialog.setBounds(500, 100, 300, 550);
		
		JLabel sewageOutletNumberLabel2= new JLabel("排污口编号");
		sewageOutletNumberLabel2.setBounds(10, 10, 80, 30);
		updateDialog.add(sewageOutletNumberLabel2);
		
		JLabel XLabel2= new JLabel("位 置  X");
		XLabel2.setBounds(10, 50, 80, 30);
		updateDialog.add(XLabel2);
		
		JLabel YLabel2 = new JLabel("位 置  Y");
		YLabel2.setBounds(10, 90, 80, 30);
		updateDialog.add(YLabel2);
		
		JLabel dischargeFlowLabel2 = new JLabel("排放流量");
		dischargeFlowLabel2.setBounds(10, 130, 80, 30);
		updateDialog.add(dischargeFlowLabel2);
		updateDialog.add(dischargeFlowLabel2);
		
		JLabel CODLabel = new JLabel("COD");
		CODLabel.setBounds(10, 170, 80, 30);
		updateDialog.add(CODLabel);
		
		
		JLabel BODLabel = new JLabel("BOD");
		BODLabel.setBounds(10, 210, 80, 30);
		updateDialog.add(BODLabel);
		
		JLabel TNLabel = new JLabel("TN");
		TNLabel.setBounds(10, 250, 80, 30);
		updateDialog.add(TNLabel);
		
		JLabel TPLabel = new JLabel("TP");
		TPLabel.setBounds(10, 290, 80, 30);
		updateDialog.add(TPLabel);
		
		JLabel NH3_NNLabel = new JLabel("NH3-N");
		NH3_NNLabel.setBounds(10, 330, 80, 30);
		updateDialog.add(NH3_NNLabel);
		
		JLabel NO3_NNLabel = new JLabel("NO3-N");
		NO3_NNLabel.setBounds(10, 370, 80, 30);
		updateDialog.add(NO3_NNLabel);
		
		JLabel DONLabel = new JLabel("DO");
		DONLabel.setBounds(10, 410, 80, 30);
		updateDialog.add(DONLabel);
		
		JTextField sewageOutletNumberTextField2 = new JTextField();
		sewageOutletNumberTextField2.setBounds(150, 10, 100, 30);
		sewageOutletNumberTextField2.setText((String) model.getValueAt(table.getSelectedRow(), 0));
		updateDialog.add(sewageOutletNumberTextField2);
		
		JTextField X_TextField2 = new JTextField();
		X_TextField2.setBounds(150, 50, 100, 30);
		X_TextField2.setText((String) model.getValueAt(table.getSelectedRow(), 1));
		updateDialog.add(X_TextField2);
		
		JTextField Y_TextField2 = new JTextField();
		Y_TextField2.setBounds(150, 90, 100, 30);
		Y_TextField2.setText((String) model.getValueAt(table.getSelectedRow(), 2));
		updateDialog.add(Y_TextField2);
		
		JTextField dischargeFlowTextField2 = new JTextField();
		dischargeFlowTextField2.setBounds(150, 130, 100, 30);
		dischargeFlowTextField2.setText((String) model.getValueAt(table.getSelectedRow(), 3));
		updateDialog.add(dischargeFlowTextField2);
		
		JTextField CODTextField = new JTextField();
		CODTextField.setBounds(150, 170, 100, 30);
		CODTextField.setText((String) model.getValueAt(table.getSelectedRow(), 4));
		updateDialog.add(CODTextField);
		
		JTextField BODTextField = new JTextField();
		BODTextField.setBounds(150, 210, 100, 30);
		BODTextField.setText((String) model.getValueAt(table.getSelectedRow(), 5));
		updateDialog.add(BODTextField);
		
		JTextField TNTextField = new JTextField();
		TNTextField.setBounds(150, 250, 100, 30);
		TNTextField.setText((String) model.getValueAt(table.getSelectedRow(), 6));
		updateDialog.add(TNTextField);
		
		JTextField TPTextField = new JTextField();
		TPTextField.setBounds(150, 290, 100, 30);
		TPTextField.setText((String) model.getValueAt(table.getSelectedRow(), 7));
		updateDialog.add(TPTextField);
		
		JTextField NH3_NTextField = new JTextField();
		NH3_NTextField.setBounds(150, 330, 100, 30);
		NH3_NTextField.setText((String) model.getValueAt(table.getSelectedRow(), 8));
		updateDialog.add(NH3_NTextField);
		
		JTextField NO3_NTextField = new JTextField();
		NO3_NTextField.setBounds(150, 370, 100, 30);
		NO3_NTextField.setText((String) model.getValueAt(table.getSelectedRow(), 9));
		updateDialog.add(NO3_NTextField);
		
		JTextField DOTextField = new JTextField();
		DOTextField.setBounds(150, 410, 100, 30);
		DOTextField.setText((String) model.getValueAt(table.getSelectedRow(), 10));
		updateDialog.add(DOTextField);
		
		JButton updateTableButton = new JButton("更新");
		updateTableButton.setBounds(100, 450, 80, 30);
		updateTableButton.addActionListener(new UpdateTableButton_action(table, model,sewageOutletNumberTextField2,
				                                                                      X_TextField2,
				                                                                      Y_TextField2,
				                                                                      dischargeFlowTextField2,
				                                                                      CODTextField,
				                                                                      BODTextField,
				                                                                      TNTextField,
				                                                                      TPTextField,
				                                                                      NH3_NTextField,
				                                                                      NO3_NTextField,
				                                                                      DOTextField,
				                                                                      updateDialog));
		updateDialog.add(updateTableButton);
		
		updateDialog.setVisible(true);
		updateDialog.pack();
		}
		
	}

}
