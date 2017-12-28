package com.snowfish.test;

public interface InterfaceGeneric<A,B,C> {
	// 会出错 Cannot make a static reference to the non-static type A
	//	private A a;
	//	private B b;
	//	private C c;
	A getA();
	B getB();
	C getC();
}
