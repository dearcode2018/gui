/**
  * @filename EditPanel.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.edit;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hua.common.CommonParam;

 /**
 * @type EditPanel
 * @description  
 * @author qianye.zheng
 */
public final class EditPanel extends CommonParam
{
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public EditPanel(final JFrame mainFrame)
	{
		JPanel panel = new JPanel();
		panel.setVisible(true);
		mainFrame.add(panel);
		panel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("名称", JLabel.HORIZONTAL);
		label.setFont(font);
		panel.add(label);
		
		JTextField textField = new JTextField("默认值", 10);
		textField.setFont(font);
		panel.add(textField);
		
		JLabel label2 = new JLabel("名称", JLabel.HORIZONTAL);
		label.setFont(font);
		panel.add(label);
		
		JTextField textField2 = new JTextField("默认值", 10);
		textField.setFont(font);
		panel.add(textField);
		
	}
}
