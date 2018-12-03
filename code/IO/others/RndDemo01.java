/* @16130110047 王一凡 528378795@qq.com */
package com.IO.others;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 文件的分割思路
 * 1、分割的块数 size    n块
 * 2、每一块的大小 blockSize
 * 	最后一块大小：总的文件大小 - (n - 1) * blockSize
 */

public class RndDemo01 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rnd = new RandomAccessFile(new File("e:/IO/test/char.txt"), "r");
		rnd.seek(40);
		//定义缓冲大小
		byte[] flush = new byte[1024];
		//接受长度
		int len = 0;
		
		while (-1 != (len = rnd.read(flush))) {
			if(len >= 20) {
				System.out.println(new String(flush, 0, 20));
				break;
			}else
				System.out.println(new String(flush, 0, len));
		}
		
		rnd.close();
	}

}
