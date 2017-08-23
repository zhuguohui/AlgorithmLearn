package com.zgh.algorithm.graph2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.zgh.algorithm.uf.UninFind6;

public class KruskalMST<W extends Comparable<W>> {
	Graph<W> graph;
	Set<Edge<W>> edges = new HashSet<>();
	MinHeap<Edge<W>> heap;
	UninFind6 uf;

	public KruskalMST(Graph<W> graph) {
		this.graph = graph;
		heap = new MinHeap<>(graph.getEdgeSize() * 2);
		uf = new UninFind6(graph.getPointSize());
		// 排序所有边
		for (int i = 0; i < graph.getPointSize(); i++) {
			Iterator<Edge<W>> iterator = graph.getPostionIterator(i);
			while (iterator.hasNext()) {
				Edge<W> edge = (Edge<W>) iterator.next();
				if (edge != null) {
					heap.insert(edge);
				}
			}
		}
		//
		int maxEdge = graph.getPointSize() - 1;
		while (!heap.isEmpty() && edges.size() < maxEdge) {
			Edge<W> edge = heap.getTop();
			// 如果形成环则丢弃
			if (uf.isConnected(edge.a, edge.b)) {
				continue;
			}
			// 添加到最小边
			edges.add(edge);
			uf.unin(edge.a, edge.b);
		}
	}

	public Iterator<Edge<W>> getMSTEdges() {
		return edges.iterator();

	}
}
