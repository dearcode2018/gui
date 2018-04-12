/**
  * @filename IndexPanel.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.index;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hua.common.CommonParam;

 /**
 * @type IndexPanel
 * @description  
 * @author qianye.zheng
 */
public final class IndexPanel extends CommonParam
{
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public IndexPanel(final JFrame mainFrame)
	{
		JPanel panel = new JPanel();
		mainFrame.add(panel);
		JButton button = new JButton("查看");
		button.setFont(font);
		// 表格
		Object[] header = {"序号", "值"};
		Object[][] data = {{"1", "a"}, {"2", "b"}, {"2", "b"}};
		JTable table = new JTable(data, header);
		table.setFont(font);
		table.setVisible(true);
		// 禁止编辑
		table.setEnabled(false);
		// 注意，将table作为构造方法的参数才能有效，直接add是不起作用的
		JScrollPane scrollPane = new JScrollPane(table);
		// 填充视图高度
		//table.setFillsViewportHeight(true);
		scrollPane.setFont(font);
		
		panel.add(scrollPane);		
	}
}
