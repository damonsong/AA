package SingleEventTest;


import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;


public class ThreeAttendeeAllHasAccompany {
	Event event = null;
	
	Attendee sh = null;
	Attendee ds = null;
	Attendee dd = null;
	@Before
	public void setUp() throws Exception {
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		dd = new Attendee("David Dong");
		
		event = new Event("Swimming", "CJ", "2011-1-1", 270);
		
		event.AddRecord(sh, 3, 0);
		event.AddRecord(ds, 2, 0);
		event.AddRecord(dd, 1, 270);
		
		sh.summaryAll();
		ds.summaryAll();
		dd.summaryAll();
	}

	@Test
	public void testHowManyIShouldRepayTo() {	
		Assert.assertEquals(90.0f, ds.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(120.0f, sh.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, dd.getHowManyIShouldRepayTo(dd));
	}

	@Test
	public void testWhoOwnMe() {
		int index;
		int numberOfOwned = dd.getNumberOfWhoOwnMe();
		
		Assert.assertEquals(2, numberOfOwned);

		for(index = 0; index < numberOfOwned; index++) {
			Assert.assertFalse(dd.getName() == dd.getWhoOwnMe(index));
			
			if(ds.getName() == dd.getWhoOwnMe(index)) {
				Assert.assertEquals(90.0f, dd.getShouldPayMe(index));	
			}
			else if(sh.getName() == dd.getWhoOwnMe(index)) {
				Assert.assertEquals(120.0f, dd.getShouldPayMe(index));
			}
			else {
				fail("Nothing!");
			}
		}
	}
}
