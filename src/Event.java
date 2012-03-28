import java.util.ArrayList;


public class Event {
	private String name;
	private String place;
	private String date;
	private float totalCost = 0.0f;
	private int totalNumberOfAttendee = 0;
	private ArrayList<Record> RecordList = new ArrayList<Record>();

	
	public Event(String eventName, String where, String when, int totalCost) {		
		this.name = eventName;
		this.place = where;
		this.date = when;
		this.totalCost = totalCost;
	}

	
	public String getName() {
		return name;
	}
	
	public String getPlace() {
		return place;
	}
	
	public String getDate() {
		return date;
	}
	
	public float getTotalCost() {
		return totalCost;
	}
	
	public float getAvgCost() {

		if(this.getTotalNumberOfAttendee() != 0) {
			return (totalCost / totalNumberOfAttendee);			
		}
		else {
			System.out.println("Woops! No attendee!");
			return 0.0f;
		}
	}
	
	public int getTotalNumberOfAttendee() {	
		return totalNumberOfAttendee;
	}
	
	private void UpdateTotalNumberOfAttendee(int numberOfAccompany) {
		this.totalNumberOfAttendee += (1 + numberOfAccompany);
	}
	
	public void AddRecord(Attendee attendee, int numberOfAccompany, float paidMoney){
		
		Record e = new Record();
		
		attendee.setNumberOfAccompany(numberOfAccompany);
		e.setAttendee(attendee);
		e.setPaidMoney(paidMoney);		
		getRecordList().add(e);
		
		this.UpdateTotalNumberOfAttendee(numberOfAccompany);
		attendee.addEvent(this);
	}
	
	public Record getRecord(int index) {
		Record e = new Record();
		
		e = getRecordList().get(index);
		
		return e; 
	}

	public void Summary() {
		int i;
		float avgCost = this.getAvgCost();
		String whoPaid = "No one";
		float paidMoney = 0.0f;
		
		System.out.println("+++++++++++++++++++++++ Summery +++++++++++++++++++++++++++++++++++");
		System.out.println(">>> Total " + this.getTotalNumberOfAttendee() + " persons attend " + this.getName() + " on " + this.getDate());
		System.out.println(">>> It costs " + this.getTotalCost());
		System.out.println(">>> avg cost is " + avgCost);
		
		for(i = 0; i < getRecordList().size(); i++) {
			if (getRecordList().get(i).getPaidMoeny() > 0) {
				whoPaid = getRecordList().get(i).getAttendee().getName();
				paidMoney = getRecordList().get(i).getPaidMoeny();
				break;
			}
		}
		
		System.out.println(">>> " + whoPaid + " spent " + paidMoney + " for all of us!");
		
		for(i = 0; i < getRecordList().size(); i++) {
			if (getRecordList().get(i).getAttendee().getName() != whoPaid) {
				System.out.println(getRecordList().get(i).getAttendee().getName() + " own " + whoPaid + " " + this.getAvgCost() + ".");
			}

		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
	}


	public ArrayList<Record> getRecordList() {
		return RecordList;
	}


	public void setRecordList(ArrayList<Record> recordList) {
		RecordList = recordList;
	}
}
