package lab5.event;

import lab5.simulator.*;
import lab5.random.*;

public class StartEvent extends Event {
	
	public StartEvent(double timeToStart) {
		getTimeToStart(); // När simuleringen startar så kommer tiden att vara 0.
	}

}
