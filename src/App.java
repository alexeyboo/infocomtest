import domain.Vertex;
import utils.GraphUtils;
import utils.IOUtils;
import utils.ParserUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class App {
	public static void main(String[] args) throws IOException {
		long time1 = System.currentTimeMillis();
		BufferedReader file = IOUtils.getFile("src\\resources\\lng-big.csv");
		Set<Vertex> graph = ParserUtils.getSetGraph(ParserUtils.PATTERN_1, file);
		Set<Set<Vertex>> groups = GraphUtils.getGroups(graph);

//		GraphUtils.writeGroups(groups, System.out);
		try (PrintStream printStream = new PrintStream("out\\result.txt")) {
			printStream.println("Количество групп с более чем одним элементом: " + GraphUtils.getNumberOfGroups(groups) + "\n");
			GraphUtils.writeGroups(groups, printStream);
		}

		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1);
	}
}
