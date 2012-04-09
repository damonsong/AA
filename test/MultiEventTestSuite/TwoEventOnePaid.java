package MultiEventTestSuite;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;


public class TwoEventOnePaid {
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
		event1 = new Event("Swimming", "FT", "2000-1-1", 150);
		event2 = new Event("FB", "KFC", "2000-1-1", 500);
		
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		dd = new Attendee("David Dong");
		az = new Attendee("Alain Zhu");
		wy = new Attendee("Wesley Yan");
		
		
		event1.AddRecord(sh, 0, 0);
		event1.AddRecord(ds, 0, 0);
		event1.AddRecord(dd, 0, 150);
		event1.AddRecord(az, 0, 0);
		event1.AddRecord(wy, 0, 0);
		
		event2.AddRecord(sh, 0, 0);
		event2.AddRecord(ds, 0, 0);
		event2.AddRecord(dd, 0, 500);
		event2.AddRecord(az, 0, 0);
		event2.AddRecord(wy, 0, 0);
		
		sh.summaryAll();
		ds.summaryAll();
		dd.summaryAll();
		az.summaryAll();
		wy.summaryAll();
	}

	@Test
	public void testHowManyOwnedMe() {
		assertEquals(4, dd.getNumberOfWhoOwnMe());
	}
	
	@Test
	public void testHowMuchShouldDamonRepayTo() {
		float expect = 130.0f;
		
		assertEquals(expect, ds.getHowManyIShouldRepayTo(dd), 0);
	}
	
	@Test
	public void testHowMuchShouldDavidGetFromAlain() {
		float expect = 130.0f;
		int index = -1;
		
		for(index = 0; index < dd.getNumberOfWhoOwnMe(); index++ ) {
			if(az.getName() == dd.getWhoOwnMe(index)) {
				break;
			}
		}
		
		if((index == -1) || (index >= dd.getNumberOfWhoOwnMe())) {
			fail("No one owned!!");
		}
		else {
			assertEquals(expect, dd.getShouldPayMe(index), 0);	
		}

	}

}
