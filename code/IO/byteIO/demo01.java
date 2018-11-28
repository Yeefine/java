/* @16130110047 王一凡 528378795@qq.com */
package com.IO.byteIO;
/*
 * 一.读取文件
	1.建立联系、 File 对象 源头
	2.选择流 文件输入流 InputStream FileInputStream
	3.操作 ： byte[] car = new byte[1024]; + read + 读取大小
 		 输出
	4.释放资源 ： 关闭
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("E:/IO/test/a/a.txt");
		InputStream is = null;  //提升作用域
		try {
			is = new FileInputStream(src);
			//3、操作不断读取 缓冲数组
			byte[] car = new byte[10];
			int len = 0; //接受 实际读取大小
			//循环读取
			while(-1 != (len = is.read(car))) {
				//输出 字节数组转成字符串
				String info = new String(car, 0, len);
				System.out.println(info);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取失败");
		}finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭文件输入流失败");
				}
			}
		}
	}

}
