package lab5.simulator;

import lab5.event.*;
import lab5.random.*;

abstract class Event {
	
	private double timeToStart;
	private eventQueue eventQueue;
	
	
	public double getTimeToStart() {
		timeToStart = uniformRandomStrean() + timeElapsed();
		return timeToStart;
	}
	
	public abstract void execute();

}
