package com.zgh.algorithm.graph;

import java.util.Iterator;

public class DenseGraph extends Graph {

	boolean[][] g;

	public DenseGraph(int n, boolean directed) {
		super(n, directed);
		g = new boolean[n][n];
	}

	@Override
	public void addEdge(int v, int w) {
		if (hasEdage(v, w)) {
			return;
		}
		checkBunds(v, w);
		g[v][w] = true;
		if (!directed) {
			g[w][v] = true;
		}
		m++;

	}

	@Override
	public boolean hasEdage(int v, int w) {
		checkBunds(v, w);
		return g[v][w];
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
		// TODO Auto-generated method stub
		return new MyIterator(v, n);
	}

	@SuppressWarnings("unused")
	private class MyIterator implements Iterator<Integer> {

		int index = -1;
		boolean[] array;
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
		public Integer next() {
			for (index += 1; index < size; index++) {
				if (array[index]) {
					return index;
				}
			}
			return -1;
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
				if (g[i][j]) {
					buffer.append("1 ");
				} else {
					buffer.append("0 ");
				}
			}
			System.out.println(buffer.toString());
		}
	}

}
