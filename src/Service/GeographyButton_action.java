package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import UI.Geography;

//地形生成按钮
public class GeographyButton_action implements ActionListener{
	
	private JFrame frame;
	
	public GeographyButton_action(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Geography geoFrame = new Geography();//跳转窗口
		frame.setVisible(false);; //当前窗口不可见	
	}

}
