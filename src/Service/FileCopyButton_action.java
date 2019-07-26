package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Util.FileChooser;

public class FileCopyButton_action  implements ActionListener{
	private File file;
	private JTextField textField;
	private String suffix;
	public FileCopyButton_action(File file, JTextField textField, String suffix){
		this.file=file;
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
			System.out.println("文件夹:"+file.getAbsolutePath());
		}else if(file1.isFile()){
			try {
				copyFileUsingFileChannels(file1,file);                //复制文件内容
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("文件:"+file.getAbsolutePath());
			textField.setText(file1.getAbsolutePath());
		}else{
			System.out.print("没有选择文件");
		}		
	}
	
	private static void copyFileUsingFileChannels(File source, File dest) throws IOException {          //复制文件内容方法  
        FileChannel inputChannel = null;    
        FileChannel outputChannel = null;    
    try {
        inputChannel = new FileInputStream(source).getChannel();
        outputChannel = new FileOutputStream(dest).getChannel();
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
    } finally {
        inputChannel.close();
        outputChannel.close();
    }
}
	}

