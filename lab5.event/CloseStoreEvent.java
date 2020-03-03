package lab5.event;

import lab5.simulator.*;
import lab5.random.*;

public class CloseStoreEvent extends Event {
	
	public CloseStoreEvent(double timeToStart) {
		getTimeToStart();
	}
	
	public void execute() {
		queue.add(New StopEvent);
	}
}
