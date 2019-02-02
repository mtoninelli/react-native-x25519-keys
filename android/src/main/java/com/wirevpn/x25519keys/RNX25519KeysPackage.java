
package com.wirevpn.x25519keys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;
public class RNX25519KeysPackage implements ReactPackage {
	@Override
	public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
		return Arrays.<NativeModule>asList(new RNX25519KeysModule(reactContext));
	}

	// Deprecated from RN 0.47
	public List<Class<? extends JavaScriptModule>> createJSModules() {
		return Collections.emptyList();
	}

	@Override
	public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
		return Collections.emptyList();
	}
}