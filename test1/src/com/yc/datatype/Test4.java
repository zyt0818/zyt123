package com.yc.datatype;
/**
 * 不能使用任何一个排序算法，将一个数组排序输出
 * @author 张娅婷
 *
 */
public class Test4 {
	public static void main(String[] args) {
		int [] x=new int[]{4,7,1,9,22,55,900,30};
		//位图
		boolean[] bs=new boolean[901];
		for(int i=0;i<x.length;i++){
			int r=x[i];
			bs[r]=true;
		}
		for(int i=0;i<bs.length;i++){
			if(bs[i]==true){
				System.out.print(i+"\t");
			}
		}
	}

	
		
	
}
