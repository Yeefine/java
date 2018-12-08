/* @16130110047 ÍõÒ»·² 528378795@qq.com */
package com.thread.info;

public class MyThread implements Runnable {
	private boolean flag = true;
	private int num = 0;
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName() + "--> " + num++);
		}
	}

	public void stop() {
		this.flag = !this.flag;
	}

	public int getNum() {
		return num;
	}
	
	
}
