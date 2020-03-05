package lab5.event;

import lab5.simulator.Event;
import lab5.simulator.EventQueue;
import lab5.state.StoreState;

public class StartEvent extends Event {
	private double time = 0;
	//private EventQueue queue;
	private StoreState state;
	
	/**
	 * constructor that starts the simulation.
	 * 
	 * @param state the state that will be modified. 
	 * @param queue where new events will be created and placed.
	 */
	public StartEvent(StoreState state, EventQueue queue) {
		this.state = state;
		this.eventQueue = queue;
	}
	
	/**
	 * the changes in the event takes place here.
	 */
	public void execute() {
		//Update state.
		state.openStore();
		
		//display view - anropa update.
		
		// creates the customer arrival.
		eventQueue.add(new ArrivalEvent(state, eventQueue));
		
		state.updateState();
	}

	public double getEventTime() {
		return this.time;
	}
	
	/**
	 * the name of the event.
	 * 
	 * @return StartEvent.
	 */
	public String getEventname() {
		return "StartEvent";
	}
}
