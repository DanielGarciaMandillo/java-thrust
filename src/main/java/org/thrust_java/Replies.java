package org.thrust_java;


/**
 * Replies : NO TERMINADO queda por hacer
 *
 */
public class Replies {
	
	public Replies(){
		
	}
	
	public EventFields getEventFields(){
		return new EventFields();
	}

	class EventFields  {
		private int[] commandId;
		private int[] eventFlags;
		
		public int[] getCommandId() {
			return commandId;
		}
		public void setCommandId(int[] commandId) {
			this.commandId = commandId;
		}
		public int[] getEventFlags() {
			return eventFlags;
		}
		public void setEventFlags(int[] eventFlags) {
			this.eventFlags = eventFlags;
		}
		public EventFields(int[] commandId, int[] eventFlags) {
			this.commandId = commandId;
			this.eventFlags = eventFlags;
		}
		
		public EventFields() {

		}
		
	}
}
