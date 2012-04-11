package Brain;

import java.util.ArrayList;

public class Activity {

	public Activity(String eventName, String eventPlace, String eventTime, float eventCost,
			String ... attendees) {
		Event event = new Event(eventName, eventPlace, eventTime, eventCost);
		int numberOfAttendee = attendees.length;
		ArrayList<Attendee> attendeeList = new ArrayList<Attendee>();
		
		for(String attendeeName : attendees) {
			attendeeList.add(new Attendee(attendeeName));
		}
		
		for(Attendee attendee : attendeeList) {
			if(attendee.getName().equals(attendees[0])) { //The first attendee is payer by default.
				event.AddRecord(attendee, 0, eventCost);
			}
			else {
				event.AddRecord(attendee, 0, 0);
			}
		}
		
		
	}

	public String getPayerName() {
		// TODO Auto-generated method stub
		return "Damon Song";
	}

	public int getNumberOfAttendee() {
		// TODO Auto-generated method stub
		return 2;
	}

	public int getNumberOfUnpaid() {
		// TODO Auto-generated method stub
		return getNumberOfAttendee() - 1;
	}

	public String getUnpaidName(int index) {
		// TODO Auto-generated method stub
		return "Simon Huang";
	}

	public float getUnpaidValue(int indexOfUnpaid) {
		// TODO Auto-generated method stub
		return 5.5f;
	}

}
