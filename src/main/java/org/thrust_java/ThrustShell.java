package org.thrust_java;

/**
 * ThrustShell
 *
 */
public class ThrustShell {
	
	public MessageId getMessageId(){
		return new MessageId();
	}

	class MessageId {
		Integer id;

		public MessageId() {
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}
	
}
