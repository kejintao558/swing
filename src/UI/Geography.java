package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import Service.StandardButton_action;
import Service.GoogleEarthButton_action;
import Util.BackgroundPanel;
import Util.FrameShow;
import Util.ImageButton;
import Util.PaintBayLinePanel;
import Util.PaintGridPanel;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;

//地形获取窗口
public class Geography extends MainFrame{
	
	private static final long serialVersionUID = 1L;
	
	private MainFrame frame;
	private float proportionW;
	private float proportionH;
	private JPanel paintPanel;
	private JPanel checkPanel;
	private PaintBayLinePanel linePanel ;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//使用beautyEye
		try
	    {
	        UIManager.put("RootPane.setupButtonVisible", false); //隐藏设置按钮   
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Geography window = new Geography();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Geography() {
		initialize();
		
		float fraWidth = frame.getWidth();//frame的宽
		float fraHeight = frame.getHeight();//frame的高
		frame.setSize(screenWidth, screenHeight);
		frame.setLocation(0, 0);
		proportionW = screenWidth/fraWidth;
		proportionH = screenHeight/fraHeight;	
		FrameShow.modifyComponentSize(frame, proportionW,proportionH);
		frame.toFront();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MainFrame();
		frame.setVisible(true);
		
		proportionW = screenWidth/frame.getWidth();
		proportionH = screenHeight/frame.getHeight();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 640, 28);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 28, 67, 320);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel getGeoPanel= new JPanel();
		getGeoPanel.setBounds(76, 47, 178, 105);
		this.getContentPane().add(getGeoPanel);
		TitledBorder tb = BorderFactory.createTitledBorder("地形获取");
		tb.setTitleFont(new Font("宋体", Font.PLAIN, 20));
        tb.setTitleJustification(TitledBorder.LEFT);  
		getGeoPanel.setBorder(tb);
		getGeoPanel.setLayout(null);
		
		JButton standard_button= new ImageButton(new ImageIcon("./image/标准文件图标.png"));
		standard_button.setBounds(50,8,73,13);
		getGeoPanel.add(standard_button);
		standard_button.addActionListener(new StandardButton_action());
		
		JButton google_button = new  ImageButton(new ImageIcon("./image/Google Earth.png"));
		google_button.setFont(new Font("宋体", Font.PLAIN, 12));
		google_button.setBounds(50,28,73,13);
		getGeoPanel.add(google_button);
		google_button.addActionListener(new GoogleEarthButton_action());
		
		
		
		JButton check_button = new  ImageButton(new ImageIcon("./image/地形断面校核.png"));
		check_button.setFont(new Font("宋体", Font.PLAIN, 10));
		check_button.setBounds(50,88,73,13);
		getGeoPanel.add(check_button);
		check_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Image image1=new ImageIcon("./image/2-俯视图.png").getImage();
				BackgroundPanel test = new BackgroundPanel(image1);
				checkPanel.removeAll();
				checkPanel.repaint();
				test.setBounds(2, 8, 175, 130);
				test.setLayout(null);
				checkPanel.add(test);
				FrameShow.modifyJPanelSize(checkPanel, proportionW, proportionH);
			}
		});
		
		checkPanel = new JPanel();
		checkPanel.setBounds(76, 165, 178, 136);
		this.getContentPane().add(checkPanel);
		TitledBorder tb1 = BorderFactory.createTitledBorder("地形校核");
		tb1.setTitleFont(new Font("宋体", Font.PLAIN, 20));
        tb1.setTitleJustification(TitledBorder.LEFT);  
		checkPanel.setBorder(tb1);
		checkPanel.setLayout(null);
		
		paintPanel = new JPanel();
		paintPanel.setBounds(268, 46, 340, 255);
		this.getContentPane().add(paintPanel);
		TitledBorder tb2 = BorderFactory.createTitledBorder("河道网络绘制");
		tb2.setTitleFont(new Font("宋体", Font.PLAIN, 20));
        tb2.setTitleJustification(TitledBorder.LEFT);  
        paintPanel.setBorder(tb2);
		paintPanel.setLayout(null);
		
		JButton show_lineButton = new  ImageButton(new ImageIcon("./image/河岸线展示.png"));
		show_lineButton.setFont(new Font("宋体", Font.PLAIN, 10));
		show_lineButton.setBounds(50, 48, 73, 13);
		getGeoPanel.add(show_lineButton);
		show_lineButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				paintPanel.removeAll();  //清空绘图区域
				paintPanel.repaint();
				linePanel = new PaintBayLinePanel(new MainFrame());
				linePanel.setBorder(BorderFactory.createEtchedBorder());
				paintPanel.add(linePanel);
				FrameShow.modifyJPanelSize(linePanel, proportionW, proportionH);
				FrameShow.modifyJPanelSize(paintPanel, proportionW, proportionH);
				
			}
		});
		
		JButton show_button = new ImageButton(new ImageIcon("./image/网格展示按钮.png"));
		show_button.setBounds(50,68,73,13);
		getGeoPanel.add(show_button);
		show_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				paintPanel.removeAll();
				paintPanel.repaint();
				PaintGridPanel gridPanel = new PaintGridPanel(new MainFrame());
				gridPanel.setBorder(BorderFactory.createEtchedBorder());
				paintPanel.add(gridPanel);
				FrameShow.modifyJPanelSize(paintPanel, proportionW, proportionH);
			}
		});
		
		frame.add(getGeoPanel); 
		frame.add(checkPanel);
		frame.add(paintPanel);

	}
}
