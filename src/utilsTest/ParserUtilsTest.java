package utilsTest;

import domain.Vertex;
import org.junit.Assert;
import org.junit.Test;
import utils.IOUtils;
import utils.ParserUtils;

import java.io.IOException;
import java.util.*;

public class ParserUtilsTest {
	private static final String FILE_NAME_1 = "src\\resources\\lng1.csv";
	private static final String FILE_NAME_2 = "src\\resources\\lng-big1.csv";

	@Test
	public void getSetGraph() throws IOException {
		Set<Vertex> arraysActual1 = ParserUtils.getSetGraph(ParserUtils.PATTERN_1, IOUtils.getFile(FILE_NAME_1));
		Set<Vertex> arraysExpected1 = new TreeSet<>();
		arraysExpected1.add(new Vertex(new String[]{"\"83178111069\"", "\"100000094623698\"", "\"200000064948582\""}));
		arraysExpected1.add(new Vertex(new String[]{"\"83822459695\"", "\"\"", "\"200000087201031\""}));
		arraysExpected1.add(new Vertex(new String[]{"\"83677311059\"", "\"100000815068665\"", "\"200000605588834\""}));
		arraysExpected1.add(new Vertex(new String[]{"\"\"", "\"100000661125097\"", "\"200000171650768\""}));
		arraysExpected1.add(new Vertex(new String[]{"\"83273885690\"", "\"100000372967409\"", "\"200000269854191\""}));
		arraysExpected1.add(new Vertex(new String[]{"\"83408667148\"", "\"100000227022280\"", "\"200000827683220\""}));
		arraysExpected1.add(new Vertex(new String[]{"\"83171375084\"", "\"100000003421956\"", "\"\""}));
		arraysExpected1.add(new Vertex(new String[]{"\"83620410120\"", "\"100000227778156\"", "\"\""}));

		Assert.assertEquals(arraysExpected1, arraysActual1);

		Set<Vertex> arraysActual2 = ParserUtils.getSetGraph(ParserUtils.PATTERN_1, IOUtils.getFile(FILE_NAME_2));
		Set<Vertex> arraysExpected2 = new TreeSet<>();
		arraysExpected2.add(new Vertex(new String[]{"\"83363.1\"", "\"83363.1\"", ""}));
		arraysExpected2.add(new Vertex(new String[]{"\"5177.1\"", "\"5177.1\"", ""}));
		arraysExpected2.add(new Vertex(new String[]{"\"32595.1\"", "\"32595.1\"", ""}));
		arraysExpected2.add(new Vertex(new String[]{"", "\"51573.1\"", ""}));
		arraysExpected2.add(new Vertex(new String[]{"", "\"83363.1\"", ""}));
		arraysExpected2.add(new Vertex(new String[]{"\"5177.1\"", "\"5177.1\"", "\"5177.1\""}));
		arraysExpected2.add(new Vertex(new String[]{"", "", ""}));
		arraysExpected2.add(new Vertex(new String[]{"", "\"32595.1\"", ""}));

		Assert.assertEquals(arraysExpected2, arraysActual2);
	}
}