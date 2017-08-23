package com.zgh.algorithm.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SparseGraph extends Graph {
	HashSet<Integer>[] g;

	public SparseGraph(int n, boolean directed) {
		super(n, directed);
		g = new HashSet[n];
		for (int i = 0; i < n; i++) {
			g[i] = new HashSet<Integer>();
		}
	}

	@Override
	public void addEdge(int v, int w) {
		if (hasEdage(v, w)) {
			return;
		}
		checkBunds(v, w);
		g[v].add(w);
		if (v != w && !directed) {
			g[w].add(v);
		}
		m++;

	}

	@Override
	public boolean hasEdage(int v, int w) {
		checkBunds(v, w);
		Set set = g[v];
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			if (integer == w) {
				return true;
			}
		}
		return false;
	}

	public void checkBunds(int... indexs) {
		for (int i = 0; i < indexs.length; i++) {
			if (i < 0 || i >= n) {
				throw new IndexOutOfBoundsException();
			}
		}
	}

	@Override
	public Iterator<Integer> getPostionIterator(int v) {
		checkBunds(v);
		return g[v].iterator();
	}

	@Override
	public void show() {
		for (int i = 0; i < n; i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(i+":");
			Iterator<Integer> iterator = getPostionIterator(i);
			while (iterator.hasNext()) {
				Integer integer = (Integer) iterator.next();
				buffer.append(integer + " ");
			}
			System.out.println(buffer);
		}

	}

}
