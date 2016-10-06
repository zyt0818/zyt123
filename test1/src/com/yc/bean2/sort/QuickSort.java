package com.yc.bean2.sort;

public class QuickSort implements Sortable {
	private int[] a;

	public QuickSort(int[] a) {
		this.a = a;
	}
	@Override
	public void sort() {
		sort(0,a.length-1);
		
	}
	private void sort(int from,int to){
		//递归的终止条件
		if(from>=to){
			return;
		}
		int p=partition(from,to);
		sort(from,p);
		sort(p+1,to);
		
	}
	

	private int partition(int from, int to) {
		int pivot=a[from];//参照值
		int i=from-1;
		int j=to+1;
		//一次外循环要保证所有比pivot大的值，在左边，比piv大的值在右边
		while(i<j){
			//让i从第一个索引循环，找到pivot大的值，找到就记录索引
			i++;
			while(a[i]<pivot){
				i++;
			}
			//让j从最后一个元素向前循环，找到比pivot小的值，找到就记录索引
			j--;
			while(a[j]>pivot){
				j--;
			}
			//经过以上两个内循环，i记录比pivot大的值的位置，j中记录比pivot小的位置
			if(i<j){
				swap(i, j);
			}
			
			
		}
		return j;
		
	}
	private void swap(int minPos,int i){
		int temp=a[i];
		a[i]=a[minPos];
		a[minPos]=temp;
	}
	public static void main(String[] args) {
		int[] arr = { 6, 2,4,8,5,9};

		QuickSort bs = new QuickSort(arr);
		bs.sort();

		for (int t : arr) {
			System.out.print(t + "\t");
		}

	}
}
