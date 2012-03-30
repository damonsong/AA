
public class TestClass {
	private static void TestUnit1() {
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
		
	}
	
	private static void TestUnit2() {
		Event event2 = new Event("Swimming", "Chunjian", "2012-3-11", 50);
		
		
		Attendee ds = new Attendee("Damon Song");
		Attendee az = new Attendee("Alain Zhu");
		Attendee dd = new Attendee("David Dong");
		
		event2.AddRecord(ds, 2, 0);
		event2.AddRecord(az, 0, 50);
		event2.AddRecord(dd, 0, 0);
		
		event2.Summary();
		
		ds.SummaryMyLord();
		ds.SummaryWhoOwnMe();
		
		az.SummaryMyLord();
		az.SummaryWhoOwnMe();
		
		dd.SummaryMyLord();
		dd.SummaryWhoOwnMe();
		
	}
	
	private static void TestUnit3() {
		Event event1 = new Event("FB1", "KFC", "2012-3-10", 50);
		Event event2 = new Event("Swimming", "Chunjian", "2012-3-11", 50);
		
		
		Attendee ds = new Attendee("Damon Song");
		Attendee az = new Attendee("Alain Zhu");
		Attendee dd = new Attendee("David Dong");

		event1.AddRecord(ds, 0, 0);
		event1.AddRecord(az, 2, 50);
		event1.AddRecord(dd, 0, 0);		
		
		event2.AddRecord(ds, 2, 0);
		event2.AddRecord(az, 0, 50);
		event2.AddRecord(dd, 0, 0);
		
		//event2.Summary();
		
		ds.SummaryMyLord();
		ds.SummaryWhoOwnMe();
		
		az.SummaryMyLord();
		az.SummaryWhoOwnMe();
		
		dd.SummaryMyLord();
		dd.SummaryWhoOwnMe();
		
	}
	public static void main(String arg[]){
		
		//TestUnit1();
		
		//TestUnit2();
		
		//TestUnit3();
		/*
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
		*/
	}
}
