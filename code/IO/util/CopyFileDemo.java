/* @16130110047 王一凡 528378795@qq.com */
package com.IO.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 *三.拷贝文件 程序为桥梁
	1.建立联系、 File 对象 源头 目的地
	2.选择流 文件输入流 InputStream FileInputStream
  			文件输出流 OutputStream FileOutputStream
	3.操作 ： 拷贝
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = 输入了.read(flush))) {
  			输出流.write(flush, 0, len)
  		}
		输出流.flush
	4.释放资源 ： 关闭 两个流
 *
 */

public class CopyFileDemo {

	public static void main(String[] args) {
		String src = "E:/IO/test";
		String dest = "E:/IO/test/3.jpg";
		try {
			copyFile(src, dest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("拷贝文件失败|关闭流失败");
		}

	}
	
	/**
	 * 文件的拷贝
	 * 	@param 原文件路径
	 * 	@param 目标文件路径
	 *  @throws FileNotFoundException、 IOException
	 *  @return
	 */
	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException, IOException {
		//1.建立联系源 (存在且为文件) + 目的地(文件可以不存在)
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {  //为文件夹或为null
			throw new IOException("只能拷贝文件");
		}
		//2.选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		//3.文件拷贝 循环 + 读取 + 写出
		byte[] flush = new byte[1024];
		int len = 0;
		//读取
		while(-1 != (len = is.read(flush))) {
			//写出
			os.write(flush, 0, len);
		}
		os.flush();  //强制刷出
		
		//关闭流  (先打开的后关闭)
//		os.close();
//		is.close();
//		FileUtil.close(os, is);
		FileUtil.closeAll(os, is);

	}

}
