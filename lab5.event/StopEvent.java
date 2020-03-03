package lab5.event;

import lab5.simulator.*;
import lab5.random.*;

public class StopEvent extends Event {
	
	public StopEvent(double timeToStart) {
		
	}
	
	public void execute() {
		stopSim = true;
	}
	


}
