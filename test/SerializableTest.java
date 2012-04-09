import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Brain.Attendee;
import Brain.Database;
import Brain.Event;


import junit.framework.Assert;

public class SerializableTest {
	private void SaveLoadEvent() throws IOException, ClassNotFoundException {
		Event event = new Event("Swimming", "FT", "2012-1-1", 30);
		Event resumedEvent = null;
		Database db = new Database();
		
		db.saveEvent(event);
		resumedEvent = db.loadEvent( );
		
		Assert.assertEquals(event.getName(), resumedEvent.getName());
		Assert.assertEquals(event.getTotalCost(), resumedEvent.getTotalCost());
		Assert.assertEquals(event.getPlace(), resumedEvent.getPlace());
		Assert.assertEquals(event.getDate(), resumedEvent.getDate());
	}
	
	private void SaveLoadSession() throws IOException, ClassNotFoundException {
		Event event1 = new Event("Swimming", "FT", "2012-2-1", 90);
		Event event2 = new Event("FB", "KFC", "2012-2-1", 90);
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
		
		db.saveEvent(event1);
		db.saveEvent(event2);
		db.saveAttendee(sh);
		db.saveAttendee(wy);
		db.saveAttendee(dd);
		
		Attendee resumedSimon = db.loadAttendee("Simon Huang");
		Attendee resumedDavid = db.loadAttendee("David Dong");
		float expectedRepayOfDavid = 60.0f;
		float expectedRepayOfSimon = 0.0f;
		
		System.out.println("$#@$#@");
		System.out.println(db.loadEvent().getRecordList().get(0).getAttendee().toString());
		System.out.println(resumedSimon.toString());
		
		Assert.assertEquals(expectedRepayOfSimon, sh.getHowManyIShouldRepayTo(dd));
		
		Assert.assertEquals(expectedRepayOfSimon, resumedSimon.getHowManyIShouldRepayTo(resumedDavid));
		
		
		
		Assert.assertEquals(sh.getHowManyIShouldRepayTo(dd), resumedSimon.getHowManyIShouldRepayTo(resumedDavid));
		Assert.assertEquals(expectedRepayOfDavid, dd.getHowManyIShouldRepayTo(sh));
//		Assert.assertEquals(expectedRepayOfDavid, resumedDavid.getHowManyIShouldRepayTo(resumedSimon));
		
	}
	@Test
	public void test() throws ClassNotFoundException, IOException {
		SaveLoadEvent();
		SaveLoadSession();
		//fail("Not yet implemented");
	}

}
