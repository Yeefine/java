/* @16130110047 王一凡 528378795@qq.com */
package com.IO.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作
 * 	1、文件拷贝
 *  2、文件夹拷贝
 * @author 52837
 *
 */
public class FileUtil {
	
	
	/**
	 * 拷贝文件夹
	 * @param srcPath 源路径
	 * @param destPath	目标路径
	 */
	public static void copyDir(String srcPath, String destPath) {
		File src = new File(srcPath); 
		File dest = new File(destPath);
		copyDir(src, dest);
	}

	/**
	 * 拷贝文件夹
	 * @param src 源File对象
	 * @param dest 目标File对象
	 */
	public static void copyDir(File src, File dest) {
		if(src.isDirectory()) {  //文件夹
			dest = new File(dest, src.getName());
		}
		copyDirDetail(src, dest);
	}
	/**
	 * 拷贝文件夹细节
	 * @param src
	 * @param dest
	 */
	public static void copyDirDetail(File src, File dest) {
		if(src.isFile()) {  //文件
			try {
				FileUtil.copyFile(src, dest);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("文件不存在");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("拷贝失败");
			}
		}else if(src.isDirectory()) {  //文件夹
				//确保目标文件夹存在
			dest.mkdirs();
			//获取下一级目录|文件
			for(File sub : src.listFiles()) {
				copyDirDetail(sub, new File(dest, sub.getName()));
			}
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
		copyFile(src, dest);
	}

	/**
	 * 文件的拷贝
	 * 	@param 原文件File对象
	 * 	@param 目标文件File对象
	 *  @throws FileNotFoundException、 IOException
	 *  @return
	 */
	public static void copyFile(File src, File dest) throws FileNotFoundException, IOException {
		if(!src.isFile()) {  //为文件夹或为null
			throw new IOException("只能拷贝文件");
		}
		//dest为已经存在的文件夹，不能建立于文件夹同名的文件
		if(dest.isDirectory()) {
			System.out.println(dest.getAbsolutePath() + "不能建立于文件夹同名的文件");
			throw new IOException(dest.getAbsolutePath() + "不能建立于文件夹同名的文件");
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
		os.close();
		is.close();

	}
}
