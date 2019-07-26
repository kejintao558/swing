package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import Service.DeleteButton_action;
import Service.FileChooserButton_action;
import Service.FileCopyButton_action;
import Service.InsertButton_action;
import Service.ResetButtonListener;
import Service.SaveButton_action1;
import Service.SaveButton_action_2;
import Service.UpdateButton_action;
import Service.analogButton_action;
import Service.exportButton_action;
import Service.simulationVerificationButton_action;
import Service.subsectionCheckBox_1_action;
import Service.textEditable_action;
import Service.viewDetailsButton_action;
import Util.BackgroundPanel;
import Util.FileHanding;
import Util.FrameShow;

import java.awt.Font;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.*;

public class InputCondition<ActionPanelEditorRenderer> extends MainFrame {
	private MainFrame frame;
	private JTextField upperBoundaryTextField;
	private JTextField lowerBoundaryWaterLevelTextField;
	private JTextField CODTextField;
	private JTextField BODTextField;
	private JTextField TNTextField;
	private JTextField TPTextField;
	private JTextField NH3NTextField;
	private JTextField NO3NTextField;
	private JTextField DOTextField;
	private JTextField computationTextField;
	private JTextField simulationTimeTextField;
	private JTable table;
	private JTextField sewageOutletNumberTextField;
	private JTextField X_TextField;
	private JTextField Y_TextField;
	private JTextField dischargeFlowTextField;
	private JTextField nonPointSourceDataTextField_1;
	private JTextField riverTextField_1;
	private JTextField riverTextField_2;
	private JTextField riverTextField_3;
	private JTextField riverTextField_4;
	private JTextField riverTextField_5;
	private JTextField DegradationCoefficientTextField_1;
	private JTextField DegradationCoefficientTextField_2;
	private JTextField DegradationCoefficientTextField_3;
	private JTextField DegradationCoefficientTextField_4;
	private JTextField DegradationCoefficientTextField_5;
	private JTextField SedimentCoefficientTextField_1;
	private JTextField SedimentCoefficientTextField_2;
	private JTextField SedimentCoefficientTextField_3;
	private JTextField SedimentCoefficientTextField_4;
	private JTextField SedimentCoefficientTextField_5;
	private JTextField measuredDataTextField;
	private File file1 = new File(FileHanding.getPath()+"/DATIN_ORG/outflow.txt");               //面源过程文件 
	
	private JButton updateButton = new JButton("修改");	
	private JButton deleteeditButton = new JButton("删除");
	private JPanel panel2 = new JPanel();
	private DefaultTableModel model = null;
	
	float proportionW;
	float proportionH;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	private JTextField controlObjectiveTextField_1;
	private JTextField controlObjectiveTextField_2;
	private JTextField controlObjectiveTextField_3;
	private JTextField controlObjectiveTextField_4;
	private JTextField controlObjectiveTextField_5;
	private JTextField yearTextField_1;
	private JTextField monthTextField_1;
	private JTextField dayTextField_1;
	private JTextField yearTextField_2;
	private JTextField monthTextField_2;
	private JTextField dayTextField_2;
	private JTextField COD_TextField;
	private JTextField BOD_TextField;
	private JTextField TN_TextField;
	private JTextField TP_TextField;
	private JTextField NH3_N_TextField;
	private JTextField NO3_N_TextField;
	private JTextField DO_TextField;
	private JTextField nonPointSourceDataTextField_2;
	private JTextField roughnessCoefficientTextField_1;
	private JTextField roughnessCoefficientTextField_2;
	private JTextField roughnessCoefficientTextField_3;
	private JTextField roughnessCoefficientTextField_4;
	private JTextField roughnessCoefficientTextField_5;
	

	public static void main(String[] args) {
		try
	    {
	        UIManager.put("RootPane.setupButtonVisible", false);    
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    	e.printStackTrace();
	    }
		
		EventQueue.invokeLater(new Runnable() {			
			public void run() {
				try {
					InputCondition window = new InputCondition();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public InputCondition(){
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
	private void initialize() {
		Set<String> set = new HashSet<String>();
		set.clear();
		frame = new MainFrame();
		frame.setVisible(true);	
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 0, 60, 28);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 67, 320);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel riverConditionPanel = new JPanel();
		riverConditionPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "河流条件", TitledBorder.LEFT, TitledBorder.TOP, null));
		riverConditionPanel.setBounds(76, 34, 176, 282);
		riverConditionPanel.setLayout(null);
		TitledBorder tb = BorderFactory.createTitledBorder("���河流条件");  
        tb.setTitleJustification(TitledBorder.LEFT);
		getContentPane().add(riverConditionPanel);
		
		JLabel upperBoundaryLabel = new JLabel("上边界流量(m³/s)");
		upperBoundaryLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		upperBoundaryLabel.setBounds(12, 15, 54, 10);
		riverConditionPanel.add(upperBoundaryLabel);
		
		JLabel lowerBoundaryWaterLevelLabel = new JLabel("下边界水位");
		lowerBoundaryWaterLevelLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		lowerBoundaryWaterLevelLabel.setBounds(12, 33, 54, 10);
		riverConditionPanel.add(lowerBoundaryWaterLevelLabel);
		
		upperBoundaryTextField = new JTextField();
		upperBoundaryTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		upperBoundaryTextField.setBounds(100, 15, 66, 12);
		riverConditionPanel.add(upperBoundaryTextField);
		upperBoundaryTextField.setColumns(10);
		
		lowerBoundaryWaterLevelTextField = new JTextField();
		lowerBoundaryWaterLevelTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		lowerBoundaryWaterLevelTextField.setBounds(100, 33, 66, 12);
		riverConditionPanel.add(lowerBoundaryWaterLevelTextField);
		lowerBoundaryWaterLevelTextField.setColumns(10);
		
		JCheckBox CODCheckBox = new JCheckBox(" COD       浓度(mg/L)");
		CODCheckBox.setFont(new Font("宋体", Font.PLAIN, 6));
		CODCheckBox.setBounds(12, 51, 90, 10);
		riverConditionPanel.add(CODCheckBox);
		
		CODTextField = new JTextField();
		CODTextField.setEditable(false);
		CODTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		CODTextField.setBounds(121, 51, 45, 12);
		riverConditionPanel.add(CODTextField);
		CODTextField.setColumns(10);
		
		JCheckBox BODCheckBox = new JCheckBox(" BOD       浓度(mg/L)");
		BODCheckBox.setFont(new Font("宋体", Font.PLAIN, 6));
		BODCheckBox.setBounds(12, 69, 90, 10);
		riverConditionPanel.add(BODCheckBox);
		
		JCheckBox TNCheckBox = new JCheckBox(" TN        浓度(mg/L)");
		TNCheckBox.setFont(new Font("宋体", Font.PLAIN, 6));
		TNCheckBox.setBounds(12, 87, 98, 10);
		riverConditionPanel.add(TNCheckBox);
		
		JCheckBox TPCheckBox = new JCheckBox(" TP        浓度(mg/L)");
		TPCheckBox.setFont(new Font("宋体", Font.PLAIN, 6));
		TPCheckBox.setBounds(12, 105, 98, 10);
		riverConditionPanel.add(TPCheckBox);
		
		JCheckBox NH3NCheckBox = new JCheckBox("NHS-N      浓度(mg/L)");
		NH3NCheckBox.setFont(new Font("宋体", Font.PLAIN, 6));
		NH3NCheckBox.setBounds(12, 123, 98, 10);
		riverConditionPanel.add(NH3NCheckBox);
		
		JCheckBox NO3NCheckBox = new JCheckBox("NOS-N      浓度(mg/L)");
		NO3NCheckBox.setFont(new Font("宋体", Font.PLAIN, 6));
		NO3NCheckBox.setBounds(12, 141, 98, 10);
		riverConditionPanel.add(NO3NCheckBox);
		
		JCheckBox DOCheckBox = new JCheckBox("DO         浓度(mg/L)");
		DOCheckBox.setFont(new Font("宋体", Font.PLAIN, 6));
		DOCheckBox.setBounds(12, 159, 98, 10);
		riverConditionPanel.add(DOCheckBox);
		
		BODTextField = new JTextField();
		BODTextField.setEditable(false);
		BODTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		BODTextField.setColumns(10);
		BODTextField.setBounds(121, 69, 45, 12);
		riverConditionPanel.add(BODTextField);
		
		TNTextField = new JTextField();
		TNTextField.setEditable(false);
		TNTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		TNTextField.setColumns(10);
		TNTextField.setBounds(121, 87, 45, 12);
		riverConditionPanel.add(TNTextField);
		
		TPTextField = new JTextField();
		TPTextField.setEditable(false);
		TPTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		TPTextField.setColumns(10);
		TPTextField.setBounds(121, 105, 45, 12);
		riverConditionPanel.add(TPTextField);
		
		NH3NTextField = new JTextField();
		NH3NTextField.setEditable(false);
		NH3NTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		NH3NTextField.setColumns(10);
		NH3NTextField.setBounds(121, 123, 45, 12);
		riverConditionPanel.add(NH3NTextField);
		
		NO3NTextField = new JTextField();
		NO3NTextField.setEditable(false);
		NO3NTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		NO3NTextField.setColumns(10);
		NO3NTextField.setBounds(121, 141, 45, 12);
		riverConditionPanel.add(NO3NTextField);
		
		DOTextField = new JTextField();
		DOTextField.setEditable(false);
		DOTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		DOTextField.setColumns(10);
		DOTextField.setBounds(121, 159, 45, 12);
		riverConditionPanel.add(DOTextField);
		
		JLabel icomputationTimeLabel = new JLabel("计算时间步长");
		icomputationTimeLabel.setFont(new Font("宋体", Font.PLAIN, 7));
		icomputationTimeLabel.setBounds(12, 177, 54, 10);
		riverConditionPanel.add(icomputationTimeLabel);
		
		JLabel simulationTimeLabel = new JLabel("模拟时长(天)");
		simulationTimeLabel.setFont(new Font("宋体", Font.PLAIN, 7));
		simulationTimeLabel.setBounds(12, 195, 54, 10);
		riverConditionPanel.add(simulationTimeLabel);
		
		computationTextField = new JTextField();
		computationTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		computationTextField.setColumns(10);
		computationTextField.setBounds(100, 177, 66, 12);
		riverConditionPanel.add(computationTextField);
		
		simulationTimeTextField = new JTextField();
		simulationTimeTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		simulationTimeTextField.setColumns(10);
		simulationTimeTextField.setBounds(100, 195, 66, 12);
		riverConditionPanel.add(simulationTimeTextField);
		
		JButton resetButton_1 = new JButton("重置");
		resetButton_1.addActionListener(new ResetButtonListener(riverConditionPanel));
		resetButton_1.setBackground(Color.BLUE);
		resetButton_1.setFont(new Font("宋体", Font.PLAIN, 6));
		resetButton_1.setBounds(27, 255, 45, 15);
		riverConditionPanel.add(resetButton_1);
		
		JButton saveButton_1 = new JButton("保存");
//		saveButton_1.addActionListener(new SaveButton_action1(pollutantComboBox));
		saveButton_1.setBackground(Color.BLUE);
		saveButton_1.setFont(new Font("宋体", Font.PLAIN, 6));
		saveButton_1.setBounds(100, 255, 50, 15);
		riverConditionPanel.add(saveButton_1);
		
		JPanel sourceOfPullutionPanel = new JPanel();
		sourceOfPullutionPanel.setLayout(null);
		sourceOfPullutionPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "污染源", TitledBorder.LEFT, TitledBorder.TOP, null) );
		sourceOfPullutionPanel.setBounds(260, 34, 124, 185);
		getContentPane().add(sourceOfPullutionPanel);
		
		JLabel sewageOutletNumberLabel = new JLabel("排污口编号");
		sewageOutletNumberLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		sewageOutletNumberLabel.setLocation(8, 15);
		sewageOutletNumberLabel.setSize(30, 12);
		sourceOfPullutionPanel.add(sewageOutletNumberLabel);
		
		sewageOutletNumberTextField = new JTextField();
		sewageOutletNumberTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		sewageOutletNumberTextField.setBounds(40, 15, 20, 12);
		sourceOfPullutionPanel.add(sewageOutletNumberTextField);
		sewageOutletNumberTextField.setColumns(10);
		
		JLabel XLabel = new JLabel("X");
		XLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		XLabel.setBounds(69, 15, 20, 12);
		sourceOfPullutionPanel.add(XLabel);
		
		JLabel YLabel = new JLabel("Y");
		YLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		YLabel.setBounds(69, 33, 10, 12);
		sourceOfPullutionPanel.add(YLabel);
		
		JLabel dischargeFlowLabel = new JLabel("排放流量");
		dischargeFlowLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		dischargeFlowLabel.setBounds(8, 33, 30, 12);
		sourceOfPullutionPanel.add(dischargeFlowLabel);
		
		JLabel nonPointSourceDataLabel_1 = new JLabel("\u9762\u6E90\u8FC7\u7A0B\u6587\u4EF6");
		nonPointSourceDataLabel_1.setFont(new Font("宋体", Font.PLAIN, 6));
		nonPointSourceDataLabel_1.setBounds(8, 123, 40, 12);
		sourceOfPullutionPanel.add(nonPointSourceDataLabel_1);
		
		X_TextField = new JTextField();
		X_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		X_TextField.setColumns(10);
		X_TextField.setBounds(80, 15, 38, 12);
		sourceOfPullutionPanel.add(X_TextField);
		
		Y_TextField = new JTextField();
		Y_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		Y_TextField.setColumns(10);
		Y_TextField.setBounds(80, 33, 38, 12);
		sourceOfPullutionPanel.add(Y_TextField);
		
		dischargeFlowTextField = new JTextField();
		dischargeFlowTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		dischargeFlowTextField.setColumns(10);
		dischargeFlowTextField.setBounds(40, 33, 20, 12);
		sourceOfPullutionPanel.add(dischargeFlowTextField);
		
		nonPointSourceDataTextField_1 = new JTextField();
		nonPointSourceDataTextField_1.setEditable(false);
		nonPointSourceDataTextField_1.setFont(new Font("宋体", Font.PLAIN, 6));
		nonPointSourceDataTextField_1.setColumns(10);
		nonPointSourceDataTextField_1.setBounds(50, 123, 42, 12);
		sourceOfPullutionPanel.add(nonPointSourceDataTextField_1);
		DefaultComboBoxModel sourceModel = new DefaultComboBoxModel();
		
		JButton fileButton_1 = new JButton("...");
		fileButton_1.setFont(new Font("宋体", Font.PLAIN, 6));
		fileButton_1.setBounds(95, 123, 20, 12);
		sourceOfPullutionPanel.add(fileButton_1);
		
		JButton resetButton_2 = new JButton("重置");
		resetButton_2.addActionListener(new ResetButtonListener(sourceOfPullutionPanel));
		resetButton_2.setBackground(Color.BLUE);
		resetButton_2.setFont(new Font("宋体", Font.PLAIN, 6));
		resetButton_2.setBounds(10, 162, 30, 15);
		sourceOfPullutionPanel.add(resetButton_2);
		
		JButton insertButton = new JButton("添加");
		insertButton.setBackground(Color.BLUE);
		insertButton.setFont(new Font("宋体", Font.PLAIN, 6));
		insertButton.setBounds(45, 162, 30, 15);
		sourceOfPullutionPanel.add(insertButton);
		
		JButton saveButton_2 = new JButton("保存");
		saveButton_2.setBackground(Color.BLUE);
		saveButton_2.setFont(new Font("宋体", Font.PLAIN, 6));
		saveButton_2.setBounds(80, 162, 30, 15);
		sourceOfPullutionPanel.add(saveButton_2);
		
		JPanel modelValidationPanel = new JPanel();
		modelValidationPanel.setLayout(null);
		modelValidationPanel.setBorder(new TitledBorder(null, "模型验证", TitledBorder.LEFT, TitledBorder.TOP, null));
		modelValidationPanel.setBounds(393, 34, 238, 204);
		getContentPane().add(modelValidationPanel);
		
		JButton simulationVerificationButton = new JButton("模拟验证");
		simulationVerificationButton.setBackground(Color.BLUE);
		simulationVerificationButton.setForeground(Color.BLACK);
		simulationVerificationButton.setFont(new Font("宋体", Font.PLAIN, 7));
		simulationVerificationButton.setBounds(20, 183, 40, 15);
		modelValidationPanel.add(simulationVerificationButton);
		
		JButton analogButton = new JButton("模拟计算");
		analogButton.setBackground(Color.BLUE);
		analogButton.setForeground(Color.BLACK);
		analogButton.setFont(new Font("宋体", Font.PLAIN, 7));
		analogButton.setBounds(91, 183, 40, 15);
		modelValidationPanel.add(analogButton);
		
		JButton viewDetailsButton = new JButton("查看详情");
		viewDetailsButton.setBackground(Color.BLUE);
		viewDetailsButton.setForeground(Color.BLACK);
		viewDetailsButton.setFont(new Font("宋体", Font.PLAIN, 7));
		viewDetailsButton.setBounds(163, 183, 40, 15);
		modelValidationPanel.add(viewDetailsButton);
		
		JLabel riverLabel = new JLabel("河流糙率");
		riverLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		riverLabel.setBounds(10, 24, 30, 12);
		modelValidationPanel.add(riverLabel);
		
		riverTextField_1 = new JTextField();
		riverTextField_1.setBounds(45, 24, 32, 12);
		modelValidationPanel.add(riverTextField_1);
		riverTextField_1.setColumns(10);
		
		riverTextField_2 = new JTextField();
		riverTextField_2.setEditable(false);
		riverTextField_2.setColumns(10);
		riverTextField_2.setBounds(82, 24, 32, 12);
		modelValidationPanel.add(riverTextField_2);
		
		riverTextField_3 = new JTextField();
		riverTextField_3.setEditable(false);
		riverTextField_3.setColumns(10);
		riverTextField_3.setBounds(119, 24, 32, 12);
		modelValidationPanel.add(riverTextField_3);
		
		riverTextField_4 = new JTextField();
		riverTextField_4.setEditable(false);
		riverTextField_4.setColumns(10);
		riverTextField_4.setBounds(156, 24, 32, 12);
		modelValidationPanel.add(riverTextField_4);
		
		riverTextField_5 = new JTextField();
		riverTextField_5.setEditable(false);
		riverTextField_5.setColumns(10);
		riverTextField_5.setBounds(193, 24, 32, 12);
		modelValidationPanel.add(riverTextField_5);
		
		DegradationCoefficientTextField_1 = new JTextField();
		DegradationCoefficientTextField_1.setColumns(10);
		DegradationCoefficientTextField_1.setBounds(45, 83, 32, 12);
		modelValidationPanel.add(DegradationCoefficientTextField_1);
		
		JLabel DegradationCoefficientLabel = new JLabel("降解系数");
		DegradationCoefficientLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		DegradationCoefficientLabel.setBounds(10, 83, 30, 12);
		modelValidationPanel.add(DegradationCoefficientLabel);
		
		JLabel SedimentCoefficientLabel = new JLabel("底泥系数");
		SedimentCoefficientLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		SedimentCoefficientLabel.setBounds(10, 105, 30, 12);
		modelValidationPanel.add(SedimentCoefficientLabel);
		
		JLabel measuredDataLabel = new JLabel("实测数据");
		measuredDataLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		measuredDataLabel.setBounds(10, 148, 30, 12);
		modelValidationPanel.add(measuredDataLabel);
		
		JLabel simulationPreLacisionbel = new JLabel("模拟精度");
		simulationPreLacisionbel.setFont(new Font("宋体", Font.PLAIN, 6));
		simulationPreLacisionbel.setBounds(10, 165, 30, 12);
		modelValidationPanel.add(simulationPreLacisionbel);

		
		DegradationCoefficientTextField_2 = new JTextField();
		DegradationCoefficientTextField_2.setEditable(false);
		DegradationCoefficientTextField_2.setColumns(10);
		DegradationCoefficientTextField_2.setBounds(82, 83, 32, 12);
		modelValidationPanel.add(DegradationCoefficientTextField_2);
		
		DegradationCoefficientTextField_3 = new JTextField();
		DegradationCoefficientTextField_3.setEditable(false);
		DegradationCoefficientTextField_3.setColumns(10);
		DegradationCoefficientTextField_3.setBounds(119, 83, 32, 12);
		modelValidationPanel.add(DegradationCoefficientTextField_3);
		
		DegradationCoefficientTextField_4 = new JTextField();
		DegradationCoefficientTextField_4.setEditable(false);
		DegradationCoefficientTextField_4.setColumns(10);
		DegradationCoefficientTextField_4.setBounds(156, 83, 32, 12);
		modelValidationPanel.add(DegradationCoefficientTextField_4);
		
		DegradationCoefficientTextField_5 = new JTextField();
		DegradationCoefficientTextField_5.setEditable(false);
		DegradationCoefficientTextField_5.setColumns(10);
		DegradationCoefficientTextField_5.setBounds(193, 83, 32, 12);
		modelValidationPanel.add(DegradationCoefficientTextField_5);
		
		SedimentCoefficientTextField_1 = new JTextField();
		SedimentCoefficientTextField_1.setColumns(10);
		SedimentCoefficientTextField_1.setBounds(45, 105, 32, 12);
		modelValidationPanel.add(SedimentCoefficientTextField_1);
		
		SedimentCoefficientTextField_2 = new JTextField();
		SedimentCoefficientTextField_2.setEditable(false);
		SedimentCoefficientTextField_2.setColumns(10);
		SedimentCoefficientTextField_2.setBounds(82, 105, 32, 12);
		modelValidationPanel.add(SedimentCoefficientTextField_2);
		
		SedimentCoefficientTextField_3 = new JTextField();
		SedimentCoefficientTextField_3.setEditable(false);
		SedimentCoefficientTextField_3.setColumns(10);
		SedimentCoefficientTextField_3.setBounds(119, 105, 32, 12);
		modelValidationPanel.add(SedimentCoefficientTextField_3);
		
		SedimentCoefficientTextField_4 = new JTextField();
		SedimentCoefficientTextField_4.setEditable(false);
		SedimentCoefficientTextField_4.setColumns(10);
		SedimentCoefficientTextField_4.setBounds(156, 105, 32, 12);
		modelValidationPanel.add(SedimentCoefficientTextField_4);
		
		SedimentCoefficientTextField_5 = new JTextField();
		SedimentCoefficientTextField_5.setEditable(false);
		SedimentCoefficientTextField_5.setColumns(10);
		SedimentCoefficientTextField_5.setBounds(193, 105, 32, 12);
		modelValidationPanel.add(SedimentCoefficientTextField_5);
		
		measuredDataTextField = new JTextField();
		measuredDataTextField.setEditable(false);
		measuredDataTextField.setFont(new Font("宋体", Font.PLAIN, 6));
		measuredDataTextField.setColumns(10);
		measuredDataTextField.setBounds(45, 148, 40, 12);
		modelValidationPanel.add(measuredDataTextField);
		
		JButton fileButton_2 = new JButton("...");
		fileButton_2.setFont(new Font("宋体", Font.PLAIN, 6));
		fileButton_2.setBounds(90, 148, 20, 12);
		modelValidationPanel.add(fileButton_2);
		
//		JComboBox roughnessFactorcomboBox = new JComboBox();
//		roughnessFactorcomboBox.setFont(new Font("宋体", Font.PLAIN, 6));
//		roughnessFactorcomboBox.setBounds(55, 17, 40, 12);
//		modelValidationPanel.add(roughnessFactorcomboBox);
		
		JComboBox degradationCoefficientComboBox = new JComboBox();
		degradationCoefficientComboBox.setFont(new Font("宋体", Font.PLAIN, 6));
		degradationCoefficientComboBox.setBounds(82, 65, 40, 12);
		modelValidationPanel.add(degradationCoefficientComboBox);
		
		JComboBox simulationPreLacisionComboBox = new JComboBox();
		DefaultComboBoxModel<?> precision_model = new DefaultComboBoxModel(new String[]{"10%","20%","30%"});//模拟精度
		(simulationPreLacisionComboBox).setModel((ComboBoxModel) precision_model);
		simulationPreLacisionComboBox.setFont(new Font("宋体", Font.PLAIN, 6));
		simulationPreLacisionComboBox.setBounds(45, 165, 40, 12);
		modelValidationPanel.add(simulationPreLacisionComboBox);
		
		JLabel verificationResultLabel = new JLabel("验证结果:");
		verificationResultLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		verificationResultLabel.setBounds(95, 165, 32, 12);
		modelValidationPanel.add(verificationResultLabel);
		
		JCheckBox subsectionCheckBox_1 = new JCheckBox("分段");
		subsectionCheckBox_1.setFont(new Font("宋体", Font.PLAIN, 6));
		subsectionCheckBox_1.setBounds(6, 10, 39, 12);
		modelValidationPanel.add(subsectionCheckBox_1);
		
		JCheckBox subsectionCheckBox_3 = new JCheckBox("分段");
		subsectionCheckBox_3.setFont(new Font("宋体", Font.PLAIN, 6));
		subsectionCheckBox_3.setBounds(6, 65, 39, 12);
		modelValidationPanel.add(subsectionCheckBox_3);
		
		JLabel controlObjectiveLabel = new JLabel("\u5E95\u6CE5\u6D53\u5EA6");
		controlObjectiveLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		controlObjectiveLabel.setBounds(10, 128, 30, 12);
		modelValidationPanel.add(controlObjectiveLabel);
		
		controlObjectiveTextField_1 = new JTextField();
		controlObjectiveTextField_1.setColumns(10);
		controlObjectiveTextField_1.setBounds(45, 128, 32, 12);
		modelValidationPanel.add(controlObjectiveTextField_1);
		
		controlObjectiveTextField_2 = new JTextField();
		controlObjectiveTextField_2.setEditable(false);
		controlObjectiveTextField_2.setColumns(10);
		controlObjectiveTextField_2.setBounds(82, 128, 32, 12);
		modelValidationPanel.add(controlObjectiveTextField_2);
		
		controlObjectiveTextField_3 = new JTextField();
		controlObjectiveTextField_3.setEditable(false);
		controlObjectiveTextField_3.setColumns(10);
		controlObjectiveTextField_3.setBounds(119, 128, 32, 12);
		modelValidationPanel.add(controlObjectiveTextField_3);
		
		controlObjectiveTextField_4 = new JTextField();
		controlObjectiveTextField_4.setEditable(false);
		controlObjectiveTextField_4.setColumns(10);
		controlObjectiveTextField_4.setBounds(156, 128, 32, 12);
		modelValidationPanel.add(controlObjectiveTextField_4);
		
		controlObjectiveTextField_5 = new JTextField();
		controlObjectiveTextField_5.setEditable(false);
		controlObjectiveTextField_5.setColumns(10);
		controlObjectiveTextField_5.setBounds(193, 128, 32, 12);
		modelValidationPanel.add(controlObjectiveTextField_5);
		
		JLabel startTimeLabel = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		startTimeLabel.setFont(new Font("宋体", Font.PLAIN, 7));
		startTimeLabel.setBounds(12, 213, 32, 10);
		riverConditionPanel.add(startTimeLabel);
		
		JLabel yearLabel_1 = new JLabel("\u5E74");
		yearLabel_1.setFont(new Font("宋体", Font.PLAIN, 7));
		yearLabel_1.setBounds(77, 213, 15, 10);
		riverConditionPanel.add(yearLabel_1);
		
		yearTextField_1 = new JTextField();
		yearTextField_1.setBounds(45, 213, 30, 12);
		riverConditionPanel.add(yearTextField_1);
		yearTextField_1.setColumns(10);
		
		JLabel monthLabel_1 = new JLabel("\u6708");
		monthLabel_1.setFont(new Font("宋体", Font.PLAIN, 7));
		monthLabel_1.setBounds(119, 213, 15, 10);
		riverConditionPanel.add(monthLabel_1);
		
		monthTextField_1 = new JTextField();
		monthTextField_1.setColumns(10);
		monthTextField_1.setBounds(87, 213, 30, 12);
		riverConditionPanel.add(monthTextField_1);
		
		JLabel dayLabel_1 = new JLabel("\u65E5");
		dayLabel_1.setFont(new Font("宋体", Font.PLAIN, 7));
		dayLabel_1.setBounds(161, 213, 15, 10);
		riverConditionPanel.add(dayLabel_1);
		
		dayTextField_1 = new JTextField();
		dayTextField_1.setColumns(10);
		dayTextField_1.setBounds(129, 213, 30, 12);
		riverConditionPanel.add(dayTextField_1);
		
		JLabel stopTimeLabel = new JLabel("\u7ED3\u675F\u65F6\u95F4");
		stopTimeLabel.setFont(new Font("宋体", Font.PLAIN, 7));
		stopTimeLabel.setBounds(12, 231, 32, 10);
		riverConditionPanel.add(stopTimeLabel);
		
		JLabel yearLabel_2 = new JLabel("\u5E74");
		yearLabel_2.setFont(new Font("宋体", Font.PLAIN, 7));
		yearLabel_2.setBounds(77, 231, 15, 10);
		riverConditionPanel.add(yearLabel_2);
		
		yearTextField_2 = new JTextField();
		yearTextField_2.setColumns(10);
		yearTextField_2.setBounds(45, 231, 30, 12);
		riverConditionPanel.add(yearTextField_2);
		
		JLabel monthLabel_2 = new JLabel("\u6708");
		monthLabel_2.setFont(new Font("宋体", Font.PLAIN, 7));
		monthLabel_2.setBounds(119, 231, 15, 10);
		riverConditionPanel.add(monthLabel_2);
		
		monthTextField_2 = new JTextField();
		monthTextField_2.setColumns(10);
		monthTextField_2.setBounds(87, 231, 30, 12);
		riverConditionPanel.add(monthTextField_2);
		
		JLabel dayLabel_2 = new JLabel("\u65E5");
		dayLabel_2.setFont(new Font("宋体", Font.PLAIN, 7));
		dayLabel_2.setBounds(161, 231, 15, 10);
		riverConditionPanel.add(dayLabel_2);
		
		dayTextField_2 = new JTextField();
		dayTextField_2.setColumns(10);
		dayTextField_2.setBounds(129, 231, 30, 12);
		riverConditionPanel.add(dayTextField_2);
		
		
		JButton exportButton = new JButton("导出");
		exportButton.setBackground(Color.BLUE);
		exportButton.setFont(new Font("宋体", Font.PLAIN, 6));
		exportButton.setBounds(260, 223, 40, 15);
		getContentPane().add(exportButton);
		table = new JTable();
		model = new DefaultTableModel(
				new Object[][] {{"","","","","","","","","","",""}},
				new String[] {
					"编号", "X 坐标", "Y 坐标", "排放流量", "COD", "BOD", "TN","TP","NH3-N","NO3-N","DO","操作"
				}
			){
			boolean[] columnEditables = new boolean[] {
			false, false, false, false, false, false, false,false,false,true,true,true
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	}; 
		table.setModel(model);
		table.setFont(new Font("宋体", Font.PLAIN, 12));
		table.getColumnModel().getColumn(11).setPreferredWidth(120);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(Color.WHITE);
		table.setShowGrid(true);
		table.getTableHeader().setReorderingAllowed(false); //设置为禁止拖动
		InputCondition.ActionPanelEditorRenderer er = new InputCondition.ActionPanelEditorRenderer();
		TableColumn column = table.getColumnModel().getColumn(11);
		column.setCellRenderer( er);
		column.setCellEditor( er);
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(260,240,370,79);
		getContentPane().add(jp);
		
		
		JLabel CODLabel = new JLabel("COD");
		CODLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		CODLabel.setBounds(8, 51, 15, 12);
		sourceOfPullutionPanel.add(CODLabel);
		
		JLabel BODLabel = new JLabel("BOD");
		BODLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		BODLabel.setBounds(67, 51, 15, 12);
		sourceOfPullutionPanel.add(BODLabel);
		
		JLabel TNLabel = new JLabel("TN");
		TNLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		TNLabel.setBounds(8, 69, 15, 12);
		sourceOfPullutionPanel.add(TNLabel);
		
		COD_TextField = new JTextField();
		COD_TextField.setEditable(false);
		COD_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		COD_TextField.setColumns(10);
		COD_TextField.setBounds(25, 51, 35, 12);
		sourceOfPullutionPanel.add(COD_TextField);
		
		BOD_TextField = new JTextField();
		BOD_TextField.setEditable(false);
		BOD_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		BOD_TextField.setColumns(10);
		BOD_TextField.setBounds(80, 51, 38, 12);
		sourceOfPullutionPanel.add(BOD_TextField);
		
		TN_TextField = new JTextField();
		TN_TextField.setEditable(false);
		TN_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		TN_TextField.setColumns(10);
		TN_TextField.setBounds(25, 69, 35, 12);
		sourceOfPullutionPanel.add(TN_TextField);
		
		JLabel TPLabel = new JLabel("TP");
		TPLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		TPLabel.setBounds(68, 69, 15, 12);
		sourceOfPullutionPanel.add(TPLabel);
		
		JLabel NH3_NLabel = new JLabel("NH3-N");
		NH3_NLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		NH3_NLabel.setBounds(8, 87, 15, 12);
		sourceOfPullutionPanel.add(NH3_NLabel);
		
		TP_TextField = new JTextField();
		TP_TextField.setEditable(false);
		TP_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		TP_TextField.setColumns(10);
		TP_TextField.setBounds(80, 69, 38, 12);
		sourceOfPullutionPanel.add(TP_TextField);
		
		NH3_N_TextField = new JTextField();
		NH3_N_TextField.setEditable(false);
		NH3_N_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		NH3_N_TextField.setColumns(10);
		NH3_N_TextField.setBounds(25, 87, 35, 12);
		sourceOfPullutionPanel.add(NH3_N_TextField);
		
		JLabel NO3_NLabel = new JLabel("NO3-N");
		NO3_NLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		NO3_NLabel.setBounds(64, 87, 15, 12);
		sourceOfPullutionPanel.add(NO3_NLabel);
		
		NO3_N_TextField = new JTextField();
		NO3_N_TextField.setEditable(false);
		NO3_N_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		NO3_N_TextField.setColumns(10);
		NO3_N_TextField.setBounds(80, 87, 38, 12);
		sourceOfPullutionPanel.add(NO3_N_TextField);
		
		JLabel DOLabel = new JLabel("DO");
		DOLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		DOLabel.setBounds(8, 105, 15, 12);
		sourceOfPullutionPanel.add(DOLabel);
		
		DO_TextField = new JTextField();
		DO_TextField.setEditable(false);
		DO_TextField.setFont(new Font("宋体", Font.PLAIN, 6));
		DO_TextField.setColumns(10);
		DO_TextField.setBounds(25, 105, 35, 12);
		sourceOfPullutionPanel.add(DO_TextField);
		
		JLabel nonPointSourceDataLabel_2 = new JLabel("\u9762\u6E90\u4F4D\u7F6E\u6587\u4EF6");
		nonPointSourceDataLabel_2.setFont(new Font("宋体", Font.PLAIN, 6));
		nonPointSourceDataLabel_2.setBounds(8, 141, 40, 12);
		sourceOfPullutionPanel.add(nonPointSourceDataLabel_2);
		
		nonPointSourceDataTextField_2 = new JTextField();
		nonPointSourceDataTextField_2.setEditable(false);
		nonPointSourceDataTextField_2.setFont(new Font("宋体", Font.PLAIN, 6));
		nonPointSourceDataTextField_2.setColumns(10);
		nonPointSourceDataTextField_2.setBounds(50, 141, 42, 12);
		sourceOfPullutionPanel.add(nonPointSourceDataTextField_2);
		
		JButton fileButton_3 = new JButton("...");
		fileButton_3.setFont(new Font("宋体", Font.PLAIN, 6));
		fileButton_3.setBounds(95, 141, 20, 12);
		sourceOfPullutionPanel.add(fileButton_3);
		
		JLabel roughnessCoefficientLabel = new JLabel("\u7CD9\u7387\u7CFB\u6570");
		roughnessCoefficientLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		roughnessCoefficientLabel.setBounds(10, 45, 30, 12);
		modelValidationPanel.add(roughnessCoefficientLabel);
		
		roughnessCoefficientTextField_1 = new JTextField();
		roughnessCoefficientTextField_1.setColumns(10);
		roughnessCoefficientTextField_1.setBounds(45, 45, 32, 12);
		modelValidationPanel.add(roughnessCoefficientTextField_1);
		
		roughnessCoefficientTextField_2 = new JTextField();
		roughnessCoefficientTextField_2.setEditable(false);
		roughnessCoefficientTextField_2.setColumns(10);
		roughnessCoefficientTextField_2.setBounds(82, 45, 32, 12);
		modelValidationPanel.add(roughnessCoefficientTextField_2);
		
		roughnessCoefficientTextField_3 = new JTextField();
		roughnessCoefficientTextField_3.setEditable(false);
		roughnessCoefficientTextField_3.setColumns(10);
		roughnessCoefficientTextField_3.setBounds(119, 45, 32, 12);
		modelValidationPanel.add(roughnessCoefficientTextField_3);
		
		roughnessCoefficientTextField_4 = new JTextField();
		roughnessCoefficientTextField_4.setEditable(false);
		roughnessCoefficientTextField_4.setColumns(10);
		roughnessCoefficientTextField_4.setBounds(156, 45, 32, 12);
		modelValidationPanel.add(roughnessCoefficientTextField_4);
		
		roughnessCoefficientTextField_5 = new JTextField();
		roughnessCoefficientTextField_5.setEditable(false);
		roughnessCoefficientTextField_5.setColumns(10);
		roughnessCoefficientTextField_5.setBounds(193, 45, 32, 12);
		modelValidationPanel.add(roughnessCoefficientTextField_5);
		
		CODCheckBox.addActionListener(new textEditable_action(CODCheckBox,CODTextField));
		BODCheckBox.addActionListener(new textEditable_action(BODCheckBox,BODTextField));
		TNCheckBox.addActionListener(new textEditable_action(TNCheckBox,TNTextField));
		TPCheckBox.addActionListener(new textEditable_action(TPCheckBox,TPTextField));
		NH3NCheckBox.addActionListener(new textEditable_action(NH3NCheckBox,NH3NTextField));
		NO3NCheckBox.addActionListener(new textEditable_action(NO3NCheckBox,NO3NTextField));
		DOCheckBox.addActionListener(new textEditable_action(DOCheckBox,DOTextField));
		
		JLabel resultLabel = new JLabel("");
		resultLabel.setFont(new Font("宋体", Font.PLAIN, 7));
		resultLabel.setBounds(140, 168, 50, 12);
		modelValidationPanel.add(resultLabel);
		
		
		                                                                                                     //将监听方法写到一起
		insertButton.addActionListener(new InsertButton_action(table,model,sewageOutletNumberTextField,
				                                                           X_TextField,
				                                                           Y_TextField,
				                                                           dischargeFlowTextField,
				                                                           COD_TextField,
				                                                           BOD_TextField,
				                                                           TN_TextField,
				                                                           TP_TextField,
				                                                           NH3_N_TextField,
				                                                           NO3_N_TextField,
				                                                           DO_TextField
				                                                           ));
		subsectionCheckBox_1.addActionListener(new subsectionCheckBox_1_action(subsectionCheckBox_1,riverTextField_1,
				                                                                                    riverTextField_2,
				                                                                                    riverTextField_3,
				                                                                                    riverTextField_4,
				                                                                                    riverTextField_5));
		subsectionCheckBox_3.addActionListener(new subsectionCheckBox_1_action(subsectionCheckBox_3,DegradationCoefficientTextField_1,
				                                                                                    DegradationCoefficientTextField_2,
				                                                                                    DegradationCoefficientTextField_3,
				                                                                                    DegradationCoefficientTextField_4,
				                                                                                    DegradationCoefficientTextField_5));
		analogButton.addActionListener(new analogButton_action(                     subsectionCheckBox_1,
				                                                                    subsectionCheckBox_3,
				                                                                    degradationCoefficientComboBox,
				                                                                    riverTextField_1,
				                                                                    riverTextField_2,
				                                                                    riverTextField_3,
				                                                                    riverTextField_4,
				                                                                    riverTextField_5,
				                                                                    DegradationCoefficientTextField_1,
				                                                                    DegradationCoefficientTextField_2,
				                                                                    DegradationCoefficientTextField_3,
				                                                                    DegradationCoefficientTextField_4,
				                                                                    DegradationCoefficientTextField_5,
				                                                                    SedimentCoefficientTextField_1,
				                                                                    SedimentCoefficientTextField_2,
				                                                                    SedimentCoefficientTextField_3,
				                                                                    SedimentCoefficientTextField_4,
				                                                                    SedimentCoefficientTextField_5,
				                                                                    controlObjectiveTextField_1,
				                                                                    controlObjectiveTextField_2,
				                                                                    controlObjectiveTextField_3,
				                                                                    controlObjectiveTextField_4,
				                                                                    controlObjectiveTextField_5,
				                                                                    roughnessCoefficientTextField_1,
				                                                                    roughnessCoefficientTextField_2,
				                                                                    roughnessCoefficientTextField_3,
				                                                                    roughnessCoefficientTextField_4,
				                                                                    roughnessCoefficientTextField_5));
		simulationVerificationButton.addActionListener(new simulationVerificationButton_action(frame,measuredDataTextField,simulationPreLacisionComboBox,
				                                                                                                           precision_model,
				                                                                                                           resultLabel));
		
		exportButton.addActionListener(new exportButton_action(table));
		saveButton_1.addActionListener(new SaveButton_action1(sourceModel,CODCheckBox,BODCheckBox,TNCheckBox,TPCheckBox,NH3NCheckBox,
				                                                                                                        NO3NCheckBox,
				                                                                                                        DOCheckBox,
				                                                                                                        upperBoundaryTextField,
				                                                                                                        lowerBoundaryWaterLevelTextField,
				                                                                                                        CODTextField,
				                                                                                                        BODTextField,
				                                                                                                        TNTextField,
				                                                                                                        TPTextField,
				                                                                                                        NH3NTextField,
				                                                                                                        NO3NTextField,
				                                                                                                        DOTextField,
				                                                                                                        computationTextField,
				                                                                                                        simulationTimeTextField,
				                                                                                                        yearTextField_1,
				                                                                                                        monthTextField_1,
				                                                                                                        dayTextField_1,
				                                                                                                        yearTextField_2,
				                                                                                                        monthTextField_2,
				                                                                                                        dayTextField_2,
				                                                                                                        degradationCoefficientComboBox,
				                                                                                                        COD_TextField,
				                                                                                                        BOD_TextField,
				                                                                                                        TN_TextField,
				                                                                                                        TP_TextField,
				                                                                                                        NH3_N_TextField,
				                                                                                                        NO3_N_TextField,
				                                                                                                        DO_TextField,
				                                                                                                        riverConditionPanel));
		saveButton_2.addActionListener(new SaveButton_action_2(table,model,nonPointSourceDataTextField_1,nonPointSourceDataTextField_2,
				                                                                                         sourceOfPullutionPanel
				                                                                                         ));
		fileButton_1.addActionListener(new FileCopyButton_action(file1,nonPointSourceDataTextField_1,"txt"));
		fileButton_2.addActionListener(new FileChooserButton_action(measuredDataTextField,"xls"));
		
		JLabel lblNewLabel = new JLabel("\u6C34\u8D28\u6307\u6807");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 6));
		lblNewLabel.setBounds(45, 65, 30, 12);
		modelValidationPanel.add(lblNewLabel);
		fileButton_3.addActionListener(new FileChooserButton_action(nonPointSourceDataTextField_2,"xls"));
		viewDetailsButton.addActionListener(new viewDetailsButton_action());
		

		
		frame.add(riverConditionPanel);                   //将其他panel加到mainframe中
		frame.add(exportButton);
		frame.add(modelValidationPanel);
		frame.add(sourceOfPullutionPanel);
		frame.add(jp);
				
	}
	class ActionPanelEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {    //将更新，删除按钮加到表格中
		public ActionPanelEditorRenderer() {
			super();
			panel2.add(updateButton);
			panel2.add(deleteeditButton);
			updateButton.setFont(new Font("宋体", Font.PLAIN, 8));
			updateButton.setPreferredSize(new Dimension(40,22));
			deleteeditButton.setFont(new Font("宋体", Font.PLAIN, 8));
			deleteeditButton.setPreferredSize(new Dimension(40,22));
			updateButton.addActionListener(new UpdateButton_action(table,model,frame));
			deleteeditButton.addActionListener(new DeleteButton_action(table,model));
		}
 
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			panel2.add(updateButton);
			panel2.add(deleteeditButton);
			panel2.setFont(new Font("宋体", Font.PLAIN, 8));
			return panel2;
		}
 
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			
			panel2.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
			return panel2;
		}
 
		@Override
		public Object getCellEditorValue() {
			return null;
		}
	}
}
