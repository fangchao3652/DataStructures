package edu.lnu.fang.BiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.lnu.fang.BiTree.BinTreeTra.Node;

/**
 * �����Ŀ��
 * 
 * @author Fangchao 2016��12��4��
 */
public class BiTreeWidth {

	int [] L=new int[100000];
	/**
	 * �ǵݹ鷽��
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
		L[rear]=1;//��һ���ڵ�Ĳ����1
		Node p;
		while(front<rear){
			p=queue[++front];
			if(p.leftChild!=null){
				queue[++rear]=p.leftChild;
				L[rear]=level+2;
				
			}
			if(p.rightChild!=null){
				queue[++rear]=p.rightChild;
				L[rear]=level+2;
			}
			if(front==last){
				level++;
				last=rear;
			}
		}
		int n=0;//ÿ����
		int m=0;//�����
		int i=0;
		for(int k=1;k<=level;k++){
			n=0;
			for(;L[i]==k;i++){
				n++;
			}
			if(n>m){
				m=n;
			}
		}
		
		
		return m;
	}

	public static void main(String[] args) {
		Node root = BinTreeTra.init();
		System.out.println(btwidth(root));
	}
}
