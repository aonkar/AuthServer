package com.org.auth.common;


public final class AuthConstants {

	private AuthConstants() {
	}

	public static final String CLAIM_KEY_USERNAME = "username";
	public static final String CLAIM_KEY_AUDIENCE = "audience";
	public static final String CLAIM_KEY_CREATED = "created";
	public static final String CLAIM_KEY_ROLE = "role";
    public static final String AUDIENCE_WEB = "web";
    public static final String AUDIENCE_MOBILE = "mobile";
    public static final String AUDIENCE_TABLET = "tablet";
    
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_READ_WRITE = "writer";
    public static final String ROLE_READ_ONLY = "reader";
   
}
