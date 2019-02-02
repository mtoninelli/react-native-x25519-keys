
package com.wirevpn.x25519keys;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import java.lang.System;
import java.security.SecureRandom;

public class RNX25519KeysModule extends ReactContextBaseJavaModule {
	private SecureRandom random;

	public RNX25519KeysModule(ReactApplicationContext reactContext) {
		super(reactContext);
		System.loadLibrary("keys");
		random = new SecureRandom();
	}

	public native String genKeyPair(byte[] rnd);

	@Override
	public String getName() {
		return "RNX25519Keys";
	}

	@ReactMethod
	public void GenKeyPair(Promise promise) {
		try {
			byte rnd[] = new byte[32];
			random.nextBytes(rnd);
			promise.resolve(genKeyPair(rnd));
		} catch(Exception e) {
			promise.reject(e.getMessage());
		}
	}
}