import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import Brain.Attendee;
import Brain.Database;
import Brain.Event;


public class MultiEventTest {


	private void testCase0() {
		Event event1 = new Event("Swimming", "FT", "2000-1-1", 60);
		Event event2 = new Event("Swimming", "FT", "2000-1-2", 60);
		
		Attendee ds = new Attendee("Damon Song");
		Attendee dd = new Attendee("David Dong");
		
		event1.AddRecord(ds, 0, 0);
		event1.AddRecord(dd, 0, 60);
		
		event2.AddRecord(ds, 0, 0);
		event2.AddRecord(dd, 0, 60);
		
		ds.summaryAll();
		dd.summaryAll();
		
		int howManyPersonOwnDamon = ds.getNumberOfWhoOwnMe();
		int howManyPersonDamonShouldRepayTo = ds.getNumberOfIShouldRepayTo();
		float DamonShouldRepayDavid = ds.getHowManyIShouldRepayTo(dd);
		final float expectedRepay = 60;
		final int expectedPersonNumberOwnedDamon = 0;
		final int expectedPersonNumberDamonShouldRepayTo = 1;
		
		Assert.assertEquals(expectedPersonNumberOwnedDamon, howManyPersonOwnDamon);
		Assert.assertEquals(expectedPersonNumberDamonShouldRepayTo, howManyPersonDamonShouldRepayTo);
		Assert.assertEquals(expectedRepay, DamonShouldRepayDavid);
		
		int howManyPersonOwnDavid = dd.getNumberOfWhoOwnMe();
		int howManyPersonDavidShouldRepayTo = dd.getNumberOfIShouldRepayTo();
		float DavidShouldRepayDamon = dd.getHowManyIShouldRepayTo(ds);
		final float expectedRepayToDamon = 0;
		final int expectedPersonNumberOwnedDavid = 1;
		final int expectedPersonNumberDavidShouldRepayTo = 0;
		
		Assert.assertEquals(expectedPersonNumberOwnedDavid, howManyPersonOwnDavid);
		Assert.assertEquals(expectedPersonNumberDavidShouldRepayTo, howManyPersonDavidShouldRepayTo);
		Assert.assertEquals(expectedRepayToDamon, DavidShouldRepayDamon);
	}
	
	private void testCase1() {
		Event event1 = new Event("Swimming", "FT", "2012-2-1", 90);
		Event event2 = new Event("FB", "KFC", "2012-2-1", 150);
		Attendee sh = new Attendee("Simon Huang");
		Attendee wy = new Attendee("Wesley Yan");
		Attendee dd = new Attendee("David Dong");
		Database db = new Database();
		
		event1.AddRecord(sh, 0, 90);
		event1.AddRecord(wy, 0, 0);
		event1.AddRecord(dd, 0, 0);
		
		event2.AddRecord(sh, 0, 90);
		event2.AddRecord(wy, 0, 0);
		event2.AddRecord(dd, 0, 0);
		
		sh.summaryAll();
		wy.summaryAll();
		dd.summaryAll();
		
		Assert.assertEquals(2, sh.getNumberOfWhoOwnMe());
		Assert.assertEquals(80.0f, dd.getHowManyIShouldRepayTo(sh));
	}
	@Test
	public void test() {
		testCase0();
		testCase1();
		//fail("Not yet implemented");
	}

}
