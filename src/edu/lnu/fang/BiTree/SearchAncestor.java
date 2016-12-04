package edu.lnu.fang.BiTree;

import java.util.Iterator;
import java.util.Stack;

import edu.lnu.fang.BiTree.BinTreeTra.Node;

public class SearchAncestor {
	static void printS(Stack S) {
		Iterator<Node> iterator = S.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().data + " ");
		}
	}
/**
 * Ѱ��ֵΪx�Ľڵ����������
 * @param root
 * @param x
 */
	static void search(Node root, int x) {
		Stack<Node> S = new Stack<Node>();
		Node p = root;
		Node r = null;

		while (p != null || S.size() > 0) {
			if (p != null) {
				S.add(p);
				p = p.leftChild;
				
			} else {
				p = S.peek();
				if (p.rightChild != null && p.rightChild != r) {
					p = p.rightChild;
					S.add(p);
					p = p.leftChild;
				} else {
					p = S.pop();
					if(p.data==x){
						printS(S);
						return;
					}
					//BinTreeTra.printNode(p);
					r = p;
					p = null;
				}
			}
		}
	}

	public static void main(String[] args) {
		Node root = BinTreeTra.init();
		search(root,16);
		 
	}
}
