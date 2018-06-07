#include "br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair.h"
#include <jni.h>
#include <libcryptosec/KeyPair.h>
#include <libcryptosec/DynamicEngine.h>
#include "util/Util.h"

KeyPair* keyPair;

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair__1init(JNIEnv* env, jobject obj, jlong _engineReference, jstring _keyId)
{
	std::string keyId(env->GetStringUTFChars(_keyId, 0));

	DynamicEngine* engine = reinterpret_cast<DynamicEngine*>(_engineReference);

	try
	{
		// KeyPair* kp = new KeyPair(engine, keyId);
  //       return jlong(kp);
		keyPair = new KeyPair(engine, keyId);
		return jlong(keyPair);
	}
	catch(EngineException& ex)
	{
		Util::throwNewException(env, "EngineException", ex.getMessage());
		return 0;
	}

}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair__1getPublicKey(JNIEnv* env, jobject obj)
{
	try
	{
		// return jlong(Util::getInstance<KeyPair*>(env, obj)->getPublicKey());
		return jlong(keyPair->getPublicKey());
	}
	catch(AsymmetricKeyException& ex)
	{
		Util::throwNewException(env, "AsymmetricKeyException", ex.getMessage());
		return 0;
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
		return 0;
	}
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair__1getPrivateKey(JNIEnv* env, jobject obj)
{
	try
	{
		// return jlong(Util::getInstance<KeyPair*>(env, obj)->getPrivateKey());
		return jlong(keyPair->getPrivateKey());
	}
	catch(AsymmetricKeyException& ex)
	{
		Util::throwNewException(env, "AsymmetricKeyException", ex.getMessage());
		return 0;
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
		return 0;
	}
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair__1delete(JNIEnv* env, jobject obj)
{
	// Util::deleteInstance<KeyPair*>(env, obj);
	delete keyPair;
}
