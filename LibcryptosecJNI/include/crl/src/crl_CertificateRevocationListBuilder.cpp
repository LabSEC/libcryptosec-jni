#include "crl/crl_CertificateRevocationListBuilder.h"
#include <libcryptosec/certificate/CertificateRevocationListBuilder.h>
#include "util/Util.h"


jint Java_crl_CertificateRevocationListBuilder__1init__(JNIEnv* env, jobject obj)
{
	return (jint) new CertificateRevocationListBuilder();
}

jint Java_crl_CertificateRevocationListBuilder__1init__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _crlPemEncoded)
{
	std::string crlPemEncoded(env->GetStringUTFChars(_crlPemEncoded, 0));
	CertificateRevocationListBuilder* builder = new CertificateRevocationListBuilder(crlPemEncoded);
	return (jint)builder;
}

jint Java_crl_CertificateRevocationListBuilder__1init___3B(JNIEnv* env, jobject obj, jbyteArray _crlDerEncoded)
{
	ByteArray data = Util::jbytearrayToByteArray(env, _crlDerEncoded);
	CertificateRevocationListBuilder* builder = new CertificateRevocationListBuilder(data);
	return (jint)builder;
}

void Java_crl_CertificateRevocationListBuilder__1setIssuer(JNIEnv* env, jobject obj, jint _rdnSequenceReference)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	RDNSequence* rdnSequence = (RDNSequence*)_rdnSequenceReference;
	builder->setIssuer(*rdnSequence);
}

void Java_crl_CertificateRevocationListBuilder__1addRevokedCertificate(JNIEnv* env, jobject obj, jint _reference)
{
	RevokedCertificate* revokedCertificate = (RevokedCertificate*)_reference;
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->addRevokedCertificate(*revokedCertificate);
}

void Java_crl_CertificateRevocationListBuilder__1addRevokedCertificates(JNIEnv* env, jobject obj, jintArray _references)
{
	int size = env->GetArrayLength(_references);
	int* references = env->GetIntArrayElements(_references, 0);
	std::vector<RevokedCertificate> revokedCertificates;
	for(int i = 0; i < size; i++)
	{
		revokedCertificates.push_back(*(RevokedCertificate*)references[i]);
	}
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->addRevokedCertificates(revokedCertificates);
}

void Java_crl_CertificateRevocationListBuilder__1setNextUpdate(JNIEnv* env, jobject obj, jstring _dateTimeString)
{
	std::string dateTimeString(env->GetStringUTFChars(_dateTimeString, 0));
	DateTime dateTime(dateTimeString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setNextUpdate(dateTime);
}

void Java_crl_CertificateRevocationListBuilder__1setLastUpdate(JNIEnv* env, jobject obj, jstring _dateTimeString)
{
	std::string dateTimeString(env->GetStringUTFChars(_dateTimeString, 0));
	DateTime dateTime(dateTimeString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setLastUpdate(dateTime);
}

void Java_crl_CertificateRevocationListBuilder__1setSerialNumber__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _serialNumberString)
{
	std::string serialNumberString(env->GetStringUTFChars(_serialNumberString, 0));
	BigInteger serialNumber(serialNumberString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setSerialNumber(serialNumber);
}
void Java_crl_CertificateRevocationListBuilder__1setSerialNumber__J(JNIEnv* env, jobject obj, jlong _serialNumber)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setSerialNumber(_serialNumber);
}
void Java_crl_CertificateRevocationListBuilder__1setVersion(JNIEnv* env, jobject obj, jlong _version)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setSerialNumber(_version);
}

jint Java_crl_CertificateRevocationListBuilder__1sign(JNIEnv *env, jobject obj, jint _privateKeyReferenece, jstring _messageDigestAlgorithmString)
{
	PrivateKey* privateKey = (PrivateKey*)_privateKeyReferenece;
	std::string messageDigestAlgorithmString(env->GetStringUTFChars(_messageDigestAlgorithmString, 0));
	MessageDigest::Algorithm messageDigestAlgorithm = Util::stringToMessageDigestAlgorithm(messageDigestAlgorithmString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	CertificateRevocationList* crl = builder->sign(*privateKey, messageDigestAlgorithm);
	return (jint)crl;
}
