/* @16130110047 王一凡 528378795@qq.com */
package com.thread.status;
/**
 * join:合并线程
 * @author 52837
 *
 */

public class JoinDemo01 extends Thread {

	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 demo01 = new JoinDemo01();
		Thread t = new Thread(demo01);  //新生
		t.start();  //就绪
		//cpu调度运行
		
		
		for(int i = 0; i < 1000; i++) {
			if(i == 50) {
				t.join();  //main阻塞...
			}
			System.out.println("main........" + i);
		}
		

	}
	
	@Override
	public void run() {
		super.run();
		for(int i =0; i < 1000; i++) {
			System.out.println("join......." + i);
		}
	}

}
