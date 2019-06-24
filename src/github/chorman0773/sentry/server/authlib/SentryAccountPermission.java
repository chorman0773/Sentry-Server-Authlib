package github.chorman0773.sentry.server.authlib;

public final class SentryAccountPermission implements Comparable<SentryAccountPermission> {
	private final String name;
	private final String domain;
	
	public SentryAccountPermission(String name) {
		this("sentry",name);
	}
	public SentryAccountPermission(String domain,String name) {
		this.domain = domain;
		this.name = name;
	}
	@Override
	public int compareTo(SentryAccountPermission o) {
		int cmp;
		if((cmp = domain.compareTo(o.domain))!=0)
			return cmp;
		else
			return name.compareTo(o.name);
	}
	
	public String getName() {
		return name;
	}
	public String getDomain() {
		return domain;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SentryAccountPermission other = (SentryAccountPermission) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return domain + "\\\\" + name;
	}
	
	public static interface Sentry{
		public static final SentryAccountPermission AUTHENTICATE = new SentryAccountPermission("authenticate");
		public static final SentryAccountPermission SERVICE = new SentryAccountPermission("service");
		public static final SentryAccountPermission SERVER = new SentryAccountPermission("server");
		public static final SentryAccountPermission ADMIN = new SentryAccountPermission("admin");
		public static final SentryAccountPermission SYSTEM = new SentryAccountPermission("system");
		public static final SentryAccountPermission DUMMY = new SentryAccountPermission("dummy");
	}
}
