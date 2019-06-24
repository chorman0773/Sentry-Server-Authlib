package github.chorman0773.sentry.server.authlib;

import java.util.Set;
import java.util.UUID;

public class System implements IAccount {
	public static final UUID SYSTEM_ID = UUID.fromString("00000000-0000-0000-0000-0000000000000");
	public String SYSTEM_ADDRESS = "system@localhost";
	@Override
	public UUID getAccountName() {
		// TODO Auto-generated method stub
		return SYSTEM_ID;
	}

	@Override
	public String getAccountUsername() {
		// TODO Auto-generated method stub
		return "SYSTEM";
	}

	@Override
	public byte[] getAccountAddressHash() {
		// TODO Auto-generated method stub
		return EmailHashGenerator.getEmailHash(SYSTEM_ADDRESS);
	}

	@Override
	public Set<SentryAccountPermission> getExtendedPermissions() {
		return Set.of(SentryAccountPermission.Sentry.SYSTEM,SentryAccountPermission.Sentry.ADMIN);
	}

	@Override
	public long getStandardPermissions() {
		// TODO Auto-generated method stub
		return Long.MAX_VALUE;
	}

	@Override
	public AuthenticationResult checkAuthenticate(byte[] password) {
		return AuthenticationResult.withError(403, 11, "Cannot Authentication as SYSTEM");
	}

}
