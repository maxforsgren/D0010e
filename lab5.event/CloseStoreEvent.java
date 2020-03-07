package lab5.event;


import lab5.simulator.Event;
import lab5.simulator.EventQueue;
import lab5.state.StoreState;

public class CloseStoreEvent extends Event {
	private double time;
	private StoreState state;
	
	/**
	 * constructor that starts the simulation.
	 * 
	 * @param state the state that will be modified. 
	 * @param queue where new events will be created and placed.
	 */
	public CloseStoreEvent(StoreState state, EventQueue queue) {
		this.state = state;
		this.eventQueue = queue;
		this.time = state.getOpeningHours();
	}
	
	/**
	 * the changes in the event takes place here.
	 * when the closing time for the store is reached this is where we close the store.
	 */
	public void execute() {
		//Update state. 
		state.updateTime(time);
		state.setRecentEvent("Stänger  ");
		
		//Stänger butiken
		if(eventQueue.getQueueSize() > 2) {
			state.updateCheckQueue(eventQueue);
		}			
		
		
		//display view - anropa update.
		state.updateState();
		//state.changeDummy();
	
		state.setRecentTime(this.time);
		state.closeStore();
		
		
	}

	public double getEventTime() {
		return this.time;
	}
	
}
