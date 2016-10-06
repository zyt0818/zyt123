package com.yc.bean1.recursion;

public class Test4 {
	public static void main(String[] args) {
		System.out.println(isPalinDrome("abba",0,"abba".length()-1));
	}
	//如果字符串长度是奇数，字符串会剩下最中间那位字符，但其不影响回文。当检查到长度为1的时候即代表此字符串是回文
	//如果字符串长度是偶数，当两端的字符串两两比较检查后不会剩下字符。即检查到长度为0的时候即代表此字符串是回文
	//判断给定的字符串是否为回文字符串   aannaa
	private static boolean isPalinDrome(String str){
		if(str==null||str.length()<=1){
			return true;
		}else if(str.charAt(0)==str.charAt(str.length()-1)){
			return isPalinDrome(str.substring(1,str.length()-1));
		}else{
			return false;
		}
	}
	//aannaa
	private static boolean isPalinDrome(String str,int low,int high){
		if(low>=high){
			return true;
		}else if(str.charAt(low)==str.charAt(high)){
			return isPalinDrome(str,low+1,high-1);
		}else{
			return false;
		}
	}
}
