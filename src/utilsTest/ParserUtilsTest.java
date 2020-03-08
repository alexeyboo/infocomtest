package utilsTest;

import domain.Vertex;
import org.junit.Assert;
import org.junit.Test;
import utils.IOUtils;
import utils.ParserUtils;

import java.io.IOException;
import java.util.*;

public class ParserUtilsTest {
	private static final String FILE_NAME = "src\\resources\\lng1.csv";

	@Test
	public void getSetGraph() throws IOException {
		Set<Vertex> arraysActual = ParserUtils.getSetGraph(ParserUtils.PATTERN_1, IOUtils.getFile(FILE_NAME));
		Set<Vertex> arraysExpected = new TreeSet<>();
		arraysExpected.add(new Vertex(new String[]{"\"83178111069\"", "\"100000094623698\"", "\"200000064948582\""}));
		arraysExpected.add(new Vertex(new String[]{"\"83822459695\"", "\"\"", "\"200000087201031\""}));
		arraysExpected.add(new Vertex(new String[]{"\"83677311059\"", "\"100000815068665\"", "\"200000605588834\""}));
		arraysExpected.add(new Vertex(new String[]{"\"\"", "\"100000661125097\"", "\"200000171650768\""}));
		arraysExpected.add(new Vertex(new String[]{"\"83273885690\"", "\"100000372967409\"", "\"200000269854191\""}));
		arraysExpected.add(new Vertex(new String[]{"\"83408667148\"", "\"100000227022280\"", "\"200000827683220\""}));
		arraysExpected.add(new Vertex(new String[]{"\"83171375084\"", "\"100000003421956\"", "\"\""}));
		arraysExpected.add(new Vertex(new String[]{"\"83620410120\"", "\"100000227778156\"", "\"\""}));

		Assert.assertEquals(arraysExpected, arraysActual);
	}
}