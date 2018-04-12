/**
 * 描述: 
 * CheckboxTest.java
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

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.FileUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * CheckboxTest
 */
public final class CheckboxTest extends BaseTest {


	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCheckbox() {
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

			// 向容器中添加组件
			frame.add(button);
			
			// 复选框，内容可是文本或图标
			JCheckBox checkBox1 = new JCheckBox("选项1", false);
			checkBox1.setFont(font);
			frame.add(checkBox1);
			// 选中
			JCheckBox checkBox2 = new JCheckBox("选项2", true);
			checkBox2.setFont(font);
			frame.add(checkBox2);
			JCheckBox checkBox3 = new JCheckBox("选项3", false);
			checkBox3.setFont(font);
			frame.add(checkBox3);
			
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
			log.error("testCheckbox =====> ", e);
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

}
