import java.util.ArrayList;


public class Attendee extends Person {
	private int numberOfAccompany = 0;
	private ArrayList<LordRecord> lordList = new ArrayList<LordRecord>();
	private ArrayList<OwnedRecord> ownedList = new ArrayList<OwnedRecord>();
	public ArrayList<Event> eventList = new ArrayList<Event>();
	
	public Attendee(String name) {
		this.setName(name);
	}

	public void addEvent(Event event) {
		eventList.add(event);
	}
	
	public void setNumberOfAccompany(int number) {
		numberOfAccompany = number;
	}
	
	public int getNumberOfAccompany() {
		return numberOfAccompany;
	}
	
	private int GetLordIndexInLordList(String name) {
		int index;
		
		for(index = 0; index < lordList.size(); index++) {
			if(name == lordList.get(index).lordName) {
				return index;
			}
		}
		
		return -1;
	}

	private int GetOwnedIndexInOwnedList(String name) {
		int index;
		
		for(index = 0; index < ownedList.size(); index++) {
			if(name == ownedList.get(index).ownedName) {
				return index;
			}
		}
		
		return -1;
	}	
	
	private void UpdateOwnedMoney(int index, float shouldPay) {
		float money = lordList.get(index).totalOwnedMoney;
		
		money += shouldPay;
		lordList.get(index).totalOwnedMoney = money;
	}
	
	private void UpdateTotalShouldPayMoney(int index, float money){
		float totalMoney = ownedList.get(index).totalShouldPayMoney;
		
		totalMoney += money;
		ownedList.get(index).totalShouldPayMoney = totalMoney;
	}
		
		
		
	public void SummaryMyLord() {
		int i, j;
		String paidPersonName = "No one";
		float shouldPay = 0.0f;
	//	String eventName = "No such a game";
	//	String eventTime = " ";


		
		for(i = 0; i < eventList.size(); i++) {
			
	//		eventName = eventList.get(i).getName();
	//		eventTime = eventList.get(i).getDate();
			shouldPay = eventList.get(i).getAvgCost();
			
			for(j = 0; j < eventList.get(i).getRecordList().size(); j++) {
				
				if(eventList.get(i).getRecordList().get(j).getPaidMoeny() != 0.0) {
					paidPersonName = eventList.get(i).getRecordList().get(j).getAttendee().getName();
									
					if(this.getName() != paidPersonName) {
						 //you owe others
						
						int index = GetLordIndexInLordList(paidPersonName);
						if(index != -1){
							//lord already in Lordlist
							UpdateOwnedMoney(index, shouldPay);							
						}
						else{
							LordRecord e = new LordRecord();
							
							e.lordName = paidPersonName;
							e.totalOwnedMoney = shouldPay;
							
							lordList.add(e);						
						}						
						//System.out.println(this.getName() + " owned " + paidPersonName + " " + shouldPay + " for " + eventName + " on " + eventTime + ".");
					}
					
					break; //Already found my lord
				}
				
			} //end of event
		} //end of eventlist
						
		System.out.println("******************FINALLY************************");
		System.out.println("*  " + this.getName() + " owned:");
		for(i = 0; i < lordList.size(); i++) {
			if(this.getName() != lordList.get(i).lordName)
				System.out.println("*  " + lordList.get(i).lordName + " : " + lordList.get(i).totalOwnedMoney + ".");
		}
		System.out.println("*************************************************");
	}
	
	public void SummaryWhoOwnMe() {
		int i, j;
		String ownMeName = "No one";
		float ownMeMoney = 0.0f;
		int indexOfLord = -1;
		
		for(i = 0; i < eventList.size(); i++) {
			
			ownMeMoney = eventList.get(i).getAvgCost();
			
			for(j = 0; j < eventList.get(i).getRecordList().size(); j++) { //find lord in single event				
				if((eventList.get(i).getRecordList().get(j).getPaidMoeny() != 0.0) &&
					(eventList.get(i).getRecordList().get(j).getAttendee().getName() == this.getName()))	{
					indexOfLord = j;
					break;
				}
			}
			
			if(indexOfLord != -1) {
				for(j = 0; j < eventList.get(i).getRecordList().size(); j++) {
					if(indexOfLord != j) {
						
						int index;
						
						ownMeName = eventList.get(i).getRecord(j).getAttendee().getName();
						index = GetOwnedIndexInOwnedList(ownMeName);
						
						if(index != -1){
							//Find name in list
							UpdateTotalShouldPayMoney(index, ownMeMoney);
						}
						else{
							//Can't find and add to list
							OwnedRecord e = new OwnedRecord();
							
							e.ownedName = ownMeName;
							e.totalShouldPayMoney = ownMeMoney ;
							
							ownedList.add(e);
						}
					}
				}
			}//Rescan event in record list
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("*  " + this.getName() + " should get money from:");
		for(i = 0; i < ownedList.size(); i++) {
			if(this.getName() != ownedList.get(i).ownedName)
				System.out.println("*  " + ownedList.get(i).ownedName + " : " + ownedList.get(i).totalShouldPayMoney + ".");
		}
		System.out.println("*************************************************");
	}
}
