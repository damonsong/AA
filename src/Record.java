
public class Record {
	private Attendee attendee;
	private float paidMoney = 0.0f;

	
	public void setAttendee(Attendee a) {
		attendee = a;
	}
	
	public Attendee getAttendee() {
		return attendee;
	}
	
	public void setPaidMoney(float money) {
		paidMoney = money;
	}
	
	public float getPaidMoeny() {
		return paidMoney;
	}

}
