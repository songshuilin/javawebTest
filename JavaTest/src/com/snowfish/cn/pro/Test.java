package com.snowfish.cn.pro;

public class Test {


	public static void main(String[] args) {
		ProxyFactory factory=new ProxyFactory();
		factory.setBeforObject(new BeforObject() {
			
			@Override
			public void beforObject() {
				System.out.println("hello");
				
			}
		});
		
		factory.setAfterObject(new AfterObject() {
			@Override
			public void afterObject() {
			System.out.println("end !");
				
			}
		});
		ManWater water=new ManWater();
		factory.setWater(water);
		Water object=(Water)factory.createProxy();
		object.server();
	}
}
