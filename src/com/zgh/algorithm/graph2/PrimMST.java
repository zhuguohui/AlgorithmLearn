package com.zgh.algorithm.graph2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrimMST<W extends Comparable<W>> {
	Graph<W> graph;
	boolean[] market;
	IndexMinHeap<Edge<W>> heap;
	Edge<W>[] minEdgeArray;
	Set<Edge<W>> edgeSet = new HashSet<>();

	@SuppressWarnings("unchecked")
	public PrimMST(Graph<W> graph) {
		this.graph = graph;
		market = new boolean[graph.getPointSize()];
		heap = new IndexMinHeap<>(graph.getPointSize());
		minEdgeArray = new Edge[graph.getPointSize()];
		visit(0);
		while (!heap.isEmpty()) {
			Edge<W> edge = heap.getTop();
			edgeSet.add(edge);
			visit(edge.a);
			visit(edge.b);
		}
	}

	private void visit(int v) {
		if (market[v]) {
			return;
		}
		market[v] = true;
		Iterator<Edge<W>> iterator = graph.getPostionIterator(v);
		while (iterator.hasNext()) {
			Edge<W> edge = (Edge<W>) iterator.next();
			if (edge == null) {
				continue;
			}
			int w = edge.other(v);
			// 如果已经标记过，则不是横切边
			if (market[w]) {
				continue;
			}
			// 判断改边是否是最短的
			if (minEdgeArray[w] == null) {
				minEdgeArray[w] = edge;
				heap.insert(w, edge);
			} else if (minEdgeArray[w].compareTo(edge) > 0) {
				minEdgeArray[w] = edge;
				heap.change(w, edge);
			}

		}

	}

	public Iterator<Edge<W>> getMSTEdges() {
		return edgeSet.iterator();
	}

}
