package Service;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Analysis_Mouse implements MouseListener{
	private JFrame frame;
	
	public Analysis_Mouse(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int c = e.getButton();// 得到按下的鼠标键
		if (c == MouseEvent.BUTTON1){ // 判断是鼠标左键按下
//			System.out.println(e.getPoint());
			
			JDialog InforDialog = new JDialog(frame, "信息",true);
			InforDialog.setLayout(null);
			InforDialog.setResizable(false);
			InforDialog.setBounds(e.getLocationOnScreen().x-10, e.getLocationOnScreen().y-10, 300, 500);
			System.out.println(e.getX());
			JLabel XLabel= new JLabel("位 置  X:");
			XLabel.setBounds(10, 10, 80, 30);
			InforDialog.add(XLabel);
		    
			JLabel YLabel = new JLabel("位 置  Y:");
			YLabel.setBounds(10, 50, 80, 30);
			InforDialog.add(YLabel);
			
			JLabel I_Label = new JLabel("I:");
			I_Label.setBounds(10, 90, 80, 30);
			InforDialog.add(I_Label);
			
			JLabel J_Label = new JLabel("J:");
			J_Label.setBounds(10, 130, 80, 30);
			InforDialog.add(J_Label);
			
			JLabel CODLabel = new JLabel("COD:");
			CODLabel.setBounds(10, 170, 80, 30);
			InforDialog.add(CODLabel);
			
			
			JLabel BODLabel = new JLabel("BOD:");
			BODLabel.setBounds(10, 210, 80, 30);
			InforDialog.add(BODLabel);
			
			JLabel TNLabel = new JLabel("TN:");
			TNLabel.setBounds(10, 250, 80, 30);
			InforDialog.add(TNLabel);
			
			JLabel TPLabel = new JLabel("TP:");
			TPLabel.setBounds(10, 290, 80, 30);
			InforDialog.add(TPLabel);
			
			JLabel NH3_NNLabel = new JLabel("NH3-N:");
			NH3_NNLabel.setBounds(10, 330, 80, 30);
			InforDialog.add(NH3_NNLabel);
			
			JLabel NO3_NNLabel = new JLabel("NO3-N:");
			NO3_NNLabel.setBounds(10, 370, 80, 30);
			InforDialog.add(NO3_NNLabel);
			
			JLabel DONLabel = new JLabel("DO:");
			DONLabel.setBounds(10, 410, 80, 30);
			InforDialog.add(DONLabel);
			
			JLabel XLabel_value= new JLabel("");
			XLabel_value.setBounds(150, 10, 80, 30);
			InforDialog.add(XLabel_value);
		    
			JLabel YLabel_value = new JLabel("");
			YLabel_value.setBounds(150, 50, 80, 30);
			InforDialog.add(YLabel_value);
			
			JLabel I_Label_value = new JLabel("");
			I_Label_value.setBounds(150, 90, 80, 30);
			InforDialog.add(I_Label_value);
			
			JLabel J_Label_value= new JLabel("");
			J_Label_value.setBounds(150, 130, 80, 30);
			InforDialog.add(J_Label_value);
			
			JLabel CODLabel_value = new JLabel("");
			CODLabel_value.setBounds(150, 170, 80, 30);
			InforDialog.add(CODLabel_value);
			
			
			JLabel BODLabel_value = new JLabel("");
			BODLabel_value.setBounds(150, 210, 80, 30);
			InforDialog.add(BODLabel_value);
			
			JLabel TNLabel_value = new JLabel("");
			TNLabel_value.setBounds(150, 250, 80, 30);
			InforDialog.add(TNLabel_value);
			
			JLabel TPLabel_value = new JLabel("");
			TPLabel_value.setBounds(150, 290, 80, 30);
			InforDialog.add(TPLabel_value);
			
			JLabel NH3_NNLabel_value = new JLabel("");
			NH3_NNLabel_value.setBounds(150, 330, 80, 30);
			InforDialog.add(NH3_NNLabel_value);
			
			JLabel NO3_NNLabel_value = new JLabel("");
			NO3_NNLabel_value.setBounds(150, 370, 80, 30);
			InforDialog.add(NO3_NNLabel_value);
			
			JLabel DONLabel_value = new JLabel("");
			DONLabel_value.setBounds(150, 410, 80, 30);
			InforDialog.add(DONLabel_value);
			
			InforDialog.setVisible(true);
			InforDialog.pack();
		}
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
