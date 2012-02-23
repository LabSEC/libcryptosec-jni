#include "keys/keys_OpenSSLKeyPair.h"
#include <jni.h>
#include <libcryptosec/KeyPair.h>
#include <libcryptosec/DynamicEngine.h>

KeyPair* getInstance(JNIEnv* env, jobject obj)
{
	jclass obj_class = env->GetObjectClass(obj);
	jfieldID fid = env->GetFieldID(obj_class, "reference", "I");
	void* keyPairReference = (void*)env->GetIntField(obj, fid);
	return (KeyPair*) keyPairReference;
}

JNIEXPORT jint JNICALL Java_keys_OpenSSLKeyPair__1loadKeyPair(JNIEnv* env, jobject obj, jint _engineReference, jstring _keyId)
{
	DynamicEngine* engine = (DynamicEngine*)_engineReference;
	std::string keyId(env->GetStringUTFChars(_keyId, 0));

	KeyPair* kp = new KeyPair(engine, keyId);

	return (int)kp;
}

JNIEXPORT jint JNICALL Java_keys_OpenSSLKeyPair__1getPublicKey(JNIEnv* env, jobject obj)
{
	std::cout << getInstance(env, obj)->getPublicKey()->getPemEncoded() << std::endl;
	return (int)getInstance(env, obj)->getPublicKey();
}

JNIEXPORT jint JNICALL Java_keys_OpenSSLKeyPair__1getPrivateKey(JNIEnv* env, jobject obj)
{
	std::cout << getInstance(env, obj)->getPrivateKey()->getPemEncoded() << std::endl;
	return (int)getInstance(env, obj)->getPrivateKey();
}
