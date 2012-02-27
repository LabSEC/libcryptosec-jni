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
	std::string dateTimeString = Util::jstringToString(env, _dateTime);
	DateTime dateTime(dateTimeString);
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	revokedCertificate->setRevocationDate(dateTime);
}

void Java_crl_OpenSSLRevokedCertificate__1setReasonCode(JNIEnv *env, jobject obj, jstring _reasonCode)
{
	std::string reasonCodeString = Util::jstringToString(env, _reasonCode);
	RevokedCertificate::ReasonCode reasonCode = Util::stringToRevokedCertificateReasonCode(reasonCodeString);
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	revokedCertificate->setReasonCode(reasonCode);
}



void Java_crl_OpenSSLRevokedCertificate__1setSerialNumber__Ljava_lang_String_2(JNIEnv *env, jobject obj, jstring _serialNumber)
{
	std::string serialNumberString = Util::jstringToString(env, _serialNumber);
	BigInteger serialNumber(serialNumberString);
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	//TODO verificar exceção BigIntegerException
	revokedCertificate->setCertificateSerialNumber(serialNumber);
}



void Java_crl_OpenSSLRevokedCertificate__1setSerialNumber__J(JNIEnv *env, jobject obj, jlong serialNumber)
{
	RevokedCertificate* revokedCertificate = Util::getInstance<RevokedCertificate*>(env, obj);
	//TODO verificar exceção BigIntegerException
	revokedCertificate->setCertificateSerialNumber(serialNumber);
}

void Java_crl_OpenSSLRevokedCertificate__1delete(JNIEnv* env, jobject obj) {
	Util::deleteInstance<RevokedCertificate*>(env, obj);
}
