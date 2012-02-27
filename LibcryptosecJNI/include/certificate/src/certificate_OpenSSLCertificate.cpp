#include "certificate/certificate_OpenSSLCertificate.h"
#include <jni.h>
#include <libcryptosec/certificate/Certificate.h>
#include "util/Util.h"

JNIEXPORT jstring JNICALL Java_certificate_OpenSSLCertificate__1getPemEncoded(JNIEnv* env, jobject obj)
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


JNIEXPORT jbyteArray JNICALL Java_certificate_OpenSSLCertificate__1getDerEncoded(JNIEnv* env, jobject obj)
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

JNIEXPORT void JNICALL Java_certificate_OpenSSLCertificate__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<Certificate*>(env, obj);
}
