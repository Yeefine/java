/* @16130110047 王一凡 528378795@qq.com */
package com.IO.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二.写出文件
	1.建立联系、 File 对象 目的地
	2.选择流 文件输出流 OutputStream FileOutputStream
	3.操作 ： write() + flush
	4.释放资源 ： 关闭
 * @author 52837
 *
 */
public class demo02 {

	public static void main(String[] args) {
		//1.建立联系、 File 对象 目的地
		File dest = new File("E:/IO/test/test.txt");
		//2.选择流 文件输出流 OutputStream FileOutputStream
		OutputStream os = null;
		//以追加形式 写出文件
		try {
			os = new FileOutputStream(dest, false);  //true为追加， false为覆盖
			//3.操作
			String string = "wyf is very good \r\n";
			//字符串转字节数组
			byte[] data = string.getBytes();
			os.write(data, 0, data.length);
			
			os.flush();  //强制刷新出去
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("文件写出失败");
		}finally {
			if(null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭资源失败");
				}
			}
		}
		

	}

}
