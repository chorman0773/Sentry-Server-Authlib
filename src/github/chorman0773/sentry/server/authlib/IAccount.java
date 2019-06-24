package github.chorman0773.sentry.server.authlib;

import java.util.Set;
import java.util.UUID;

public interface IAccount {
	public UUID getAccountName();
	public String getAccountUsername();
	public byte[] getAccountAddressHash();
	public Set<SentryAccountPermission> getExtendedPermissions();
	public long getStandardPermissions();
	public AuthenticationResult checkAuthenticate(byte[] password);
}
