package com.zgh.algorithm.graph2;

import javax.xml.bind.annotation.W3CDomHandler;

public class Edge<W extends Comparable<W>> implements Comparable<Edge<W>> {
	int a, b;
	W w;

	public Edge(int a, int b, W w) {
		this.a = a;
		this.b = b;
		this.w = w;
	}

	public Edge() {

	}

	public int a() {
		return a;
	}

	public int b() {
		return b;
	}

	public W wt() {
		return w;
	}

	public int other(int x) {
		if (x != a && x != b) {
			throw new IllegalArgumentException(x + "不是边的端点之一" + toString());
		}
		return x == a ? b : a;
	}

	@Override
	public String toString() {

		return "[" + a + "" + "->" + b + ",w=" + w + "]";

	}

	@Override
	public int compareTo(Edge<W> o) {
		return w.compareTo(o.w);
	}

}
