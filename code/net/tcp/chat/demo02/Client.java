/* @16130110047 王一凡 528378795@qq.com */
package com.net.tcp.chat.demo02;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端： 发送数据 + 接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 
 * 输入流与输出流在同一个线程内  应该独立处理， 彼此独立
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 9999);
		//控制台输入流
		new Thread(new Send(client)).start();  //一条路径
		new Thread(new Receive(client)).start();
	}

}
