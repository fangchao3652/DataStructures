package edu.lnu.fang.BiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * �����������ֱ��� �ݹ� �ǵݹ� +��α���
 * 
 * @author Fangchao 2016��12��3��
 */
public class BinTreeTra {
	private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16 };
	static List<Node> nodeList = null;

	/**
	 * �ڲ��ࣺ�ڵ�
	 */
	public static class Node {
		Node leftChild;
		Node rightChild;
		int data;

		Node(int newData) {
			leftChild = null;
			rightChild = null;
			data = newData;
		}
	}

	public void createBinTree() {
		nodeList = new LinkedList<Node>();
		// ��һ�������ֵ����ת��ΪNode�ڵ�
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new Node(array[nodeIndex]));
		}
		// ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// ����
			nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
			// �Һ���
			nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
		}
		// ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������
		int lastParentIndex = array.length / 2 - 1;
		// ����
		nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
		// �Һ���,�������ĳ���Ϊ�����Ž����Һ���
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
		}
	}

	/**
	 * �������
	 * 
	 * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������
	 * 
	 * @param node
	 *            �����Ľڵ�
	 */
	public static void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}

	/**
	 * �������
	 * 
	 * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������
	 * 
	 * @param node
	 *            �����Ľڵ�
	 */
	public static void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.leftChild);
		System.out.print(node.data + " ");
		inOrderTraverse(node.rightChild);
	}

	/**
	 * �������
	 * 
	 * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������
	 * 
	 * @param node
	 *            �����Ľڵ�
	 */
	public static void postOrderTraverse(Node node) {
		if (node == null)
			return;

		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.print(node.data + " ");
	}

	// ��ӡ�ڵ���ֵ
	public static void printNode(Node node) {
		System.out.print(node.data + " ");
	}

	/**
	 * �ǵݹ��������
	 * 
	 * @param root
	 */
	public static void preOrder_stack(Node root) {// �������

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null || stack.size() > 0) {// ����������ѹջ
			if (node != null) {// ѹջ֮ǰ�ȷ���
				printNode(node);
				stack.push(node);
				node = node.leftChild;

			} else {
				node = stack.pop();
				node = node.rightChild;
			}
		}
	}

	/**
	 * �ǵݹ� �������
	 * 
	 * @param root
	 */
	public static void inOrder_stack(Node root) {// zhong�����

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null || stack.size() > 0) {// ����������ѹջ
			if (node != null) {// ѹջ֮ǰ�ȷ���

				stack.push(node);
				node = node.leftChild;

			} else {
				node = stack.pop();
				printNode(node);
				node = node.rightChild;
			}
		}
	}

	/**
	 * �ǵݹ�� ��������
	 * 
	 * @param root
	 */
	public static void postOrder_Stack(Node root) {// ��������

		Stack<Node> stack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();// ����һ���м�ջ���洢����������Ľ��
		Node node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				output.push(node);
				stack.push(node);
				node = node.rightChild;
			} else {
				node = stack.pop();
				node = node.leftChild;
			}
		}

		while (output.size() > 0) {
			printNode(output.pop());
		}

	}

	/**
	 * ʹ�ø�����r ��¼������ʹ��Ľ��
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
					printNode(p);
					r = p;
					p = null; // �ڵ������� ����p
				}
			}
		}
	}

	/**
	 * ��α���
	 * 
	 * @param root
	 */
	static void LevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			Node p = queue.poll();
			printNode(p);
			if (p.leftChild != null) {
				queue.add(p.leftChild);
			}

			if (p.rightChild != null) {
				queue.add(p.rightChild);
			}
		}
	}

	static Node init() {
		BinTreeTra binTree = new BinTreeTra();
		binTree.createBinTree();
		// nodeList�е�0����������ֵ��Ϊ���ڵ�
		Node root = nodeList.get(0);
		return root;
	}

	public static void main(String[] args) {

		Node root = init();

		System.out.println("���������");
		preOrderTraverse(root);
		System.out.println();

		System.out.println("���������");
		inOrderTraverse(root);
		System.out.println();

		System.out.println("���������");
		postOrderTraverse(root);
		System.out.println();

		System.out.println("�ǵݹ� ���������");
		preOrder_stack(root);
		System.out.println();

		System.out.println("�ǵݹ� ���������");
		inOrder_stack(root);
		System.out.println();

		System.out.println("�ǵݹ���������");
		postOrder_Stack(root);
		System.out.println();
		System.out.println("�ǵݹ������� ���ø����ڵ�R��");
		PostOrder_r(root);
		System.out.println();
		System.out.println("��� ������");
		LevelOrder(root);
		System.out.println();
	}
}
