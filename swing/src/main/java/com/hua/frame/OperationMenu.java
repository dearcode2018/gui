/**
  * @filename OperationMenu.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.frame;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.hua.common.CommonParam;
import com.hua.login.LoginDialog;

 /**
 * @type OperationMenu
 * @description  【操作】菜单
 * @author qianye.zheng
 */
public final class OperationMenu extends CommonParam
{
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public OperationMenu(final JMenuBar menuBar)
	{
		JMenu operationMenu = new JMenu("操作");
		operationMenu.setFont(font);
		// 分割线
		operationMenu.addSeparator();
		operationMenu.setVisible(true);
		menuBar.add(operationMenu);
		
		JMenuItem indexMenuItem = new JMenuItem("首页");
		indexMenuItem.setFont(font);
		operationMenu.add(indexMenuItem);
		
		JMenuItem logoffMenuItem = new JMenuItem("注销");
		logoffMenuItem.setFont(font);
		operationMenu.add(logoffMenuItem);
		/*logoffMenuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// 销毁当前主界面，打开登录窗口
				Window window = (Window) menuBar.getParent().getParent().getParent();
				window.dispose();
				// 构造登录对话框
				LoginDialog loginDialog = new LoginDialog();
			}
		});*/
		
		JMenuItem quitMenuItem = new JMenuItem("退出");
		quitMenuItem.setFont(font);
		operationMenu.add(quitMenuItem);
		/*quitMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// 销毁当前主界面，打开登录窗口
				Window window = (Window) menuBar.getParent().getParent().getParent();
				window.dispose();
				// 关闭程序
				System.exit(0);
			}
		});		*/
	}
}
