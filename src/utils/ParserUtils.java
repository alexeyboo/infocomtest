package utils;

import domain.Vertex;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParserUtils {
	public static final Pattern PATTERN_1 = Pattern.compile("^([^;]*);([^;]*);([^;]*)$");

	public static Set<Vertex> getSetGraph(Pattern pattern, BufferedReader reader) throws IOException {
		Set<Vertex> graph = new TreeSet<>();
		String line, s1, s2, s3;
		Matcher matcher;

		while ((line = reader.readLine()) != null) {
			matcher = pattern.matcher(line);

			if (matcher.find()) {
				s1 = matcher.group(1);
				s2 = matcher.group(2);
				s3 = matcher.group(3);
				Vertex vertex = new Vertex(new String[]{s1, s2, s3});
				graph.add(vertex);
			}
		}

		return graph;
	}
}