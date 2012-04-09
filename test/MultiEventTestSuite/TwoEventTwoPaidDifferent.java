package MultiEventTestSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;

public class TwoEventTwoPaidDifferent {
	Event event1 = null;
	Event event2 = null;
	
	Attendee sh = null;
	Attendee ds = null;
	Attendee dd = null;
	Attendee wy = null;
	Attendee az = null;
	Attendee fw = null;
	Attendee jl = null;
	Attendee jz = null;
	Attendee jd = null;
	Attendee sw = null;
	
	@Before
	public void setUp() throws Exception {
		event1 = new Event("Swimming", "FT", "2000-1-1", 200);
		event2 = new Event("FB", "KFC", "2000-1-1", 100);
		
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");	
		
		event1.AddRecord(sh, 0, 200);
		event1.AddRecord(ds, 0, 0);
		
		event2.AddRecord(sh, 0, 0);
		event2.AddRecord(ds, 0, 100);
		
		sh.summaryAll();
		ds.summaryAll();
	}

	@Test
	public void testHowManyOwnedSimon() {
		assertEquals(1, sh.getNumberOfWhoOwnMe());
	}
	
	@Test
	public void testHowManyOwnedDamon() {
		assertEquals(0, ds.getNumberOfWhoOwnMe());
	}
	
	@Test
	public void testHowMuchShouldDamonRepayTo() {
		float expect = 50.0f;
		
		assertEquals(expect, ds.getHowManyIShouldRepayTo(sh), 0);
	}
	
	@Test
	public void testHowMuchSimonOwnedDamon() {
		float expect = 50.0f;
		
		assertEquals(expect, sh.getShouldPayMe(0), 0);
	}
	
	@Test
	public void testHowMuchDamonOwnedSimon() {
		int expect = 0;
		
		assertEquals(expect, ds.getNumberOfWhoOwnMe(), 0);
	}

	@Test
	public void testHowMuchShouldSimonRepayTo() {
		float expect = 0.0f;
		
		assertEquals(expect, sh.getHowManyIShouldRepayTo(ds), 0);
	}


}
