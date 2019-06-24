package github.chorman0773.sentry.server.authlib;

import java.security.PrivateKey;
import java.security.SecureRandom;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

public class AuthenticationToken implements Destroyable {
	private byte[] token;
	private long authorizations;
	private PrivateKey key;
	private boolean destroyed;
	
	private static SecureRandom rand = new SecureRandom();
	
	public AuthenticationToken(long authorizations,PrivateKey key) {
		token = new byte[32];
		rand.nextBytes(token);
		this.authorizations = authorizations;
		this.key = key;
		this.destroyed = true;
	}

	@Override
	public void destroy() throws DestroyFailedException {
		for(int i = 0;i<token.length;i++)
			token[i] = 0;
		try {
			key.destroy();
		}finally {
			destroyed = true;
		}
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return destroyed;
	}
}
