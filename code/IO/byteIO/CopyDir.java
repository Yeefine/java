/* @16130110047 王一凡 528378795@qq.com */
package com.IO.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * 文件夹的拷贝
 * 1、文件 复制 copyFile
 * 2、文件夹 创建 mkdirs()
 * 3、递归查找子孙级
 *
 *
 */
public class CopyDir {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//源目录
		String srcPath = "E:/IO/test/1.jpg";
		//目标目录  
		String destPath = "E:/IO/test/dir";
		copyDir(srcPath, destPath);
	}

	/**
	 * 拷贝文件夹
	 * @param srcPath 源路径
	 * @param destPath	目标路径
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(String srcPath, String destPath) throws FileNotFoundException, IOException {
		File src = new File(srcPath); 
		File dest = new File(destPath);
		copyDir(src, dest);
	}

	/**
	 * 拷贝文件夹
	 * @param src 源File对象
	 * @param dest 目标File对象
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(File src, File dest) throws FileNotFoundException, IOException {
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
	public static void copyDirDetail(File src, File dest) throws FileNotFoundException,IOException{
		if(src.isFile()) {  //文件
			try {
				FileUtil.copyFile(src, dest);
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				throw e;
			} catch (IOException e) {
				//e.printStackTrace();
				throw e;
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

}
