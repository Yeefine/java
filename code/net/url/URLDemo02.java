/* @16130110047 王一凡 528378795@qq.com */
package com.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 获取资源： 源代码
 * @author 52837
 *
 */
public class URLDemo02 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");  //主页 默认资源
		
//		//获取资源 网络流
//		InputStream is = url.openStream();
//		byte[] flush = new byte[1024];
//		int len = 0; 
//		while(-1 != (len = is.read(flush))) {
//			System.out.println(new String(flush));
//		}
//		is.close();
		
		//使用转换流(防乱码)
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
		BufferedWriter bw = 
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"), "utf-8"));
		
		String msg = null;
		while(null != (msg = br.readLine())) {
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
