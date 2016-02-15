package com.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = 
				new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			for (UndirectedGraphNode neighbor : n.neighbors) {
				if (map.containsKey(neighbor)) {
					map.get(n).neighbors.add(map.get(neighbor));
				} else {
					UndirectedGraphNode neighborCopy = 
							new UndirectedGraphNode(neighbor.label);
					map.get(n).neighbors.add(neighborCopy);
					map.put(neighbor, neighborCopy);
					queue.add(neighbor);
				}
			}
		}
		return copy;
	}
	
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = 
				new HashMap<>();
		return DFS(node, map);
	}
	
	private UndirectedGraphNode DFS(UndirectedGraphNode node, 
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(node)) {
			return map.get(node);
		}
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			copy.neighbors.add(DFS(neighbor, map));
		}
		return copy;
	}
	
}
