package com.yc.bean1.recursion;

public class Test3 {
	//用递归实现十进制输出二进制
	public static void main(String[] args) {
		decimalToBinary(103);

	}
	 public static void decimalToBinary(int num) {
		  if (num == 0) { // 当num=0时，循环结束
		   return;
		  } else {
		   decimalToBinary(num / 2); // 调用递归方法
		   System.out.print(num % 2);
		  }
		 }

}
