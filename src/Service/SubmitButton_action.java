package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import UI.MainFrame;
import Util.FileHanding;
import Util.PaintBayLinePanel;

//河岸线展示 确定按钮，写grid_cont.dat
public class SubmitButton_action implements ActionListener{
	private List<int[]> xy;
	public SubmitButton_action(List<int[]> xy){
		this.xy = xy;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Double[] pro= new PaintBayLinePanel(new MainFrame()).getPro();//获取坐标转换参数
		 FileHanding.getGrid_cont((ArrayList<int[]>) xy, pro);
		 
		 Process p;    
	     String cmd="cmd /c start "+FileHanding.getAbsolutePath("exe/1/grid.exe")+" "+FileHanding.getAbsolutePath("path");    
	            //执行命令    
	      try {
	    	  p = Runtime.getRuntime().exec(cmd);
	    	  } catch (IOException e1) {
	    	  // TODO Auto-generated catch block 
	    		  e1.printStackTrace();
	    		  }    
	}
}
