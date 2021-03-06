package utilsTest;

import domain.Vertex;
import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

import java.util.*;

public class GraphUtilsTest {
	private Vertex a_1 = new Vertex(new String[]{"83178111069", "100000094623698", "200000064948582"});
	private Vertex a_2 = new Vertex(new String[]{"83822459695", "100000094623698", "200000087201031"});
	private Vertex a_3 = new Vertex(new String[]{"83677311059", "100000815068665", "200000605588834"});
	private Vertex a_4 = new Vertex(new String[]{"83822459695", "100000661125097", "200000171650768"});
	private Vertex a_5 = new Vertex(new String[]{"83273885690", "100000372967409", "200000269854191"});
	private Vertex a_6 = new Vertex(new String[]{"83408667148", "100000227022280", "200000827683220"});
	private Vertex a_7 = new Vertex(new String[]{"83171375084", "100000003421956", "200000605588834"});
	private Vertex a_8 = new Vertex(new String[]{"83620410120", "100000227778156", "200000269854191"});

	private Vertex b_1 = new Vertex(new String[]{"\"83363.1\"", "\"83363.1\"", ""});
	private Vertex b_2 = new Vertex(new String[]{"\"5177.1\"", "\"5177.1\"", ""});
	private Vertex b_3 = new Vertex(new String[]{"\"32595.1\"", "\"32595.1\"", ""});
	private Vertex b_4 = new Vertex(new String[]{"", "\"51573.1\"", ""});
	private Vertex b_5 = new Vertex(new String[]{"", "\"83363.1\"", ""});
	private Vertex b_6 = new Vertex(new String[]{"\"5177.1\"", "\"5177.1\"", "\"5177.1\""});
	private Vertex b_7 = new Vertex(new String[]{"", "", ""});
	private Vertex b_8 = new Vertex(new String[]{"", "\"32595.1\"", ""});

	private List<Vertex> before = new ArrayList<>(Arrays.asList(a_1, a_2, a_3, a_4, a_5, a_6, a_7, a_8));
	private List<Vertex> before1 = new ArrayList<>(Arrays.asList(b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8));

	private List<Vertex> after_group_1 = Arrays.asList(a_1, a_2, a_4);
	private List<Vertex> after_group_2 = Arrays.asList(a_3, a_7);
	private List<Vertex> after_group_3 = Arrays.asList(a_5, a_8);
	private List<Vertex> after_group_4 = Collections.singletonList(a_6);

	private List<Vertex> after_group_11 = Arrays.asList(b_1, b_5);
	private List<Vertex> after_group_21 = Arrays.asList(b_2, b_6);
	private List<Vertex> after_group_31 = Arrays.asList(b_3, b_8);
	private List<Vertex> after_group_41 = Collections.singletonList(b_4);
	private List<Vertex> after_group_51 = Collections.singletonList(b_7);



	@Test
	public void getGroups() {
		Set<Vertex> beforeSet = new HashSet<>(before);
		Set<Set<Vertex>> groupsActual = GraphUtils.getGroups(beforeSet);
		Set<Set<Vertex>> groupsExpected = new HashSet<>();
		groupsExpected.add(new HashSet<>(after_group_1));
		groupsExpected.add(new HashSet<>(after_group_2));
		groupsExpected.add(new HashSet<>(after_group_3));
		groupsExpected.add(new HashSet<>(after_group_4));

		Assert.assertEquals(groupsExpected, groupsActual);

		Set<Vertex> beforeSet1 = new HashSet<>(before1);
		Set<Set<Vertex>> groupsActual1 = GraphUtils.getGroups(beforeSet1);
		Set<Set<Vertex>> groupsExpected1 = new HashSet<>();
		groupsExpected1.add(new HashSet<>(after_group_11));
		groupsExpected1.add(new HashSet<>(after_group_21));
		groupsExpected1.add(new HashSet<>(after_group_31));
		groupsExpected1.add(new HashSet<>(after_group_41));
		groupsExpected1.add(new HashSet<>(after_group_51));

		Assert.assertEquals(groupsExpected1, groupsActual1);
	}
}