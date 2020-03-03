package lab5.event;

import lab5.simulator.*;
import lab5.random.*;

public class PaymentEvent extends Event {
	
	public PaymentEvent(double timeToStart) {
		getTimeToStart(timeToStart);
	}
	
	public void execute() {
		if(customerQueue.isEmpty != true) {
			customerQueue.remove(0);
			NOCheckouts--;
			queue.add(New PaymentEvent);
		}else {
			NOCheckouts++;
		}
		finishedCustomers++;
		customersInStore--;
		NOCheckouts++;
	}
}
