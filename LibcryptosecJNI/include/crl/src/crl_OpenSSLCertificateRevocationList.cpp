#include "crl/crl_OpenSSLCertificateRevocationList.h"
#include <libcryptosec/certificate/CertificateRevocationList.h>
#include "util/Util.h"

jstring Java_crl_OpenSSLCertificateRevocationList__1getPemEncoded(JNIEnv* env, jobject obj)
{
	CertificateRevocationList* crl = Util::getInstance<CertificateRevocationList*>(env, obj);
	std::string data = crl->getPemEncoded();
	return env->NewStringUTF(data.c_str());
}

jbyteArray Java_crl_OpenSSLCertificateRevocationList__1getDerEncoded(JNIEnv* env, jobject obj)
{
	CertificateRevocationList* crl = Util::getInstance<CertificateRevocationList*>(env, obj);
	ByteArray data = crl->getDerEncoded();
	return Util::byteArrayTojbytearray(env, data);
}
