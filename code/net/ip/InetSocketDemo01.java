/* @16130110047 王一凡 528378795@qq.com */
package com.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 封装端口： 在InetAddress基础上 + 端口
 * @author 52837
 *
 */
public class InetSocketDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress address = new InetSocketAddress("localhost", 9999);
		address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9999);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());

	}

}
