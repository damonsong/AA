package SingleEventTest;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;


public class ThreeAttendessOnePaid {
	Event event = null;	
	Attendee sh = null;
	Attendee ds = null;
	Attendee dd = null;
	
	@Before
	public void setUp() throws Exception {
		event = new Event("Swimming", "CJ", "2011-1-1", 90);
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		dd = new Attendee("David Dong");
		
		event.AddRecord(sh, 0, 0);
		event.AddRecord(ds, 0, 0);
		event.AddRecord(dd, 0, 90);
		
		sh.summaryAll();
		ds.summaryAll();
		dd.summaryAll();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWhoisMyLord() {
		Assert.assertEquals(dd.getName(), ds.getWhoIsMyLord(event));
		Assert.assertFalse(sh.getName() == ds.getWhoIsMyLord(event));
	}
	
	@Test
	public void testHowManyIShouldRepayTo() {	
		Assert.assertEquals(30.0f, ds.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, ds.getHowManyIShouldRepayTo(sh));
		Assert.assertEquals(30.f, sh.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, sh.getHowManyIShouldRepayTo(ds));
	}
	
	@Test
	public void testWhoOwnMe() {
		int index;
		int numberOfOwned = dd.getNumberOfWhoOwnMe();
		
		Assert.assertEquals(2, numberOfOwned);
		
		for(index = 0; index < numberOfOwned; index++) {
			Assert.assertFalse(dd.getName() == dd.getWhoOwnMe(index));
			Assert.assertEquals(30.0f, dd.getShouldPayMe(index));			
		}
	}
}
