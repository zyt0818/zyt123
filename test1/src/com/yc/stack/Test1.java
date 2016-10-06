package com.yc.stack;

import javax.management.RuntimeErrorException;
/**
 * 只能用一个数组来实现三个栈的功能键
 * @author 张娅婷
 *
 */
public class Test1 {
	public static void main(String[] args) {
		MyStack ms=new MyStack();
		ms.push(100, 0);
		ms.push(200, 0);
		ms.push(100, 1);
		ms.push(200, 1);
		System.out.println(ms.size(0));
		System.out.println(ms.size(1));
		for(int i=0;i<2;i++){
			System.out.println(ms.pop(0));
		}
		System.out.println(ms.size(0));
	}

}
//特殊的栈，它里面有三个栈
class MyStack{
	int stackSize=10;
	int[] buffer=new int[stackSize*3];
	int[] stackPoint=new int[]{-1,-1,-1};
	
	public boolean empty(int stackNum){
		return stackPoint[stackNum]==-1;
	}
	public boolean isFull(int stackNum){

		return stackPoint[stackNum]==stackSize-1;
		
	}
	//清空
	public void clear(int stackNum ){
		stackPoint[stackNum]=-1;
	}
	/**
	 * 大小
	 * @param stackNum
	 * @return
	 */
	public int size(int stackNum){
		return stackPoint[stackNum]+1;
	}
	//入zhan
	public void push(int t,int stackNum){
		if(isFull(stackNum)){
			throw new RuntimeException("No."+stackNum+"stack is full");
		}
		stackPoint[stackNum]++;
		//计算当前这个栈的栈顶的绝对位置
		int index=stackNum*stackSize+stackPoint[stackNum];
		buffer[index]=t;
	}
	//出栈
	public int pop(int stackNum){
		if(empty(stackNum)){
			throw new RuntimeException("No."+stackNum+"stack is empty");

		}
		int index=stackNum*stackSize+stackPoint[stackNum];
		int result=buffer[index];
		stackPoint[stackNum]--;
		return result;
	}
	//出栈
		public int peek(int stackNum){
			if(empty(stackNum)){
				throw new RuntimeException("No."+stackNum+"stack is empty");

			}
			int index=stackNum*stackSize+stackPoint[stackNum];
			int result=buffer[index];
			//stackPoint[stackNum]--;
			return result;
		}
	
}
