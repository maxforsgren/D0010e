package lab5.event;


import lab5.simulator.Event;
import lab5.simulator.EventQueue;
import lab5.state.StoreState;

public class StopEvent extends Event {
	private double time;
	private StoreState state;
	
	/**
	 * constructor that starts the simulation.
	 * 
	 * @param state the state that will be modified. 
	 * @param queue where new events will be created and placed.
	 */
	public StopEvent(StoreState state, EventQueue queue) {
		this.state = state;
		this.eventQueue = queue;
		this.time = state.getStopTime();
	}
	
	/**
	 * the changes in the event takes place here.
	 * when the closing time for the store is reached this is where we close the store.
	 */
	public void execute() {
		//Update state. 
		state.updateTime(this.time);
		state.setRecentEvent("Stop");
		state.updateState();
		//Sätter flaggan till falsk. avslutar simuleringen.
		state.stopSim();
		state.updateState();
		
		
		//display view - anropa update.
		//state.updateState();
		
	}

	public double getEventTime() {
		return this.time;
	}
	
}
