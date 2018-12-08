/* @16130110047 王一凡 528378795@qq.com */
package com.thread.syn;
/**
 * 单例设计模式：确保一个类只有一个对象  (外部不能创建对象，只能使用类内部创建的对象)
 *
 */
public class SynDemo02 {

	public static void main(String[] args) {
		JvmThread thread1 = new JvmThread(100);
		JvmThread thread2 = new JvmThread(200);
		thread1.start();
		thread2.start();
		
	}

}

class JvmThread extends Thread {
	private long time;
	public JvmThread() {

	}
	
	public JvmThread(long time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "--> 创建：" + Jvm.getInstance(time));
	}
}

/**
 * 单例设计模式
 * 确保一个类只有一个对象
 * 懒汉式  double checking
 * 1、构造器私有化，避免外部直接创建对象
 * 2、声明一个私有的静态变量
 * 3、创建一个对外的公共的静态方法 访问该变量， 如果变量没有对象， 创建该对象
 *
 */
class Jvm {
	//声明一个私有的静态变量
	private static Jvm instance = null;
	
	//构造器私有化，避免外部直接创建对象
	private Jvm() {
		
	}
	
	public static Jvm getInstance(long time) {
		if(null == instance) {
			//a b   --> 效率 提供已经存在对象的访问效率
			synchronized (Jvm.class) {
				if(null == instance) {
					try {
						Thread.sleep(time);  //延时，放大错误的可能性
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}	
			
			}
		}	
		return instance;
	}
	
	//创建一个对外的公共的静态方法 访问该变量， 如果变量没有对象， 创建该对象
	public static Jvm getInstance3(long time) {
		//效率不高  存在对象也需要等待
		synchronized (Jvm.class) {
			if(null == instance) {
				try {
					Thread.sleep(time);  //延时，放大错误的可能性
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}	
			return instance;
		}
	}
	
	//创建一个对外的公共的静态方法 访问该变量， 如果变量没有对象， 创建该对象
	public static synchronized Jvm getInstance2(long time) {
		if(null == instance) {
			try {
				Thread.sleep(time);  //延时，放大错误的可能性
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
	
	//创建一个对外的公共的静态方法 访问该变量， 如果变量没有对象， 创建该对象
	public static Jvm getInstance1(long time) {
		if(null == instance) {
			try {
				Thread.sleep(time);  //延时，放大错误的可能性
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
}