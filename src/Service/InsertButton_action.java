package Service;

import java.awt.Component;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class InsertButton_action implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	private JTextField sewageOutletNumberTextField;
	private JTextField X_TextField;
	private JTextField Y_TextField;
	private JTextField dischargeFlowTextField;
	private JTextField cOD_TextField;
	private JTextField bOD_TextField;
	private JTextField tN_TextField;
	private JTextField tP_TextField;
	private JTextField nH3_N_TextField;
	private JTextField nO3_N_TextField;
	private JTextField dO_TextField;

	public InsertButton_action(JTable table, DefaultTableModel model, JTextField sewageOutletNumberTextField,
			                                                          JTextField X_TextField,
			                                                          JTextField Y_TextField,
			                                                          JTextField dischargeFlowTextField,
			                                                          JTextField cOD_TextField,
			                                                          JTextField bOD_TextField,
			                                                          JTextField tN_TextField,
			                                                          JTextField tP_TextField,
			                                                          JTextField nH3_N_TextField,
			                                                          JTextField nO3_N_TextField,
			                                                          JTextField dO_TextField) {
		// TODO Auto-generated constructor stub
		this.table=table;
		this.model=model;
		this.sewageOutletNumberTextField=sewageOutletNumberTextField;
		this. X_TextField= X_TextField;
		this.Y_TextField=Y_TextField;
		this.dischargeFlowTextField=dischargeFlowTextField;
		this.cOD_TextField=cOD_TextField;
		this.bOD_TextField=bOD_TextField;
		this.tN_TextField=tN_TextField;
		this.tP_TextField=tP_TextField;
		this.nH3_N_TextField=nH3_N_TextField;
		this.nO3_N_TextField=nO3_N_TextField;
		this.dO_TextField=dO_TextField;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			 boolean flag = false;             //默认开始不存在重复的编口号
			if(model.getRowCount()!=0){                   //添加第二条及第N条数据时
			for(int i =0;i<model.getRowCount();i++){      //判断排污口编号是否重复
				if(sewageOutletNumberTextField.getText().equals(model.getValueAt(i, 0))){
				flag = true;
				}
			}
			if(flag==false){                  //表格中无重复的排污口编号
				Vector<String> rowData = new Vector<String>();
				rowData.add(sewageOutletNumberTextField.getText());
				rowData.add(X_TextField.getText());
				rowData.add(Y_TextField.getText());
				rowData.add(dischargeFlowTextField.getText());
				if(cOD_TextField.getText()!=null){          //添加污染物浓度
					rowData.add(cOD_TextField.getText());
				}
				if(bOD_TextField.getText()!=null){
					rowData.add(bOD_TextField.getText());
				}
				if(tN_TextField.getText()!=null){
					rowData.add(tN_TextField.getText());
				}
				if(tP_TextField.getText()!=null){
					rowData.add(tP_TextField.getText());
				}
				if(nH3_N_TextField.getText()!=null){
					rowData.add(nH3_N_TextField.getText());
				}
				if(nO3_N_TextField.getText()!=null){
					rowData.add(nO3_N_TextField.getText());
				}
				if(dO_TextField.getText()!=null){
					rowData.add(dO_TextField.getText());
				}
				model.insertRow(model.getRowCount()-1, rowData);
			}
			}else{                                        //添加第一条数据时,即model.getRowCount()=0
				if(sewageOutletNumberTextField.getText()!=null){        //排污口编号不能为空
				Vector<String> rowData = new Vector<String>();
				rowData.add(sewageOutletNumberTextField.getText());
				rowData.add(X_TextField.getText());
				rowData.add(Y_TextField.getText());
				rowData.add(dischargeFlowTextField.getText());
				if(cOD_TextField.getText()!=null){          //添加污染物浓度
					rowData.add(cOD_TextField.getText());
				}
				if(bOD_TextField.getText()!=null){
					rowData.add(bOD_TextField.getText());
				}
				if(tN_TextField.getText()!=null){
					rowData.add(tN_TextField.getText());
				}
				if(tP_TextField.getText()!=null){
					rowData.add(tP_TextField.getText());
				}
				if(nH3_N_TextField.getText()!=null){
					rowData.add(nH3_N_TextField.getText());
				}
				if(nO3_N_TextField.getText()!=null){
					rowData.add(nO3_N_TextField.getText());
				}
				if(dO_TextField.getText()!=null){
					rowData.add(dO_TextField.getText());
				}
				model.insertRow(model.getRowCount(), rowData);
				}else{
					System.out.print("排污口编号不能为空");
				}
			}
		
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}

