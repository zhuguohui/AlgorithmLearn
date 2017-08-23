package com.zgh.algorithm.search;

public class Demo2 {
	public static void main(String[] args) {
		BST<Integer, String> bst = new BST<>();
		bst.insert(10, "a");
		bst.insert(12, "b");
		bst.insert(3, "d");
		bst.insert(9, "cdd");
		bst.insert(33, "cff");
		bst.insert(38, "ceee");
		bst.insert(1, "aaaa");
		bst.insert(0, "dddd");
		bst.insert(99, "dddd");
		bst.insert(100, "dddd");
		bst.insert(7, "dddd");
		bst.insert(1, "dddd");
		// 从根开始打印
		TreePrintUtil.pirnt(bst.getRoot());
		System.out.println("删除元素10");
		bst.delete(10);
		TreePrintUtil.pirnt(bst.getRoot());
		System.out.println("删除元素3");
		bst.delete(3);
		TreePrintUtil.pirnt(bst.getRoot());
	}
}
