package SingleEventTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Brain.Activity;

public class HighLevelInterface_2A1P {
	Activity activity_instance = null;


	@Before
	public void setUp() throws Exception {
		activity_instance = new Activity("Lunch", "ZH", "2012-4-11", 11, "Damon Song", "Simon Huang");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWhoIsPayerInTheActivity() {
		assertEquals("Damon Song", activity_instance.getPayerName());
	}
	
	@Test
	public void testHowManyAttendeeInTheActivity() {
		assertEquals(2, activity_instance.getNumberOfAttendee());
	}
	
	@Test
	public void testHowManyUnpaidInTheActivity() {
		assertEquals(1, activity_instance.getNumberOfUnpaid());
	}
	
	@Test
	public void testWhoIsUnPaidInTheActivity() {
		int indexOfUnpaid = 0;
		
		assertEquals("Simon Huang", activity_instance.getUnpaidName(indexOfUnpaid));
	}
	
	@Test
	public void testHowMuchShouldRepayToDamon() {
		int indexOfUnpaid = 0;
		
		assertEquals(5.5f, activity_instance.getUnpaidValue(indexOfUnpaid), 0);
	}

}
