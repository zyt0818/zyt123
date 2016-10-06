package com.yc.datatype;

import java.util.Hashtable;

/**
 * 移除没有排序的链表中重复的节点
 * @author 张娅婷
 *
 */
public class Test1 {
	public static void main(String[] args) {
		LinkedListType llt=new LinkedListType();
		llt.add(1);
		llt.add(2);
		llt.add(3);
		llt.add(4);
		llt.add(2);
		llt.add(1);
		delete2(llt);
		llt.showAllNode();
	}
	//使用快慢行指针的方法案来实现
	private static void delete2(LinkedListType llt){
		if(llt==null){
			throw new RuntimeException("linkedList should not be null");
		}
		LinkedListType p1=llt;
		while(p1!=null){
			LinkedListType p2=p1;
			while(p2.nextNode!=null){
				if(p2.nextNode.t.equals(p1.t)){
					p2.nextNode=p2.nextNode.nextNode;
				}else{
					p2=p2.nextNode;
				}
			}
			p1=p1.nextNode;
			
		}
		
	}
	//以空间换时间
	//HashTable
	private static void delete1(LinkedListType llt){
		Hashtable ht=new Hashtable();
		LinkedListType previous=null;
		if(llt==null){
			throw new RuntimeException("linkedList should not be null");

		}
		llt=llt.nextNode;
		while(llt!=null){
			if(ht.containsKey(llt.t)){
				previous.nextNode=llt.nextNode;
			}else{
				ht.put(llt.t, true);
				previous=llt;
			}
			llt=llt.nextNode;
		}
	}
}
