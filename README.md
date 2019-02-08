
# react-native-x25519-keys

- This module creates a base64 encoded Curve25519 key pair.
- It uses the [curve25519-donna](https://github.com/agl/curve25519-donna) library underneath.
- For RNG `SecureRandom` and `SecRandomCopyBytes` are used for Android and iOS, respectively.

## Getting started

`$ npm install react-native-x25519-keys --save`

### Mostly automatic installation

`$ react-native link react-native-x25519-keys`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-x25519-keys` and add `RNX25519Keys.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNX25519Keys.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. In XCode, in the project navigator, select your project. Add `$(SRCROOT)/../node_modules/react-native-x25519-keys/ios` to your project's `Build Settings` ➜ `Header Search Paths`
5. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
    - Add `import com.wirevpn.x25519keys.RNX25519KeysPackage;` to the imports at the top of the file
    - Add `new RNX25519KeysPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-x25519-keys'
  	project(':react-native-x25519-keys').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-x25519-keys/android')
  	```
3. Insert the following lines inside the `dependencies` block in `android/app/build.gradle`:
  	```
    compile project(':react-native-x25519-keys')
  	```

## Usage
```javascript
import RNX25519Keys from 'react-native-x25519-keys';

RNX25519Keys.GenKeyPair().then(keys => {
    console.log(keys.public_key);
    console.log(keys.private_key);
});
```
