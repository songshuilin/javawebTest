package com.snowfish.cn;

import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class JavaTest {

	public static void main(String[] args) {
		ThreadLocal< MyThread> local=new ThreadLocal<>();
		Queue<Thread> queue=new LinkedList<Thread>();

		MyThread thread1=new MyThread("a");
		MyThread thread2=new MyThread("b");
		MyThread thread3=new MyThread("c");

	}

}
