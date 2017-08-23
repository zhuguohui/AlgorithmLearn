package com.zgh.algorithm.graph2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

 class LazyPrimMST<W extends Comparable<W>> {
	Graph<W> graph;
	Set<Edge<W>> edgeSet = new HashSet<>();
	boolean[] marked;
	MinHeap<Edge<W>> minHeap;

	public LazyPrimMST(Graph<W> graph) {
		this.graph = graph;
		marked = new boolean[graph.getPointSize()];
		minHeap = new MinHeap<>(graph.getEdgeSize() * 2);
		visit(0);
		while (!minHeap.isEmpty()) {
			Edge<W> edge = minHeap.getTop();
			if (marked[edge.a] && marked[edge.b]) {
				continue;
			}
			edgeSet.add(edge);
			visit(edge.a);
			visit(edge.b);
		}
	}

	private void visit(int v) {
		if (marked[v]) {
			return;
		}
		marked[v] = true;
		Iterator<Edge<W>> iterator = graph.getPostionIterator(v);
		while (iterator.hasNext()) {
			Edge<W> edge = (Edge<W>) iterator.next();
			// 如果这条边的另外一个顶点没有被访问
			// 说明是在交界线上，将边加入到最小堆
			if (edge != null && !marked[edge.other(v)]) {
				minHeap.insert(edge);
			}
		}
	}

	public Iterator<Edge<W>> getMSTEdges() {
		return edgeSet.iterator();
	}
}
