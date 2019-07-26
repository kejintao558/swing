package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import UI.MainFrame;

//窗口最大化
public class MaxButton_action implements ActionListener{
	
	private MainFrame frame;
	
	public MaxButton_action(MainFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub    
		//退出程序
		int result = JOptionPane.showConfirmDialog(frame,"确定要退出?", "系统提示",
	               JOptionPane.YES_NO_CANCEL_OPTION,
	               JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION){
			System.exit(0);
		}
		
		
//		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//最大化窗口
	}

}