package Util;

import java.awt.*;  
import javax.swing.JPanel;  
  
//panel填充图片
public class BackgroundPanel extends JPanel {  
      
	private static final long serialVersionUID = 1L;
      
    private Image image = null;  
  
    public BackgroundPanel(Image image) {  
        this.image = image;  
    }  
  
    protected void paintComponent(Graphics g) {  
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  
}

//调用方法
// Image image=new ImageIcon("images/bg.gif").getImage();  
// JPanel panel = new BackgroundPanel(image); 

