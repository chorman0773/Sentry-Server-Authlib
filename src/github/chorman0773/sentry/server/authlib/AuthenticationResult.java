package github.chorman0773.sentry.server.authlib;

import java.security.PrivateKey;

public class AuthenticationResult {
	private int httpCode;
	private AuthenticationToken token;
	private int errorCode;
	private String errorMsg;
	
	private AuthenticationResult(int code,AuthenticationToken token,int errorCode,String errorString) {
		
	}
	
	public static AuthenticationResult withError(int code,int error,String errorString) {
		return new AuthenticationResult(code,null,error,errorString);
	}
	
	public static AuthenticationResult basicToken(PrivateKey key) {
		return new AuthenticationResult(200,new AuthenticationToken(0x7fff,key),0,null);
	}
	
	public static AuthenticationResult elevatedToken(long elevations,PrivateKey key) {
		return new AuthenticationResult(200,new AuthenticationToken(0x7fff|elevations&0xffffffffffff8000L,key),0,null);
	}
	
	public int getHttpStatusCode() {
		return httpCode;
	}

}
