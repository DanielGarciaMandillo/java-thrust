package org.thrust_java;

import java.util.Date;

/**
 * RemoteArguments : TERMINADOS
 *
 */
public class RemoteArguments {

	abstract class RemoteArgument {
	}

	public class Cookie {
		private String source;
		private String name;
		private String value;
		private String domain;
		private String path;
		private Date creation;
		private Date expiry;
		private Date last_access;
		private boolean secure;
		private boolean http_only;
		private String priority;

		public Cookie() {
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDomain() {
			return domain;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public Date getCreation() {
			return creation;
		}

		public void setCreation(Date creation) {
			this.creation = creation;
		}

		public Date getExpiry() {
			return expiry;
		}

		public void setExpiry(Date expiry) {
			this.expiry = expiry;
		}

		public Date getLast_access() {
			return last_access;
		}

		public void setLast_access(Date last_access) {
			this.last_access = last_access;
		}

		public boolean isSecure() {
			return secure;
		}

		public void setSecure(boolean secure) {
			this.secure = secure;
		}

		public boolean isHttp_only() {
			return http_only;
		}

		public void setHttp_only(boolean http_only) {
			this.http_only = http_only;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

	}

	public class Key extends RemoteArgument {
		private String key;

		public Key() {
		}

		public Key(String key) {
			this.key = key;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

}
