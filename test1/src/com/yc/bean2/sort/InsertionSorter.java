package com.yc.bean2.sort;

public class InsertionSorter implements Sortable {
	private int[] arr;

	public InsertionSorter(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void sort() {
		//插入排序    将前面的元素当成一个已经排好序的数组，在内循环中，拿后面的一个元素与前面排好序的部分的最后一个元素比较
		//如果比它大，则内循环结束
		//如果比它小，则将前面的数组向前循环，值到找到一个比它大的，交换
		//{6,3,5,6,7,0}
		for(int i=1;i<arr.length;i++){
			//记录索引位置
			int j=i-1; //j=1
			//记录i索引位置的值
			int next=arr[i];//next=3
			//循环j,让j不断--,直到j<0或是arr[j-1]>next
			while(j>=0&&arr[j]>next){
				//交换位置
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=next;
			
		}
		
	}
}
