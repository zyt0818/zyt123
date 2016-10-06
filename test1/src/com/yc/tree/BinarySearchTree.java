package com.yc.tree;

import javax.lang.model.element.Element;

public class BinarySearchTree {
	protected BinaryNode root;
	public BinarySearchTree(){
		this.root=null;
	}
	/**
	 * 判断是否为数
	 * @return
	 */
	public boolean isEmpty(){
		return root==null;
	}
	/**
	 * 将树置空
	 */
	public void makeEmpty(){
		root=null;
	}
	/**
	 * 查找树中的最大值
	 */
	public Comparable findMax(){
		BinaryNode maxNode=findMax(root);
		return maxNode.element;
	}
	/**
	 * 最大值所在的节点的特点：这个节点是没有右节点的
	 * @param root
	 * @return
	 */
	protected BinaryNode findMax(BinaryNode root){
		if(root!=null){
			while(root.right!=null){
				root=root.right;
			}
		}
		return root;
	}
	/**
	 * 查找树中的最小值
	 */
	public Comparable findMin(){
		BinaryNode minNode=findMin(root);
		return minNode.element;
	}
	/**
	 * 最小值所在的节点的特点: 这个节点是没有左节点的
	 */
	private BinaryNode findMin(BinaryNode t){
		if(t!=null){
			while(t.left!=null){
				t=t.left;
			}
		}
		return t;
	}
	
	/**
	 * 递归实现查找元素在树中的节点的元素
	 */
	
	public Comparable find(Comparable element){
		BinaryNode node=find(element,root);
		return node==null?null:node.element;
	}
	private BinaryNode find(Comparable element, BinaryNode root) {
		if(root==null){
			return null;
		}
		if(element.compareTo(root.element)<0){
			return find(element,root.left);
		}else if(element.compareTo(root.element)>0){
			return find(element,root.right);
		}else{
			return root;
		}
		
	}
	/**
	 * 非递归实现查找元素在树中的节点的元素(效率更高)
	 */
	public Comparable iterativeFind(Comparable element){
		BinaryNode node=iterativeFind(element,root);
		return node==null?null:node.element;
	}
	private BinaryNode iterativeFind(Comparable element, BinaryNode root) {
		while(root!=null){
			int cmp=element.compareTo(root.element);
			if(cmp<0){
				root=root.left;
			}else if(cmp>0){
				root=root.right;
			}else{
				return root;
			}
		}
		return root;
	}
	/**
	 * 添加操作
	 * 1.查找要添加的位置 2.添加进去
	 */
	public void insert(Comparable element){
		root=insert(element,root);
	}
	private BinaryNode insert(Comparable element, BinaryNode root) {
		if(root==null){
			root=new BinaryNode(element, null, null);
		}else if(element.compareTo(root.element)<0){
			BinaryNode newNode=insert(element,root.left);
			root.left=newNode;
		}else if(element.compareTo(root.element)>0){
			BinaryNode newNode=insert(element,root.right);
			root.right=newNode;
		}
		return root;
	}
	/**
	 * 删除操作：1.找位置
	 * @param args
	 */
	public void remove(Comparable element){
		root=remove(element,root);
	}
	private BinaryNode remove(Comparable element, BinaryNode root) {
		if(root==null){
			return root;
		}
		if(element.compareTo(root.element)<0){
			BinaryNode newNode=remove(element,root.left);
			root.left=newNode;
		}else if(element.compareTo(root.element)>0){
			BinaryNode newNode=remove(element,root.right);
			root.right=newNode;
		}else if(root.left!=null&&root.right!=null){
			//root是当前要删除的节点，且左子树与右子树都不能为空
			//从右子树中查找最小的值
			root.element=(findMin(root.right)).element;
			root.right=remove(root.element, root.right);
		}else{
			root=root.left!=null?root.left:root.right;
		}
		
		return root;
	}
	/**
	 * 先序遍历，先访问根节点然后遍历左子树，最后遍历右子树。在遍历左、右子树时，仍然先访问根结点，然后遍历左子树，最后遍历右子树
	 * @param args
	 */
	public void printTreePreOrder(){
		printTreePreOrder(this.root);
	}
	private void printTreePreOrder(BinaryNode root) {
		if(root!=null){
			System.out.println(root.element);
			printTreePreOrder(root.left);
			printTreePreOrder(root.right);
		}
		
	}
	/**
	 * 中序遍历树：首先遍历左子树，然后访问跟节点，最后遍历右子树。在遍历左、右子树时，仍然先遍历左子树，再访问根结点，最后遍历右子树, 若二叉树为空则结束返回
	 * 
	 * @param args
	 */
	public void printTreeInOrder(){
		printTreeInOrder(this.root);
	}
	private void printTreeInOrder(BinaryNode root) {
		if(root!=null){
			printTreeInOrder(root.left);
			System.out.println(root.element+" ");
			printTreeInOrder(root.right);
		}
		
	}
	/**
	 * 后序遍历: 先遍历左子树，然后遍历右子树，最后访问根结点，在遍历左、右子树时，仍然先遍历左子树，然后遍历右子树，最后遍历根结点。若二叉树为空则结束返回
	 */
	public void printTreePostOrder(){
		printTreePostOrder( this.root );
	}
	private void printTreePostOrder(   BinaryNode root    ){
		if(root!=null){
			printTreePostOrder( root.left );
			printTreePostOrder( root.right);
			System.out.print(  root.element+" "  );
		}
	}

	/**
	 * 输出二叉树的层次结构
	 */
	public void print(){
		if( root!=null){
			print( root, root.element, 0);
		}
	}
	/**
	 * 
	 * @param root
	 * @param element
	 * @param side:   0表示该节点是根节点    -1表示它是它的父节点的左孩子,     1 表示它是它的父节点的右孩子
	 */
	private void print(BinaryNode root, Comparable element,int side){
		if( root!=null){
			if( side==0 ){
				System.out.println(   root.element+" 是根节点 \n");
			}else{
				System.out.println(  root.element+"是"+element+"的"+  (side==1?"右":"左")+"孩子" );
			}
			print( root.left,root.element,-1);
			print( root.right, root.element, 1);
		}
	}
	

	
	
	public static void main(String[] args) {
		BinarySearchTree root=new BinarySearchTree();
		root.insert(3);
		root.insert(4);
		root.insert(10);
	}
}
