package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Util.FileChooser;
import Util.FileHanding;

//google earth 按钮
public class GoogleEarthButton_action implements ActionListener{

	
	@Override
	public void actionPerformed(ActionEvent e) {
		while(true){
			JOptionPane.showMessageDialog( null, "请选择右岸文件！", "提示",JOptionPane.INFORMATION_MESSAGE);
			FileChooser right_fileChooser = new FileChooser("dat");    //右岸文件选择框
			right_fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //只能选择文件
			int right_returnVal = right_fileChooser.showOpenDialog(right_fileChooser);
		    if(right_returnVal == FileChooser.APPROVE_OPTION) {  //右岸文件选择标志
		    	File right_read_file = right_fileChooser.getSelectedFile();//获取右岸.dat
		    	
		    	JOptionPane.showMessageDialog( null, "请选择左岸文件！", "提示",JOptionPane.INFORMATION_MESSAGE);
				FileChooser left_fileChooser = new FileChooser("dat"); //左岸文件选择框
				left_fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //只能选择文件
				int left_returnVal = right_fileChooser.showOpenDialog(right_fileChooser);
				if(left_returnVal == FileChooser.APPROVE_OPTION){
					File left_read_file = right_fileChooser.getSelectedFile();
					
					JOptionPane.showMessageDialog( null, "请选择断面文件夹！", "提示",JOptionPane.INFORMATION_MESSAGE);
					JFileChooser filechooser = new JFileChooser();
					filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择文件夹
					filechooser.setApproveButtonText("选择");
					int returnVal = filechooser.showOpenDialog(filechooser);
					if(returnVal== FileChooser.APPROVE_OPTION){
						File read_file = filechooser.getSelectedFile();
						//文件格式转换
						File write_geo_file= new File(FileHanding.getPath()+"/GEO_ORG/GEO.DAT"); 
						FileHanding.get_geo(write_geo_file,read_file);//写geo.dat
						File write_bay_file= new File(FileHanding.getPath()+"/GEO_ORG/BAY_LINE.DAT"); //写bay_line.dat
						FileHanding.get_bay_line(write_bay_file, left_read_file,false);//写入右岸.dat，创建新文件
						FileHanding.get_bay_line(write_bay_file, right_read_file,true);//写入左岸.dat , 不覆盖文件
						JOptionPane.showMessageDialog( null, "格式转换成功", "提示",JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else{
						JOptionPane.showMessageDialog( null, "未选择断面文件夹，格式转换失败！", "提示",JOptionPane.ERROR_MESSAGE);
						break;
					}						
				}
				else{//左岸文件没有选择，不执行文件格式转换
					JOptionPane.showMessageDialog( null, "未选择左岸文件，格式转换失败！", "提示",JOptionPane.ERROR_MESSAGE);
					break;
				}
		    }
		    else{//右岸文件没有选择，不执行文件格式转换
		    	JOptionPane.showMessageDialog( null, "未选择右岸文件，格式转换失败！", "提示",JOptionPane.ERROR_MESSAGE);
		    	break;
		    }
		}
	}

}
