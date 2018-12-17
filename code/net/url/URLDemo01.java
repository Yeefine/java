/* @16130110047 王一凡 528378795@qq.com */
package com.net.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	public static void main(String[] args) throws MalformedURLException {
		//绝对路径构建
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=wyf");
		System.out.println("协议：" + url.getProtocol());
		System.out.println("域名：" + url.getHost());
		System.out.println("端口号：" + url.getPort());
		System.out.println("资源：" + url.getFile());
		System.out.println("相对路径:" + url.getPath());
		System.out.println("锚点：" + url.getRef());   //锚点
		System.out.println("参数：" + url.getQuery()); //?参数：存在锚点 返回null，不存在，返回正确
		
		//相对路径构建
		URL url1 = new URL("http://www.baidu.com:80/a/");
		URL url2 = new URL(url1, "b.txt");
		System.out.println(url2.toString());
	}

}
