package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import UI.InputCondition;

//输入条件按钮
public class InputConditionButton_action implements ActionListener{
	
	private JFrame frame;
	
	public InputConditionButton_action(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		InputCondition inputFrame = new InputCondition();//跳转窗口
		frame.setVisible(false);; //当前窗口不可见	
	}

}
