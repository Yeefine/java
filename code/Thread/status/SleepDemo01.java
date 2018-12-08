/* @16130110047 王一凡 528378795@qq.com */
package com.thread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 * 1、倒数10个数，一秒内打印一个
 * 2、倒计时
 * @author 52837
 *
 */
public class SleepDemo01 {

	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis() + 10 * 1000);  //当前时间加10秒
		long end = endTime.getTime();
		while(true) {
			//输出
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//构建下一秒时间
			endTime = new Date(endTime.getTime() - 1000);
			//等待一秒
			Thread.sleep(1000);
			//10秒以内继续 否则 退出
			if(end - 10000 > endTime.getTime()) {
				break;
			}
		}
	}
	
	public static void test1() throws InterruptedException {
		int num = 10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);
			if(num <= 0) {
				break;
			}
		}
	}

}
