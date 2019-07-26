package Util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UI.MainFrame;

public class PaintGridPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	
	private  static ArrayList<String[]> xyToIJ;//转换X,Y坐标对应IJ
	
	private double proportion;//缩放比例
	private double B=0,L=0;  //图像显示长L，宽B
	private double maxx=0,maxy=0,minx=100000000,miny=100000000;
	private float proportionW;//屏幕与窗口 宽度比例
	private float proportionH;//屏幕与窗口 高度比例
	private int size1,size2,size;
	private Double[] X; //X坐标数组
	private Double[] Y; //Y坐标数组
	private int [] newX;//转换屏幕坐标X
	private int [] newY;//转换屏幕坐标Y
	
	public PaintGridPanel(JFrame frame){
		this.proportionW = screenWidth/frame.getWidth();
    	this.proportionH = screenHeight/frame.getHeight();
		this.setBounds(10, 14, 320, 240);
		this.setLayout(null);
		setPro();
	}
	
	public void setPro(){
		ArrayList<String[]> list = new FileHanding().getGrid();//获取坐标
		this.xyToIJ = list;
        this.size = list.size();//点的总数
 		for(int i = 0;i<list.size();i++){
 			if(Integer.valueOf(list.get(i)[4])>this.size2){
 				this.size2 = Integer.valueOf(list.get(i)[4]);//获取J的最大值
 			}
 		}
 		X =  new Double[size];
 		Y =  new Double[size];
 		this.size1 = this.size/size2;//获取I的最大值
		for(int i = 0;i<list.size();i++){
				this.X[i] = Double.valueOf(list.get(i)[0]);
				this.Y[i] = Double.valueOf(list.get(i)[1]);
			}
			
			//统计X和Y的最大最小值，确定面板与实际网格范围之间的比例
	        for(int i=0;i<this.size;i++) {
	            if(this.X[i]>=this.maxx)  this.maxx=this.X[i];
	            if(this.X[i]<=this.minx)  this.minx=this.X[i];
	            if(this.Y[i]>=this.maxy)  this.maxy=this.Y[i];
	            if(this.Y[i]<=this.miny)  this.miny=this.Y[i];
	        }
	        //取300*200用来绘制网格，等比缩小网格
	        double value1 = this.maxx-this.minx;
	        double value2 = this.maxy-this.miny;
	        //网格偏水平时，横向缩放为准
	        this.proportion = value1>value2 ? value1/300 : value2/200;
	        //图像显示长L，宽B
	        this.L=(this.maxx-this.minx)/this.proportion;
	        this.B=(this.maxy-this.miny)/this.proportion;
	        
	        newX = new int [size];
		    newY = new int [size];
		        for(int i=0;i<size;i++) {
		            //坐标系平移变换，外加显示居中追加计算,末尾加上舍入误差
		        	newX[i]=((int)((X[i]-minx)/proportion)+(int)(150-L/2)+1)*(int)proportionW;
		        	newY[i]=((int)((maxy-Y[i])/proportion)+(int)(100-B/2)+1)*(int)proportionH;
		        	this.xyToIJ.get(i)[0] = String.valueOf(newX[i]);
		        	this.xyToIJ.get(i)[1] = String.valueOf(newY[i]);
		        }
	}
	
	//重写绘图方法
	public void paint(Graphics g){
		try {
			super.paint(g);
            g.setColor(Color.red);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON); //清除锯齿
         
	        int n=0;
	        for(int i=0;i<size2-1;i++) {
	            for(int j=0;j<size1-1;j++) {
	            	if(i == 0 ){
	            		((Graphics2D)g).setStroke(new BasicStroke(2.0f));  //右边界画粗
	            		g.drawLine(newX[n],newY[n],newX[n+1],newY[n+1]);
	            		((Graphics2D)g).setStroke(new BasicStroke(1.0f));//边界内部画细
	            	}else if(i == size2-2){
	                	((Graphics2D)g).setStroke(new BasicStroke(2.0f));  //左边界画粗
	                	g.drawLine(newX[n+size1],newY[n+size1],newX[n+size1+1],newY[n+size1+1]);
	                	((Graphics2D)g).setStroke(new BasicStroke(1.0f));//边界内部画细
	                	g.drawLine(newX[n],newY[n],newX[n+1],newY[n+1]);
	                }
	            	else{
	            		g.drawLine(newX[n],newY[n],newX[n+1],newY[n+1]);
	            	}
	                n++;
	            }
	            n++;
	        }
	        for(int j=0;j<size2-1;j++) {  //连接边界首部并画粗
	        	((Graphics2D)g).setStroke(new BasicStroke(2.0f));
	        	g.drawLine(newX[j*size1],newY[j*size1],newX[(j+1)*size1],newY[(j+1)*size1]);//连接边界首部
	        	g.drawLine(newX[(j+1)*size1-1],newY[(j+1)*size1-1],newX[(j+2)*size1-1],newY[(j+2)*size1-1]);//连接边界尾部
	        }
	        for(int j=0;j<size1-1;j++){
	        	((Graphics2D)g).setStroke(new BasicStroke(1.0f));
	        	g.drawLine(newX[j],newY[j],newX[size-size1+j],newY[size-size1+j]);
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 600, 400);
		frame.setVisible(true);
		frame.setTitle("hahah");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		PaintGridPanel panel = new PaintGridPanel(new MainFrame());
		ArrayList<String[]> xyTo = panel.xyToIJ;
		
//		 for(int i=0;i<xyTo.size();i++) {
//	            //坐标系平移变换，外加显示居中追加计算,末尾加上舍入误差
//			
//	        	System.out.println(xyTo.get(i)[0]+","+xyTo.get(i)[1]);
//	        }
//		 
		panel.setSize(300, 200);
		
		frame.setContentPane(panel);
	}
}
