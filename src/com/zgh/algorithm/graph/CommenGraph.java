package com.zgh.algorithm.graph;

import java.util.Arrays;
import java.util.Iterator;

public class CommenGraph {
	boolean[] readed;
	int[] ids;
	int count = 0;
	Graph graph;

	public CommenGraph(Graph graph) {
		this.graph = graph;
		int size = graph.getPointSize();
		readed = new boolean[size];
		ids = new int[size];
		for (int i = 0; i < size; i++) {
			ids[i] = i;
		}
		for (int i = 0; i < size; i++) {
			if (!readed[i]) {
				calcularCommen(i);
				count++;
			}
		}
	}

	/**
	 * 计算联通分量
	 * 
	 * @param graph2
	 */
	private void calcularCommen(int i) {
		if (readed[i]) {
			return;
		}
		readed[i] = true;
		ids[i] = count;
		Iterator<Integer> iterator = graph.getPostionIterator(i);
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			calcularCommen(integer);
		}
	}

	public int getCount() {
		return count;
	}

	public boolean isConnected(int a, int b) {
		return ids[a] == ids[b];
	}

	public void printConnectState() {
		System.out.println(Arrays.toString(ids));
	}
}
