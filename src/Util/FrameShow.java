package Util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameShow {
	/**
	 * frame中的控件自适应frame大小：改变大小位置和字体
	 * @param frame 要控制的窗体
	 * @param proportion 当前和原始的比例
	 */
	public static void modifyComponentSize(JFrame frame,float proportionW,float proportionH){
		
		//放大frame里的组件
		try 
		{
			Component[] components = frame.getRootPane().getContentPane().getComponents();
			for(Component co:components)
			{
				//Panel容器内组件放大
				if(co.getClass().getName().equals("javax.swing.JPanel")){ 
					try {
						int count = ((Container) co).getComponentCount();
						for (int i = 0; i < count; i++) {
							Component comp = ((Container) co).getComponent(i);
							max(comp,proportionW,proportionH);
						}			
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}				
				max(co,proportionW,proportionH); //放大其他组件
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//用来放大父Panel嵌入的子panel内的组件
	public static void modifyJPanelSize(JPanel panel,float proportionW,float proportionH){
		try {
			int count = panel.getComponentCount();
			for (int i = 0; i < count; i++) {
				Component comp = panel.getComponent(i);
				max(comp,proportionW,proportionH);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//放大单个组件方法
	public static void max(Component co,float proportionW,float proportionH){
		float locX = co.getX() * proportionW;
		float locY = co.getY() * proportionH;
		float width = co.getWidth() * proportionW;
		float height = co.getHeight() * proportionH;
		co.setLocation((int)locX, (int)locY);
		co.setSize((int)width, (int)height);
		int size = (int)(co.getFont().getSize() * proportionH);
		Font font = new Font(co.getFont().getFontName(), co.getFont().getStyle(), size);
		co.setFont(font);	
	}
	

}
