package com.yc.bean2.sort;

public class SelectionSorter implements Sortable {
	private int[] arr;

	public SelectionSorter(int[] arr) {
		this.arr = arr;
	}
	//{6,3,5,6,7,0}
	//每次内循环，找一个最小值，记录这个最小值的索引，当内循环完毕后，将这个最小值与外循环当前索引元素进行交换
	@Override
	public void sort() {
		for(int i=0;i<arr.length;i++){
			int minindex=i;
			for(int j=i+1;j<arr.length;j++){
				//将j当前的元素值与最小值的比
				if(arr[j]<arr[minindex]){
					minindex=j;
				}
				//如果发现j当前的值还小，则更改最小值的索引，直到全部循环
			}
			//将最小值与i所代表的值进行交换
			int temp=arr[i];
			arr[i]=arr[minindex];
			arr[minindex]=temp;
		}

	}

}
