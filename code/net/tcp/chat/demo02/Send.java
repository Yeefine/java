/* @16130110047 王一凡 528378795@qq.com */
package com.net.tcp.chat.demo02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据 线程
 * @author 52837
 *
 */
public class Send implements Runnable{
	//从控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	private boolean isRunning = true; 
	
	public Send() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dos, console);
		}
	}
	
	/* 
	 * 1、从控制台接收数据
	 */
	public String getMsgFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			
		}
		return "";
	}
	
	/**
	 * 1、从控制台接收数据
	 * 2、发送数据
	 */
	public void send() {
		String msg = getMsgFromConsole();
		if(null != msg && !msg.equals("")) {
			try {
				dos.writeUTF(msg);
				dos.flush();  //强制刷新
			} catch (IOException e) {
				//e.printStackTrace();
				isRunning = false;
				CloseUtil.closeAll(dos, console);
			}
		}
	}
	
	public void run() {
		//线程体
		while(isRunning) {
			send();
		}
	}

}
