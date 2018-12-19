/* @16130110047 王一凡 528378795@qq.com */
package com.net.tcp.chat.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * @author 52837
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true) {
			Socket client = server.accept();
			//写出数据
			//输入流
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			while(true) {
				String msg = dis.readUTF();
				System.out.println(msg);
				//输出流
				dos.writeUTF("server --> " + msg);
				dos.flush();
			}
		}
		
	}

}
