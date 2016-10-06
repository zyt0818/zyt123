package com.yc.bean2.sort;

public class BubbleSorter implements Sortable {
	private int[] arr;
	
	public BubbleSorter(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void sort() {
		//冒泡排序
		//{6,3,5,6,7,0}
		for(int i=0;i<arr.length-1;i++){//长度减一,只要找到length-1个最大值
			for(int j=0;j<arr.length-1-i;j++){//5   4  
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}

}
