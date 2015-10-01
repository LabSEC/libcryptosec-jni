#include "br_ufsc_labsec_libcryptosec_keys_OpensslPrivateKey.h"
#include <jni.h>
#include <libcryptosec/PrivateKey.h>
#include "util/Util.h"

void Java_br_ufsc_labsec_libcryptosec_keys_OpensslPrivateKey__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<PrivateKey*>(env, obj);
}
