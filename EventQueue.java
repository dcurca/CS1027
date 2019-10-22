/**
 * EventQueue class allows users to insert and delete event elements
 * in the respective event queue.
 */
public class EventQueue {
final int impossibleNumItemsValue=-1;

// Event queue holds all events
QueueADT<Event> eventQueue;

 // Constructor initializes the event queue.
public EventQueue() {
	eventQueue=new LinkedQueue<Event>();
}

// Method insertEvent inserts events into the queue,
// one at a time and in sorted order on eventTime.
public void insertEvent(Event insertEvent,boolean debug) 
{
String s;

if(debug)
{
System.out.format("\nINSERT EVENT:\nEvent time: %7.2f Event type: %s",
   insertEvent.getEventTime(),insertEvent.getEventType());
if(insertEvent.getEventNumItems()!=impossibleNumItemsValue)
   System.out.format(" Event number of items: %d",insertEvent.getEventNumItems());
System.out.format("\n");
System.out.println("\nEvent Queue before new event enqueued");
System.out.println("-------------------------------------");
s=eventQueue.toString();
if(!s.equals("")) 
   System.out.println(s);
else
   System.out.println("Empty Queue");
System.out.println("\n");
}

QueueADT<Event> tempQueue = new LinkedQueue<Event>(); //secondary queue
boolean inserted = false; //boolean to check whether new event has been inserted or not
int queueSize = eventQueue.size(); //Current size of eventQueue
Event tempEvent; //temporary event used to hold info of events from eventQueue
if(eventQueue.isEmpty()) { //if emptyQueue is empty..
	eventQueue.enqueue(insertEvent); } //insert insertEvent into eventQueue
else 
	for(int i=0; i<queueSize; i++) { //iterate through eventQueue
		tempEvent = eventQueue.dequeue(); 
		if(tempEvent.getEventTime() > insertEvent.getEventTime() & !inserted) { //check if tempEvent time is greater than insertEvent time and already not inserted
			tempQueue.enqueue(insertEvent); //if true enqueue into tempQueue
			inserted = true; 
			}
		tempQueue.enqueue(tempEvent);
	}
if(!inserted) { //if not inserted..
	tempQueue.enqueue(insertEvent); //enqueue insertEvent into tempQueue
	inserted = true;
}
eventQueue=tempQueue;
if(debug)
{
System.out.println("\nEvent Queue after new event enqueued");
System.out.println("------------------------------------");
s=eventQueue.toString();
if(!s.equals(""))
   System.out.println(s);
else
   System.out.println("Empty Queue");
System.out.println("\n");
}
} // insertEvent

// Method deletes all events from order queue whose eventTime >= minAllDoneTime
public void deleteEvents(double minAllDoneTime,boolean debug) 
{
String s;

System.out.println("\n\nDELETE EVENT\n");
if(debug)
{
System.out.println("\nEvent Queue before all events with eventTime >= " + 
		minAllDoneTime + " deleted");
System.out.println("------------------------------------------------------");
s=eventQueue.toString();
if(!s.equals(""))
  System.out.println(s);
else
  System.out.println("Empty Queue");
System.out.println("\n");
}

QueueADT<Event> tempQueue = new LinkedQueue<Event>(); //secondary queue
Event tempEvent; //temporary event used to hold info of events from eventQueue
boolean lessThanMinAllDoneTime = true; //boolean for moving while loop
boolean allDoneFound = false; //boolean for while loop
if(eventQueue.isEmpty()) 
	System.out.println("Queue is empty!");
else 
	while(lessThanMinAllDoneTime) { //while true 
		tempEvent = eventQueue.first(); 
		if(tempEvent.getEventTime() < minAllDoneTime) { //check to make sure minAllDoneTime is larger than tempEvent time
			tempEvent = eventQueue.dequeue(); 
			tempQueue.enqueue(tempEvent); //if true enqueue tempEvent to tempQueue
		}
		else 
			lessThanMinAllDoneTime = false; 
	}
eventQueue = tempQueue; 
if(debug)
{
System.out.println("\nEvent Queue after all events with eventTime >= " + 
     		      minAllDoneTime + " deleted");
System.out.println("-----------------------------------------------------");
		s=eventQueue.toString();
if(!s.equals(""))
     System.out.println(s);
else
     System.out.println("Empty Queue");
System.out.println("\n");
}

} // deleteEvents

} // class EvetQueue