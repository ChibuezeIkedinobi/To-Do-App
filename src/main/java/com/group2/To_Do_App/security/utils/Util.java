package com.group2.To_Do_App.security.utils;

public final class Util {

    private Util() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public final static String ACCOUNT_CREATION_SUCCESS_CODE = "201";
    public final static String ACCOUNT_CREATION_SUCCESS_MESSAGE = "Account has been created successfully✅";

    public final static String LOGIN_SUCCESS_CODE = "200";
    public final static String LOGIN_SUCCESS_MESSAGE = "Login Successful✅";

    public final static String LOGIN_FAILURE_CODE = "401";
    public final static String LOGIN_FAILURE_MESSAGE = "Invalid credentials. Please check your email and password.🚨🚨";

    public static final String LOGOUT_SUCCESS_CODE = "200";
    public static final String LOGOUT_SUCCESS_MESSAGE = "Logout successful.";

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";     //Don't ignore the space after the word bearer
    public static final String SECRET_KEY = "MIHcAgEBBEIAi9oBwuqEzYFdh8ly8oWdsgFOsYjv+4PQUG29kXAHeFwhD4R1JGwzM2sIQ1TIV0CzvkLvKlz+ApmoklnmCst1teKgBwYFK4EEACOhgYkDgYYABABLnZ8o4KVkAfAHmOZ3AQStgqajw4kL3LoL1Njs2d2ACPIvJ157uOFj92K5QaPHJiSnesVqLscpm0yBFip75vW6tAHVSkwpuebXatT840+0WvFni0xnzONuP+gbgp0iXFEYlTcvk/+DvLebrBuwHGRCWj2Oasawz3NbGDFh+rYtArSP7A==";

}
