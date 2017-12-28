package com.snowfish.test;

import java.util.List;

public class MyGeneric<T> {
    private T object;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	} 
}
