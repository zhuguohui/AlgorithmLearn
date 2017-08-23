package com.zgh.algorithm.graph2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class ReadGraph<W extends Comparable<W>> {
	Graph<W> graph;
	WeightParser<W> weightParser;

	public ReadGraph(Class<?> clazz, WeightParser<W> weightParser, boolean directed, String filePath) throws Exception {
		if (Graph.class.isAssignableFrom(clazz)) {
			File file = new File(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String header = reader.readLine();
			String[] headers = header.split(" ");
			int size = Integer.parseInt(headers[0]);
			int eageSize = Integer.parseInt(headers[1]);
			Constructor constructor = clazz.getConstructor(new Class[] { int.class, boolean.class });
			graph = (Graph) constructor.newInstance(size, directed);
			for (int i = 0; i < eageSize; i++) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				String[] lines = line.split(" ");
				int v = Integer.parseInt(lines[0]);
				int w = Integer.parseInt(lines[1]);
				W wt = weightParser.parserWeight(lines[2]);
				graph.addEdge(v, w, wt);
			}
			reader.close();
		}
	}

	public Graph<W> getGraph() {
		return graph;
	}

	public interface WeightParser<W> {
		W parserWeight(String info);
	}
}
