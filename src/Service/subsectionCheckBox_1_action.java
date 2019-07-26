package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class subsectionCheckBox_1_action implements ActionListener{
	private JCheckBox subsectionCheckBox_1;
	private JTextField riverTextField_1;
	private JTextField riverTextField_2;
	private JTextField riverTextField_3;
	private JTextField riverTextField_4;
	private JTextField riverTextField_5;

	public subsectionCheckBox_1_action(JCheckBox subsectionCheckBox_1, JTextField riverTextField_1,
			                                                           JTextField riverTextField_2,
			                                                           JTextField riverTextField_3,
			                                                           JTextField riverTextField_4,
			                                                           JTextField riverTextField_5) {
		// TODO Auto-generated constructor stub
		this.subsectionCheckBox_1=subsectionCheckBox_1;
		this.riverTextField_1=riverTextField_1;
		this.riverTextField_2=riverTextField_2;
		this.riverTextField_3=riverTextField_3;
		this.riverTextField_4=riverTextField_4;
		this.riverTextField_5=riverTextField_5;
	}

	@Override
	public void actionPerformed(ActionEvent e) {               //用于控制对应的文本框是否可编辑
		// TODO Auto-generated method stub
		if(subsectionCheckBox_1.isSelected()){
			riverTextField_1.setText(null);
			riverTextField_2.setEditable(true);
			riverTextField_3.setEditable(true);
			riverTextField_4.setEditable(true);
			riverTextField_5.setEditable(true);
		}else{
			riverTextField_2.setEditable(false);
			riverTextField_2.setText(null);
			riverTextField_3.setEditable(false);
			riverTextField_3.setText(null);
			riverTextField_4.setEditable(false);
			riverTextField_4.setText(null);
			riverTextField_5.setEditable(false);
			riverTextField_5.setText(null);
		}
		
	}

}
