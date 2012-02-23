#include "certificate/certificate_CertificateBuilder.h"
#include <jni.h>
#include <libcryptosec/DateTime.h>
#include <libcryptosec/PublicKey.h>
#include <libcryptosec/certificate/CertificateBuilder.h>
#include "util/Util.h"

JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1init__(JNIEnv* env, jobject obj)
{
	CertificateBuilder* builder = new CertificateBuilder();
	return (jint)builder;
}

JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1init__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _pemEncoded)
{
	std::string certRequestPemEncoded(env->GetStringUTFChars(_pemEncoded, 0));
	CertificateBuilder* builder = new CertificateBuilder(certRequestPemEncoded);
	return (jint)builder;
}

JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1init___3B(JNIEnv* env, jobject obj, jbyteArray _derEncoded)
{
	jsize size = env->GetArrayLength(_derEncoded);
	jbyte* jdata = env->GetByteArrayElements(_derEncoded, 0);
	ByteArray* data = new ByteArray((unsigned char*)jdata, (int)size);
	CertificateBuilder* builder = new CertificateBuilder(*data);
	return (jint)builder;
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setSerialNumber__J(JNIEnv* env, jobject obj, jlong _serialNumber)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	builder->setSerialNumber(_serialNumber);
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setSerialNumber__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _serialNumber)
{
	std::string serialNumber(env->GetStringUTFChars(_serialNumber, 0));
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	builder->setSerialNumber(BigInteger(serialNumber));
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setVersion(JNIEnv* env, jobject obj, jlong _version)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	builder->setVersion(_version);
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setSubject(JNIEnv* env, jobject obj, jint _rdnSequenceReference)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	RDNSequence* rdnSequence = (RDNSequence*)_rdnSequenceReference;
	builder->setSubject(*rdnSequence);
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setIssuer(JNIEnv* env, jobject obj, jint _rdnSequenceReference)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	RDNSequence* rdnSequence = (RDNSequence*)_rdnSequenceReference;
	builder->setIssuer(*rdnSequence);
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setNotBefore(JNIEnv* env, jobject obj, jstring _notBefore)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	std::string notBefore(env->GetStringUTFChars(_notBefore, 0));
	DateTime dt(notBefore);
	builder->setNotBefore(dt);
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setNotAfter(JNIEnv* env, jobject obj, jstring _notAfter)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	std::string notAfter(env->GetStringUTFChars(_notAfter, 0));
	DateTime dt(notAfter);
	builder->setNotAfter(dt);
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setPublicKey__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _publicKeyPemEncoded)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	std::string publicKeyPemEncoded(env->GetStringUTFChars(_publicKeyPemEncoded, 0));
	PublicKey pkey(publicKeyPemEncoded);
	builder->setPublicKey(pkey);
}

JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setPublicKey___3B(JNIEnv* env, jobject obj, jbyteArray _publicKeyDerEncoded)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	ByteArray data = Util::jbytearrayToByteArray(env, _publicKeyDerEncoded);
	PublicKey pkey(data);
	builder->setPublicKey(pkey);
}

JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1sign(JNIEnv* env, jobject obj, jint _keyReference, jstring _messageDigestAlgorithm)
{
	std::string messageDigestAlgorithm(env->GetStringUTFChars(_messageDigestAlgorithm, 0));
	MessageDigest::Algorithm algorithm = Util::stringToMessageDigestAlgorithm(messageDigestAlgorithm);
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	PrivateKey* pkey = (PrivateKey*)_keyReference;
	Certificate* signedCert = builder->sign(*pkey, algorithm);
	return (jint)signedCert;
}
