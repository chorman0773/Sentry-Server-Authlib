package github.chorman0773.sentry.server.authlib.session;

import java.nio.charset.StandardCharsets;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Set;
import java.util.UUID;

public class RequestObject {
	
	private Set<SessionScope> requiredScopes;
	private String method;
	private String path;
	private byte[] content;
	
	public void updateSignature(Signature sig) throws SignatureException {
		sig.update(method.getBytes(StandardCharsets.US_ASCII));
		sig.update(method.getBytes(StandardCharsets.UTF_8));
		sig.update(content);
	}

	public boolean checkScope(UUID gameScope, Set<SessionScope> scopes) {
		return false;
	}

}
