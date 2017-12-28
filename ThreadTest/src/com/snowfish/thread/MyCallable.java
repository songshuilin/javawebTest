package com.snowfish.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private String name;


	public MyCallable(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		System.out.println(name);
		return name;
	}

}
