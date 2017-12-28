package com.snowfish.cn.pro;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	private BeforObject beforObject;
	private AfterObject afterObject;
	private Object object;
	
	public  Object createProxy() {
		ClassLoader loader=this.getClass().getClassLoader();
		Class<?>[] interfaces=object.getClass().getInterfaces();
		InvocationHandler h=new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				beforObject.beforObject();
				method.invoke(object, args);
				afterObject.afterObject();
				return proxy;
			}
		};
		
		 Object object=Proxy.newProxyInstance(loader, interfaces, h);
		
		
		return object;
	}

	public BeforObject getBeforObject() {
		return beforObject;
	}

	public void setBeforObject(BeforObject beforObject) {
		this.beforObject = beforObject;
	}

	public AfterObject getAfterObject() {
		return afterObject;
	}

	public void setAfterObject(AfterObject afterObject) {
		this.afterObject = afterObject;
	}

	public Object getWater() {
		return object;
	}

	public void setWater(Object object) {
		this.object = object;
	}
	

}
