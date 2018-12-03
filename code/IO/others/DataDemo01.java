/* @16130110047 王一凡 528378795@qq.com */
package com.IO.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型(基本+String)处理流
 * 1.输入流 DataInputStream
 * 2.输出流 DataOutputStream
 * 新增方法不能使用多态
 * java.io.EOFException :没有读取到相关的内容 
 *
 */

public class DataDemo01 {

	public static void main(String[] args) {
		try {
			//write("E:/IO/test/data.txt");
			//read("E:/IO/test/array.txt");  //非法内容
			read("E:/IO/test/data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从文件中读取数据+类型
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException {
		//创建源
		File src = new File(destPath);
		//选择流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src))
				
				);
		
		//操作 读取的顺序与写出一致，必须存在才能读取
		//不一致， 数据存在问题
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		
		dis.close();
		
		System.out.println(num2 + "-->" + str);
	}

	/**
	 * 数据+类型输出到文件
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		
		//创建源
		File dest = new File(destPath);
		//选择流 DataOutputStream
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest))
				);
		
		//操作
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dos.close();
	}
}
