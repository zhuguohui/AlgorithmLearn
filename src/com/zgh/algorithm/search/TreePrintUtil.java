package com.zgh.algorithm.search;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TreePrintUtil {
	public static void pirnt(TreeNode root) {
		// �ҵ���ߵ����ƫ����
		int maxLeftOffset = findMaxOffset(root, 0, true);
		int maxRightOffset = findMaxOffset(root, 0, false);
		int offset = Math.max(maxLeftOffset, maxRightOffset);
		// �������ƫ����
		Map<Integer, PrintLine> lineMap = new HashMap<Integer, PrintLine>();
		calculateLines(root, offset, lineMap, 0, true);
		Iterator<Integer> lineNumbers = lineMap.keySet().iterator();
		int maxLine = 0;
		while (lineNumbers.hasNext()) {
			int lineNumber = lineNumbers.next();
			if (lineNumber > maxLine) {
				maxLine = lineNumber;
			}
		}
		for (int i = 0; i <= maxLine; i++) {
			PrintLine line = lineMap.get(i);
			if (line != null) {
				System.out.println(line.getLineString());
			}
		}

	}

	private static void calculateLines(TreeNode parent, int offset, Map<Integer, PrintLine> lineMap, int level,
			boolean right) {
		if (parent == null) {
			return;
		}
		int nameoffset = parent.toString().length() / 2;
		PrintLine line = lineMap.get(level);
		if (line == null) {
			line = new PrintLine();
			lineMap.put(level, line);
		}
		line.putString(right ? offset : (offset - nameoffset), parent.toString());
		// �ж���û����һ��
		if (parent.getLeftChild() == null && parent.getRightChild() == null) {
			return;
		}
		// ����У���ӷָ��߼�/\
		PrintLine separateLine = lineMap.get(level + 1);
		if (separateLine == null) {
			separateLine = new PrintLine();
			lineMap.put(level + 1, separateLine);
		}
		if (parent.getLeftChild() != null) {
			separateLine.putString(offset - 1, "/");
			calculateLines(parent.getLeftChild(), offset - nameoffset - 1, lineMap, level + 2, false);
		}
		if (parent.getRightChild() != null) {
			separateLine.putString(offset + nameoffset + 1, "\\");
			calculateLines(parent.getRightChild(), offset + nameoffset + 1, lineMap, level + 2, true);
		}

	}

	/**
	 * ��Ҫ��ӡ��ĳһ��
	 * 
	 * @author zhuguohui
	 *
	 */
	private static class PrintLine {
		/**
		 * ��¼��offset��String��map
		 */
		Map<Integer, String> printItemsMap = new HashMap<>();
		int maxOffset = 0;

		public void putString(int offset, String info) {
			printItemsMap.put(offset, info);
			if (offset > maxOffset) {
				maxOffset = offset;
			}
		}

		public String getLineString() {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i <= maxOffset; i++) {
				String info = printItemsMap.get(i);
				if (info == null) {
					buffer.append(" ");
				} else {
					buffer.append(info);
					i += info.length();
				}
			}
			return buffer.toString();
		}

	}

	private static int findMaxOffset(TreeNode parent, int offset, boolean findLeft) {
		if (parent == null) {
			return offset;
		}
		if (parent != null) {
			offset += parent.toString().length();
		}
		if (findLeft && parent.getLeftChild() != null) {
			offset += 1;
			return findMaxOffset(parent.getLeftChild(), offset, findLeft);
		}
		if (!findLeft && parent.getRightChild() != null) {
			return findMaxOffset(parent.getRightChild(), offset, findLeft);
		}
		return offset;
	}

	public interface TreeNode {
		/**
		 * ��Ҫ��ӡ����Ϣ
		 * 
		 * @return
		 */
		String getPrintInfo();

		TreeNode getLeftChild();

		TreeNode getRightChild();
	}

}
