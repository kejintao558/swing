package Service;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonListener implements ActionListener {
	private JPanel Panel; 
	public ResetButtonListener(JPanel Panel) {
		this.Panel = Panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int count = Panel.getComponentCount();
			for (int i = 0; i < count; i++) {                              //将panel中的文本框和单选框清空
				Component comp = Panel.getComponent(i);
				if(comp.getClass().getName().equals("javax.swing.JCheckBox")){
					((JCheckBox) comp).setSelected(false);
				}else if(comp.getClass().getName().equals("javax.swing.JTextField")){
					((JTextField) comp).setText(null);
				}
			}
			
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
