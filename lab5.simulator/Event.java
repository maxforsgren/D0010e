package lab5.simulator;

import lab5.event.*;


public abstract class Event {
	
	protected double time;
	protected EventQueue eventQueue;
	protected SimState state;

	
	

	public abstract void execute();
	public abstract double getEventTime();
}
