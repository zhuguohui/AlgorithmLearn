package com.zgh.algorithm.graph2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SparseGraph<W extends Comparable<W>> extends Graph<W> {
	HashSet<Edge<W>>[] g;

	public SparseGraph(int n, boolean directed) {
		super(n, directed);
		g = new HashSet[n];
		for (int i = 0; i < n; i++) {
			g[i] = new HashSet<Edge<W>>();
		}
	}

	@Override
	public void addEdge(int v, int w, W weight) {
		if (hasEdage(v, w)) {
			return;
		}
		checkBunds(v, w);
		g[v].add(new Edge<W>(v, w, weight));
		if (v != w && !directed) {
			g[w].add(new Edge<W>(v, w, weight));
		}
		m++;

	}

	@Override
	public boolean hasEdage(int v, int w) {
		checkBunds(v, w);
		Set set = g[v];
		Iterator<Edge<W>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Edge<W> edge = iterator.next();
			if (edge.other(v) == w) {
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
	public Iterator<Edge<W>> getPostionIterator(int v) {
		checkBunds(v);
		return g[v].iterator();
	}

	@Override
	public void show() {
		for (int i = 0; i < n; i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(i + ":");
			Iterator<Edge<W>> iterator = getPostionIterator(i);
			while (iterator.hasNext()) {
				buffer.append(iterator.next() + " ");
			}
			System.out.println(buffer);
		}

	}

}
