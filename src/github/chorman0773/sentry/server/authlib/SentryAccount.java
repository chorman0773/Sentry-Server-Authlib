package github.chorman0773.sentry.server.authlib;

import java.util.Set;
import java.util.UUID;

public class SentryAccount implements IAccount {
	private UUID id;
	private String username;
	private String addressHash;
	private Set<SentryAccountPermission> extendedPermissions;
	private long standardPermissions;
	
	
	@Override
	public UUID getAccountName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getAccountAddressHash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SentryAccountPermission> getExtendedPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getStandardPermissions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AuthenticationResult checkAuthenticate(byte[] password) {
		// TODO Auto-generated method stub
		return null;
	}

}
