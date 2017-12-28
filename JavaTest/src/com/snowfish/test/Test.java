package com.snowfish.test;



public class Test {
	public static void main(String[] args) {
//    ClassGeneric<String, Integer, Float> generic=new ClassGeneric<>();
//       generic.setA("Hello world");
//       generic.setB(12345);
//       generic.setC(12345.0f);
//       System.out.println(generic);
		Object[] objects= {12,34,56};
		Integer[] integers={12,34,56};
		
		
		
		
		Integer[]integer= (Integer[]) objects;
		
		System.out.println(integer);
	}
}
