cmake_minimum_required(VERSION 3.4.1)

add_library(keys SHARED
            jni.c
            ../../../x25519c/base64.c
            ../../../x25519c/curve25519-donna.c
            ../../../x25519c/keys.c)