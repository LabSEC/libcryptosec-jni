#include "keys/keys_OpenSSLPublicKey.h"
#include <jni.h>
#include <libcryptosec/PublicKey.h>
#include "util/Util.h"

void Java_keys_OpenSSLPublicKey__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<PublicKey*>(env, obj);
}
