package Service;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class comboBox_action implements ItemListener{
	private JComboBox comboBox;


	public comboBox_action(JComboBox comboBox) {
		// TODO Auto-generated constructor stub
		this.comboBox = comboBox;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {                     //默认刚开始选择COD
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED)               //当下拉框选项发生改变时
        {
            //这里写你的任务 ，比如取到现在的值
            String text=(String) comboBox.getSelectedItem();
            System.out.println(text);
        }
	}

}
