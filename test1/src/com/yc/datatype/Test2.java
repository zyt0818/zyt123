package com.yc.datatype;

public class Test2 {
	public static void main(String[] args) {
		LinkedListType llt=new LinkedListType();
		llt.add(1000);
		llt.add(222);
		LinkedListType node=partition(llt, 300);
		node.showAllNode();
	}
	/**
	 * 以给定值x为基准，将链表分为两个部分，所有小于x的节点都排在大于或等于x的节点
	 */
	/**
	 * 解决方案：创建两个子链表，一个链表存所有小于x的节点，另一个链表存所有大于x的节点
	 * 循环原链表，将每个节点插入到这两个子链表中，最后再合并两个链表
	 * 
	 */
	private static LinkedListType partition(LinkedListType head,Comparable x){
		LinkedListType beforeStart=null;
		LinkedListType afterStart=null;
		head=head.nextNode;
		while(head!=null){
			LinkedListType next=head.nextNode;
			if(x.compareTo(head.t)>0){
				head.nextNode=beforeStart;
				beforeStart=head;
			}else{
				head.nextNode=afterStart;
				afterStart=head;
			}
			head=next;
			
		}
		if(beforeStart==null){
			return afterStart;
		}
		LinkedListType newHead=new LinkedListType();
		newHead.nextNode=beforeStart;
		while(beforeStart.nextNode!=null){
			beforeStart=beforeStart.nextNode;
		}
		beforeStart.nextNode=afterStart;
		return newHead;
	}
}
