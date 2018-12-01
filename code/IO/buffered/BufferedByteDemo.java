/* @16130110047 王一凡 528378795@qq.com */
package com.IO.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedByteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException, IOException {
		//1.建立联系源 (存在且为文件) + 目的地(文件可以不存在)
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {  //为文件夹或为null
			throw new IOException("只能拷贝文件");
		}
		//dest为已经存在的文件夹，不能建立于文件夹同名的文件
		if(dest.isDirectory()) {
			System.out.println(dest.getAbsolutePath() + "不能建立于文件夹同名的文件");
			throw new IOException(dest.getAbsolutePath() + "不能建立于文件夹同名的文件");
		}
		//2.选择流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
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
		os.close();
		is.close();
	}
}
