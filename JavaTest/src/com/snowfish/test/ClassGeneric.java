package com.snowfish.test;

public class ClassGeneric<A,B,C> {
	private A a;
	private B b;
	private C c;
	public A getA() {
		return a;
	}
	public void setA(A a) {
		this.a = a;
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	public C getC() {
		return c;
	}
	public void setC(C c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "ClassGeneric [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
