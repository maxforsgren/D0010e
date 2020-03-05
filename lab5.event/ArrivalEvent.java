package lab5.event;

import lab5.simulator.Event;
import lab5.simulator.EventQueue;
import lab5.state.Customer;
import lab5.state.StoreState;

public class ArrivalEvent extends Event {
	private double time;
	//private EventQueue queue;
	private StoreState state;
	private Customer c;
	
	
	/**
	 * constructor for ArrivalEvent.
	 * 
	 * @param state the state that will be modified.
	 * @param queue where new events will be created and placed.
	 */
	public ArrivalEvent(StoreState state, EventQueue queue) {
		this.state = state;
		this.eventQueue= queue;
		this.time = state.getArrivalTime();
		this.c = state.newCustomer();
	}
	
	public void execute() {
		//Update state
		state.updateTime(this.time);
		state.setRecentEvent("Ankomst  ");
		state.setRecentCustomer(this.c);
		
		
		if(state.getIsPlace()) {
			if(state.getStoreStatus()) {
				state.addCustomerInStore();
				eventQueue.add((Event) new ArrivalEvent(state, eventQueue));
				eventQueue.add((Event) new PickingEvent(state, eventQueue,this.c));
				state.updateCheckQueue(eventQueue);
				state.updateState();
			}
			
			
			
		}
		else {
			state.addMissedCustomer();
		}
	}
	
	public double getEventTime() {
		System.out.println(this.time);
		return this.time;
	}
	
	public String getEventname() {
		return "ArrivalEvent";
	}
	
	
}
