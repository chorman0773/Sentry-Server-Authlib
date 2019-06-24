package github.chorman0773.sentry.server.authlib.session;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Set;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import github.chorman0773.sentry.server.authlib.RequestResult;

public class SessionKey {
	private PublicKey sessionKey;
	private byte[] sessionNonce;
	private byte[] secondaryNonce;
	private UUID gameScope;
	private Set<SessionScope> scopes;
	
	private static final SecureRandom rand = new SecureRandom();
	private static final MessageDigest sha512;
	
	static {
		try {
			sha512 = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private void updateNonce() {
		byte[] input = new byte[128];
		System.arraycopy(sessionNonce, 0, input, 0, 64);
		System.arraycopy(secondaryNonce, 0, input, 64, 64);
		sessionNonce = sha512.digest(input);
		secondaryNonce = sha512.digest(secondaryNonce);
	}
	
	public SessionKey(PublicKey key) {
		secondaryNonce = new byte[64];
		rand.nextBytes(secondaryNonce);
		sessionNonce = sha512.digest(secondaryNonce);
	}
	
	public String getSecondaryNonce() {
		return Base64.getEncoder().encodeToString(secondaryNonce);
	}
	
	public RequestResult validate(RequestObject request,byte[] signature){
		try {
			Signature sig = Signature.getInstance("SHA256withRSA");
			sig.initVerify(sessionKey);
			request.updateSignature(sig);
			sig.update(sessionNonce);
			if(sig.verify(signature)) {
				updateNonce();
				if(request.checkScope(gameScope,scopes))
					return RequestResult.ok(request);
				else
					return RequestResult.error(403, 16, "Mismatched Scopes");
			}
			else
				return RequestResult.error(401, 15, "Could not verify session, mismatched signature");
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
			return RequestResult.error(500, 12, e.toString());
		}
		
	}
}
