/**
  * @filename CommonParam.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.common;

import java.awt.Font;

import com.hua.util.ClassPathUtil;

 /**
 * @type CommonParam
 * @description  
 * @author qianye.zheng
 */
public abstract class CommonParam
{
	/** 统一字体 */
	public final Font font = new Font("Segoe UI", Font.PLAIN, 15);
	
	/** 状态栏图标 */
	public final String path = ClassPathUtil.getClassSubpath("/file/img/button_icon.png", true);
}
