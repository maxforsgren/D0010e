package lab5.event;

import lab5.simulator.Event;
import lab5.simulator.EventQueue;
import lab5.state.Customer;
import lab5.state.StoreState;

public class PaymentEvent extends Event{
		private Customer c;
		private StoreState state;
		private Customer c1;
	
	public PaymentEvent(StoreState state, EventQueue queue, Customer c) {
		this.c = c;
		this.state = state;
		this.eventQueue = queue;
		this.time = state.getCheckoutTime();
		
	}
	
	public void execute() {
		
		state.updateTime(time);
		state.setRecentCustomer(this.c);
		state.setRecentEvent("Betalning");
	
	//detta blir som en loop först betala och lämna, sedan kollar kassakön
	//och uppdaterar den, sedan betala och lämna osv.
		
		//kunden betalar sina varor och lämnar snabbköpet.
		//1. minskar antalet kunder i snabbköpet.
		//2. lägger till att en kund har handlat.
		//3. En kassa blir ledig.
		state.removeCustomerInStore();		//minska antalet kunder i snabbköpet.		
		state.addFinishedCustomers();
		//lägger till kunder som har betalat/handlat.
		//tar bort en person från kassan "en kassa blir ledig".
		state.removeCheckoutCustomer();	
		//4. Kollar om kassakön inte är tom
		//5. Kund som stått längst i kön/först i arrayen.
		//6. Går till den lediga kassan.
		//7. Genererar en betalningshändelse för C.
		if(!state.isCheckoutLineEmpty()) {		
			System.out.println("Kön är inte tom");//Om kassakön ej är tom.
			c1 = state.getFirstCheckoutLine();		//Den som är först i kön går till kassa/betalar.
			state.removeFromCheckoutLine();			//Minskar kön från första position.
			state.addCheckoutCustomer();			//En kassa blir upptagen.    	
			eventQueue.add(new PaymentEvent(state, eventQueue, c1));
		}
		
		
		
		//Display view
		state.updateCheckQueue(eventQueue);
		state.updateState();
		
				
	}

	
	public double getEventTime() {
		return this.time;
	}
	
	

}
