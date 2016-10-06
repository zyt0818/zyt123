package com.yc.bean2.sort;
//归并排序：特点：以空间换时间
//核心算法：如何将两个有序数组组合成一个有序数组
//1.拆：将一个大的数组一直拆到n个长度为g的数组
//2.排序：每两个长度为一 的数组排序
//3：合并
public class MergeSort implements Sortable{
	private int[] arr;

	public MergeSort(int[] arr) {
		this.arr = arr;
	}
	@Override
	public void sort() {
		//拆分的终止条件是只到一个数组长度为一
		if(arr.length<=1){
			return;
		}
		//将arr拆成两个数组
		int[] a=new int[arr.length/2];
		int[] b=new int[arr.length-a.length];
		//将arr中的值分成两部分存到新的两个数组   System.arrayCopy()
		System.arraycopy(arr, 0, a, 0, a.length);
		System.arraycopy(arr, a.length, b, 0, b.length);
		//对这两个数组进行递归归并排序
		MergeSort ms1=new MergeSort(a);
		MergeSort ms2=new MergeSort(b);
		ms1.sort();
		ms2.sort();
		//在调用合并，以合并这个已排好序数组
		merge(a, b);
		
		
	}
	/**
	 * 将已经排好序的数组合成一个，存到arr中
	 * @param first
	 * @param second
	 */
	private void merge(int[] first,int[] second){
		int ifirst=0,isecond=0,j=0;
		while(ifirst<first.length&&isecond<second.length){
			if(first[ifirst]<second[isecond]){
				arr[j]=first[ifirst];
				ifirst++;
			}else{
				arr[j]=second[isecond];
				isecond++;
			}
			j++;
		}
		System.arraycopy(first,  ifirst, arr, j, first.length-ifirst);
		System.arraycopy(second, isecond, arr, j, second.length-isecond);
		
	}
	public static void main(String[] args) {
		int[] a={1,7,55,88};
		int[] b={2,10,23,34};
		int[] z=new int[8];
		MergeSort ms=new MergeSort(z);
		ms.merge(a, b);
		for(int t:z){
			System.out.println(t);
		}
	}
}
