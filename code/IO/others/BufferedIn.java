/* @16130110047 王一凡 528378795@qq.com */
package com.IO.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 封装输入
 * 
 *
 */
public class BufferedIn {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("请输入");
		String msg = br.readLine();
		System.out.println(msg);
	}

}
