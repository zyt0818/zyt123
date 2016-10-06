package com.yc.bean1.recursion;

import java.io.File;


public class Test6 {
	/**
	 * File类：isFile()  isDirectory()
	 * 如果是目录，则要取出目录下所有文件和目录   File[]   listFiles()
	 * 取出大小累加
	 * @param args
	 */
	public static void main(String[] args) {
		File f=new File(System.getProperty("user.home"));
		System.out.println("大小为"+GetFileSize(f));
	}

	private static long GetFileSize(File f) {
		long size=0;
		if(f.isFile()){
			size=f.length();
		}else{
			File[] f1=f.listFiles();
			if(f1!=null&&f1.length>0){
				for(File f2:f1){
					size+=GetFileSize(f2);
				}
			}
		}
		return size;
	}

}
