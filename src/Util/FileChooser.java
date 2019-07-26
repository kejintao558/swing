package Util;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFileChooser{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//创建文件选择器，过滤指定文件

	public FileChooser(String extensions){
		this.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//可以选择文件夹和文件
		this.setApproveButtonText("选择");
		String description = "文件(*"+extensions+","+"*"+extensions.toUpperCase()+")";//文件类型描述
		FileNameExtensionFilter filter = new FileNameExtensionFilter(description,extensions,extensions.toUpperCase());
		this.setFileFilter(filter);
	}
	
}
