#include <jni.h>
#include <stdlib.h>

extern char *gen_key_pair(unsigned char *rnd);

JNIEXPORT jstring JNICALL
Java_com_wirevpn_x25519keys_RNX25519KeysModule_genKeyPair(JNIEnv *env, jclass c, jbyteArray rnd)
{
	jbyte *buffer = (*env)->GetByteArrayElements(env, rnd, NULL);
	char *keys = gen_key_pair((unsigned char *) buffer);
	if (!keys) {
		return NULL;
	}
	jstring ret = (*env)->NewStringUTF(env, keys);
	(*env)->ReleaseByteArrayElements(env, rnd, buffer, JNI_ABORT);
	free(keys);
	return ret;
}