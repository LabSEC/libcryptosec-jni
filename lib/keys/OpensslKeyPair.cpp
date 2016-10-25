#include "br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair.h"
#include <jni.h>
#include <libcryptosec/KeyPair.h>
#include <libcryptosec/DynamicEngine.h>
#include "util/Util.h"

// FIXME: find a way to make this global variable unnecessary
// (i.e, fix Util::getInstance in 64 bit machines)
KeyPair* keyPairInstance;

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair__1init(JNIEnv* env, jobject obj, jlong _engineReference, jstring _keyId)
{
	std::string keyId(env->GetStringUTFChars(_keyId, 0));
	DynamicEngine* engine = reinterpret_cast<DynamicEngine*>(_engineReference);

	try
	{
		// KeyPair* kp = new KeyPair(engine, keyId);
		// return reinterpret_cast<jlong>(kp);
		keyPairInstance = new KeyPair(engine, keyId);
		return reinterpret_cast<jlong>(keyPairInstance);
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
		// return reinterpret_cast<jlong>(Util::getInstance<KeyPair*>(env, obj)->getPublicKey());
		return reinterpret_cast<jlong>(keyPairInstance->getPublicKey());
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
		// return reinterpret_cast<jlong>(Util::getInstance<KeyPair*>(env, obj)->getPrivateKey());
		return reinterpret_cast<jlong>(keyPairInstance->getPrivateKey());
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
	Util::deleteInstance<KeyPair*>(env, obj);
}
