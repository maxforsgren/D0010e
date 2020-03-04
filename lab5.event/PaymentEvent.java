
package lab5.event;

import lab5.simulator.Event;
import lab5.simulator.EventQueue;
import lab5.state.Customer;
import lab5.state.StoreState;

public class PaymentEvent extends Event{
		private Customer c;
		private StoreState state;
	
	public PaymentEvent(StoreState state, EventQueue ev,Customer c) {
		this.c = c;
		this.state = state;
		this.eventQueue = ev;
		this.time = state.getCheckoutTime();
		
	}
	
	public void execute() {
		if (state.getFreeCheckouts() == 0) {
			state.checkoutLine.add(c);
			state.addTotalNoQueue();
		}
		else {
			state.addCheckoutCustomer();
			
		}
		
		
				
	}

	@Override
	public double getEventTime() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
