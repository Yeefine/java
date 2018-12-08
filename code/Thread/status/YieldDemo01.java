/* @16130110047 王一凡 528378795@qq.com */
package com.thread.status;

public class YieldDemo01 extends Thread {

	public static void main(String[] args) {
		YieldDemo01 demo01 = new YieldDemo01();
		Thread t = new Thread(demo01);  //新生
		t.start();  //就绪
		//cpu调度运行
		
		
		for(int i = 0; i < 1000; i++) {
			if(i % 20 == 0) {
				Thread.yield();  //暂停本现程main
			}
			System.out.println("main........" + i);
		}
		
	}

	@Override
	public void run() {
		for(int i =0; i < 1000; i++) {
			System.out.println("yield......." + i);
		}
	}
}
