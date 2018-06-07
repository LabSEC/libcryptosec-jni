#include "br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.h"
#include <libcryptosec/certificate/CertificateRevocationList.h>
#include "util/Util.h"

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1init(JNIEnv* env, jobject obj, jlong reference)
{
	CertificateRevocationList* crl = (CertificateRevocationList*)reference;
	CertificateRevocationList* new_crl = new CertificateRevocationList(*crl);
}

JNIEXPORT jstring JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1getPemEncoded(JNIEnv* env, jobject obj)
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

JNIEXPORT jbyteArray JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1getDerEncoded(JNIEnv* env, jobject obj)
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

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<CertificateRevocationList*>(env, obj);
}
