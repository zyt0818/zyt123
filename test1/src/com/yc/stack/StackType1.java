package com.yc.stack;

import javax.management.RuntimeErrorException;

import com.yc.datatype.LinkedListType;

//栈
//后进先出
//应用：撤销   重做
//构造算术表达式
public class StackType1<T> {
	private static final int MAXLENGTH=100;
	//底层用数组 （也可以用链表）
	//private Object[] data=new Object[MAXLENGTH];
	private LinkedListType data=new LinkedListType();
	//记录栈顶的指针
	private int top;
	//初始化栈
	public void init(){
		top=0;
		//data=new Object[MAXLENGTH];
		data=new LinkedListType();
		System.gc();
	}
	public boolean empty(){
		return top==0?true:false;
	}
	public boolean isFull(){
		return top==MAXLENGTH;
	}
	//清空栈
	public void clear(){
		top=0;
	}
	//入zhan
	public T push(T t){
		if(isFull()){
			throw new RuntimeErrorException(null, "stack is full");
		}
		//data[top]=t;
		data.add(t);
		top++;
		return t;
	}
	
	//出战
	public T pop(){
		if(empty()){
			throw new RuntimeErrorException(null, "stack is empty");
		}
		--top;
		return (T) data.get(top);
		
	}
	//出战
		public T peek(){
			if(empty()){
				throw new RuntimeErrorException(null, "stack is empty");
			}
			
			return (T) data.get(top-1);
			
		}
		
	public int size(){
		return top;
	}
	public static void main(String[] args) {
		StackType1 st=new StackType1();
		st.push("a");
		st.push("b");
		st.push("c");
		System.out.println(st.size());
		System.out.println(st.peek());
		System.out.println(st.pop());
	}
}
