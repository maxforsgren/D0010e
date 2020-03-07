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
		state.setRecentCustomer(this.c);
		state.setRecentEvent("Plock    ");
		
		
		if(eventQueue.getQueueSize() > 1) {
			state.updateCheckQueue(eventQueue);
		}
		
		if(state.getFreeCheckouts() > 0) {
			
			eventQueue.add(new PaymentEvent(state, eventQueue, this.c));
			state.updateState();
			state.addCheckoutCustomer();
		//Om kassorna är fulla lägger vi till en kund till kassakön.
		} else {
			
			state.updateState();
			state.addToCheckoutLine(this.c);
			state.addTotalNoQueue();
			//Lägg till kunder i FIFO som står i kö.
		}
		
		
		
		
		state.setRecentTime(this.time);
		
		
		
	}

	@Override
	public double getEventTime() {
		// TODO Auto-generated method stub
		return time;
	}

}


