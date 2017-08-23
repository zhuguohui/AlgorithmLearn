package com.zgh.algorithm.graph;

import java.util.Iterator;

public abstract class Graph {
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

	public abstract void addEdge(int v, int w);

	public abstract boolean hasEdage(int v, int w);

	public abstract Iterator<Integer> getPostionIterator(int v);
	
	public abstract void show();
}
