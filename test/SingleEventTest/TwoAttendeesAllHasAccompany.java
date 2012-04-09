package SingleEventTest;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;


public class TwoAttendeesAllHasAccompany {
	Event event = null;
	
	Attendee sh = null;
	Attendee ds = null;
	
	@Before
	public void setUp() throws Exception {
		event = new Event("Swimming", "CJ", "2011-1-1", 180);
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		
		event.AddRecord(sh, 2, 180);
		event.AddRecord(ds, 2, 0);
		
		sh.summaryAll();
		ds.summaryAll();
	}


	@Test
	public void testHowManyIShouldRepayTo() {
		Assert.assertEquals(90.0f, ds.getHowManyIShouldRepayTo(sh));
	}

}
