package org.utils;

import org.thrust_java.RemoteMethods.RemoteMethod;

public class IntegerRemoteMethod {

	private Integer integer;
	private RemoteMethod remoteMethod;

	public IntegerRemoteMethod() {

	}

	public IntegerRemoteMethod(Integer integer, RemoteMethod remoteMethod) {
		this.integer = integer;
		this.remoteMethod = remoteMethod;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public RemoteMethod getRemoteMethod() {
		return remoteMethod;
	}

	public void setRemoteMethod(RemoteMethod remoteMethod) {
		this.remoteMethod = remoteMethod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((integer == null) ? 0 : integer.hashCode());
		result = prime * result + ((remoteMethod == null) ? 0 : remoteMethod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegerRemoteMethod other = (IntegerRemoteMethod) obj;
		if (integer == null) {
			if (other.integer != null)
				return false;
		} else if (!integer.equals(other.integer))
			return false;
		if (remoteMethod == null) {
			if (other.remoteMethod != null)
				return false;
		} else if (!remoteMethod.equals(other.remoteMethod))
			return false;
		return true;
	}

}
