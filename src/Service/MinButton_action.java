package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import UI.MainFrame;

//窗口最小化
public class MinButton_action implements ActionListener{
	
	private MainFrame frame;
	
	public MinButton_action(MainFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.frame.setExtendedState(JFrame.ICONIFIED);//最小化窗口
	}

}
