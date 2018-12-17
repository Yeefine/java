/* @16130110047 王一凡 528378795@qq.com */
package com.net.ip;
/**
 * 没有封装端口
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());  //返回：10.177.207.126
		System.out.println(addr.getHostName());  //输出计算机名  
		//根据域名得到InetAddress对象
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());  //返回163服务器的ip： 219.145.171.124
		System.out.println(addr.getHostName());  //输出： www.163.com
		//根据ip得到InetAddress对象
		addr = InetAddress.getByName("61.135.253.15");
		System.out.println(addr.getHostAddress());  //返回163服务器的ip:61.135.253.15
		System.out.println(addr.getHostName());  //输出ip而不是域名，如果这个ip地址不存在或者DNS不给解析

	}

}
