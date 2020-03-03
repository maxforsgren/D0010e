package lab5.event;

import lab5.simulator.*;
import lab5.random.*;

public class PickingEvent extends Event {
	
	public PickingEvent(double timeToStart) {
		getTimeToStart(timeToStart);
	}
	
	public void execute() {
		if(NOCheckouts > 0) {
			NOCheckouts--;
			queue.add(New PaymentEvent);
		}else {
			customerQueue.add(New PaymentEvent);
		}
	}

}
