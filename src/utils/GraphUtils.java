package utils;

import domain.Vertex;

import java.io.PrintStream;
import java.util.*;

public final class GraphUtils {

	private static final Comparator<Set<Vertex>> GROUPS_COMPARATOR = (o1, o2) ->
		o1.size() != o2.size() ? o2.size() - o1.size() : o2.hashCode() - o1.hashCode();

	/**
	 * Generates a set of groups from a graph
	 *
	 * @param graph a set of Vertex objects
	 * @return a set of groups
	 */
	public static Set<Set<Vertex>> getGroups(Set<Vertex> graph) {
		Map<String, Set<Vertex>> firstElems = new HashMap<>();
		Map<String, Set<Vertex>> secondElems = new HashMap<>();
		Map<String, Set<Vertex>> thirdElems = new HashMap<>();

		Set<Set<Vertex>> groups = new TreeSet<>(GROUPS_COMPARATOR);

		for (Vertex vertex : graph) {
			String s1 = vertex.getValue()[0];
			String s2 = vertex.getValue()[1];
			String s3 = vertex.getValue()[2];

			if (!s1.equals("\"\"")) {
				if (firstElems.containsKey(s1)) {
					firstElems.get(s1).add(vertex);
				} else {
					firstElems.put(s1, new HashSet<>(Collections.singleton(vertex)));
				}
			}

			if (!s2.equals("\"\"")) {
				if (secondElems.containsKey(s2)) {
					secondElems.get(s2).add(vertex);
				} else {
					secondElems.put(s2, new HashSet<>(Collections.singleton(vertex)));
				}
			}

			if (!s3.equals("\"\"")) {
				if (thirdElems.containsKey(s3)) {
					thirdElems.get(s3).add(vertex);
				} else {
					thirdElems.put(s3, new HashSet<>(Collections.singleton(vertex)));
				}
			}
		}

		while (!graph.isEmpty()) {
			Set<Vertex> group = new HashSet<>();
			Vertex vertex = graph.stream().findAny().get();
			graph.remove(vertex);
			Deque<Vertex> deque = new ArrayDeque<>();
			deque.push(vertex);
			while (!deque.isEmpty()) {
				group.add(vertex);
				Vertex pop = deque.pop();
				pop.setVisited(true);
				Set<Vertex> firstVertices = firstElems.remove(pop.getValue()[0]);
				Set<Vertex> secondVertices = secondElems.remove(pop.getValue()[1]);
				Set<Vertex> thirdVertices = thirdElems.remove(pop.getValue()[2]);

				if (firstVertices != null) {
					group.addAll(firstVertices);
					for (Vertex firstVertex : firstVertices) {
						if (!firstVertex.isVisited()) {
							deque.push(firstVertex);
							firstVertex.setVisited(true);
						}
					}
				}

				if (secondVertices != null) {
					group.addAll(secondVertices);
					for (Vertex secondVertex : secondVertices) {
						if (!secondVertex.isVisited()) {
							deque.push(secondVertex);
							secondVertex.setVisited(true);
						}
					}
				}

				if (thirdVertices != null) {
					group.addAll(thirdVertices);
					for (Vertex thirdVertex : thirdVertices) {
						if (!thirdVertex.isVisited()) {
							deque.push(thirdVertex);
							thirdVertex.setVisited(true);
						}
					}
				}
			}

			graph.removeAll(group);
			groups.add(group);
		}

		return groups;
	}

	/**
	 * Counts a number of groups which consist of 2 or more elements
	 *
	 * @param groups a set of groups
	 * @return a number of groups which consist of 2 or more elements
	 */
	public static int getNumberOfGroups(Set<Set<Vertex>> groups) {
		int number = 0;
		for (Set<Vertex> group : groups) {
			if (group.size() > 1) {
				number++;
			}
		}

		return number;
	}

	/**
	 * Prints groups in
	 *
	 * @param groups a set of groups
	 */
	public static void writeGroups(Set<Set<Vertex>> groups, PrintStream printStream) {
		int i = 0;
		for (Set<Vertex> group : groups) {
			printStream.println("Группа " + ++i + "\n");
			for (Vertex vertex : group) {
				printStream.println(vertex + "\n");
			}
		}
		printStream.close();
	}
}
