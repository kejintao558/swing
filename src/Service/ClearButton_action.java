package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Util.PaintBayLinePanel;

//清除按钮
public class ClearButton_action implements ActionListener{
	private List<int[]> xy;
	private PaintBayLinePanel linePanel;
	public ClearButton_action(PaintBayLinePanel linePanel,List<int[]> xy){
		this.linePanel = linePanel;
		this.xy = xy;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		linePanel.repaint();
		xy.clear();
		System.out.println("清除成功！");
	}

}
