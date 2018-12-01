/* @16130110047 王一凡 528378795@qq.com */
package com.IO.buffered;
/**
 * 字符缓冲流 + 新增方法(不能发生多态)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCharDemo {

	public static void main(String[] args) {
		//仅限于字符的纯文本
		//创建源
		File src = new File("E:/IO/test/demo02.java");
		File dest = new File("E:/IO/test/char.txt");
		//选择流
		BufferedReader reader = null;
		BufferedWriter wt = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			wt = new BufferedWriter(new FileWriter(dest));
			//读取操作
			/*
			char[] flush = new char[1024];
			int len = 0;
			while(-1 != (len = reader.read(flush))) {
				wt.write(flush, 0, len);
			} */
			//新增方法的操作
			String line = null;
			while(null != (line = reader.readLine())) {
				wt.write(line);
			//	wt.append("\r\n");
				wt.newLine();  //换行符号
			}
			wt.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		}finally {
			if(null != wt) {
				try {
					wt.close();
				}catch (IOException e) {
					e.printStackTrace();
				} 
			}
			if(null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
