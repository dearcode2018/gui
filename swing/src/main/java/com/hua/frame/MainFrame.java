/**
  * @filename MainFrame.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.frame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.hua.common.CommonParam;
import com.hua.edit.EditPanel;
import com.hua.index.IndexPanel;

 /**
 * @type MainFrame
 * @description  
 * @author qianye.zheng
 */
public final class MainFrame extends CommonParam
{

	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public MainFrame()
	{
		/*
		 * 主界面
		 * 菜单栏
		 * 数据列表
		 * 
		 */
		// 继承自Window
		JFrame mainFrame = new JFrame("首页");
		mainFrame.setFont(font);
		mainFrame.setVisible(true);
		// 设置大小: 宽度，高度
		mainFrame.setSize(700, 500);
		Image image = Toolkit.getDefaultToolkit().getImage(path);
		mainFrame.setIconImage(image);
		/*
		 * 主框架的菜单，进入系统后菜单一直存在
		 * [首页]
		 * [注销]
		 * [退出]
		 */
		// 菜单
		Menu menu = new Menu(mainFrame);
		
		// 搜索栏
		JPanel searchPanel = new JPanel();
		searchPanel.setVisible(true);
		searchPanel.setSize(100, 50);
		mainFrame.add(searchPanel);
		JButton viewButton = new JButton("查看");
		viewButton.setVisible(true);
		searchPanel.add(viewButton);
		
	/*	viewButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// 进去查看界面
				new EditPanel(mainFrame);
			}
		});*/
		
		// 首页列表
		new IndexPanel(mainFrame);
		
		/*
		 * 设置相对组件为null，则直接居中显示，不相对任何组件
		 * 注意，这个是在 setSize()方法之后执行的才有效
		 */
		mainFrame.setLocationRelativeTo(null);
		// 设置窗体在屏幕中的位置
		//frame.setLocation(x, y);
		
		/*
		 * 注册window监听器 可实现关闭等操作
		 */
		mainFrame.addWindowListener(new WindowAdapter()
		{
			/*
			 * 焦点 获取/失去
			 * 关闭后/关闭中
			 * 窗口已打开
			 * 窗口已激活
			 * 窗口状态改变
			 */
			/**
			 * @description 窗口关闭中
			 * @param e
			 * @author qianye.zheng
			 */
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosed(e);
				// 销毁窗口
				//mainFrame.dispose();
				// 关闭程序
				System.exit(0);
			}
			
			/**
			 * @description 窗口关闭后
			 * @param e
			 * @author qianye.zheng
			 */
			@Override
			public void windowClosed(WindowEvent e)
			{
				super.windowClosed(e);
			}
		}
		);		
	}
}
