package com.yc.bean2.sort;

public class ShellSorter implements Sortable{
	private int[] arr;

	public ShellSorter(int[] arr) {
		this.arr = arr;
	}
	@Override
	public void sort() {
		int r,i,j,temp;
		//外循坏控制倍数
		for(r=arr.length/2;r>=1;r/=2){
			
			
			for(i=r;i<arr.length;i++){
				j=i-r;
				temp=arr[i];
				while(j>=0&&arr[j]>temp){
					arr[j+r]=arr[j];
					j-=r;
				}
				arr[j+r]=temp;
				
			}
		}
		
	}

}
