import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class SingleEventTest {
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
	
	void SetUp(int caseIndex) {
		switch(caseIndex){
		
		case 2: {
			event = new Event("Swimming", "CJ", "2011-1-1", 60);
			sh = new Attendee("Simon Huang");
			ds = new Attendee("Damon Song");
			
			event.AddRecord(sh, 0, 60);
			event.AddRecord(ds, 0, 0);
			
			sh.summaryAll();
			ds.summaryAll();

			break;
		}
		
		case 3: {
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
			break;
		}

		case 4: {
			event = new Event("Swimming", "CJ", "2011-1-1", 90);
			sh = new Attendee("Simon Huang");
			ds = new Attendee("Damon Song");
			
			event.AddRecord(sh, 1, 90);
			event.AddRecord(ds, 0, 0);
			
			sh.summaryAll();
			ds.summaryAll();

			break;
		}
		
		case 5: {
			event = new Event("Swimming", "CJ", "2011-1-1", 90);
			sh = new Attendee("Simon Huang");
			ds = new Attendee("Damon Song");
			
			event.AddRecord(sh, 0, 90);
			event.AddRecord(ds, 1, 0);
			
			sh.summaryAll();
			ds.summaryAll();

			break;
		}
		
		case 6: {
			event = new Event("Swimming", "CJ", "2011-1-1", 180);
			sh = new Attendee("Simon Huang");
			ds = new Attendee("Damon Song");
			
			event.AddRecord(sh, 2, 120);
			event.AddRecord(ds, 2, 0);
			
			sh.summaryAll();
			ds.summaryAll();

			break;
		}

		case 7: {
			event = new Event("Swimming", "CJ", "2011-1-1", 270);
			sh = new Attendee("Simon Huang");
			ds = new Attendee("Damon Song");
			dd = new Attendee("David Dong");
			
			event.AddRecord(sh, 3, 0);
			event.AddRecord(ds, 2, 0);
			event.AddRecord(dd, 1, 270);
			
			sh.summaryAll();
			ds.summaryAll();
			dd.summaryAll();

			break;
		}		
		
		case 10: {
			event = new Event("Swimming", "CJ", "2011-1-1", 300);
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
			
			break;
		}
		default:
			break;
		}
		
	}

	@Test
	public void testCase0() {
		String expectedEventName = "Swimming";
		String expectedEventPlace = "Chun Jian";
		String expectedEventTime = "2012-3-3";
		float expectedEventCost = 30.0f;
		float expectedEventAvgCost = 0.0f;
		int expectedTotalAttendee = 0;
		
		Event event = new Event(expectedEventName, expectedEventPlace, expectedEventTime, expectedEventCost);
		
		Assert.assertEquals(expectedEventName, event.getName());
		Assert.assertEquals(expectedEventPlace, event.getPlace());
		Assert.assertEquals(expectedEventTime, event.getDate());
		Assert.assertEquals(expectedEventCost, event.getTotalCost());
		
		Assert.assertEquals(expectedEventAvgCost, event.getAvgCost());
		Assert.assertEquals(expectedTotalAttendee, event.getTotalNumberOfAttendee());	
	}
	

	@Test
	public void testCase1() {
		Event event1 = new Event("FB", "KFC", "2012-3-1", 30);		
		Attendee ds = new Attendee("Damon Song");
		Attendee az = new Attendee("Alain Zhu");
		Attendee dd = new Attendee("David Dong");
		final float expectedTotalCost = 30.0f;
		final float expectedAvgCost = 10.0f;
		final int expectedNumberOfAttendee = 3;
		final String expectedWhoPaid = "Alain Zhu";
		Record rc_ds = new Record();
		Record rc_az = new Record();
		Record rc_dd = new Record();
		
		rc_ds.setAttendee(ds);
		rc_ds.setPaidMoney(-10.0f);
		rc_az.setAttendee(az);
		rc_az.setPaidMoney(30.0f);
		rc_dd.setAttendee(dd);
		rc_dd.setPaidMoney(-10.0f);
		
		float actualTotalCost = 0.0f;
		float actualAvgCost = 0.0f;
		int actualNumberOfAttendee = 0;
		String actualWhoPaid = "Nobody";
		int index;
		
		
		event1.AddRecord(ds, 0, 0);
		event1.AddRecord(az, 0, 30);
		event1.AddRecord(dd, 0, 0);
		
		ds.summaryAll();
		az.summaryAll();
		dd.summaryAll();
		
		actualTotalCost = event1.getTotalCost();
		actualAvgCost = event1.getAvgCost();
		actualNumberOfAttendee = event1.getTotalNumberOfAttendee();
		actualWhoPaid = event1.getWhoPaid();
		
		Assert.assertEquals(expectedTotalCost, actualTotalCost);
		Assert.assertEquals(expectedAvgCost, actualAvgCost);
		Assert.assertEquals(expectedNumberOfAttendee, actualNumberOfAttendee);
		Assert.assertEquals(expectedWhoPaid, actualWhoPaid);
		
		Assert.assertEquals(3, event1.getRecordList().size());

		Assert.assertEquals(rc_ds.getAttendee(), event1.getRecord(0).getAttendee());
		Assert.assertEquals(rc_az.getAttendee(), event1.getRecord(1).getAttendee());
		Assert.assertEquals(rc_dd.getAttendee(), event1.getRecord(2).getAttendee());
		
		String dsLord = ds.getWhoIsMyLord(event1);
		String azLord = az.getWhoIsMyLord(event1);
		String ddLord = dd.getWhoIsMyLord(event1);
		String dsExpectedLord = "Alain Zhu";
		String azExpectedLord = "self";
		String ddExpectedLord = "Alain Zhu";
		
		Assert.assertEquals(dsExpectedLord, dsLord);
		Assert.assertEquals(azExpectedLord, azLord);
		Assert.assertEquals(ddExpectedLord, ddLord);
		
		int howManyPersonOwnDamonOnEvent1 = ds.getNumberOfWhoOwnMe( );
		int howManyPersonOwnAlainOnEvent1 = az.getNumberOfWhoOwnMe( );
		int howManyPersonOwnDavidOnEvent1 = dd.getNumberOfWhoOwnMe( );
		final int expectedPersonNumberOwnDamon = 0;
		final int expectedPersonNumberOwnAlain = 2;
		final int expectedPersonNumberOwnDavid = 0;
		
		Assert.assertEquals(expectedPersonNumberOwnDamon, howManyPersonOwnDamonOnEvent1);
		Assert.assertEquals(expectedPersonNumberOwnAlain, howManyPersonOwnAlainOnEvent1);
		Assert.assertEquals(expectedPersonNumberOwnDavid, howManyPersonOwnDavidOnEvent1);

		String OwnedList[] = {"Damon Song", "David Dong"};
		final float expectedOwnedMoney = 10.0f;
		
		for(index = 0; index < howManyPersonOwnAlainOnEvent1; index++) {
			Assert.assertEquals(OwnedList[index], az.getWhoOwnMe(  index));
			Assert.assertEquals(expectedOwnedMoney, az.getShouldPayMe( index));
		}
	}
	//////////////////////////////////////
	// Who is My Lord Test Suite
	//////////////////////////////////////

	@Test
	public void testWhoisMyLord2P() {
		SetUp(2);
		
		Assert.assertEquals(sh.getName(), ds.getWhoIsMyLord(event));
	}

	@Test
	public void testWhoisMyLord3P() {
		SetUp(3);
		
		Assert.assertEquals(dd.getName(), ds.getWhoIsMyLord(event));
		Assert.assertFalse(sh.getName() == ds.getWhoIsMyLord(event));
	}

	@Test
	public void testWhoisMyLord3PLordwithAccompany() {
		SetUp(4);
		
		Assert.assertEquals(sh.getName(), ds.getWhoIsMyLord(event));
	}

	@Test
	public void testWhoisMyLord10P() {
		SetUp(10);
		
		Assert.assertEquals(az.getName(), ds.getWhoIsMyLord(event));
	}

	@Test
	public void testWhoisMyLordSuite() {
		testWhoisMyLord2P();
		testWhoisMyLord3P();
		testWhoisMyLord3PLordwithAccompany();
		testWhoisMyLord10P();
	}
	//////////////////////////////////////
	// How Many I Should Repay Test Suite
	//////////////////////////////////////	

	@Test
	public void testHowManyIShouldRepayTo2P() {
		SetUp(2);
		
		Assert.assertEquals(30.0f, ds.getHowManyIShouldRepayTo(sh));
	}

	@Test
	public void testHowManyIShouldRepayTo3P() {
		SetUp(3);
		
		Assert.assertEquals(30.0f, ds.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, ds.getHowManyIShouldRepayTo(sh));
		Assert.assertEquals(30.f, sh.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, sh.getHowManyIShouldRepayTo(ds));
	}

	@Test
	public void testHowManyIShouldRepayTo3PLordWithAccompany() {
		SetUp(4);
		
		Assert.assertEquals(30.0f, ds.getHowManyIShouldRepayTo(sh));
	}

	@Test
	public void testHowManyIShouldRepayTo3POwnedWithAccompany() {
		SetUp(5);
		
		Assert.assertEquals(60.0f, ds.getHowManyIShouldRepayTo(sh));
	}

	@Test
	public void testHowManyIShouldRepayTo4PAllWithAccompany() {
		SetUp(6);
		
		Assert.assertEquals(90.0f, ds.getHowManyIShouldRepayTo(sh));
	}

	@Test
	public void testHowManyIShouldRepayTo9PAllWithAccompany() {
		SetUp(7);
		
		Assert.assertEquals(90.0f, ds.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(120.0f, sh.getHowManyIShouldRepayTo(dd));
		Assert.assertEquals(0.0f, dd.getHowManyIShouldRepayTo(dd));
	}

	@Test
	public void testHowManyIShouldRepayTo10P() {
		SetUp(10);
		
		Assert.assertEquals(30.0f, ds.getHowManyIShouldRepayTo(az));
	}

	@Test
	public void testHowManyIShouldRepayToSuite() {
		testHowManyIShouldRepayTo2P(); 
		testHowManyIShouldRepayTo3P();
		testHowManyIShouldRepayTo3PLordWithAccompany();
		testHowManyIShouldRepayTo3POwnedWithAccompany();
		testHowManyIShouldRepayTo4PAllWithAccompany();
		testHowManyIShouldRepayTo9PAllWithAccompany();
		testHowManyIShouldRepayTo10P();
	}

	@Test
	public void testWhoOwnMe2P() {
		SetUp(2);
		
		Assert.assertEquals(1, sh.getNumberOfWhoOwnMe());
		Assert.assertEquals(ds.getName(), sh.getWhoOwnMe(0));
		Assert.assertEquals(30.0f, sh.getShouldPayMe(0));
	}

	@Test
	public void testWhoOwnMe3P() {
		SetUp(3);
		
		int index;
		int numberOfOwned = dd.getNumberOfWhoOwnMe();
		
		Assert.assertEquals(2, numberOfOwned);
		
		for(index = 0; index < numberOfOwned; index++) {
			Assert.assertFalse(dd.getName() == dd.getWhoOwnMe(index));
			Assert.assertEquals(30.0f, dd.getShouldPayMe(index));			
		}
	}

	@Test
	public void testWhoOwnMe9PAllWithAccompany() {
		SetUp(7);
		
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
	
	@Test
	public void testWhoOwnMe10P() {
		SetUp(10);
		
		int index;
		int numberOfOwned = az.getNumberOfWhoOwnMe();
		
		Assert.assertEquals(9, numberOfOwned);
		
		for(index = 0; index < numberOfOwned; index++) {
			Assert.assertFalse(az.getName() == az.getWhoOwnMe(index));
			Assert.assertEquals(30.0f, az.getShouldPayMe(index));			
		}
	}
	
	@Test
	public void testWhoOwnMeSuite() {
		testWhoOwnMe2P();
		testWhoOwnMe3P();
		testWhoOwnMe9PAllWithAccompany();
		testWhoOwnMe10P();
	}

	@Test
	public void test() {
		testCase0();
		testCase1();
		testWhoisMyLordSuite(); 
		testHowManyIShouldRepayToSuite();
		//testWhoOwnMeSuite();
	}

}
