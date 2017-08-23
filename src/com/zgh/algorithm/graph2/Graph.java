package com.zgh.algorithm.graph2;

import java.util.Iterator;

public abstract class Graph<W extends Comparable<W>> {
	protected int n, m;
	protected boolean directed;

	public Graph(int n, boolean directed) {
		this.n = n;
		this.directed = directed;
		this.m = 0;
	}

	public int getPointSize() {
		return n;
	}

	public int getEdgeSize() {
		return m;
	}

	public abstract void addEdge(int v, int w,W weight);

	public abstract boolean hasEdage(int v, int w);

	public abstract Iterator<Edge<W>> getPostionIterator(int v);

	public abstract void show();
}
