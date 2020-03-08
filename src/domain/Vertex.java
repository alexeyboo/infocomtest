package domain;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Vertex implements Comparable {
	private String[] value;
	private boolean visited;

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vertex vertex = (Vertex) o;
		return Arrays.equals(value, vertex.value);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(value);
	}

	@Override
	public String toString() {
		return value[0] + ";" + value[1] + ";" + value[2];
	}

	public Vertex(String[] value) {
		this.value = value;
	}

	public String[] getValue() {
		return value;
	}

	public void setValue(String[] value) {
		this.value = value;
	}

	@Override
	public int compareTo(@NotNull Object o) {
		Vertex o1 = (Vertex) o;
		return (getValue().length - o1.getValue().length) != 0
			? getValue().length - o1.getValue().length
			: this.hashCode() - o1.hashCode();

	}
}
