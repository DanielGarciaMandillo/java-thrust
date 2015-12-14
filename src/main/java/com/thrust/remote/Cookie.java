package com.thrust.remote;

import java.util.Date;

public final class Cookie implements RemoteArgument {
	private final String source;
	private final String name;
	private final String value;
	private final String domain;
	private final String path;
	private final Date creation;
	private final Date expiry;
	private Date lastAccess;
	private final Boolean secure;
	private final Boolean httpOnly;
	private final String priority;
	
	public Cookie(String source, String name, String value, String domain, String path,
			Date creation, Date expiry, Date lastAccess, Boolean secure, Boolean httpOnly, String priority) {
		this.source = source;
		this.name = name;
		this.value = value;
		this.domain = domain;
		this.path = path;
		this.creation = creation;
		this.expiry = expiry;
		this.lastAccess = lastAccess;
		this.secure = secure;
		this.httpOnly = httpOnly;
		this.priority = priority;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public String getPath() {
		return path;
	}
	
	public Date getCreation() {
		return creation;
	}
	
	public Date getExpiry() {
		return expiry;
	}
	
	public Date getLastAccess() {
		return lastAccess;
	}
	
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Boolean getSecure() {
		return secure;
	}
	
	public Boolean getHttpOnly() {
		return httpOnly;
	}
	
	public String getPriority() {
		return priority;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((expiry == null) ? 0 : expiry.hashCode());
		result = prime * result + ((httpOnly == null) ? 0 : httpOnly.hashCode());
		result = prime * result + ((lastAccess == null) ? 0 : lastAccess.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((secure == null) ? 0 : secure.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Cookie other = (Cookie) obj;
		if (creation == null) {
			if (other.creation != null)
				return false;
		} else if (!creation.equals(other.creation))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (expiry == null) {
			if (other.expiry != null)
				return false;
		} else if (!expiry.equals(other.expiry))
			return false;
		if (httpOnly == null) {
			if (other.httpOnly != null)
				return false;
		} else if (!httpOnly.equals(other.httpOnly))
			return false;
		if (lastAccess == null) {
			if (other.lastAccess != null)
				return false;
		} else if (!lastAccess.equals(other.lastAccess))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (secure == null) {
			if (other.secure != null)
				return false;
		} else if (!secure.equals(other.secure))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cookie [source=" + source + ", name=" + name + ", value=" + value + ", domain=" + domain + ", path="
				+ path + ", creation=" + creation + ", expiry=" + expiry + ", lastAccess=" + lastAccess + ", secure="
				+ secure + ", httpOnly=" + httpOnly + ", priority=" + priority + "]";
	}
}
