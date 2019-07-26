package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import Service.LoginButton_action;
import Util.BackgroundPanel;
import Util.FrameShow;
import Util.ImageButton;

import java.awt.Image;
import java.awt.Toolkit;

//登录窗口
public class Login extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JTextField urmTextField;
	private JPasswordField passwordField;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	
	private float proportionW ;
	private float proportionH ;	

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
					Login window = new Login();
					window.frame.setVisible(true);
//					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		
		initialize();		
		
		float fraWidth = frame.getWidth();//frame的宽
		float fraHeight = frame.getHeight();//frame高
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
//		this.setBounds(100, 100, 640, 360);
		frame = new JFrame();
		frame.setTitle("城市河流水质模拟平台");
		frame.setResizable(true);
		frame.setBounds(100, 100, 640, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		proportionW = screenWidth/frame.getWidth();
		proportionH = screenHeight/frame.getHeight();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 640, 360);
		panel_1.setLayout(null);
		
		Image image=new ImageIcon("./image/header.png").getImage();
		BackgroundPanel panel = new BackgroundPanel(image);
		panel.setBounds(0, 0, 640, 200);
		panel_1.add(panel);
		panel.setLayout(null);
		
		Image image1=new ImageIcon("./image/background.png").getImage();
		BackgroundPanel panel2 = new BackgroundPanel(image1);
		panel2.setBounds(0, 200, 640, 160);
		panel2.setLayout(null);
		panel_1.add(panel2);
		
		JButton btnNewButton = new ImageButton(new ImageIcon("./image/用户图标.png"));
		btnNewButton.setBounds(240, 37, 9, 9);
		panel2.add(btnNewButton);
		
		JButton btnNewButton_1 = new ImageButton(new ImageIcon("./image/密码图标.png"));
		btnNewButton_1.setBounds(240, 64, 9, 9);
		panel2.add(btnNewButton_1);
		
		JLabel userLabel = new JLabel("用户");
		userLabel.setBounds(254, 35, 25, 12);
		userLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		userLabel.setForeground(Color.white);
		panel2.add(userLabel);
		
		JLabel psdLabel = new JLabel("密码");
		psdLabel.setBounds(254, 62, 25, 12);
		psdLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		psdLabel.setForeground(Color.white);
		panel2.add(psdLabel);
		
		urmTextField = new JTextField();
		urmTextField.setBounds(285, 34, 90, 15);
		urmTextField.setFont(new Font("宋体", Font.PLAIN, 12));
		panel2.add(urmTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 61, 90, 15);
		passwordField.setFont(new Font("宋体", Font.PLAIN, 12));
		panel2.add(passwordField);
		
		JButton loginButton = new ImageButton(new ImageIcon("./image/登录.png"));
		loginButton.setBounds(260, 90, 95, 15);
		panel2.add(loginButton);
		loginButton.addActionListener(new LoginButton_action(frame,urmTextField,passwordField));
		
		frame.getContentPane().add(panel_1);
		FrameShow.modifyJPanelSize(panel2, proportionW, proportionH);
		
		
	}
}
