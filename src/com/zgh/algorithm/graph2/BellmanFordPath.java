package com.zgh.algorithm.graph2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.zgh.algorithm.graph2.DijkstraPath.AddListener;

public class BellmanFordPath<W extends Comparable<W>> {
	Object[] distTo;
	Graph<W> graph;
	AddListener<W> addListener;
	Edge<W>[] from;
	private boolean hasNegativeCycle;
	int s;

	@SuppressWarnings("unchecked")
	public BellmanFordPath(Graph<W> graph, int s, W zeroW, AddListener<W> addListener) {
		this.graph = graph;
		this.s = s;
		this.addListener = addListener;
		int size = graph.getPointSize();
		distTo = new Object[size];
		from = new Edge[size];
		distTo[s] = zeroW;

		for (int pass = 1; pass < size; pass++) {

			for (int i = 0; i < size; i++) {
				Iterator<Edge<W>> iterator = graph.getPostionIterator(i);
				while (iterator.hasNext()) {
					Edge<W> edge = (Edge<W>) iterator.next();
					if (edge == null)
						continue;
					int v = edge.other(i);
					W nW = addListener.add((W) distTo[i], edge.w);
					if (from[v] == null || nW.compareTo((W) distTo[v]) < 0) {
						from[v] = edge;
						distTo[v] = nW;
					}

				}
			}
			hasNegativeCycle = hasNegativeCycle();
		}

	}

	private boolean hasNegativeCycle() {
		for (int i = 0; i < graph.getPointSize(); i++) {
			Iterator<Edge<W>> iterator = graph.getPostionIterator(i);
			while (iterator.hasNext()) {
				Edge<W> edge = (Edge<W>) iterator.next();
				if (edge == null)
					continue;
				int v = edge.other(i);
				W nW = addListener.add((W) distTo[i], edge.w);
				if (from[v] == null || nW.compareTo((W) distTo[v]) < 0) {
					return true;
				}

			}
		}
		return false;
	}

	public Iterator<Edge<W>> getPath(int v) {
		if (!hasPath(v)) {
			return null;
		}

		List<Edge<W>> pathList = new ArrayList<Edge<W>>();
		Edge<W> edge = from[v];
		Stack<Edge<W>> stack = new Stack<>();
		while (edge != null) {
			stack.push(edge);
			v = edge.other(v);
			edge = from[v];

		}
		while (!stack.isEmpty()) {
			pathList.add(stack.pop());
		}
		return pathList.iterator();

	}

	private boolean hasPath(int v) {
		return from[v] != null;
	}

}
