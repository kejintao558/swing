package Service;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Util.FileHanding;

public class SaveButton_action1 implements ActionListener{
	
	private DefaultComboBoxModel sourceModel;
	private JCheckBox CODCheckBox;
	private JCheckBox BODCheckBox;
	private JCheckBox TNCheckBox;
	private JCheckBox TPCheckBox;
	private JCheckBox NHSNCheckBox;
	private JCheckBox NOSNCheckBox;
	private JCheckBox DOCheckBox;
	private JTextField upperBoundaryTextField;
	private JTextField lowerBoundaryWaterLevelTextField;
	private JTextField CODTextField;
	private JTextField BODTextField;
	private JTextField TNTextField;
	private JTextField TPTextField;
	private JTextField NH3NTextField;
	private JTextField NO3NTextField;
	private JTextField DOTextField;
	private JTextField simulationTimeTextField;
	private JTextField computationTextField;
	private JTextField yearTextField_1;
	private JTextField monthTextField_1;
	private JTextField dayTextField_1;
	private JTextField yearTextField_2;
	private JTextField monthTextField_2;
	private JTextField dayTextField_2;
	private JComboBox<?> degradationCoefficientComboBox;
	private JTextField cOD_TextField;
	private JTextField bOD_TextField;
	private JTextField tN_TextField;
	private JTextField tP_TextField;
	private JTextField nH3_N_TextField;
	private JTextField nO3_N_TextField;
	private JTextField dO_TextField;
	private JPanel riverConditionPanel;
	
	private String source[]=new String[7];
	private int i=0;


	public SaveButton_action1( DefaultComboBoxModel sourceModel, JCheckBox cODCheckBox, JCheckBox bODCheckBox,
			                                                                             JCheckBox tNCheckBox,
			                                                                             JCheckBox tPCheckBox,
			                                                                             JCheckBox nHSNCheckBox,
			                                                                             JCheckBox nOSNCheckBox,
			                                                                             JCheckBox dOCheckBox,
			                                                                             JTextField upperBoundaryTextField,
			                                                                             JTextField lowerBoundaryWaterLevelTextField,
			                                                                             JTextField cODTextField,
			                                                                             JTextField bODTextField,
			                                                                             JTextField tNTextField,
			                                                                             JTextField tPTextField,
			                                                                             JTextField nH3NTextField,
			                                                                             JTextField nO3NTextField,
			                                                                             JTextField dOTextField,
			                                                                             JTextField computationTextField,
			                                                                             JTextField simulationTimeTextField,
			                                                                             JTextField yearTextField_1,
			                                                                             JTextField monthTextField_1,
			                                                                             JTextField dayTextField_1,
			                                                                             JTextField yearTextField_2,
			                                                                             JTextField monthTextField_2,
			                                                                             JTextField dayTextField_2,
			                                                                             JComboBox degradationCoefficientComboBox,
			                                                                             JTextField cOD_TextField,
			                                                                             JTextField bOD_TextField,
			                                                                             JTextField tN_TextField,
			                                                                             JTextField tP_TextField,
			                                                                             JTextField nH3_N_TextField,
			                                                                             JTextField nO3_N_TextField,
			                                                                             JTextField dO_TextField,
			                                                                             JPanel riverConditionPanel) {
		// TODO Auto-generated constructor stub
		this.sourceModel= sourceModel;
		this.CODCheckBox= cODCheckBox;
		this.BODCheckBox = bODCheckBox;
		this.TNCheckBox= tNCheckBox;
		this.TPCheckBox= tPCheckBox;
		this.NHSNCheckBox= nHSNCheckBox;
		this.NOSNCheckBox= nOSNCheckBox;
		this.DOCheckBox=dOCheckBox;
		this.upperBoundaryTextField=upperBoundaryTextField;
		this.lowerBoundaryWaterLevelTextField=lowerBoundaryWaterLevelTextField;
		this.CODTextField=cODTextField;
		this.BODTextField=bODTextField;
		this.TNTextField=tNTextField;
		this.TPTextField=tPTextField;
		this.NH3NTextField=nH3NTextField;
		this.NO3NTextField=nO3NTextField;
		this.DOTextField=dOTextField;
		this.computationTextField=computationTextField;
		this.simulationTimeTextField=simulationTimeTextField;
		this.yearTextField_1=yearTextField_1;
		this.monthTextField_1=monthTextField_1;
		this.dayTextField_1=dayTextField_1;
		this.yearTextField_2=yearTextField_2;
		this.monthTextField_2=monthTextField_2;
		this.dayTextField_2=dayTextField_2;
		this.degradationCoefficientComboBox=degradationCoefficientComboBox;
		this.cOD_TextField=cOD_TextField;
		this.bOD_TextField=bOD_TextField;
		this.tN_TextField=tN_TextField;
		this.tP_TextField=tP_TextField;
		this.nH3_N_TextField=nH3_N_TextField;
		this.nO3_N_TextField=nO3_N_TextField;
		this.dO_TextField=dO_TextField;
		this.riverConditionPanel=riverConditionPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {                                                  //用于决定第二第三个panel中下拉框污染物指标的元素
			if(CODCheckBox.isSelected()==true){
				
				cOD_TextField.setEditable(true);
				source[i]="COD";
				i++;
			}
			if(BODCheckBox.isSelected()==true){
				
				bOD_TextField.setEditable(true);
				source[i]="BOD";
				i++;
			}
			if(TNCheckBox.isSelected()==true){
				
				tN_TextField.setEditable(true);
				source[i]="TN";
				i++;
			}
			if(TPCheckBox.isSelected()==true){
				
				tP_TextField.setEditable(true);
				source[i]="TP";
				i++;
			}
			if(NHSNCheckBox.isSelected()==true){
				
				nH3_N_TextField.setEditable(true);
				source[i]="NH3-N";
				i++;
			}
			if(NOSNCheckBox.isSelected()==true){
				
				nO3_N_TextField.setEditable(true);
				source[i]="NO3-N";
				i++;
			}
			if(DOCheckBox.isSelected()==true){
				
				dO_TextField.setEditable(true);
				source[i]="DO";
				i++;
			}
			
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		String source1[]=new String[i];
		for(int a=0;a<i;a++){
			source1[a]=source[a];
		}
		sourceModel=new DefaultComboBoxModel(source1);                //根据选择的污染物指标确定下拉框的model
		degradationCoefficientComboBox.setModel(sourceModel);
		try {
			File file = new File(FileHanding.getPath()+"/DATIN_ORG/TIME_QC_UP.DAT"); // 创建文件对象
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false))); 
//			FileWriter out = new FileWriter(file); // 创建FileWriter对象
			String s = "2"+" "+"1"+" "+i; // 获取文本域中的文本
			out.write(s); // 将信息写入磁盘文件
			out.newLine();
			s = "1"+" "+"0"+" "+"2"+" "+upperBoundaryTextField.getText()+" "+
					CODTextField.getText()+" "+BODTextField.getText()+" "+TNTextField.getText()+" "+TPTextField.getText()+
					" "+NH3NTextField.getText()+" "+NO3NTextField.getText()+" "+DOTextField.getText()+" "+lowerBoundaryWaterLevelTextField.getText();
			out.write(s);
			out.newLine();
			s = "2"+" "+simulationTimeTextField.getText()+" "+"2"+" "+upperBoundaryTextField.getText()+" "+
					CODTextField.getText()+" "+BODTextField.getText()+" "+TNTextField.getText()+" "+TPTextField.getText()+
					" "+NH3NTextField.getText()+" "+NO3NTextField.getText()+" "+DOTextField.getText()+" "+lowerBoundaryWaterLevelTextField.getText();
			out.write(s);
			out.close(); // 将流关闭
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			File time_file = new File(FileHanding.getPath()+"/DAT_ORG/DT_STR_END.DAT");                 //写入DT_STR_END.dat文件
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(time_file, false)));
			String s=computationTextField.getText()+" "+"0"+" "+simulationTimeTextField.getText()+" "+yearTextField_1.getText()+" "+
					monthTextField_1.getText()+" "+dayTextField_1.getText()+" "+yearTextField_2.getText()+" "+monthTextField_2.getText()+" "+dayTextField_2.getText();
			out.write(s);
			out.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
		i=0;
		riverConditionPanel.setVisible(false);
	}

}

