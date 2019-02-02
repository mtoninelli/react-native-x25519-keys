#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define KEY_SIZE 32
#define BUFFER_SIZE 128
#define B64_KEY_SIZE 45

extern void curve25519_donna(unsigned char *out, const unsigned char *a, const unsigned char *b);
extern unsigned int base64_encode(const unsigned char *in, unsigned int inlen, char *out);

char *gen_key_pair(unsigned char *rnd)
{
    static const unsigned char basepoint[KEY_SIZE] = {9};
    unsigned char privatekey[KEY_SIZE];
    unsigned char publickey[KEY_SIZE];
    char b64_priv[B64_KEY_SIZE];
    char b64_pub[B64_KEY_SIZE];
    char *buffer = (char *) malloc(BUFFER_SIZE);

    // Generate private key
    memcpy(privatekey, rnd, KEY_SIZE);
    privatekey[0]  &= 248;
    privatekey[31] &= 127;
    privatekey[31] |= 64;

    // Generate public key
    curve25519_donna(publickey, privatekey, basepoint);

    // Encode keys
    base64_encode(privatekey, KEY_SIZE, b64_priv);
    base64_encode(publickey, KEY_SIZE, b64_pub);

    // Convert to JSON
    snprintf(buffer, BUFFER_SIZE, "{\"public_key\":\"%s\",\"private_key\":\"%s\"}", b64_pub, b64_priv);

    return buffer;
}