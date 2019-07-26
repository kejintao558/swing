package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import UI.Analysis;

//结果分析按钮
public class AnalysisButton_action implements ActionListener{
	
	private JFrame frame;

	
	public AnalysisButton_action(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Analysis anaFrame = new Analysis();//跳转窗口
		frame.setVisible(false);; //当前窗口不可见	
	}

}
