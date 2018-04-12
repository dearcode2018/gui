/**
  * @filename LoginDialog.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.login;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.hua.common.CommonParam;
import com.hua.frame.MainFrame;

 /**
 * @type LoginDialog
 * @description  
 * @author qianye.zheng
 */
public final class LoginDialog extends CommonParam
{
	/* 登录成功 标识 */
	private boolean loginSuccess = false;
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public LoginDialog()
	{
		// 登录对话框 宽度/高度
		int dialogWidth = 400;
		int dialogHeight = 100;
		// 密码框长度
		int passwordLength = 10;
		String password = "123";
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
		
		/*button.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// 密码验证
				String inputPassword = new String(passwordField.getPassword());
				if (password.equals(inputPassword))
				{ // 登录成功
					loginSuccess = true;
					tipLabel.setForeground(null);
					tipLabel.setText("登录中...");
					// 关闭对话框
					dialog.dispose();
					// 进入主界面
					MainFrame mainFrame = new MainFrame();
				} else
				{
					// 红色显示
					tipLabel.setForeground(Color.RED);
					tipLabel.setText("密码不正确!");
					loginSuccess = false;
				}
			}
		});
		*/
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
				//dialog.dispose();
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

	/**
	 * @return the loginSuccess
	 */
	public final boolean isLoginSuccess()
	{
		return loginSuccess;
	}

}
