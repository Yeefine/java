/* @16130110047 王一凡 528378795@qq.com */
package com.thread.syn;


public class SynDemo01 {

	public static void main(String[] args) {
		//真实角色
		Web12306 web = new Web12306();
		//代理
		Thread t1 = new Thread(web, "路人甲");
		Thread t2 = new Thread(web, "黄牛乙");
		Thread t3 = new Thread(web, "攻城狮");
		//启动线程
		t1.start();
		t2.start();
		t3.start();

	}

}

/**
 * 线程安全的类
 * @author 52837
 *
 */

class Web12306 implements Runnable{
	private int num = 10;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			test5();
		}
	}
	
	public void test6() {
		if(num <= 0) {
			flag = false;
			return;
		}
		
		synchronized(this) {
			try {
				Thread.sleep(100);   //模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);	
		}
		
	}
	
	//线程不安全 锁定资源不正确
	public void test5() {
		synchronized((Integer)num) {
			if(num <= 0) {
			flag = false;
			return;
			}
			try {
				Thread.sleep(100);   //模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);	
		}
		
	}
	
	//线程不安全 锁定范围不正确
	public void test4 () {
		//b c 1
		synchronized(this) {
			//b
			if(num <= 0) {
				flag = false;
				return;
			}
		}
		//a 
		try {
			Thread.sleep(100);   //模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);	
	}
	 
	//线程安全 锁定正确
	public void test3() {
		synchronized(this) {
			if(num <= 0) {
			flag = false;
			return;
			}
			try {
				Thread.sleep(100);   //模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);	
		}
	}
	
	
	public synchronized void test2() {
		if(num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(100);   //模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);	
	}
	
	//线程不安全
	public void test1() {
		if(num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(500); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);	
	}
}