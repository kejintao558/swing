package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class textEditable_action implements ActionListener{
	private JCheckBox CheckBox;
	private JTextField TextField;

	public textEditable_action(JCheckBox CheckBox, JTextField TextField) {
		// TODO Auto-generated constructor stub
		this.CheckBox=CheckBox;
		this.TextField=TextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(CheckBox.isSelected()){
			TextField.setEditable(true);
		}
		
	}

}
