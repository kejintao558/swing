package Service;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import UI.Analysis;

public class viewDetailsButton_action implements ActionListener{
	
	
	public viewDetailsButton_action(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{ 
			Runtime.getRuntime().exec("cmd /c start D:/Datain/指标系数展示.xls");    //打开详细结果Excel表
			}catch(IOException e1){
				e1.printStackTrace();
			} 

	}

}
