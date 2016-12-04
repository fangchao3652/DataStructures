package edu.lnu.fang.BiTree;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import edu.lnu.fang.BiTree.BinTreeTra.Node;

public class PostOrder_r {
/**
 * 使用辅助节点r 保存最近访问过的节点
 * @param root
 */
	static void PostOrder_r(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		Node r = null;
		while (p != null || stack.size() > 0) {
			if (p != null) {
				stack.add(p);
				p = p.leftChild;
			} else {
				p = stack.peek();
				if (p.rightChild != null && p.rightChild != r) {
					p = p.rightChild;
					stack.add(p);
					p = p.leftChild;
				} else {
					p = stack.pop();
					BinTreeTra.printNode(p);
					r = p;
					p = null; // 节点访问完后 重置p
				}
			}
			/*
			 * //栈内元素 System.out.print("栈内元素：");
			 * 
			 * Iterator<Node> iterator= stack.iterator(); while
			 * (iterator.hasNext()){ //显示枚举（stack ） 中的所有元素 System.out.print(
			 * iterator.next().data+" "); }
			 */
		}
	}

	public static void main(String[] args) {
		Node root = BinTreeTra.init();
		System.out.println("非递归后序遍历 利用辅助节点R：");
		PostOrder_r(root);
		System.out.println();
	}
}
