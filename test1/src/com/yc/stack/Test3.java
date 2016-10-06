package com.yc.stack;
/**
 * 用两个栈实现一个队列
 * @author 张娅婷
 *
 */
public class Test3 {

}
//设计一个队列
class MyQueue<T>{
	private StackType stackNew=new StackType();
	private StackType stackOld=new StackType();
	public int size(){
		return stackNew.size()+stackOld.size();
	}
	//入队
	public void enqueue(T t){
		stackNew.push(t);
	}
	private void shiftStack(){
		if(stackOld.empty()){
			//循环操作，将新栈中的数据移到旧栈
			while(!stackNew.empty()){
				T t=(T) stackNew.pop();
				stackOld.push(t);
			}		
		}
	}
	//查看对头			
	public T peek(){//4  3
		shiftStack();
		return (T) stackOld.peek();
	}
	//出队
	public T dequeue(){
		shiftStack();
		return (T) stackOld.pop();
	}
}
