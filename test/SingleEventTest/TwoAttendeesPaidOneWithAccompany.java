package SingleEventTest;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;


public class TwoAttendeesPaidOneWithAccompany {
	Event event = null;	
	Attendee sh = null;
	Attendee ds = null;
	
	@Before
	public void setUp() throws Exception {
		
		event = new Event("Swimming", "CJ", "2011-1-1", 90);
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		
		event.AddRecord(sh, 1, 90);
		event.AddRecord(ds, 0, 0);
		
		sh.summaryAll();
		ds.summaryAll();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWhoisMyLord() {
		Assert.assertEquals(sh.getName(), ds.getWhoIsMyLord(event));
	}
	
	@Test
	public void testHowManyIShouldRepayTo() {	
		Assert.assertEquals(30.0f, ds.getHowManyIShouldRepayTo(sh));
	}
}
