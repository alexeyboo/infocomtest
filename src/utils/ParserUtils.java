package utils;

import domain.Vertex;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParserUtils {
	public static final Pattern PATTERN_1 = Pattern.compile("^[^;]*;[^;]*;[^;]*$");

	public static Set<Vertex> getSetGraph(Pattern pattern, BufferedReader reader) throws IOException {
		Set<Vertex> graph = new TreeSet<>();
		String line;
		Matcher matcher;

		while ((line = reader.readLine()) != null) {
			matcher = pattern.matcher(line);

			if (matcher.find()) {
				Vertex vertex = new Vertex(matcher.group().split(";"));
				graph.add(vertex);
			}
		}

		return graph;
	}
}