import java.io.*;

public class Database {
	private String getEventFileName(String name, String place, String date) {
		return "Event.ser";//name + "_" + place + "_" + date + ".ser";
	}
	public void saveEvent(Event event) throws IOException {
		String eventName = event.getName();
		String eventPlace = event.getPlace();
		String eventDate = event.getDate();
		String saveFileName = getEventFileName(eventName, eventPlace, eventDate);
		FileOutputStream filesystem = new FileOutputStream(saveFileName);
		ObjectOutputStream os = new ObjectOutputStream(filesystem);
		
		os.writeObject(event);
		os.close();
	}

	public Event loadEvent() throws IOException, ClassNotFoundException {	
		FileInputStream filesystem = new FileInputStream("Event.ser");
		ObjectInputStream os = new ObjectInputStream(filesystem);
		
		Object o = os.readObject();
		Event e = (Event)o;
		
		os.close();
		return e;
	}
	
	public void saveAttendee(Attendee a) throws IOException {
		String fileName = a.getName() + ".ser";
		FileOutputStream filesystem = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(filesystem);
		
		os.writeObject(a);
		os.close();
	}

	public Attendee loadAttendee(String attendeeName) throws IOException, ClassNotFoundException {	
		String fileName = attendeeName + ".ser";
		FileInputStream filesystem = new FileInputStream(fileName);
		ObjectInputStream os = new ObjectInputStream(filesystem);
		
		Object o = os.readObject();
		Attendee a = (Attendee)o;
		
		os.close();
		return a;
	}

}
