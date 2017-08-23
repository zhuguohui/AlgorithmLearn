package com.zgh.algorithm.graph2;

import java.util.Iterator;

import com.zgh.algorithm.graph2.DijkstraPath.AddListener;
import com.zgh.algorithm.graph2.ReadGraph.WeightParser;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		ReadGraph<Double> readGraph = new ReadGraph<Double>(DenseGraph.class, new WeightParser<Double>() {
			@Override
			public Double parserWeight(String info) {
				if (info != null) {
					if (info.startsWith(".")) {
						info = "0" + info;
					}
					return Double.parseDouble(info);
				}
				return null;
			}
		}, true, "C:/Users/yuelin/Desktop/testG1.txt");
		// LazyPrimMST<Double> lazyPrimMST=new
		// LazyPrimMST<>(readGraph.getGraph());
		DijkstraPath<Double> dijkstraPath = new DijkstraPath<Double>(readGraph.getGraph(), 0, 0d,
				new AddListener<Double>() {

					@Override
					public Double add(Double a, Double b) {
						// TODO Auto-generated method stub
						return a + b;
					}
				});

		for (int i = 0; i < 5; i++) {
			Iterator<Edge<Double>> iterator = dijkstraPath.getPath(i);
			StringBuffer buffer = new StringBuffer();
			buffer.append("to " + i + " path:");
			if (iterator != null) {
				while (iterator.hasNext()) {
					Edge<java.lang.Double> edge = (Edge<java.lang.Double>) iterator.next();
					if (edge != null) {
						buffer.append(edge.toString() + " ");
					}
				}
			} else {
				buffer.append("null");
			}
			buffer.append(" length=" + dijkstraPath.getPathLength(i));
			System.out.println(buffer);
		}
	}
}
