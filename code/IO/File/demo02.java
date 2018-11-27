/* @16130110047 王一凡 528378795@qq.com */
/*
 * 相对路径与绝对路径构造File对象
 * 1、相对路径
 * 	File(String parent, String child)  ==>File("E:/GUI", "1.jpg")
 * 	File(File parent, String child)    ==>File(new File("E:/GUI"), "1.jpg")
 */
package com.IO.File;

import java.io.File;

public class demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String parentPath = "E:/GUI";
		String name = "1.jpg";
		//相对路径
		File src = new File(parentPath, name);
		src = new File(new File(parentPath), name);
		//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//绝对路径
		src = new File("E:/GUI/1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//若无盘符， 以当前user.dir创建
		src = new File("text.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}

}
