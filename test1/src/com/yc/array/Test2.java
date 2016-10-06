package com.yc.array;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class Test2 {

	public static void main(String[] args) {
		String[] arr=new String[]{"abc","cba","efg","bac","ab","gh"};
		sort(   arr );
		
		for(    String s: arr){
			System.out.print( s+"\t");
		}
	}

	public static String sortChars(String s) {
		char[] chs = s.toCharArray();
		Arrays.sort(chs);
		return new String(chs);
	}

	public static void sort(String[] array) {
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();

		// 将同为变位词的单词放在一组
		for (String s : array) {
			String key = sortChars(s);
			System.out.println(key);
			if (!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> ll = hash.get(key);
			ll.push(s);
		}
		// 将散列表转换为数组
		int index = 0;
		for (String key : hash.keySet()) {
			LinkedList<String> ll = hash.get(key);
			for (String t : ll) {
				array[index] = t;
				index++;
			}
		}
	}
}

