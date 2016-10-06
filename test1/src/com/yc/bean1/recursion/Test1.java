package com.yc.bean1.recursion;

public class Test1 {
	/**
	 * 算法：递归
	 * @param args
	 */
	//需求：计算n的阶乘    1!=1    2!=2*1   3!=3*2!=3*2*1!=3*2*1
	public static void main(String[] args) {
		System.out.println(factrial(2));
	}
	private static int factrial(int n){
		if(n==1){
			return 1;
		}else{
			return n*factrial(n-1);
		}
	}
}
