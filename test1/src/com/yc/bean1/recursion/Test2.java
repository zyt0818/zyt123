package com.yc.bean1.recursion;

public class Test2 {
	public static void main(String[] args) {
		System.out.println(fib(5));
	}
	//fibbo数列  1 1 2 3 5 8 13   f(3) 1+1=2  4 f(3)+f(2) 
	private static int fib(int i){
		if(i==1){
			return 1;
		}else if(i==2){
			return 1;
		}else{
			return fib(i-1)+fib(i-2);
		}
	}
}
