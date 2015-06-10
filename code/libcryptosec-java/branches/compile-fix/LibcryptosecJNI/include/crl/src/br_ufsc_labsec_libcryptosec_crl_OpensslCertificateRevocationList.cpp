#include "crl/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.h"
#include <libcryptosec/certificate/CertificateRevocationList.h>
#include "util/Util.h"

jstring Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1getPemEncoded(JNIEnv* env, jobject obj)
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

jbyteArray Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1getDerEncoded(JNIEnv* env, jobject obj)
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

void Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<CertificateRevocationList*>(env, obj);
}
