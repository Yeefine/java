/* @16130110047 王一凡 528378795@qq.com */
package com.thread.info;
/**
 * 优先级：概率， 不是绝对的先后顺序
 * MAX_PRIORITY   10
 * NORM_PRIORITY  5  (默认)
 * MIN_PRIORITY   1
 *
 * setPriority()  设置优先级
 * getPriority()
 */
public class InfoDemo02 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		Thread p1 = new Thread(it1, "挨踢1");
		MyThread it2 = new MyThread();
		Thread p2 = new Thread(it2, "挨踢2");
		
		p1.setPriority(Thread.MIN_PRIORITY); //设置优先级
		p2.setPriority(Thread.MAX_PRIORITY); //设置优先级
		p1.start();
		p2.start();
		
		Thread.sleep(50);
		
		it1.stop();
		it2.stop();
	}

}
