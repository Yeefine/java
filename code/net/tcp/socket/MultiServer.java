/* @16130110047 王一凡 528378795@qq.com */
package com.net.tcp.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 必须先启动服务器 后连接
 * 1、创建服务器 指定端口 ServerSocket(int port)
 * 2、接收客户端连接， 阻塞式
 * 3、发送数据 + 接收数据
 * 
 * 接受多个客户端
 */
public class MultiServer {

	public static void main(String[] args) throws IOException {
		//1、创建服务器 指定端口 ServerSocket(int port)
		ServerSocket server = new ServerSocket(8888);
		//2、接收客户端连接 阻塞式
		while(true) {  //死循环 一个accept() 一个客户端
			Socket socket = server.accept();
			System.out.println("一个客户端建立连接");
			//3、发送数据
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String str = "欢迎使用";
			dos.writeUTF(str);
			dos.flush();
		}

	}

}
