package com.yc.array;
/**
 * 给定两个排序后的数组a和数组b,其中a的末端有足够的空间来存b,编写一个方法，将b合并入a并排序
 * 解决方案：从数组的最后开始比较，将最大的元素放到数组a的最后
 * @author 张娅婷
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[] x=new int[]{2,4,7,99,100,200,0,0,0,0,0};
		int[] y={3,6,8,9,220};
		merge(x,y,6,5);
	}
	/**
	 * 合并
	 * @param x：第一个排序数组
	 * @param y：第二个排序数组
	 * @param i：第一个数组的有效数据的长度
	 * @param j：第二个数组的有效数据的长度
	 */
	private static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA=lastA-1;//5
		int indexB=lastB-1;//4
		int indexmerged=lastA+lastB-1;//合并后最后元素的索引   10
		while(indexA>=0&&indexB>=0){
			if(a[indexA]>b[indexB]){
				a[indexmerged]=a[indexA];
				indexmerged--;
				indexA--;
				
			}else{
				a[indexmerged]=b[indexB];
				indexmerged--;
				indexB--;
			}
		}
		while(indexB>=0){
			a[indexmerged]=b[indexB];
			indexmerged--;
			indexB--;
		}
	}

}
