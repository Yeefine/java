/* @16130110047 王一凡 528378795@qq.com */
package com.thread.pro;
/**
 * 一个场景，共同的资源
 * 生产者消费者模式 信号灯法
 * wait() :等待、释放锁   sleep  :不释放锁
 * notify() / notifyAll() : 唤醒
 * 与synchronized一起使用
 */
public class Movie {
	private String pic;
	//信号灯
	//flag  --> T， 生产者生产，消费者等待，生产完成后通知消费
	//flag  --> F， 消费者消费，生产者等待，消费完成后通知生产
	private boolean flag = true;
	/**
	 * 播放
	 * @param pic
	 */
	public synchronized void play(String pic) {
		if(!flag) {  //生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//生产完毕
		this.pic = pic;		
		//通知消费
		this.notify();
		//停止生产
		this.flag = false;
		System.out.println("生产了:" + pic);
		
	}
	
	public synchronized void watch() {
		if(flag) {  //消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//消费完毕
		System.out.println("消费:" + pic);
		//通知生产
		this.notify();
		//停止消费
		this.flag = true;
	}
}
