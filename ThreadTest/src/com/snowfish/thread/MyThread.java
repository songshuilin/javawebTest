package com.snowfish.thread;

public class MyThread extends Thread{
	private String name;


	public MyThread(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(name);
	}

}
