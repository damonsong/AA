package SingleEventTest;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;


public class TenAttendeesOnePaid {
	Event event = null;
	
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
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		dd = new Attendee("David Dong");
		wy = new Attendee("Wesley Yan");
		az = new Attendee("Alain Zhu");
		fw = new Attendee("Fan Wang");
		jl = new Attendee("Jan Liu");
		jz = new Attendee("Jet Zhang");
		jd = new Attendee("John Deng");
		sw = new Attendee("Samuel Wu");		
		
		event = new Event("Swimming", "CJ", "2011-1-1", 300);
		
		event.AddRecord(sh, 0, 0);
		event.AddRecord(ds, 0, 0);
		event.AddRecord(dd, 0, 0);
		event.AddRecord(wy, 0, 0);
		event.AddRecord(az, 0, 300);
		event.AddRecord(fw, 0, 0);
		event.AddRecord(jl, 0, 0);
		event.AddRecord(jz, 0, 0);
		event.AddRecord(jd, 0, 0);
		event.AddRecord(sw, 0, 0);
		
		sh.summaryAll();
		ds.summaryAll();
		dd.summaryAll();
		wy.summaryAll();
		az.summaryAll();
		fw.summaryAll();
		jl.summaryAll();
		jz.summaryAll();
		jd.summaryAll();
		sw.summaryAll();
	}

	@Test
	public void testWhoisMyLord() {
		Assert.assertEquals(az.getName(), ds.getWhoIsMyLord(event));
	}

	@Test
	public void testHowManyIShouldRepayTo() {
		Assert.assertEquals(30.0f, ds.getHowManyIShouldRepayTo(az));
	}

	@Test
	public void testWhoOwnMe10P() {
	
		int index;
		int numberOfOwned = az.getNumberOfWhoOwnMe();
		
		Assert.assertEquals(9, numberOfOwned);
		
		for(index = 0; index < numberOfOwned; index++) {
			Assert.assertFalse(az.getName() == az.getWhoOwnMe(index));
			Assert.assertEquals(30.0f, az.getShouldPayMe(index));			
		}
	}

}
