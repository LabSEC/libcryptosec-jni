#include "br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest.h"
#include "util/Util.h"
#include <libcryptosec/certificate/CertificateRequest.h>

void Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<CertificateRequest*>(env, obj);
}

jlong Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1init__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _pemEncoded)
{
	try{
		std::string pemEncoded = Util::jstringToString(env, _pemEncoded);
		CertificateRequest* request = new CertificateRequest(pemEncoded);
		return jlong( request);
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
		return 0;
	}
}

jlong Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1init___3B(JNIEnv* env, jobject obj, jbyteArray _derEncoded)
{
	try{
		ByteArray derEncoded = Util::jbytearrayToByteArray(env, _derEncoded);
		CertificateRequest* request = new CertificateRequest(derEncoded);
		return jlong( request);
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
		return 0;
	}

}

jlong Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest__1init__(JNIEnv* env, jobject jobject)
{
	return jlong( new CertificateRequest());
}
