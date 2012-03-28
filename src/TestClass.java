
public class TestClass {
	public static void main(String arg[]){
		Event event1 = new Event("Swimming", "Chun Jian", "2012-2-1", 180);
		Event event2 = new Event("FB", "NYPD", "2012-2-1", 120);
		Event event3 = new Event("Swimming", "Chun Jian", "2012-3-1", 300);
		
		Attendee ds = new Attendee("Damon Song");
		Attendee az = new Attendee("Alain Zhu");
		Attendee dd = new Attendee("David Dong");
		Attendee fw = new Attendee("Fan Wang");
		Attendee wy = new Attendee("Wesley Yan");

		
		event1.AddRecord(ds, 0, 0);
		event1.AddRecord(az, 0, 0);
		event1.AddRecord(dd, 0, 0);
		event1.AddRecord(fw, 2, 180.0f);
		
		event1.Summary();
		

		
		event2.AddRecord(ds, 0, 120);
		event2.AddRecord(az, 0, 0);
		event2.AddRecord(dd, 0, 0);	
		
		event2.Summary();

		
		event3.AddRecord(ds, 5, 300);
		event3.AddRecord(az, 0, 0);
		event3.AddRecord(dd, 0, 0);
		event3.AddRecord(fw, 0, 0);
		event3.AddRecord(wy, 0, 0);
		
		event3.Summary();
	
		//////////////////////////////////////////////////
		ds.SummaryMyLord();
		az.SummaryMyLord();
		dd.SummaryMyLord();
		fw.SummaryMyLord();
		wy.SummaryMyLord();
		
		ds.SummaryWhoOwnMe();
		az.SummaryWhoOwnMe();
		dd.SummaryWhoOwnMe();
		fw.SummaryWhoOwnMe();
		wy.SummaryWhoOwnMe();
	}
}
