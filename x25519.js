import { NativeModules } from 'react-native';

const { RNX25519Keys } = NativeModules;

module.exports = {
    async GenKeyPair() {
        let keys = await RNX25519Keys.GenKeyPair();
        return new Promise(function(resolve, reject) {
            try {
                resolve(JSON.parse(keys));
            } catch(e) {
                reject(e);
            }
        });
    }
}