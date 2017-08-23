package com.zgh.algorithm.search;

import java.awt.Container;
import java.awt.image.RescaleOp;
import java.util.LinkedList;
import java.util.Queue;

import com.zgh.algorithm.search.TreePrintUtil.TreeNode;

/**
 * 二分搜索树
 * 
 * @author zhuguohui
 *
 */
public class BST<K extends Comparable<K>, V> {
	private int count;
	private Node<K, V> root;
	private int maxLevel;
	private Queue<Node<K, V>> queue = new LinkedList<>();

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(K k, V v) {
		Node<K, V> node = new Node<>(k, v);
		root = insertToNode(root, node);

	}

	public Node<K, V> getRoot() {
		return root;
	}

	public boolean contain(K key) {
		return search(key) != null;
	}

	public V search(K key) {
		Node<K, V> node = search(key, true);
		return node == null ? null : node.v;
	}

	private Node<K, V> search(K key, boolean withNode) {
		Node<K, V> currentNode = root;
		while (currentNode != null) {
			int reuslt = currentNode.k.compareTo(key);
			if (reuslt == 0) {
				return currentNode;
			} else if (reuslt > 0) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}

		}
		return null;
	}

	public void inOrder() {
		System.out.println("\n中序遍历");
		inOrder(getRoot());
	}

	private void inOrder(Node<K, V> node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.k + " ");
		inOrder(node.right);
	}

	public void scopeOrder() {
		queue.clear();
		queue.offer(getRoot());
		System.out.println("\r\n广度优先遍历");
		Node<K, V> currentNode = null;
		while ((currentNode = queue.poll()) != null) {
			System.out.print(currentNode.k + " ");
			if (currentNode.left != null) {
				queue.offer(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.offer(currentNode.right);
			}
		}
	}

	public K miniKey() {
		Node<K, V> miniNode = miniKey(root, true);
		return miniNode == null ? null : miniNode.k;
	}

	private Node<K, V> miniKey(Node<K, V> currentNode, boolean withNode) {
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode == null ? null : currentNode;
	}

	public K maxKey() {
		Node<K, V> currentNode = root;
		while (currentNode.right != null) {
			currentNode = currentNode.right;
		}

		return currentNode == null ? null : currentNode.k;
	}

	public void removeMin() {
		root = removeMin(root);
	}

	@SuppressWarnings("unchecked")
	private Node<K, V> removeMin(Node<K, V> currentNode) {
		if (currentNode.left == null) {
			return currentNode.right;
		} else {
			currentNode.left = removeMin(currentNode.left);
			return currentNode;
		}
	}

	public void removeMax() {
		root = removeMax(root);
	}

	@SuppressWarnings("unchecked")
	private Node<K, V> removeMax(Node<K, V> currentNode) {
		if (currentNode.right == null) {
			return currentNode.left;
		} else {
			currentNode.right = removeMax(currentNode.right);
			return currentNode;
		}

	}

	public void delete(K key) {
		root = delete(root, key);

	}

	@SuppressWarnings("unchecked")
	private Node<K, V> delete(Node<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		int result = node.k.compareTo(key);
		if (result > 0) {
			node.left = delete(node.left, key);
			return node;
		} else if (result < 0) {
			node.right = delete(node.right, key);
			return node;
		} else {
			Node<K, V> successorNode = miniKey(node.right, true);
			successorNode.right = removeMin(node.right);
			successorNode.left = node.left;
			return successorNode;
		}

	}

	public void postOrder() {
		System.out.println("\r\n后序遍历");
		postOrder(getRoot());
	}

	private void postOrder(Node<K, V> node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.k + " ");
		}
	}

	/**
	 * 
	 * @param parint
	 * @param node
	 * @return 如果新增返回true，如果只是更新返回false
	 */
	@SuppressWarnings("unchecked")
	private Node<K, V> insertToNode(Node<K, V> parent, Node<K, V> node) {
		if (parent == null) {
			count++;
			return node;
		}
		if (parent.k.compareTo(node.k) == 0) {
			// key相同则更新
			parent.v = node.v;

		} else if (parent.k.compareTo(node.k) < 0) {
			parent.right = insertToNode(parent.right, node);
		} else {
			parent.left = insertToNode(parent.left, node);
		}

		return parent;

	}

	private static class Node<K extends Comparable<K>, V> implements TreeNode {
		K k;
		V v;
		Node left, right;

		public Node(K k, V v) {
			this.k = k;
			this.v = v;
		}

		@Override
		public String toString() {
			return "[" + k + "]";
		}

		@Override
		public String getPrintInfo() {

			return toString();
		}

		@Override
		public TreeNode getLeftChild() {
			// TODO Auto-generated method stub
			return left;
		}

		@Override
		public TreeNode getRightChild() {
			// TODO Auto-generated method stub
			return right;
		}

	}
}
