#include "keys/br_ufsc_labsec_libcryptosec_keys_OpensslPublicKey.h"
#include <jni.h>
#include <libcryptosec/PublicKey.h>
#include "util/Util.h"

void Java_br_ufsc_labsec_libcryptosec_keys_OpensslPublicKey__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<PublicKey*>(env, obj);
}
