import static org.junit.Assert.*;

import org.junit.Test;


public class singleEvent {

	@Test
	public void test() {
		int i = 0;
		
		assertEquals(i, 1);
		
		Event event1 = new Event("FB1", "KFC", "2012-3-10", 50);
		
		Attendee ds = new Attendee("Damon Song");
		Attendee az = new Attendee("Alain Zhu");
		Attendee dd = new Attendee("David Dong");
		
		event1.AddRecord(ds, 0, 0);
		event1.AddRecord(az, 2, 50);
		event1.AddRecord(dd, 0, 0);
		
		event1.Summary();
		
		ds.SummaryMyLord();
		ds.SummaryWhoOwnMe();
		
		az.SummaryMyLord();
		az.SummaryWhoOwnMe();
		
		dd.SummaryMyLord();
		dd.SummaryWhoOwnMe();
		
		//fail("Not yet implemented");
	}

}
