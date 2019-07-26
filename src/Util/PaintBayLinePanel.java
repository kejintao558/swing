package Util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import Service.BackoutButton_action;
import Service.ClearButton_action;
import Service.DrawButton_action;
import Service.SubmitButton_action;
import UI.MainFrame;

public  class PaintBayLinePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	
	private List<int[]> xy = new ArrayList<int[]>();//画图取点数组
	
    static Double[] right_countX = null; //右岸点X坐标数组
    static Double[] right_countY = null; //右岸点Y坐标数组
    static Double[] left_countX = null; //左岸点X坐标数组
    static Double[] left_countY = null; //左岸点Y坐标数组
    

    
    private double proportion;//缩放比例
    private double B=0,L=0;  //图像显示长L，宽B
    private double maxx=0,maxy=0,minx=100000000,miny=100000000;
	private float proportionW;//屏幕与窗口 宽度比例
	private float proportionH;//屏幕与窗口 高度比例
    
    //构造方法
    public PaintBayLinePanel(JFrame frame){ 
    	this.proportionW = screenWidth/frame.getWidth();
    	this.proportionH = screenHeight/frame.getHeight();
		this.setBounds(10, 0, 320, 255);
		this.setLayout(null);
		
		read();
        setPro();
		
		JButton draw_button = new JButton("画线");
		draw_button.setFont(new Font("宋体", Font.PLAIN, 10));
		draw_button.setBounds(15, 242, 60, 13);
		this.add(draw_button);
		draw_button.addActionListener(new DrawButton_action(this,xy,draw_button));
	
			
		JButton backout_button = new JButton("撤销");
		backout_button.setFont(new Font("宋体", Font.PLAIN, 10));
		backout_button.setBounds(80, 242, 60, 13);
		this.add(backout_button);
		backout_button.addActionListener(new BackoutButton_action(this, xy));
		
		JButton clear_button = new JButton("清除");
		clear_button.setFont(new Font("宋体", Font.PLAIN, 10));
		clear_button.setBounds(145, 242, 60, 13);
		this.add(clear_button);
		clear_button.addActionListener(new ClearButton_action(this,xy));
		
		JButton submit_button = new JButton("确定");
		submit_button.setFont(new Font("宋体", Font.PLAIN, 10));
		submit_button.setBounds(210, 242, 60, 13);
		this.add(submit_button);
		submit_button.addActionListener(new SubmitButton_action(xy));
		
    }
    
    //设置坐标转换 参数
    public void setPro(){
    	
    	//统计X和Y的最大最小值，确定面板与实际网格范围之间的比例
        for(int i=0;i<right_countX.length;i++) {
            if(right_countX[i]>=this.maxx)  this.maxx=right_countX[i];
            if(right_countX[i]<=this.minx)  this.minx=right_countX[i];
            if(right_countY[i]>=this.maxy)  this.maxy=right_countY[i];
            if(right_countY[i]<=this.miny)  this.miny=right_countY[i];
        }
        for(int i=0;i<left_countX.length;i++) {
            if(left_countX[i]>=this.maxx)  this.maxx=left_countX[i];
            if(left_countX[i]<=this.minx)  this.minx=left_countX[i];
            if(left_countY[i]>=this.maxy)  this.maxy=left_countY[i];
            if(left_countY[i]<=this.miny)  this.miny=left_countY[i];
        }
        
      //面板尺寸固定为340x255（高）取300*200用来绘制网格，等比缩小网格
        double value1 = this.maxx-this.minx;
        double value2 = this.maxy-this.miny;
        //网格偏水平时，横向缩放为准
        this.proportion = value1>value2 ? value1/300 : value2/200;
        this.L=(this.maxx-this.minx)/this.proportion;//图像显示长
        this.B=(this.maxy-this.miny)/this.proportion;//图像显示宽
    }
    
    
	//获取左岸右岸点的个数
	public  static int[] readCount(String filepath){
		int[] count = null;
		try {
			BufferedReader br = null;
		    br = new BufferedReader(new FileReader(filepath));
		    String line = br.readLine();
		    int right_count = 0;
		    int left_count = 0;
		    while(line != null){
		    	String[] numbers = line.split("\\s+ ");
		    	if(Integer.valueOf(numbers[0]) ==1  && numbers.length==2){
		    		right_count = Integer.valueOf(numbers[1]); //右岸点个数
		    	}		    	
		    	if(Integer.valueOf(numbers[0]) == 2 && numbers.length==2){
		    		left_count = Integer.valueOf(numbers[1]); //左岸点个数
		    	}
		    	line = br.readLine();
		    	}
		    System.out.println("readCount获取左岸右岸点成功!");
		    br.close();
		    int[] count1 = {right_count,left_count};
		    count = count1;
		    }
			catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	
	//读边界文件
	@SuppressWarnings("resource")
	public void read(){
		try {
			String filepath =FileHanding.getPath()+"/GEO_ORG/BAY_LINE.DAT";
			BufferedReader br = null;
		    br = new BufferedReader(new FileReader(filepath));
		    String line = br.readLine();
		    int[] count = readCount(filepath);
		    int j =0;
		   right_countX = new Double[count[0]]; //右岸点X坐标数组
		   right_countY = new Double[count[0]]; //右岸点Y坐标数组
		   left_countX = new Double[count[1]]; //左岸点X坐标数组
		   left_countY = new Double[count[1]]; //左岸点Y坐标数组
		    
		    for(int i = 0;i< right_countX.length && (line=br.readLine())!=null ;i++){ //读右岸
	    		 String[] numbers = line.split("\\s+ ");
	    		 right_countX[i] = Double.valueOf(numbers[1]);//写入X坐标
	    		 right_countY[i] = Double.valueOf(numbers[2]);//写入Y坐标
	    		 }
		    System.out.println("右岸坐标写入成功!");
		    line = br.readLine();
		    while((line = br.readLine())!=null){  //读左岸
		    	if(j<count[1]){
		    		String[] numbers = line.split("\\s+ ");
		    		left_countX[j] = Double.valueOf(numbers[1]);//写入X坐标
		    		left_countY[j] = Double.valueOf(numbers[2]);//写入Y坐标
		    		j++;
		    	}
		    }
		    System.out.println("左岸坐标写入成功!");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//画边界线
	public void paint(Graphics g) {
		 try {
			 	super.paint(g);
	            g.setColor(Color.red);
	            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON); //清除锯齿
	            
	            int [] right_X = new int [right_countX.length];
	            int [] right_Y = new int [right_countY.length];
	            int [] left_X = new int [left_countX.length];
	            int [] left_Y = new int [left_countX.length];
	            
	            for(int i=0;i<right_countX.length;i++) {
	                //坐标系平移变换，外加显示居中追加计算,末尾加上舍入误差
	            	right_X[i]=((int)((right_countX[i]-this.minx)/this.proportion)+(int)(150-this.L/2)+1)*(int)proportionW;
	            	right_Y[i]=((int)((this.maxy-right_countY[i])/this.proportion)+(int)(100-this.B/2)+1)*(int)proportionH;
	            }
	            for(int i=0;i<left_countX.length;i++) {
	                //坐标系平移变换，外加显示居中追加计算,末尾加上舍入误差
	            	left_X[i]=((int)((left_countX[i]-this.minx)/this.proportion)+(int)(150-this.L/2)+1)*(int)proportionW;
	            	left_Y[i]=((int)((this.maxy-left_countY[i])/this.proportion)+(int)(100-this.B/2)+1)*(int)proportionH;
	            }
	            
	            for(int i=0;i<right_countX.length-1;i++) {//画右边界
	            	if(i == 0){//连接左右边界的首部
	            		g.drawLine(right_X[i],right_Y[i],right_X[i+1],right_Y[i+1]);
	            		g.drawLine(right_X[0],right_Y[0],left_X[0],left_Y[0]);
	            	}
	            	else if(i == right_countX.length-2){//连接左右边界的尾部
	            		g.drawLine(right_X[i+1],right_Y[i+1],left_X[left_countX.length-1],left_Y[left_countX.length-1]);
	            		g.drawLine(right_X[i],right_Y[i],right_X[i+1],right_Y[i+1]);
	            	}
	            	else{
	            		g.drawLine(right_X[i],right_Y[i],right_X[i+1],right_Y[i+1]);
	            	}
	            	
	            }
	           
	            for(int i=0;i<left_countX.length-1;i++) {//画左边界
	            	g.drawLine(left_X[i],left_Y[i],left_X[i+1],left_Y[i+1]);
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		 
	 }
	
	 @Override
	 
	 public void paintComponent(Graphics g) {
		super.paintComponent(g); 
	 }
	
	//获取坐标转换参数
	public Double[] getPro(){
		Double[] pro = new Double[7];
		pro[0] = this.proportion; 
		pro[1] = this.L;
		pro[2] = this.B;
		pro[3] = (double) this.proportionH;
		pro[4] = (double) this.proportionW;
		pro[5] = this.minx;
		pro[6] = this.maxy;
		
		return pro;
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 600, 400);
		frame.setVisible(true);
		frame.setTitle("hahah");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		PaintBayLinePanel panel = new PaintBayLinePanel(new MainFrame());
		panel.setSize(300, 200);
		
		frame.setContentPane(panel);
		
		
	}
}
