/* @16130110047 王一凡 528378795@qq.com */
package com.IO.util;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	
	/**
	 * 工具类关闭流
	 * 可变参数： ...  只能放在形参最后一个位置，处理方式与数组一致
	 */
	public static void close(Closeable ... io) {
		for (Closeable temp : io) {
			if(null != temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 使用泛型方法
	 */
	public static <T extends Closeable> void closeAll(T ... io) {
		for (Closeable temp : io) {
			if(null != temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
