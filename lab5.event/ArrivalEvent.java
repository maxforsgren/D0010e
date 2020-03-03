package lab5.event;

import lab5.simulator.*;
import lab5.random.*;

public class ArrivalEvent extends Event{
	
	public ArrivalEvent(double timeToStart) {
		getTimeToStart();
	}
	
	/**
	 * Metod som kontrollerar huruvida affären är öppen samt om det finns
	 * plats för fler kunder. Nya händelser skapas därefter.
	 * 
	 */
	public void execute() {
		if(openingHours == simTime) { // Är öppettider lika med simuleringstid så stänger affären.
			storeOpen = false;
			queue.add(New CloseStoreEvent);
		}else {
			queue.add(new ArrivalEvent); // Lägger till en ny händelse i kön.
			queue.sortQueue; // Sorterar kön.
			if(customersInStore < maxCustomers) {
				queue.addEvent(new PickingEvent);
				queue.sortQueue;
				customersInStore++;	
			}else {
				missedCustomers++;
			}
		}
	}
}
