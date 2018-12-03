/* @16130110047 王一凡 528378795@qq.com */
package com.IO.others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream 打印流 --> 处理流
 * @author 52837
 *
 */

public class PrintStreamDemo01 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.println(false);
		
		//输出到文件
		File src = new File("e:/IO/test/print.txt");
		ps = new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(src))
				);
		ps.println("io is so easy ....");
		ps.close();
	}

}
