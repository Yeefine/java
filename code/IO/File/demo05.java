/* @16130110047 王一凡 528378795@qq.com */
package com.IO.File;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级目录|文件名称(绝对路径)
 * 1、listFiles()
 * 2、递归
 * @author 52837
 *
 */
public class demo05 {

	public static void main(String[] args) {
		String path = "E:/IO";
		File parent = new File(path);
		printName(parent);
		
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
	}
	
	/**
	 * 输出路径
	 */
	public static void printName(File src) {
		if(null == src || !src.exists()) {
			return;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()) {  //文件夹
			for(File sub : src.listFiles()) {
				printName(sub);
			}
		}
	}

}
