package Service;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import Util.PaintBayLinePanel;

//画线按钮
public class DrawButton_action implements ActionListener{
	private PaintBayLinePanel linePanel;
	private List<int[]> xy;//用于存取左右岸坐标
	private JButton button;
	public DrawButton_action(PaintBayLinePanel linePanel,List<int[]> xy,JButton button){
		this.linePanel = linePanel;
		this.xy = xy;
		this.button = button;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		linePanel.addMouseListener(new MouseListener() {
			
			List<Point> li = new ArrayList<Point>();
			Graphics g;
	
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Point p1 = new Point();
				Point p2 = new Point();
				int[] point_XY = new int[4];//暂存点的坐标
				li.add(e.getPoint());
				if (li.size() % 2 == 0) {
					g = linePanel.getGraphics();
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);//去掉锯齿
					g.setColor(Color.red);
					p1 = li.get(0);
					p2 = li.get(1);
					
					point_XY[0] = p1.x;
					point_XY[1] = p1.y;
					point_XY[2] = p2.x;
					point_XY[3] = p2.y;
					
					g.fillOval(e.getX(), e.getY(), 2, 2);//画点
					g.drawLine(p1.x, p1.y, p2.x, p2.y);//画线
					System.out.println("绘制的点为:"+p1.x+" "+p1.y+","+p2.x+" "+p2.y);
					xy.add(point_XY);
					li.clear();
				} else {
					g = linePanel.getGraphics();
					g.setColor(Color.red);
					g.fillOval(e.getX(), e.getY(), 2, 2);
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
		});
//		button.setVisible(false);// 使其不见
//		button.setEnable(false); // 使其不可用
		this.button.removeActionListener(this);// 移除侦听事件
	}

}
