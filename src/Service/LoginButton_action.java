package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

import UI.Geography;
import Util.FileChooser;
import Util.FileHanding;

//登录按钮
public class LoginButton_action implements ActionListener{
	private JFrame frame;
	private JTextField urm;
	private JPasswordField psd;
	
	public LoginButton_action(JFrame frame,JTextField urm,JPasswordField psd){
		this.frame=frame;	
		this.urm=urm;
		this.psd=psd;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(urm.getText().equals("admin") && psd.getText().equals("123456")){
			JOptionPane.showMessageDialog( null, "登录成功！请选择path", "系统提示",JOptionPane.INFORMATION_MESSAGE);
			JFileChooser filechooser = new JFileChooser();
			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择文件夹
			filechooser.setApproveButtonText("选择");
			int returnVal = filechooser.showOpenDialog(filechooser);
			if(returnVal== FileChooser.APPROVE_OPTION){
				File Path_file = filechooser.getSelectedFile();
				int result = JOptionPane.showConfirmDialog(frame,"是否确认path？", "系统提示",
			               JOptionPane.YES_NO_CANCEL_OPTION,
			               JOptionPane.INFORMATION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
					if(Path_file.listFiles().length == 0){//所选为新建项目(即空目录)
						File sourceFile  = new File("./project_File");//复制工程目录
						try {
							FileUtils.copyDirectory(sourceFile,Path_file);
							System.out.println("成功创建工程！");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
						FileHanding.setPath(Path_file.getPath());
						System.out.println("项目路径为:"+FileHanding.getPath());
						Geography geo = new Geography();//跳转窗口	
						frame.setVisible(false);; //当前窗口不可见	
						
				}
				else{
					JOptionPane.showMessageDialog( null, "请重新登录！", "系统提示",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog( null, "请重新登录！", "系统提示",JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog( null, "用户名或密码错误！", "系统提示",JOptionPane.WARNING_MESSAGE);
			urm.setText(null);
			psd.setText(null);
		}
			
		
	}
	
}
