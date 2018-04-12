/**
 * 描述: 
 * FrameTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.object;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.login.LoginDialog;
import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.FileUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FrameTest
 */
public final class FrameTest extends BaseTest {


	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFrame() {
		try {
			String path = null;
			// 继承自Window
			JFrame frame = new JFrame("图形用户界面应用程序");
			
			// 标签
			//Label label = new Label("aa");
			/**
			 * 中文乱码问题
			 * 解决方法:  在Run Configurations VM 参数中添加
			 *  -Dfile.encoding=GB18030
			 */
			JLabel label = new JLabel("姓名", Label.LEFT);
			// 背景色
			label.setBackground(Color.YELLOW);
			
			//frame.setLocale(Locale.CHINA);
			
			// 设置布局
			FlowLayout layout = new FlowLayout();
			layout.setAlignment(FlowLayout.LEFT);
			frame.setLayout(layout);
			
			//frame.setEnabled(true);
			//frame.setEnabled(false);
			
			// 设置图标
			path = ClassPathUtil.getClassSubpath("/file/img/icon_01.png", true);
			Image image = Toolkit.getDefaultToolkit().getImage(path);
			frame.setIconImage(image);
			
			// 是否可调整
			frame.setResizable(true);
			
			/*
			 * 注册window监听器 可实现关闭等操作
			 */
			frame.addWindowListener(new WindowAdapter()
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
			
			// 向容器中添加组件
			frame.add(label);
			
			// 设置大小: 宽度，高度
			frame.setSize(700, 500);
			
			/*
			 * 设置相对组件为null，则直接居中显示，不相对任何组件
			 * 注意，这个是在 setSize()方法之后执行的才有效
			 */
			frame.setLocationRelativeTo(null);
			// 设置窗体在屏幕中的位置
			//frame.setLocation(x, y);
			
			// 设置为可视，默认是不可视的
			frame.setVisible(true);

			
			
			// 防止主线程结束， 在main方法中运行可以去掉次行
			Thread.sleep(1000 * 1000);
		} catch (Exception e) {
			log.error("testFrame =====> ", e);
		}
	}	

	/**
	 * 
	 * 描述: 窗体跳转，按钮触发事件去跳转
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFrameWithAction() {
		try {
			String path = null;
			// 继承自Window
			JFrame frame = new JFrame("图形用户界面应用程序");
			
			// 设置字体
			Font font = new Font(Font.SERIF, Font.PLAIN, 15);
			frame.setFont(font);
			
			// 标签
			//Label label = new Label("aa");
			/**
			 * 中文乱码问题
			 * 解决方法:  在Run Configurations VM 参数中添加
			 *  -Dfile.encoding=GB18030
			 */
			path = ClassPathUtil.getClassSubpath("/file/img/button_icon.png", true);
			frame.setFont(font);
			byte[] fileBt = FileUtil.getByteArray(new File(path));
			// 图标
			Icon icon = new ImageIcon(fileBt);
			JButton button = new JButton(icon);
			//JButton button = new JButton("按钮啊", icon);
			button.setFont(font);
			//button.setBounds(0, 0, 500, 2);

			// 注册动作监听器
			button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e)
				{
				}
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
/*				@Override
				public void actionPerformed(ActionEvent event)
				{
					// 事件监听器具体方法中 书写具体逻辑
					// 关闭窗口
					frame.dispose();
				}*/
			});
			
			// 向容器中添加组件
			frame.add(button);
			// 背景色
			//button.setBackground(Color.YELLOW);
			
			//frame.setLocale(Locale.CHINA);
			//frame.setLocale(Locale.CHINESE);
			//frame.setLocale(Locale.SIMPLIFIED_CHINESE);
			//frame.setLocale(Locale.getDefault());
			
			// 设置布局
			FlowLayout layout = new FlowLayout();
			layout.setAlignment(FlowLayout.LEFT);
			frame.setLayout(layout);
			
			//frame.setEnabled(true);
			//frame.setEnabled(false);
			
			// 设置图标
			path = ClassPathUtil.getClassSubpath("/file/img/icon_01.png", true);
			Image image = Toolkit.getDefaultToolkit().getImage(path);
			frame.setIconImage(image);
			
			// 是否可调整
			frame.setResizable(true);
			
			/*
			 * 注册window监听器 可实现关闭等操作
			 */
			frame.addWindowListener(new WindowAdapter()
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
			
			// 设置大小: 宽度，高度
			frame.setSize(700, 500);
			
			/*
			 * 设置相对组件为null，则直接居中显示，不相对任何组件
			 * 注意，这个是在 setSize()方法之后执行的才有效
			 */
			frame.setLocationRelativeTo(null);
			// 设置窗体在屏幕中的位置
			//frame.setLocation(x, y);
			
			// 设置为可视，默认是不可视的
			frame.setVisible(true);

			
			
			// 防止主线程结束， 在main方法中运行可以去掉次行
			Thread.sleep(1000 * 1000);			
			
		} catch (Exception e) {
			log.error("testFrameWithAction =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 窗体跳转，按钮触发事件去跳转
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFrameExample() {
		try {
			/**
			 * 设计思路
			 * 每个组件均有一个内部业务化id，跳转的时候，根据id和参数来调度页面
			 * 
			 */
			/** ====================== 配置参数 ===================== */
			// 对话框 图标
			String path = ClassPathUtil.getClassSubpath("/file/img/button_icon.png", true);
			// 登录对话框 宽度/高度
			int dialogWidth = 400;
			int dialogHeight = 100;
			// 密码框长度
			int passwordLength = 10;
			String password = "123";
			// 设置字体
			Font font = new Font(Font.SERIF, Font.PLAIN, 15);
			// 
			// 图标
			Image image = Toolkit.getDefaultToolkit().getImage(path);
			
			/** ====================== 登录对话框 ===================== */
			
			
			LoginDialog loginDialog = new LoginDialog();
			
			/** =========================================== */
			
			// 
			
			
			// 防止主线程结束， 在main方法中运行可以去掉次行
			Thread.sleep(1000 * 1000);			
			
		} catch (Exception e) {
			log.error("testFrameExample =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 窗体跳转，按钮触发事件去跳转
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFrameExampleOld() {
		try {
			/**
			 * 设计思路
			 * 每个组件均有一个内部业务化id，跳转的时候，根据id和参数来调度页面
			 * 
			 */
			/** ====================== 配置参数 ===================== */
			// 对话框 图标
			String path = ClassPathUtil.getClassSubpath("/file/img/button_icon.png", true);
			// 登录对话框 宽度/高度
			int dialogWidth = 400;
			int dialogHeight = 100;
			// 密码框长度
			int passwordLength = 10;
			String password = "123";
			// 设置字体
			Font font = new Font(Font.SERIF, Font.PLAIN, 15);
			// 
			// 图标
			Image image = Toolkit.getDefaultToolkit().getImage(path);
			
			/** ====================== 登录对话框 ===================== */
			
			// 对话框，布尔参数: 是否是模态框
			JDialog dialog = new JDialog();
			dialog.setIconImage(image);
			dialog.setTitle("登录");
			dialog.setFont(font);
			JPanel panel = new JPanel();
			
			JLabel label = new JLabel("请输入密码", JLabel.HORIZONTAL);
			label.setFont(font);
			panel.add(label);
			dialog.add(panel);
			
			// 密码输入框
			JPasswordField passwordField = new JPasswordField("", passwordLength);
			passwordField.setFont(font);
			// 向容器中添加组件
			panel.add(passwordField);			
			dialog.doLayout();
			dialog.setSize(dialogWidth, dialogHeight);
			/*
			 * 设置相对组件为null，则直接居中显示，不相对任何组件
			 * 注意，这个是在 setSize()方法之后执行的才有效
			 */
			dialog.setLocationRelativeTo(null);
			// 弹出对话框
			dialog.setVisible(true);
			// 关闭，等效于 事件监听器中的 System.exist(0);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			JButton button = new JButton("登录");
			button.setFont(font);
			panel.add(button);
			
			JLabel tipLabel = new JLabel("", JLabel.HORIZONTAL);
			//tipLabel.setSize(200, 20);
			tipLabel.setFont(font);
			panel.add(tipLabel);
			
			button.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					// 密码验证
					String inputPassword = new String(passwordField.getPassword());
					if (password.equals(inputPassword))
					{
						tipLabel.setForeground(null);
						tipLabel.setText("登录中...");
						// 关闭对话框
						dialog.dispose();
						/**
						 * 所有界面公用一个窗口，把常用的界面放在pane中隐藏掉，
						 * 需要的时候掉出来，不常用的界面直接销毁，下次用的时候重新创建
						 */
						
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
						/*
						 * 主框架的菜单，进入系统后菜单一直存在
						 * [首页]
						 * [注销]
						 * [退出]
						 */
						// 菜单栏
						JMenuBar menuBar = new JMenuBar();
						// 设置菜单栏
						mainFrame.setJMenuBar(menuBar);
						JMenu operationMenu = new JMenu("操作");
						operationMenu.setFont(font);
						// 分割线
						operationMenu.addSeparator();
						operationMenu.setVisible(true);
						menuBar.add(operationMenu);
						
						JMenuItem indexMenuItem = new JMenuItem("首页");;
						indexMenuItem.setFont(font);
						operationMenu.add(indexMenuItem);
						
						JMenuItem logoffMenuItem = new JMenuItem("注销");;
						logoffMenuItem.setFont(font);
						operationMenu.add(logoffMenuItem);
						logoffMenuItem.addActionListener(new ActionListener()
						{
							
							@Override
							public void actionPerformed(ActionEvent e)
							{
							}
						});
						
						JMenuItem quitMenuItem = new JMenuItem("退出");;
						quitMenuItem.setFont(font);
						operationMenu.add(quitMenuItem);
						
						
						
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
								mainFrame.dispose();
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
						
						// 新增界面
						
						/* =========================================== */		
						
						// 编辑界面
						
						/* =========================================== */			
						
						// 查看界面
						/* =========================================== */								
					} else
					{
						// 红色显示
						tipLabel.setForeground(Color.RED);
						tipLabel.setText("密码不正确!");
						
						return;
					}
				}
			});
			
			/*
			 * 注册window监听器 可实现关闭等操作
			 */
			dialog.addWindowListener(new WindowAdapter()
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
			
			/** =========================================== */
			
			// 
			
			
			// 防止主线程结束， 在main方法中运行可以去掉次行
			Thread.sleep(1000 * 1000);			
			
		} catch (Exception e) {
			log.error("testFrameExampleOld =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}
	
	/**
	 * 
	 * @description 
	 * @param args
	 * @author qianye.zheng
	 */
	public static void main(String[] args)
	{
		try {
			// 继承自Window
			JFrame frame = new JFrame("图形用户界面应用程序");
			
			// 标签
			//Label label = new Label("aa");
			/**
			 * 中文乱码问题
			 * 解决方法:  在Run Configurations VM 参数中添加
			 *  -Dfile.encoding=GB18030
			 */
			JLabel label = new JLabel("姓名", Label.LEFT);
			// 背景色
			label.setBackground(Color.YELLOW);
			
			//frame.setLocale(Locale.CHINA);
			
			// 设置布局
			FlowLayout layout = new FlowLayout();
			layout.setAlignment(FlowLayout.LEFT);
			frame.setLayout(layout);
			
			//frame.setEnabled(true);
			//frame.setEnabled(false);
			
			// 设置图标
			String path = ClassPathUtil.getClassSubpath("/file/img/icon_01.png", true);
			Image icon = Toolkit.getDefaultToolkit().getImage(path);
			frame.setIconImage(icon);
			
			// 是否可调整
			frame.setResizable(true);
			
			/*
			 * 注册window监听器 可实现关闭等操作
			 */
			frame.addWindowListener(new WindowAdapter()
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
			
			// 向容器中添加组件
			frame.add(label);
			
			// 设置大小: 宽度，高度
			frame.setSize(700, 500);
			
			/*
			 * 设置相对组件为null，则直接居中显示，不相对任何组件
			 * 注意，这个是在 setSize()方法之后执行的才有效
			 */
			frame.setLocationRelativeTo(null);
			// 设置窗体在屏幕中的位置
			//frame.setLocation(x, y);
			
			// 设置为可视，默认是不可视的
			frame.setVisible(true);
		} catch (Exception e) {
		}
	}

}
