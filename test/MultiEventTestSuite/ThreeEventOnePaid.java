package MultiEventTestSuite;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;

public class ThreeEventOnePaid {
	Event swimming = null;
	Event fb = null;
	Event msj = null;
	
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
		swimming = new Event("Swimming", "ChunJian", "2012-4-9", 120); //30 avg
		fb = new Event("FB", "KFC", "2012-4-9", 400); //100 avg
		msj = new Event("MSJ", "SN", "2012-4-9", 800); //200 avg
		
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		dd = new Attendee("David Dong");
		wy = new Attendee("Wesley Yan");
		
		swimming.AddRecord(sh, 0, 0);
		swimming.AddRecord(ds, 0, 0);
		swimming.AddRecord(dd, 0, 120);
		swimming.AddRecord(wy, 0, 0);
		
		fb.AddRecord(sh, 0, 0);
		fb.AddRecord(ds, 0, 0);
		fb.AddRecord(dd, 0, 400);
		fb.AddRecord(wy, 0, 0);
		
		msj.AddRecord(sh, 0, 0);
		msj.AddRecord(ds, 0, 0);
		msj.AddRecord(dd, 0, 800);
		msj.AddRecord(wy, 0, 0);
		
		sh.summaryAll();
		ds.summaryAll();
		dd.summaryAll();
		wy.summaryAll();
	}

	@Test
	public void testWhoIsWesleyLord() {
		Assert.assertEquals(dd.getName(), wy.getWhoIsMyLord(swimming));
	}
	
	@Test
	public void testWhoIsDamonLord() {
		Assert.assertEquals(dd.getName(), ds.getWhoIsMyLord(fb));
	}
	
	@Test
	public void testWhoIsSimonLord() {
		Assert.assertEquals(dd.getName(), sh.getWhoIsMyLord(msj));
	}
	
	@Test
	public void testWhoIsDaivdLord() {
		Assert.assertEquals("self", dd.getWhoIsMyLord(msj));
	}
	
	@Test
	public void testHowManyWesleyShouldRepayTo() {
		Assert.assertEquals(330.0f, wy.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, wy.getHowManyIShouldRepayTo(ds));
	}
	
	@Test
	public void testHowManySimonShouldRepayTo() {
		Assert.assertEquals(330.0f, sh.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, sh.getHowManyIShouldRepayTo(ds));
	}
	
	@Test
	public void testHowManyDamonShouldRepayTo() {
		Assert.assertEquals(330.0f, ds.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, ds.getHowManyIShouldRepayTo(ds));
	}
	
	@Test
	public void testHowManyDavidShouldRepayTo() {
		Assert.assertEquals(0.0f, dd.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, dd.getHowManyIShouldRepayTo(ds));
	}

	@Test
	public void testHowManyDavidShouldGetFrom() {
		int numberOfOwnedDavid = dd.getNumberOfWhoOwnMe();
		int index;
				
		assertEquals(3, numberOfOwnedDavid);
		
		for(index = 0; index < numberOfOwnedDavid; index++){
			assertEquals(330.0f, dd.getShouldPayMe(index), 0);
		}
	}	
}
