/* @16130110047 王一凡 528378795@qq.com */
package com.IO.convert;

import java.io.UnsupportedEncodingException;





public class ConvertDemo01 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "中国";
		byte[] data = str.getBytes();
		//字节数不完整
		System.out.println(new String(data, 0, 3));
	}
	/**
	 * 编码与解码字符集必须相同，否则乱码
	 * @throws UnsupportedEncodingException
	 */
	
	public static void test1() throws UnsupportedEncodingException {
		 //解码 byte -> char
		 String str = "中国";  //gbk
		 //编码 char -> byte
		 byte[] data = str.getBytes();
		 //编码与解码字符集统一
		 System.out.println(new String(data));
		 //编码与解码字符集不统一
		 data = str.getBytes("utf-8");  //设定编码字符集
		 //不同意则乱码
		 System.out.println(new String(data));
		 
		 System.out.println(new String(data, "utf-8"));
	}

}
