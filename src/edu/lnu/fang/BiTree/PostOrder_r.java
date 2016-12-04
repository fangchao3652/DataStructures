package edu.lnu.fang.BiTree;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import edu.lnu.fang.BiTree.BinTreeTra.Node;

public class PostOrder_r {
/**
 * ʹ�ø����ڵ�r ����������ʹ��Ľڵ�
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
					p = null; // �ڵ������� ����p
				}
			}
			/*
			 * //ջ��Ԫ�� System.out.print("ջ��Ԫ�أ�");
			 * 
			 * Iterator<Node> iterator= stack.iterator(); while
			 * (iterator.hasNext()){ //��ʾö�٣�stack �� �е�����Ԫ�� System.out.print(
			 * iterator.next().data+" "); }
			 */
		}
	}

	public static void main(String[] args) {
		Node root = BinTreeTra.init();
		System.out.println("�ǵݹ������� ���ø����ڵ�R��");
		PostOrder_r(root);
		System.out.println();
	}
}
