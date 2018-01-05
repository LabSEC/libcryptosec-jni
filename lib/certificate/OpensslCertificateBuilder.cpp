#include "br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder.h"
#include <jni.h>
#include <libcryptosec/DateTime.h>
#include <libcryptosec/PublicKey.h>
#include <libcryptosec/certificate/CertificateBuilder.h>
#include "util/Util.h"

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1init__(JNIEnv* env, jobject obj)
{
	CertificateBuilder* builder = new CertificateBuilder();
	return jlong(builder);
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1init__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _pemEncoded)
{
	std::string certRequestPemEncoded = Util::jstringToString(env, _pemEncoded);

	try
	{
		CertificateBuilder* builder = new CertificateBuilder(certRequestPemEncoded);
		return jlong(builder);
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
		return 0;
	}
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1init___3B(JNIEnv* env, jobject obj, jbyteArray _derEncoded)
{
	ByteArray data = Util::jbytearrayToByteArray(env, _derEncoded);
	try
	{
		CertificateBuilder* builder = new CertificateBuilder(data);
		return jlong(builder);
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
		return 0;
	}
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1init__I(JNIEnv* env, jobject obj, jlong _certificateRequestReference)
{
	CertificateRequest* request = (CertificateRequest*)_certificateRequestReference;
	return jlong( new CertificateBuilder(*request));
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setSerialNumber__J(JNIEnv* env, jobject obj, jlong _serialNumber)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	builder->setSerialNumber(_serialNumber);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setSerialNumber__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _serialNumber)
{
	std::string serialNumber = Util::jstringToString(env, _serialNumber);
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	try
	{
		builder->setSerialNumber(BigInteger(serialNumber));
	}
	catch(BigIntegerException& ex)
	{
		Util::throwNewException(env, "BigIntegerException", ex.getMessage());
	}
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setVersion(JNIEnv* env, jobject obj, jlong _version)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	builder->setVersion(_version);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setSubject(JNIEnv* env, jobject obj, jlong _rdnSequenceReference)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	RDNSequence* rdnSequence = (RDNSequence*)_rdnSequenceReference;
	builder->setSubject(*rdnSequence);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setIssuer(JNIEnv* env, jobject obj, jlong _rdnSequenceReference)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	RDNSequence* rdnSequence = (RDNSequence*)_rdnSequenceReference;
	builder->setIssuer(*rdnSequence);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setNotBefore(JNIEnv* env, jobject obj, jstring _notBefore)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	std::string notBefore = Util::jstringToString(env, _notBefore);
	DateTime dateTime(notBefore);
	builder->setNotBefore(dateTime);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setNotAfter(JNIEnv* env, jobject obj, jstring _notAfter)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	std::string notAfter = Util::jstringToString(env, _notAfter);
	DateTime dateTime(notAfter);
	builder->setNotAfter(dateTime);
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setPublicKey__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _publicKeyPemEncoded)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	std::string publicKeyPemEncoded = Util::jstringToString(env, _publicKeyPemEncoded);
	PublicKey* pkey = new PublicKey(publicKeyPemEncoded);
	builder->setPublicKey(*pkey);
	return jlong(pkey);
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setPublicKey___3B(JNIEnv* env, jobject obj, jbyteArray _publicKeyDerEncoded)
{
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);
	ByteArray data = Util::jbytearrayToByteArray(env, _publicKeyDerEncoded);
	PublicKey* pkey = new PublicKey(data);
	builder->setPublicKey(*pkey);
	return jlong(pkey);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1setPublicKey__I(JNIEnv* env, jobject obj, jlong publicKeyReference)
{
	PublicKey* pkey = (PublicKey*)publicKeyReference;
	Util::getInstance<CertificateBuilder*>(env, obj)->setPublicKey(*pkey);
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1sign(JNIEnv* env, jobject obj, jlong _keyReference, jstring _messageDigestAlgorithm)
{
	std::string messageDigestAlgorithm = Util::jstringToString(env, _messageDigestAlgorithm);
	MessageDigest::Algorithm algorithm = Util::stringToMessageDigestAlgorithm(messageDigestAlgorithm);

	PrivateKey* pkey = (PrivateKey*)_keyReference;

	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);

	try
	{
		Certificate* signedCert = builder->sign(*pkey, algorithm);
		return jlong(signedCert);
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
		return 0;
	}
	catch(AsymmetricKeyException& ex)
	{
		Util::throwNewException(env, "AsymmetricException", ex.getMessage());
		return 0;
	}
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1addExtension(JNIEnv* env, jobject obj, jstring _oid, jboolean _isCritical, jbyteArray _value)
{
	std::string oid = Util::jstringToString(env, _oid);
	bool isCritical = (bool)_isCritical;
	ByteArray value = Util::jbytearrayToByteArray(env, _value);
	
	CertificateBuilder* builder = Util::getInstance<CertificateBuilder*>(env, obj);

	try
	{
		Extension ext(oid, isCritical, Base64::encode(value));
		builder->addExtension(ext);
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
	}

}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder__1delete(JNIEnv *env, jobject obj)
{
	Util::deleteInstance<CertificateBuilder*>(env, obj);
}
