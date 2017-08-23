package com.zgh.algorithm.graph2;

import java.util.Iterator;

public class DenseGraph<W extends Comparable<W>> extends Graph<W> {

	Edge<W>[][] g;

	@SuppressWarnings("unchecked")
	public DenseGraph(int n, boolean directed) {
		super(n, directed);
		g = new Edge[n][n];
	}

	@Override
	public void addEdge(int v, int w, W weight) {
		if (hasEdage(v, w)) {
			return;
		}
		checkBunds(v, w);
		g[v][w] = new Edge<W>(v, w, weight);
		if (!directed) {
			g[w][v] = new Edge<W>(v, w, weight);
		}
		m++;

	}

	@Override
	public boolean hasEdage(int v, int w) {
		checkBunds(v, w);
		return g[v][w] != null;
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
		// TODO Auto-generated method stub
		return new MyIterator(v, n);
	}

	@SuppressWarnings("unused")
	private class MyIterator implements Iterator<Edge<W>> {

		int index = -1;
		Edge<W>[] array;
		int size;

		public MyIterator(int v, int size) {
			checkBunds(v);
			array = g[v];
			this.size = size;
		}

		@Override
		public boolean hasNext() {
			// System.out.println("hasNext index="+index+" size="+size);
			return index < size;
		}

		@Override
		public Edge<W> next() {
			for (index += 1; index < size; index++) {
				if (array[index] != null) {
					return array[index];
				}
			}
			return null;
		}

		@Override
		public void remove() {
		}

	}

	@Override
	public void show() {
		for (int i = 0; i < n; i++) {
			StringBuffer buffer = new StringBuffer();
			for (int j = 0; j < n; j++) {
				if (g[i][j] != null) {
					buffer.append(g[i][j].wt()+" ");
				} else {
					buffer.append("NULL ");
				}
			}
			System.out.println(buffer.toString());
		}
	}

}
