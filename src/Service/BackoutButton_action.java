package Service;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import Util.PaintBayLinePanel;

//河岸线展示 撤销按钮
public class BackoutButton_action implements ActionListener{
	private List<int[]> xy;
	private PaintBayLinePanel linePanel;
	public BackoutButton_action(PaintBayLinePanel linePanel,List<int[]> xy){
		this.linePanel = linePanel;
		this.xy = xy;
	}
	Graphics g;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			System.out.println("撤销点为:"+xy.get(xy.size()-1)[0]+" "+xy.get(xy.size()-1)[1]+","+xy.get(xy.size()-1)[2]+" "+xy.get(xy.size()-1)[3]);
			xy.remove(xy.size()-1);//删除最后一条线
		} catch (ArrayIndexOutOfBoundsException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog( null, "不能再撤销了！", "提示",JOptionPane.WARNING_MESSAGE);
		}
		
		g = linePanel.getGraphics();
		linePanel.paint(g);
		g.setColor(Color.red);
		for(int i=0;i<xy.size();i++){//重绘实现撤销效果
			int[] point=xy.get(i);
			g.fillOval(point[0], point[1], 2, 2);
			g.fillOval( point[2], point[3], 2, 2);
			g.drawLine(point[0], point[1], point[2], point[3]);
		}
	}

}
