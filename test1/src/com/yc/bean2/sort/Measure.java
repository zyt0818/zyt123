package com.yc.bean2.sort;

import java.util.Random;

public class Measure {
	public static void main(String[] args) {
		int[] x={6,3,5,9,7,0};
		/*Random r=new Random();
		for(int i=0;i<x.length;i++){
			x[i]=r.nextInt(9999999);
		}*/
		//Sortable sort=new BubbleSorter(x);
		//InsertionSorter sort=new InsertionSorter(x);
		//ShellSorter sort=new ShellSorter(x);
		//MergeSort
		MergeSort sort=new MergeSort(x);
		//SelectionSorter sort=new SelectionSorter(x);
		long start=System.currentTimeMillis();
		sort.sort();
		for(int c:x){
			System.out.println(c);
		}
		long end=System.currentTimeMillis();
		System.out.println("排序时间："+(end-start));
	}
}
