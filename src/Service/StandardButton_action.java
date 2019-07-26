package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Util.FileChooser;
import Util.FileHanding;

//标准文件按钮
public class StandardButton_action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		while(true){
			JOptionPane.showMessageDialog( null, "请选择边界文件！", "提示",JOptionPane.INFORMATION_MESSAGE);
			FileChooser bay_fileChooser = new FileChooser("dat");    //bay_line文件选择框
			bay_fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //只能选择文件
			int bay_returnVal = bay_fileChooser.showOpenDialog(bay_fileChooser);
		    if(bay_returnVal == FileChooser.APPROVE_OPTION) {
		    	
		    	File bay_read_file = bay_fileChooser.getSelectedFile();
		    	JOptionPane.showMessageDialog( null, "请选择标准断面文件！", "提示",JOptionPane.INFORMATION_MESSAGE);
		    	FileChooser geo_fileChooser = new FileChooser("dat"); 
		    	geo_fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //只能选择文件
				int geo_returnVal = geo_fileChooser.showOpenDialog(geo_fileChooser);
				if(geo_returnVal == FileChooser.APPROVE_OPTION) {
					
					File geo_read_file = geo_fileChooser.getSelectedFile();
					File write_geo_file= new File(FileHanding.getPath()+"/GEO_ORG/GEO.DAT"); 
					File write_bay_file= new File(FileHanding.getPath()+"/GEO_ORG/BAY_LINE.DAT");
					FileHanding.copyFile(write_bay_file, bay_read_file);
					FileHanding.copyFile(write_geo_file, geo_read_file);
					JOptionPane.showMessageDialog( null, "文件读写成功", "提示",JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				else{
					JOptionPane.showMessageDialog( null, "未选择标准断面文件，读写失败", "提示",JOptionPane.ERROR_MESSAGE);
					break;
				}    	
		    }
		    else{
		    	JOptionPane.showMessageDialog( null, "未选择边界文件，读写失败", "提示",JOptionPane.ERROR_MESSAGE);
				break;       	
		    }
		}
	}

}
