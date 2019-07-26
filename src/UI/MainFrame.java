package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Service.AnalysisButton_action;
import Service.GeographyButton_action;
import Service.InputConditionButton_action;
import Service.MaxButton_action;
import Service.MinButton_action;
import Util.BackgroundPanel;
import Util.FrameShow;
import Util.ImageButton;

import javax.swing.JButton;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	
	
	/**
	 *
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {	
		this.setBounds(100, 100, 640, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); 
		this.getContentPane().setLayout(null);
		
		this.setLocation(screenWidth/2-this.getWidth()/2,screenHeight/2-this.getHeight()/2);
		float fraWidth = this.getWidth();//frame的宽
		float fraHeight = this.getHeight();//frame的高
		float proportionW = screenWidth/fraWidth;
		float proportionH = screenHeight/fraHeight;	
		
		Image image=new ImageIcon("./image/上边条.png").getImage();
		BackgroundPanel panel = new BackgroundPanel(image);
		panel.setBounds(0, 0, 640, 28);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton minButton = new ImageButton(new ImageIcon("./image/最小化图标.png"));
		minButton.setBounds(560, 0, 10, 28);
		panel.add(minButton);
		FrameShow.max(minButton, proportionW,proportionH);
		minButton.addActionListener(new MinButton_action(this));
		
		
		JButton maxButton = new ImageButton(new ImageIcon("./image/最大化图标.png"));
		maxButton.setBounds(590, 0, 10, 28);
		panel.add(maxButton);
		FrameShow.max(maxButton, proportionW,proportionH);
		maxButton.addActionListener(new MaxButton_action(this));
		
		Image image1=new ImageIcon("./image/左边条.png").getImage();
		BackgroundPanel panel_1 = new BackgroundPanel(image1);
		panel_1.setBounds(0, 28, 67, 335);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton geographyButton = new ImageButton(new ImageIcon("./image/地形生成.png"));
		geographyButton.setBounds(0,0, 67, 33);
		panel_1.add(geographyButton);
		geographyButton.addActionListener(new GeographyButton_action(this));
		FrameShow.max(geographyButton, proportionW,proportionH);
		geographyButton.addMouseListener(new MouseAdapter() {//鼠标监听效果
			public void mouseEntered(MouseEvent e) {
				geographyButton.setIcon(new ImageIcon("./image/地形生成-蓝.png"));
			}
			public void mouseExited(MouseEvent e) {
				geographyButton.setIcon(new ImageIcon("./image/地形生成.png"));
			}
		});
		
		JButton inputConditionButton = new ImageButton(new ImageIcon("./image/输入条件.png"));
		inputConditionButton.setBounds(0,33, 67, 33);
		panel_1.add(inputConditionButton);
		inputConditionButton.addActionListener(new InputConditionButton_action(this));
		FrameShow.max(inputConditionButton, proportionW,proportionH);
		inputConditionButton.addMouseListener(new MouseAdapter() {//鼠标监听效果
			public void mouseEntered(MouseEvent e) {
				inputConditionButton.setIcon(new ImageIcon("./image/条件输入.png"));
			}
			public void mouseExited(MouseEvent e) {
				inputConditionButton.setIcon(new ImageIcon("./image/输入条件.png"));
			}
		});
		
		JButton analysisButton = new ImageButton(new ImageIcon("./image/结果分析.png"));
		analysisButton.setBounds(0, 66, 67, 33);
		panel_1.add(analysisButton);
		analysisButton.addActionListener(new AnalysisButton_action(this));
		FrameShow.max(analysisButton, proportionW,proportionH);
		analysisButton.addMouseListener(new MouseAdapter() {//鼠标监听效果
			public void mouseEntered(MouseEvent e) {
				analysisButton.setIcon(new ImageIcon("./image/结果分析-蓝.png"));
			}
			public void mouseExited(MouseEvent e) {
				analysisButton.setIcon(new ImageIcon("./image/结果分析.png"));
			}
		});
				
	}
	

}
