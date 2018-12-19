/* @16130110047 王一凡 528378795@qq.com */
package com.net.tcp.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1、创建客户端 必须制定服务器 + 端口 此时就在连接
 * 	Socket(String host, int port)
 * 2、接收数据 + 发送数据
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、创建客户端 必须指定服务器 + 端口 此时就在连接
		Socket client = new Socket("localhost", 8888);
		//2、读取数据
		/*
		BufferedReader br = new BufferedReader(
				new InputStreamReader(client.getInputStream()));
		String msg = br.readLine();
		System.out.println(msg);
		*/
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println(str);
	}

}
