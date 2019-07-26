package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Util.FileChooser;

public class FileChooserButton_action implements ActionListener{
	private JTextField textField;
	private String suffix;

	public FileChooserButton_action(JTextField textField, String suffix) {
		// TODO Auto-generated constructor stub
		this.textField=textField;
		this.suffix=suffix;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc=new FileChooser(suffix);
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File file1=jfc.getSelectedFile();
		if(file1.isDirectory()){
			System.out.println("文件夹:"+file1.getAbsolutePath());
		}else if(file1.isFile()){
			System.out.println("文件:"+file1.getAbsolutePath());
			textField.setText(file1.getAbsolutePath());
		}else{
			System.out.print("没有选择文件");
		}		
	}

}
