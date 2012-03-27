#include "certificate/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest.h"
#include "util/Util.h"
#include <libcryptosec/certificate/CertificateRequest.h>

void Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<CertificateRequest*>(env, obj);
}

jint Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1init__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _pemEncoded)
{
	std::string pemEncoded = Util::jstringToString(env, _pemEncoded);
	CertificateRequest* request = new CertificateRequest(pemEncoded);
	return (jint) request;
}

jint Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1init___3B(JNIEnv* env, jobject obj, jbyteArray _derEncoded)
{
	ByteArray derEncoded = Util::jbytearrayToByteArray(env, _derEncoded);
	CertificateRequest* request = new CertificateRequest(derEncoded);
	return (jint) request;
}

jint Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1init__(JNIEnv* env, jobject jobject)
{
	return (jint) new CertificateRequest();
}
