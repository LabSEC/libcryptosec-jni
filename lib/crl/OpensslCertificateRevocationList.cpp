#include "br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.h"
#include <libcryptosec/certificate/CertificateRevocationList.h>
#include "util/Util.h"

// FIXME: find a way to make this global variable unnecessary
// (i.e, fix Util::getInstance in 64 bit machines)
CertificateRevocationList* certRevocationInstance;

jstring Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1getPemEncoded(JNIEnv* env, jobject obj)
{
	CertificateRevocationList* crl = certRevocationInstance;//Util::getInstance<CertificateRevocationList*>(env, obj);
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
	CertificateRevocationList* crl = certRevocationInstance;//Util::getInstance<CertificateRevocationList*>(env, obj);
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

void Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList__1init(JNIEnv* env, jobject obj, jlong reference)
{
	certRevocationInstance = (CertificateRevocationList*) reference;
}
