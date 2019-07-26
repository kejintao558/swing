package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Service.Analysis_Mouse;
import Service.comboBox_action;
import Service.countButton_action;
import Service.findButton_action;
import Util.FileHanding;
import Util.FrameShow;
import Util.ImageButton;
import Util.PieCharts;
import Util.barGraph;
//import Util.PaintGridPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

//结果分析窗口
public class Analysis extends MainFrame {

	private static final long serialVersionUID = 1L;
	
	private MainFrame frame;
	float proportionW;
	float proportionH;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	private JTextField coordinates_textField;
	private JTable table;
	private DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	private DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
	private DefaultComboBoxModel sourceModel;
	private String source[]=new String[]{"COD","TN","TP"};
	
	private File file1 = new File("D:/Datain/CP.DAT");
	
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
					Analysis window = new Analysis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Analysis() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 640, 28);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 28, 67, 320);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);		
		
		JPanel partPanel = new JPanel();
		partPanel.setBounds(84, 45, 160, 269);
		TitledBorder tb = BorderFactory.createTitledBorder("环境容量分析");
		tb.setTitleFont(new Font("宋体", Font.PLAIN, 20));
        tb.setTitleJustification(TitledBorder.LEFT);  
        partPanel.setBorder(tb);
		getContentPane().add(partPanel);
		partPanel.setLayout(null);
		
		JLabel label = new JLabel("功能区坐标");
		label.setFont(new Font("宋体", Font.PLAIN, 7));
		label.setBounds(5, 15, 50, 13);
		partPanel.add(label);
		
		coordinates_textField = new JTextField();
		coordinates_textField.setEditable(false);
		coordinates_textField.setFont(new Font("宋体", Font.PLAIN, 6));
		coordinates_textField.setColumns(10);
		coordinates_textField.setBounds(67, 15, 47, 13);
		partPanel.add(coordinates_textField);
	
		JButton find_button = new JButton("···");
		find_button.setBounds(125, 15, 24, 13);
		find_button.setFont(new Font("宋体", Font.PLAIN, 8));
		partPanel.add(find_button);
		
		JButton count_button = new  ImageButton(new ImageIcon("./image/计算环境容量.png"));
		count_button.setFont(new Font("宋体", Font.PLAIN, 10));
		count_button.setBounds(39, 35, 73, 13);
		partPanel.add(count_button);
		
		
		JLabel result_label = new JLabel("环境容量计算结果:");
		result_label.setFont(new Font("宋体", Font.PLAIN, 7));
		result_label.setBounds(32, 52, 80, 13);
		partPanel.add(result_label);
		
		Object[] columns={"功能区","COD","TN","TP"};
		Object[][] data={ { "1", "" ,""},{ "2", "" ,""},{ "3", "" ,""},{ "4", "" ,""},{ "5", "" ,""},{ "6", "" ,""},{ "7", "" ,""}};
		DefaultTableModel model=new DefaultTableModel(data, columns);
		table = new JTable(model);
		
		table.setFont(new Font("宋体", Font.PLAIN, 9));
		table.setShowGrid(true);
		table.setBackground(Color.WHITE);
		table.getTableHeader().setReorderingAllowed(false); //设置为禁止拖动
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(11, 70, 138, 70);
		partPanel.add(scrollPane);
		
		JPanel paintPanel = new JPanel();
		paintPanel.setBounds(265, 45, 348, 269);
		TitledBorder tb2 = BorderFactory.createTitledBorder("水质指标计算结果查看");
		tb2.setTitleFont(new Font("宋体", Font.PLAIN, 20));
        tb2.setTitleJustification(TitledBorder.LEFT);  
        paintPanel.setBorder(tb2);
		getContentPane().add(paintPanel);
		paintPanel.setLayout(null);
		paintPanel.addMouseListener(new Analysis_Mouse(new MainFrame()));
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 7));
		comboBox.setBounds(270, 180, 35, 12);
		sourceModel=new DefaultComboBoxModel(source);
		comboBox.setModel(sourceModel);
		paintPanel.add(comboBox);
		
		JPanel barGraphPanel = barGraph.createPanel(dataset);
		barGraphPanel.setBounds(11, 140, 138, 125);
		partPanel.add(barGraphPanel);
		
		JPanel pigChartPanel = PieCharts.createDemoPanel(defaultpiedataset);
		defaultpiedataset.setValue("一类水", 20);
		defaultpiedataset.setValue("二类水", 20);
		defaultpiedataset.setValue("三类水", 20);
		defaultpiedataset.setValue("四类水", 20);
		defaultpiedataset.setValue("五类水", 20);
		pigChartPanel.setBounds(260, 200, 50, 40);
		paintPanel.add(pigChartPanel);
		
		find_button.addActionListener(new findButton_action(file1,coordinates_textField,"xls"));  //导入功能区坐标
		count_button.addActionListener(new countButton_action(table,coordinates_textField,dataset));
		comboBox.addItemListener(new comboBox_action(comboBox));

		JButton button = new JButton("查看");
		button.setBounds(10, 15, 35, 10);
		button.setFont(new Font("宋体", Font.PLAIN, 10));
		paintPanel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Process p;    
			     String cmd="C:\\Users\\12149\\Desktop\\Tecplot10.0.6\\Bin\\tecplot.exe"; 
//			     String cmd="E:\\Tool\\wuDa\\GetGECoords.bkill.com\\GoogleEarth高程数据采集工具2014\\GetGECoords.exe";
			            //执行命令    
			      try {
			    	  p = Runtime.getRuntime().exec(cmd);
			    	  } catch (IOException e1) {
			    	  // TODO Auto-generated catch block 
			    		  e1.printStackTrace();
			    		  }
				
			}
		});
		
		frame.add(partPanel);
		frame.add(paintPanel);

	}
}
