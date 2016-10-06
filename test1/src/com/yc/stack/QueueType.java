package com.yc.stack;

public class QueueType {
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
	//入队
	public boolean enqueue(Object t){
		if(isFull()){
			
		}
		data[tail]=t;
		tail++;
		return true;
		
	}
	//https://github.com/zhangyingchengqi
	//1.给定几百w个文件，如何找出内容里面有某个词的文件?apple hadoop
	//出对
	public Object dequeue(){
		if(empty()){
			
		}
		Object t=data[head];
		head++;
		return t;
	}
	//出对
		public Object peek(){
			if(empty()){
				
			}
			Object t=data[head];
			return t;
		}
	public int size(){
		return tail-head;
	}

}
