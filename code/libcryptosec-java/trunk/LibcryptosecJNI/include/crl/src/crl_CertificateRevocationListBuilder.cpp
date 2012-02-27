#include "crl/crl_CertificateRevocationListBuilder.h"
#include <libcryptosec/certificate/CertificateRevocationListBuilder.h>
#include "util/Util.h"


jint Java_crl_CertificateRevocationListBuilder__1init__(JNIEnv* env, jobject obj)
{
	return (jint) new CertificateRevocationListBuilder();
}

jint Java_crl_CertificateRevocationListBuilder__1init__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _crlPemEncoded)
{
	std::string crlPemEncoded = Util::jstringToString(env, _crlPemEncoded);

	try
	{
		CertificateRevocationListBuilder* builder = new CertificateRevocationListBuilder(crlPemEncoded);
		return (jint)builder;
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}

}

jint Java_crl_CertificateRevocationListBuilder__1init___3B(JNIEnv* env, jobject obj, jbyteArray _crlDerEncoded)
{
	ByteArray data = Util::jbytearrayToByteArray(env, _crlDerEncoded);
	try
	{
		CertificateRevocationListBuilder* builder = new CertificateRevocationListBuilder(data);
		return (jint)builder;
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}
}

void Java_crl_CertificateRevocationListBuilder__1setIssuer(JNIEnv* env, jobject obj, jint _rdnSequenceReference)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	RDNSequence* rdnSequence = (RDNSequence*)_rdnSequenceReference;
	try
	{
		builder->setIssuer(*rdnSequence);
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
	}
}

void Java_crl_CertificateRevocationListBuilder__1addRevokedCertificate(JNIEnv* env, jobject obj, jint _reference)
{
	RevokedCertificate* revokedCertificate = (RevokedCertificate*)_reference;
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	try
	{
		builder->addRevokedCertificate(*revokedCertificate);
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
	}
}

void Java_crl_CertificateRevocationListBuilder__1addRevokedCertificates(JNIEnv* env, jobject obj, jintArray _references)
{
	std::vector<RevokedCertificate> revokedCertificates = Util::getObjectVector<RevokedCertificate>(env, _references);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	try
	{
		builder->addRevokedCertificates(revokedCertificates);
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
	}
}

void Java_crl_CertificateRevocationListBuilder__1setNextUpdate(JNIEnv* env, jobject obj, jstring _dateTimeString)
{
	std::string dateTimeString = Util::jstringToString(env, _dateTimeString);
	DateTime dateTime(dateTimeString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setNextUpdate(dateTime);
}

void Java_crl_CertificateRevocationListBuilder__1setLastUpdate(JNIEnv* env, jobject obj, jstring _dateTimeString)
{
	std::string dateTimeString = Util::jstringToString(env, _dateTimeString);
	DateTime dateTime(dateTimeString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setLastUpdate(dateTime);
}

void Java_crl_CertificateRevocationListBuilder__1setSerialNumber__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _serialNumberString)
{
	std::string serialNumberString = Util::jstringToString(env, _serialNumberString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	try
	{
		BigInteger serialNumber(serialNumberString);
		builder->setSerialNumber(serialNumber);
	}
	catch(BigIntegerException& ex)
	{
		Util::throwNewException(env, "BigIntegerException", ex.getMessage());
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
	}
}
void Java_crl_CertificateRevocationListBuilder__1setSerialNumber__J(JNIEnv* env, jobject obj, jlong _serialNumber)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	try
	{
		builder->setSerialNumber(_serialNumber);
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
	}
}
void Java_crl_CertificateRevocationListBuilder__1setVersion(JNIEnv* env, jobject obj, jlong _version)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setVersion(_version);
}

jint Java_crl_CertificateRevocationListBuilder__1sign(JNIEnv *env, jobject obj, jint _privateKeyReferenece, jstring _messageDigestAlgorithmString)
{
	std::string messageDigestAlgorithmString = Util::jstringToString(env, _messageDigestAlgorithmString);
	MessageDigest::Algorithm messageDigestAlgorithm = Util::stringToMessageDigestAlgorithm(messageDigestAlgorithmString);
	PrivateKey* privateKey = (PrivateKey*)_privateKeyReferenece;
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);

	try{
		CertificateRevocationList* crl = builder->sign(*privateKey, messageDigestAlgorithm);
		return (jint)crl;
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
		return 0;
	}
}

void Java_crl_CertificateRevocationListBuilder__1delete(JNIEnv *env, jobject obj)
{
	Util::deleteInstance<CertificateRevocationListBuilder*>(env, obj);
}
