package github.chorman0773.sentry.server.authlib;

import github.chorman0773.sentry.server.authlib.session.RequestObject;

public class RequestResult {
	
	private int httpCode;
	private int errorCode;
	private String errorMsg; 
	private RequestObject obj;
	
	private RequestResult(int http,int errorc,String errMsg,RequestObject request) {
		this.httpCode = http;
		this.errorCode = errorc;
		this.errorMsg = errMsg;
		this.obj = request;
	}

	public static RequestResult ok(RequestObject request) {
		return new RequestResult(200,-1,null,request);
	}
	public static RequestResult error(int http,int error,String msg) {
		return new RequestResult(http,error,msg,null);
	}
}