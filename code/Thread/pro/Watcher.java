/* @16130110047 Õı“ª∑≤ 528378795@qq.com */
package com.thread.pro;

public class Watcher implements Runnable{
	private Movie m;

	public Watcher(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			m.watch();
		}
	}

}