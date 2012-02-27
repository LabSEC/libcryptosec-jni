#include "keys/keys_OpenSSLPrivateKey.h"
#include <jni.h>
#include <libcryptosec/PrivateKey.h>
#include "util/Util.h"

void Java_keys_OpenSSLPrivateKey__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<PrivateKey*>(env, obj);
}
