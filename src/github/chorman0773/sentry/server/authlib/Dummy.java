package github.chorman0773.sentry.server.authlib;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

public class Dummy implements IAccount {
	public static final UUID dummyId = UUID.nameUUIDFromBytes("Sentry\\\\dummy".getBytes(StandardCharsets.UTF_8));
	public static final String dummyAddress = "dummy@localhost";
	public static final String dummyPass = "dummy";
	
	public Dummy() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public UUID getAccountName() {
		// TODO Auto-generated method stub
		return dummyId;
	}


	@Override
	public String getAccountUsername() {
		// TODO Auto-generated method stub
		return "dummy";
	}


	@Override
	public byte[] getAccountAddressHash() {
		// TODO Auto-generated method stub
		return EmailHashGenerator.getEmailHash(dummyAddress);
	}


	@Override
	public Set<SentryAccountPermission> getExtendedPermissions() {
		// TODO Auto-generated method stub
		return Set.of(SentryAccountPermission.Sentry.DUMMY);
	}


	@Override
	public long getStandardPermissions() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public AuthenticationResult checkAuthenticate(byte[] password) {
		if(Arrays.equals(password, dummyPass.getBytes(StandardCharsets.UTF_8)))
			return AuthenticationResult.withError(403, 10, "The dummy Account cannot be authenticated as");
		else
			return AuthenticationResult.withError(401, 1, "Incorrect Password");
	}

}
