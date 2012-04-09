package MultiEventTestSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Brain.Attendee;
import Brain.Event;

public class FourEventFourPaid {
	Event swimming = null;
	Event fb = null;
	Event msj = null;
	Event swimming2 = null;
	
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
		swimming2 = new Event("Swimming", "ChunJian", "2012-4-11", 240); //30 avg
		
		sh = new Attendee("Simon Huang");
		ds = new Attendee("Damon Song");
		dd = new Attendee("David Dong");
		wy = new Attendee("Wesley Yan");
		
		az = new Attendee("Alain Zhu");
		fw = new Attendee("Fan Wang");
		jl = new Attendee("Jan Liu");
		jz = new Attendee("Jet Zhang");
		
		swimming.AddRecord(sh, 0, 120);
		swimming.AddRecord(ds, 0, 0);
		swimming.AddRecord(dd, 0, 0);
		swimming.AddRecord(wy, 0, 0);
		
		fb.AddRecord(sh, 0, 0);
		fb.AddRecord(ds, 0, 0);
		fb.AddRecord(dd, 0, 0);
		fb.AddRecord(wy, 0, 400);
		
		msj.AddRecord(sh, 0, 0);
		msj.AddRecord(ds, 0, 800);
		msj.AddRecord(dd, 0, 0);
		msj.AddRecord(wy, 0, 0);
		
		swimming2.AddRecord(sh, 0, 0);
		swimming2.AddRecord(ds, 0, 0);
		swimming2.AddRecord(az, 0, 0);
		swimming2.AddRecord(dd, 0, 240);
		swimming2.AddRecord(wy, 0, 0);
		swimming2.AddRecord(fw, 0, 0);
		swimming2.AddRecord(jl, 0, 0);
		swimming2.AddRecord(jz, 0, 0);
		
		sh.summaryAll();
		ds.summaryAll();
		dd.summaryAll();
		wy.summaryAll();
		az.summaryAll();
		fw.summaryAll();
		jl.summaryAll();
		jz.summaryAll();
	}

	@Test
	public void testLordOfSimon() {
		int lordNumber = sh.getNumberOfLord();
		assertEquals(2, lordNumber);
		
		assertEquals(0, sh.WhereIsMyLord(wy.getName()));
		assertEquals(1, sh.WhereIsMyLord(ds.getName()));
		assertEquals(wy.getName(), sh.getMyLordName(0));
		assertEquals(ds.getName(), sh.getMyLordName(1));
		
		assertEquals(170.0f, sh.getHowManyIShouldRepayTo(ds), 0);
		assertEquals(70.0f, sh.getHowManyIShouldRepayTo(wy), 0);
		assertEquals(0.0f, sh.getHowManyIShouldRepayTo(jz), 0);
	}
	
	@Test
	public void testLordOfDamon() {	
		assertEquals(0, ds.getNumberOfLord());
	}
	
	@Test
	public void testLordOfDavid() {	
		int lordNumber = dd.getNumberOfLord();
		assertEquals(2, lordNumber);

		assertEquals(wy.getName(), dd.getMyLordName(0));
		assertEquals(ds.getName(), dd.getMyLordName(1));
		
		assertEquals(170.0f, dd.getHowManyIShouldRepayTo(ds), 0);
		assertEquals(70.0f, dd.getHowManyIShouldRepayTo(wy), 0);
		assertEquals(0.0f, dd.getHowManyIShouldRepayTo(jl), 0);
	}
	
	@Test
	public void testLordOfWesley() {	
		int lordNumber = wy.getNumberOfLord();
		assertEquals(1, lordNumber);

		assertEquals(ds.getName(), wy.getMyLordName(0));
		
		assertEquals(100.0f, wy.getHowManyIShouldRepayTo(ds), 0);
		assertEquals(0.0f, wy.getHowManyIShouldRepayTo(az), 0);
	}
	
	@Test
	public void testLordOfAlain() {	
		int lordNumber = az.getNumberOfLord();
		assertEquals(1, lordNumber);

		assertEquals(dd.getName(), az.getMyLordName(0));
		
		assertEquals(30.0f, az.getHowManyIShouldRepayTo(dd), 0);
		assertEquals(0.0f, az.getHowManyIShouldRepayTo(fw), 0);
	}
	
	@Test
	public void testOwnedOfSimon() {	
		int OwnedNumber = sh.getNumberOfOwned();
		assertEquals(0, OwnedNumber);
	}
	
	@Test
	public void testOwnedOfDamon() {	
		int OwnedNumber = ds.getNumberOfOwned();
		assertEquals(3, OwnedNumber);
		
		int i = ds.WhereIsMyOwned("Simon Huang");
		int j = ds.WhereIsMyOwned("David Dong");
		int k = ds.WhereIsMyOwned("Wesley Yan");
		
		assertEquals(sh.getName(), ds.getMyOwnedName(i));
		assertEquals(dd.getName(), ds.getMyOwnedName(j));
		assertEquals(wy.getName(), ds.getMyOwnedName(k));
		
		assertEquals(-1, ds.WhereIsMyOwned("Alain Zhu"));
		
		assertEquals(170.0f, ds.getShouldPayMe(i), 0);
		assertEquals(170.0f, ds.getShouldPayMe(j), 0);
		assertEquals(100.0f, ds.getShouldPayMe(k), 0);
	}

	@Test
	public void testOwnedOfDavid() {	
		int OwnedNumber = dd.getNumberOfOwned();
		assertEquals(4, OwnedNumber);
		
		int i = dd.WhereIsMyOwned("Alain Zhu");
		int j = dd.WhereIsMyOwned("Fan Wang");
		int k = dd.WhereIsMyOwned("Jan Liu");
		int m = dd.WhereIsMyOwned("Jet Zhang");
		
		assertEquals(az.getName(), dd.getMyOwnedName(i));
		assertEquals(fw.getName(), dd.getMyOwnedName(j));
		assertEquals(jl.getName(), dd.getMyOwnedName(k));
		assertEquals(jz.getName(), dd.getMyOwnedName(m));
		
		assertEquals(-1, dd.WhereIsMyOwned("Simon Huang"));
		
		assertEquals(30.0f, dd.getShouldPayMe(i), 0);
		assertEquals(30.0f, dd.getShouldPayMe(j), 0);
		assertEquals(30.0f, dd.getShouldPayMe(k), 0);
		assertEquals(30.0f, dd.getShouldPayMe(m), 0);
	}
	
	@Test
	public void testOwnedOfWesley() {	
		int OwnedNumber = wy.getNumberOfOwned();
		assertEquals(2, OwnedNumber);
		
		int i = wy.WhereIsMyOwned("Simon Huang");
		int j = wy.WhereIsMyOwned("David Dong");
		
		assertEquals(sh.getName(), wy.getMyOwnedName(i));
		assertEquals(dd.getName(), wy.getMyOwnedName(j));

		
		assertEquals(-1, wy.WhereIsMyOwned("Jet Zhang"));
		
		assertEquals(70.0f, wy.getShouldPayMe(i), 0);
		assertEquals(70.0f, wy.getShouldPayMe(j), 0);

	}
	
	@Test
	public void testOwnedOfAlain() {	
		int OwnedNumber = az.getNumberOfOwned();
		assertEquals(0, OwnedNumber);
	}
}
