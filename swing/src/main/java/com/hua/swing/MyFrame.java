/**
  * @filename MyFrame.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.swing;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

 /**
 * @type MyFrame
 * @description 
 * @author qianye.zheng
 */
@SuppressWarnings({"serial"})
public class MyFrame extends JFrame
{
	/**
	 * 开发思路
	 * 1) 用 WindowBuilder来构造基础页面，填充基础业务数据
	 * 2) 一个容器控件继承其父类，然后在构造方法中构造
	 * 3) 每个控件作为一个属性，独立一个方法来深入构造，包括绑定各种时间
	 * 4) 使用MVC的方式来组织代码逻辑
	 * 5) 
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("名称：");
		contentPane.add(label);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("用户名：");
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("搜索");
		contentPane.add(button_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"111", "11", "222", null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		contentPane.add(table);
		
		try
		{
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		//contentPane.
		
	}

}
