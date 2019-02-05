
package com.wirevpn.x25519keys;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import java.lang.System;
import java.security.SecureRandom;

public class RNX25519KeysModule extends ReactContextBaseJavaModule {
	private static final SecureRandom random = new SecureRandom();
    private static final keySize = 32;
    private static String genKeyPair(byte[] rnd);

	public RNX25519KeysModule(ReactApplicationContext reactContext) {
		super(reactContext);
		System.loadLibrary("keys");
	}

	@Override
	public String getName() {
		return "RNX25519Keys";
	}

	@ReactMethod
	public void GenKeyPair(Promise promise) {
		try {
			byte rnd[] = new byte[];
			random.nextBytes(rnd);
			promise.resolve(genKeyPair(rnd));
		} catch(Exception e) {
			promise.reject(e.getMessage());
		}
	}
}