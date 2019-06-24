package github.chorman0773.sentry.server.authlib;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public final class EmailHashGenerator {
	
	private static MessageDigest sha256;
	
	static {
		try {
			sha256 = MessageDigest.getInstance("SHA256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private EmailHashGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public static byte[] getEmailHash(String address) {
		return sha256.digest(address.getBytes(StandardCharsets.UTF_8));
	}
	public static String getBase64EncodedEmailHash(String address) {
		return Base64.getEncoder().encodeToString(getEmailHash(address));
	}
}
