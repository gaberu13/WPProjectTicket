package com.buyticket.demo.filter;

public class SecurityConstants {

    public static final String SECRET = "ExpansionBay";
    public static final long EXPIRATION_TIME = 4 * 3600 * 1000; // 4h
    public static final String TOKEN_PREFIX = "tok_";
    public static final String HEADER_STRING = "authorization";
    public static final String SIGN_UP_URL = "/user/sign-up";

}
