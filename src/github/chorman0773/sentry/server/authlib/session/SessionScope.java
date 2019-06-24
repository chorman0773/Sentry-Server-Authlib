package github.chorman0773.sentry.server.authlib.session;

public class SessionScope implements Comparable<SessionScope> {
	
	private String group;
	private String component;
	
	public SessionScope(String group,String component) {
		this.group = group;
		this.component = component;
	}
	
	@Override
	public int compareTo(SessionScope o) {
		int cmp;
		if((cmp=group.compareTo(o.group))!=0)
			return cmp;
		else
			return component.compareTo(o.component);
	}
	
	public String toString() {
		return group+":"+component;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
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
		SessionScope other = (SessionScope) obj;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		return true;
	}

}
