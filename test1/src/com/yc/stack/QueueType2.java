package com.yc.stack;

import com.yc.datatype.LinkedListType;

public class QueueType2<T> {
	private LinkedListType<T> data=new LinkedListType<T>();
	private int head;//对头
	private int tail;//队尾
	public void init(){
		data=new LinkedListType<T>();
		head=0;
		tail=0;
		System.gc();
	}
	public boolean empty(){
		return head==tail;
	}
	public boolean isFull(){
		return tail==Integer.MAX_VALUE;
	}
	public void clear(){
		head=0;
		tail=0;
	}
	public boolean enqueue(T t){
		if(isFull()){
			throw new RuntimeException("queue is full");
		}
		//data[tail]=t;
		data.add(t);
		tail++;
		return true;
	}
	public Object dequeue(){
		if(empty()){
			throw new RuntimeException("queue is empty");
		}
		//T t=data[head];
		T t=data.get(head);
		head++;
		return t;
	}
	public Object peek(){
		if(empty()){
			throw new RuntimeException("queue is empty");
		}
		//Object t=data[head];
		T t=data.get(head);
		return t;
	}
	public int size(){
		return tail-head;
	}
	
	

}
