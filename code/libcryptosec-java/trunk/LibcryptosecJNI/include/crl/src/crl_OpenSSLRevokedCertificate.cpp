#include "crl/crl_OpenSSLRevokedCertificate.h"
#include <string>
#include <libcryptosec/certificate/RevokedCertificate.h>
#include <libcryptosec/DateTime.h>
#include "util/Util.h"

jint Java_crl_OpenSSLRevokedCertificate__1init(JNIEnv *env, jobject obj)
{
	RevokedCertificate* cert = new RevokedCertificate();
	return (jint)cert;
}

void Java_crl_OpenSSLRevokedCertificate__1setRevocationDate(JNIEnv *env, jobject obj, jstring _dateTime)
{
	std::string dateTimeString(env->GetStringUTFChars(_dateTime, 0));
	DateTime dateTime(dateTimeString);
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	revokedCertificate->setRevocationDate(dateTime);
}

void Java_crl_OpenSSLRevokedCertificate__1setReasonCode(JNIEnv *env, jobject obj, jstring _reasonCode)
{
	std::string reasonCodeString(env->GetStringUTFChars(_reasonCode, 0));
	RevokedCertificate::ReasonCode reasonCode = Util::stringToRevokedCertificateReasonCode(reasonCodeString);
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	revokedCertificate->setReasonCode(reasonCode);
}



void Java_crl_OpenSSLRevokedCertificate__1setSerialNumber__Ljava_lang_String_2(JNIEnv *env, jobject obj, jstring _serialNumber)
{
	std::string serialNumberString(env->GetStringUTFChars(_serialNumber, 0));
	BigInteger serialNumber(serialNumberString);
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	revokedCertificate->setCertificateSerialNumber(serialNumber);
}



void Java_crl_OpenSSLRevokedCertificate__1setSerialNumber__J(JNIEnv *env, jobject obj, jlong serialNumber)
{
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	revokedCertificate->setCertificateSerialNumber(serialNumber);
}

