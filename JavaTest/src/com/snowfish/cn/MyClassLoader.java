package com.snowfish.cn;

public class MyClassLoader extends ClassLoader{
	
	static {
		int a=10/0;
	}
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		
		return super.loadClass(name);
	}


}
