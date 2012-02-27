#include "crl/crl_OpenSSLCertificateRevocationList.h"
#include <libcryptosec/certificate/CertificateRevocationList.h>
#include "util/Util.h"

jstring Java_crl_OpenSSLCertificateRevocationList__1getPemEncoded(JNIEnv* env, jobject obj)
{
	CertificateRevocationList* crl = Util::getInstance<CertificateRevocationList*>(env, obj);
	std::string data;
	try
	{
		data = crl->getPemEncoded();
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}
	return env->NewStringUTF(data.c_str());
}

jbyteArray Java_crl_OpenSSLCertificateRevocationList__1getDerEncoded(JNIEnv* env, jobject obj)
{
	CertificateRevocationList* crl = Util::getInstance<CertificateRevocationList*>(env, obj);
	ByteArray data;
	try
	{
		data = crl->getDerEncoded();
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}
	return Util::byteArrayTojbytearray(env, data);
}

void Java_crl_OpenSSLCertificateRevocationList__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<CertificateRevocationList*>(env, obj);
}
