package edu.lnu.fang.BiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.lnu.fang.BiTree.BinTreeTra.Node;

/**
 * 求树的宽度
 * 
 * @author Fangchao 2016年12月4日
 */
public class BiTreeWidth {

	 
	/**
	 * 非递归方法
	 *  
	 * @param root
	 * @return
	 */
	static int btwidth(Node root) {
		int front = -1, rear = -1;
		int last = 0, level = 0;
		Node[] queue = new Node[100000];
		int [] L=new int[100000];//
		if (root == null) {
			return 0;
		}
		queue[++rear]=root;
		L[++rear]=1;//第一个节点的层次是1
		Node p;
		while(front<rear){
			p=queue[++front];
			if(p.leftChild!=null){
				queue[++rear]=p.leftChild;
				
			}
			if(p.rightChild!=null){
				queue[++rear]=p.rightChild;
			}
			if(front==last){
				level++;
				last=rear;
			}
		}
		return level;
	}

	public static void main(String[] args) {
		Node root = BinTreeTra.init();
		 
	}
}
