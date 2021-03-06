package Brain;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;


public class Attendee extends Person implements Serializable{
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
		int paidPersonAccompany = 0;
		float shouldPay = 0.0f;
	//	String eventName = "No such a game";
	//	String eventTime = " ";


		
		for(i = 0; i < eventList.size(); i++) {
			
	//		eventName = eventList.get(i).getName();
	//		eventTime = eventList.get(i).getDate();
			
			/////////////////========This loop should move to Event class as a method================////////////////////////
			for(j = 0; j < eventList.get(i).getRecordList().size(); j++) {
				if((this.getName() == eventList.get(i).getRecordList().get(j).getAttendee().getName()) && 
				(eventList.get(i).getRecordList().get(j).getPaidMoeny() == 0.0)) {
					int accompanyNumber = eventList.get(i).getRecordList().get(j).getAttendee().getNumberOfAccompany();
					
					shouldPay = eventList.get(i).getAvgCost() * (1 + accompanyNumber);
					break;
				}
			}
			////////////////=====================================================================/////////////////////////
			
			for(j = 0; j < eventList.get(i).getRecordList().size(); j++) {
				
				if(eventList.get(i).getRecordList().get(j).getPaidMoeny() != 0.0) {
					paidPersonName = eventList.get(i).getRecordList().get(j).getAttendee().getName();
					//paidPersonAccompany = eventList.get(i).getRecordList().get(j).getAttendee().getNumberOfAccompany();
									
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
						
		System.out.println("******************Lords************************");
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
			
			indexOfLord = -1;
			
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
						ownMeMoney = ((eventList.get(i).getRecord(j).getAttendee().getNumberOfAccompany() + 1) * eventList.get(i).getAvgCost());
						
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
		System.out.println(" ");
		System.out.println("++++++++++++++++++++OwnedList+++++++++++++++++++++++++++++");
		System.out.println("*  " + this.getName() + " should get money from:");
		for(i = 0; i < ownedList.size(); i++) {
			if(this.getName() != ownedList.get(i).ownedName)
				System.out.println("*  " + ownedList.get(i).ownedName + " : " + ownedList.get(i).totalShouldPayMoney + ".");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	// Must be called after SummaryMyLord() and SummaryWhoOwnMe()
	// This behavior will balance my lord and who owned me.
	// If someone in my lord list and also in my owned list, balance
	// the money.
	// If amount of lord and owned are same, remove from both lists.
	// If amount of lord greater than owned, substract owned money and keep in lord list.
	// If amount of lord less then owned, substract lord money and keep in owned list.
	/////////////////////////////////////////////////////////////////////////////////////
	private void BalanceMyLordAndWhoOwnMe() {
		int indexOfLordList = -1;
		int indexOfOwnedList = -1;
		ArrayList<String> removedLordList = new ArrayList<String>();
		ArrayList<String> removedOwnedList = new ArrayList<String>();
		
		//Go through Lord List
		for(indexOfLordList = 0; indexOfLordList < this.lordList.size(); indexOfLordList++) {
			//Pick up one and find in owned list
			for(indexOfOwnedList = 0; indexOfOwnedList < this.ownedList.size(); indexOfOwnedList++) {
				//Exist in owned list?
				if(this.lordList.get(indexOfLordList).lordName.equals(this.ownedList.get(indexOfOwnedList).ownedName)){
					if(this.lordList.get(indexOfLordList).totalOwnedMoney == this.ownedList.get(indexOfOwnedList).totalShouldPayMoney) {
						this.lordList.get(indexOfLordList).totalOwnedMoney = 0;
						this.ownedList.get(indexOfOwnedList).totalShouldPayMoney = 0;
						removedLordList.add(this.lordList.get(indexOfLordList).lordName);
						removedOwnedList.add(this.ownedList.get(indexOfOwnedList).ownedName);
					}
					else if(this.lordList.get(indexOfLordList).totalOwnedMoney > this.ownedList.get(indexOfOwnedList).totalShouldPayMoney){
						float balanced = this.lordList.get(indexOfLordList).totalOwnedMoney -  this.ownedList.get(indexOfOwnedList).totalShouldPayMoney;
						
						this.lordList.get(indexOfLordList).totalOwnedMoney = balanced;
						this.ownedList.get(indexOfOwnedList).totalShouldPayMoney = 0;
						removedOwnedList.add(this.ownedList.get(indexOfOwnedList).ownedName);
					}
					else {
						float balanced = this.ownedList.get(indexOfOwnedList).totalShouldPayMoney  -  this.lordList.get(indexOfLordList).totalOwnedMoney;
						
						this.ownedList.get(indexOfOwnedList).totalShouldPayMoney = balanced;
						this.lordList.get(indexOfLordList).totalOwnedMoney = 0;	
						removedLordList.add(this.lordList.get(indexOfLordList).lordName);
					}
				} //Exist in owned list
				
			} // Loop in owned list
			
		}// loop in lord list
		
		//Remove element from lordList if totalOwnedMoney is zero
		for(indexOfLordList = 0; indexOfLordList < removedLordList.size(); indexOfLordList++) {
			String name = removedLordList.get(indexOfLordList).toString();
			int i = this.WhereIsMyLord(name);
			this.lordList.remove(i);
		}
		//Remove element from ownedList if totalShouldPayMoney is zero
		for(indexOfOwnedList = 0; indexOfOwnedList < removedOwnedList.size(); indexOfOwnedList++) {
			String name = removedOwnedList.get(indexOfOwnedList).toString();
			int i = this.WhereIsMyOwned(name);
			this.ownedList.remove(i);
		}
	}
	
	public int WhereIsMyOwned(String name) {
		int index = -1;
		
		for(index = 0; index < getNumberOfOwned(); index++) {
			if(getMyOwnedName(index).equals(name)) {
				break;
			}
		}
		
		if(index == getNumberOfOwned()) {
			return -1;
		}
		else {
			return index;
		}
	}

	public void summaryAll() {
		SummaryMyLord();
		SummaryWhoOwnMe();
		BalanceMyLordAndWhoOwnMe();
	}

	public ArrayList<OwnedRecord> getOwnMeList() {

		return ownedList;
	}

	public int getNumberOfWhoOwnMe() {

		return ownedList.size();
	}

	public String getWhoIsMyLord(Event event1) {
		int index = eventList.indexOf(event1);
		String whoPaid = eventList.get(index).getWhoPaid();
		
		if(this.getName() == whoPaid){
			return "self";
		}
		else {
			return whoPaid;			
		}

	}

	public String getWhoOwnMe(int index) {		
		return ownedList.get(index).ownedName;
	}

	public float getShouldPayMe(int index) {
		return ownedList.get(index).totalShouldPayMoney;
	}

	public int getNumberOfIShouldRepayTo() {
		int result = lordList.size();
		return result;
	}

	public float getHowManyIShouldRepayTo(Attendee myLord) {
		float result = 0.0f;
		int index = -1;
		
		for(int i = 0; i < lordList.size(); i++) {
			if (myLord.getName() == lordList.get(i).lordName){
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			result = lordList.get(index).totalOwnedMoney;
		}
		else{
			System.out.println(myLord.getName() + " is not my lord!");
		}
		
		return result;
	}

	public int getNumberOfLord() {
		int numberOfLord = 0;
		
		numberOfLord = this.lordList.size();
		
		return numberOfLord;
	}
	
	public int getNumberOfOwned() {
		return this.ownedList.size();
	}

	public String getMyLordName(int i) {
		return this.lordList.get(i).lordName;
	}
	
	public String getMyOwnedName(int i) {
		return this.ownedList.get(i).ownedName;
	}
	
	public int WhereIsMyLord(String name) {
		int index = -1;
		
		for(index = 0; index < getNumberOfLord(); index++) {
			if(getMyLordName(index).equals(name)) {
				break;
			}
		}
		
		if(index == getNumberOfLord()) {
			return -1;
		}
		else {
			return index;
		}
	}
}
