/* @16130110047 王一凡 528378795@qq.com */
/*
 * 两个常量
 * 1、路径分隔符 ;
 * 2、文件分割符  \ （Windows）    / （Linux 等）
 */

package com.IO.File;

import java.io.File;

public class demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(File.pathSeparator);    //路径分隔符
		System.out.println(File.separator);
		//路径表现形式
		String path = "E:\\GUI\\1.jpg";
		path = "E:" + File.separator + "GUI" + File.separator + "1.jpg";  //适合动态生成时使用，若是定值 不推荐使用
		//推荐方式
		path = "E:/GUI/1.jpg";
		
		
		
		
	}

}
