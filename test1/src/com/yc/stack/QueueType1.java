package com.yc.stack;

public class QueueType1 {
	private static final int MAXLEN=100;
	private Object[] data=new Object[MAXLEN];
	private int head;//对头
	private int tail;//队尾
	public void init(){
		data=new Object[MAXLEN];
		head=0;
		tail=0;
		System.gc();
	}
	public boolean empty(){
		return head==tail;
	}
	public boolean isFull(){
		return tail==MAXLEN;
	}
	public void clear(){
		head=0;
		tail=0;
	}
	public boolean enqueue(Object t){
		if(isFull()){
			throw new RuntimeException("queue is full");
		}
		data[tail]=t;
		tail++;
		return true;
	}
	public Object dequeue(){
		if(empty()){
			throw new RuntimeException("queue is empty");
		}
		Object t=data[head];
		head++;
		return t;
	}
	public Object peek(){
		if(empty()){
			throw new RuntimeException("queue is empty");
		}
		Object t=data[head];
		return t;
	}
	public int size(){
		return tail-head;
	}
	
	

}
