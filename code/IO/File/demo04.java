/* @16130110047 王一凡 528378795@qq.com */
package com.IO.File;

import java.io.File;
import java.io.FilenameFilter;

public class demo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "E:/IO/";
		File src = new File(path);  //文件夹
		if(src.isDirectory()) {  //存在并且为目录
			System.out.println("------子目录|文件名------");
			String[] subNames = src.list();
			for (String st : subNames) {
				System.out.println(st);
			}
			
			System.out.println("------子目录|文件File对象------");
			File[] subFiles = src.listFiles();
			for (File file : subFiles) {
				System.out.println(file.getAbsolutePath());
			}
			
			System.out.println("------子文件.java对象------");
			//命令设计模式
			subFiles = src.listFiles(new FilenameFilter() {
				
				@Override
				/*
				 * dir 代表 src
				 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
				 */
				public boolean accept(File dir, String name) {
					System.out.println(dir.getAbsolutePath());
					return new File(dir, name).isFile() && name.endsWith(".java");
				}
			});
			for (File file : subFiles) {
				System.out.println(file.getAbsolutePath());
			}
		}
	}

}
