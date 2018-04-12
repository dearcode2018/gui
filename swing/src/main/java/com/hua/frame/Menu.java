/**
  * @filename Menu.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.hua.common.CommonParam;

 /**
 * @type Menu
 * @description  
 * @author qianye.zheng
 */
public final class Menu extends CommonParam
{
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public Menu(final JFrame mainFrame)
	{
		// 菜单栏
		JMenuBar menuBar = new JMenuBar();
		// 设置菜单栏
		mainFrame.setJMenuBar(menuBar);
		menuBar.setFont(font);
		// 构造 [操作] 菜单
		OperationMenu operationMenu = new OperationMenu(menuBar);
		
		
	}
}
