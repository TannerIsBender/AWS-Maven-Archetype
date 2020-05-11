package ${package};

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SampleTest {

	@Test
	public void simpleJUnit5Test() {
		String result = "tanner";
		assertEquals("tanner", result);
	}
}
