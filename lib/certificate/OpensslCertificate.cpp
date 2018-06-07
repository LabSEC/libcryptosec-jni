#include "br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate.h"
#include <jni.h>
#include <libcryptosec/certificate/Certificate.h>
#include "util/Util.h"

JNIEXPORT jstring JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate__1getPemEncoded(JNIEnv* env, jobject obj)
{
	Certificate* certificate = Util::getInstance<Certificate*>(env, obj);
	std::string pemEncoded;

	try
	{
		pemEncoded = certificate->getPemEncoded();
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}

	const char* data = pemEncoded.c_str();
	jstring jpemEncoded = env->NewStringUTF(data);

	return jpemEncoded;
}


JNIEXPORT jbyteArray JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate__1getDerEncoded(JNIEnv* env, jobject obj)
{
	Certificate* certificate = Util::getInstance<Certificate*>(env, obj);
	ByteArray data;
	try
	{
		data = certificate->getDerEncoded();
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}
	return Util::byteArrayTojbytearray(env, data);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<Certificate*>(env, obj);
}
