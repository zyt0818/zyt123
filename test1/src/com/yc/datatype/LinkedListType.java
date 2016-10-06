package com.yc.datatype;

import javax.management.RuntimeErrorException;

//单链表：它是一个对象，这个对象中有两个元素，存真实对象，另一个元素是一个节点的引用
public class LinkedListType<T> {
	public T t;// 存的元素
	public LinkedListType<T> nextNode;// 下一个节点

	public int size() {
		int size = 0;
		LinkedListType llt = this;
		while (llt != null) {
			size++;
			llt = llt.nextNode;
		}
		return size - 1;
	}

	public void add(T t) {
		if (t == null) {
			throw new IllegalArgumentException("argument should not be null");
		}
		LinkedListType newNextNode = new LinkedListType();
		if (newNextNode == null) {
			throw new RuntimeException("there is no enough memery space");
		}
		newNextNode.t = t;
		newNextNode.nextNode = null;
		// 循环查找 this
		LinkedListType temp = this;
		while (temp.nextNode != null) {
			temp = temp.nextNode;
		}
		temp.nextNode = newNextNode;

	}

	// 将t做为头节点添加

	public LinkedListType addFirst(T t) {
		LinkedListType newNextNode = new LinkedListType();
		if (newNextNode == null) {
			throw new RuntimeException("there is no enough memery space");
		}
		this.t = t;
		newNextNode.t = null;
		newNextNode.nextNode = this;
		return newNextNode;
	}

	public void addLast(T t) {
		add(t);

	}

	public LinkedListType remove(T t) {
		// 快行指针
		LinkedListType temp = this.nextNode;
		LinkedListType pre = null;// 上一个节点
		while (temp != null) {
			
			if (temp.t.equals(t)) {
				// 这个temp是要删除的节点
				break;
			}
			pre = temp;
			temp = temp.nextNode;
		}
		// 当temp为空时，pre是倒数第二个节点
		pre.nextNode = temp.nextNode;
		return this;
	}

	public LinkedListType removeFirst() {
		LinkedListType newHead = this.nextNode;
		return newHead;
	}

	public LinkedListType removeLast() {
		// 快行指针
		LinkedListType temp = this;
		LinkedListType pre = null;// 上一个节点
		while (temp.nextNode != null) {
			
			pre = temp;
			temp = temp.nextNode;
		}
		// 当temp为空时，pre是倒数第二个节点
		pre.nextNode = null;
		return this;
	}

	public T get(int index) {
		int i=-1;
		LinkedListType temp=this;
		while(temp!=null){
			if(i==index){
				return (T) temp.t;
			}
			i++;
			temp=temp.nextNode;
		}
		throw new RuntimeErrorException(null, "out of bounds exception");
	}
	public void showAllNode(){
		LinkedListType temp=this;
		int length=size();
		System.out.println("本链表总长："+length);
		while(temp!=null){
			temp=temp.nextNode;
			if(temp!=null){
				System.out.println(temp.t);
			}
		}
	}

	public static void main(String[] args) {
		LinkedListType llt = new LinkedListType();
		llt.add(1);
		llt.add(2);
		llt.add(3);
		/*llt.showAllNode();
		System.out.println(llt.get(0));
		llt=llt.addFirst(-8);
		llt.addLast(100);
		llt.showAllNode();
		System.out.println();
		llt=llt.removeFirst();
		llt=llt.removeLast();
		llt.showAllNode();*/
		llt=llt.remove(2);
		llt.showAllNode();
		
	}

}
