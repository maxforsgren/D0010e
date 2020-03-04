package lab5.event;

import lab5.simulator.*;
import lab5.state.*;

public class PickingEvent extends Event {
		private StoreState state;
		private Customer c;

	public PickingEvent(StoreState state,EventQueue ev,Customer c) {
		this.c = c;
		this.state = state;
		this.eventQueue = ev;
		this.time = state.getPickingTime();
	}
	
	public void execute() {
		
		state.updateTime(time);
		state.setRecentCustomer(c);
		state.setRecentEvent("Plock");
		
		state.updateState();
		
		eventQueue.add((Event) new PaymentEvent(state,eventQueue,c));
		
		
	}

	@Override
	public double getEventTime() {
		// TODO Auto-generated method stub
		return time;
	}

}


