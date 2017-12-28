package com.snowfish.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.snowfish.thread.MyCallable;
import com.snowfish.thread.MyThread;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		fixeThreadPool();
//		singleThreadPool();
//		cachedThreadPool();
		 callableTest();
	}
	
	public static void callableTest() throws InterruptedException, ExecutionException{
		ExecutorService executor=Executors.newFixedThreadPool(6);
		//Future<?> name=executor.submit(new MyCallable("zhangsan"));
		Future<String> name= executor.submit(new MyCallable("zhangsan"));
		System.out.println(name.get());
		executor.shutdown();
	}
	
	public static void singleThreadPool(){
		ExecutorService executor=Executors.newSingleThreadExecutor();
		for (int i = 0; i < 8; i++) {
			executor.execute(new MyThread("song"+i));
		}
		executor.shutdown();
	}
	
	public static void fixeThreadPool(){
		ExecutorService executor=Executors.newFixedThreadPool(6);
		for (int i = 0; i < 8; i++) {
			executor.execute(new MyThread("song"+i));
		}
		executor.shutdown();
	}
	
	
	public static void cachedThreadPool(){
		ExecutorService executor=Executors.newCachedThreadPool();
		for (int i = 0; i < 8; i++) {
			executor.execute(new MyThread("song"+i));
		}

		executor.shutdown();
	}
}
