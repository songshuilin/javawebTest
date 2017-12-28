package com.snowfish.cn;

public class MyThread extends Thread{
	public  String name;
	public MyThread(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		System.out.println(name);
		super.run();
	}

}
