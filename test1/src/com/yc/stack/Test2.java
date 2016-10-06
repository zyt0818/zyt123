package com.yc.stack;
/**
 * 设计一个栈,这个栈中提供特殊的两个功能,min(),得到栈中最小的值
 * max(),得到栈中最大的值
 * 解决方案：新建一个栈对象,让继承StackType，另外扩展两个方法,min(),max()
 * 还要在这个新对象增加两个StackType,一个存最大值,一个存最小值
 * @author 张娅婷
 *
 */
public class Test2 {

}
class MyStackType<T> extends StackType<T>{
	private StackType<T> min=new StackType<T>();
	private StackType<T> max=new StackType<T>();
	//重写入栈的功能，提供了最大，最小值的判断
	public T push(T t){
		if(isFull()){
			throw new RuntimeException("stack is full");
		}
		if(super.empty()){
			min.push(t);
			max.push(t);
		}else{
			//判断当前这个新的t是否为最大值
			T maxT=max.peek();
			if(((Comparable)maxT).compareTo(t)<=0){
				//t大，将t压栈到max中
				max.push(t);
			}
			T minT=min.peek();
			if(((Comparable)minT).compareTo(t)>=0){
				min.push(t);
			}
		}
		return super.push(t);
	}
	//重写出栈，将最大值或最小值移除
	public T pop(){
		//是否清空
		if(empty()){
			throw new RuntimeException("stack is empty");
		}
		T t=super.pop();
		//查看t是最大值还是最小值
		T maxT=max.peek();
		if(((Comparable)maxT).compareTo(t)==0){
			max.pop();
		}
		T minT=min.peek();
		if(((Comparable)minT).compareTo(t)==0){
			min.pop();
		}
		return t;
	}
	public T min(){
		if(min.empty()){
			throw new RuntimeException("there is no element in min stack");
		}
		return min.peek();
	}
	public T max(){
		if(max.empty()){
			throw new RuntimeException("there is no element in min stack");
		}
		return max.peek();
	}
}
