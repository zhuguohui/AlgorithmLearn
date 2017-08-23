package com.zgh.algorithm.graph2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * dijkstra 单源最短路径
 * 
 * @author yuelin
 *
 */
public class DijkstraPath<W extends Comparable<W>> {
	Graph<W> graph;
	boolean[] market;
	IndexMinHeap<Edge<W>> heap;
	Object[] shortestEdges;
	Edge<W>[] from;
	AddListener<W> addListener;
	int s;

	public DijkstraPath(Graph<W> graph, int s, W zeroW, AddListener<W> listener) {
		this.graph = graph;
		int size = graph.getPointSize();
		market = new boolean[size];
		from = new Edge[size];
		shortestEdges = new Object[size];
		heap = new IndexMinHeap<>(size);
		this.s = s;
		Edge<W> edge = new Edge<>();
		edge.a = s;
		edge.b = s;
		edge.w = zeroW;
		from[s] = null;
		heap.insert(s, edge);
		this.addListener = listener;
		
		while (!heap.isEmpty()) {
			Edge<W> edge2 = heap.getTop();
			if (market[edge2.a] && market[edge2.b]) {
				continue;
			}
			int v = market[edge2.a] ? edge2.b : edge.a;
			market[v] = true;
			Iterator<Edge<W>> iterator = graph.getPostionIterator(v);
			while (iterator.hasNext()) {
				Edge<W> edge3 = (Edge<W>) iterator.next();
				if (edge3 == null) {
					continue;
				}
				int w = edge3.other(v);
				if (market[w]) {
					continue;
				}
				W add = shortestEdges[v] != null ? addListener.add((W) shortestEdges[v], edge3.wt()) : edge3.wt();
				// 判断是否是最短边
				if (shortestEdges[w] == null || add.compareTo((W) shortestEdges[w]) < 0) {
					// 更新最短边
					shortestEdges[w] = add;
					from[w] = edge3;
				}
				// 添加边到堆
				if (heap.contain(w)) {
					heap.change(w, edge3);
				} else {
					heap.insert(w, edge3);
				}

			}

		}
	}

	public boolean hasPath(int v) {
		return market[v];
	}
	
	public W getPathLength(int v){
		if(hasPath(v)){
			return (W) shortestEdges[v];
		}
		return null;
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

	public static interface AddListener<W> {
		W add(W a, W b);
	}

}
