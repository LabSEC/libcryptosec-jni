#include "br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder.h"
#include <libcryptosec/certificate/Certificate.h>
#include <libcryptosec/certificate/CertificateRevocationListBuilder.h>
#include "util/Util.h"

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1init__(JNIEnv* env, jobject obj)
{
	return jlong(new CertificateRevocationListBuilder());
}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1init__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _crlPemEncoded)
{
	std::string crlPemEncoded = Util::jstringToString(env, _crlPemEncoded);
	try
	{
		CertificateRevocationListBuilder* builder = new CertificateRevocationListBuilder(crlPemEncoded);
		return jlong(builder);
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}

}

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1init___3B(JNIEnv* env, jobject obj, jbyteArray _crlDerEncoded)
{
	ByteArray data = Util::jbytearrayToByteArray(env, _crlDerEncoded);
	try
	{
		CertificateRevocationListBuilder* new_builder = new CertificateRevocationListBuilder(data);
		return jlong(new_builder);
	}
	catch(EncodeException& ex)
	{
		Util::throwNewException(env, "EncodeException", ex.getMessage());
	}
}

void Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setIssuer(JNIEnv* env, jobject obj, jlong _issuerReference)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	Certificate* issuer = (Certificate*)_issuerReference;
	try
	{
		builder->setIssuer(issuer->getX509());
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
	}
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1addRevokedCertificate(JNIEnv* env, jobject obj, jlong _reference)
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

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1addRevokedCertificates(JNIEnv* env, jobject obj, jlongArray _references)
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

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setNextUpdate(JNIEnv* env, jobject obj, jstring _dateTimeString)
{
	std::string dateTimeString = Util::jstringToString(env, _dateTimeString);
	DateTime dateTime(dateTimeString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);

	builder->setNextUpdate(dateTime);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setLastUpdate(JNIEnv* env, jobject obj, jstring _dateTimeString)
{
	std::string dateTimeString = Util::jstringToString(env, _dateTimeString);
	DateTime dateTime(dateTimeString);
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setLastUpdate(dateTime);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setSerialNumber__Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _serialNumberString)
{
	std::string serialNumberString = Util::jstringToString(env, _serialNumberString);
	CertificateRevocationListBuilder* new_builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	try
	{
		BigInteger serialNumber(serialNumberString);
		new_builder->setSerialNumber(serialNumber);
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

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setSerialNumber__J(JNIEnv* env, jobject obj, jlong _serialNumber)
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

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setVersion(JNIEnv* env, jobject obj, jlong _version)
{
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);
	builder->setVersion(_version);
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1addExtension(JNIEnv* env, jobject obj, jstring _oid, jboolean _isCritical, jbyteArray _value)
{
        std::string oid = Util::jstringToString(env, _oid);
        bool isCritical = (bool)_isCritical;
        ByteArray value = Util::jbytearrayToByteArray(env, _value);

        CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);


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

JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1sign(JNIEnv *env, jobject obj, jlong _privateKeyReferenece, jstring _messageDigestAlgorithmString)
{
	std::string messageDigestAlgorithmString = Util::jstringToString(env, _messageDigestAlgorithmString);
	MessageDigest::Algorithm messageDigestAlgorithm = Util::stringToMessageDigestAlgorithm(messageDigestAlgorithmString);
	PrivateKey* privateKey = (PrivateKey*)_privateKeyReferenece;
	CertificateRevocationListBuilder* builder = Util::getInstance<CertificateRevocationListBuilder*>(env, obj);

	try{
		CertificateRevocationList* crl = builder->sign(*privateKey, messageDigestAlgorithm);
		std::cout << "crl builder:: crl address: " << crl << std::endl;
		return jlong(crl);
	}
	catch(CertificationException& ex)
	{
		Util::throwNewException(env, "CertificationException", ex.getMessage());
		return 0;
	}
}

JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1delete(JNIEnv *env, jobject obj)
{
	Util::deleteInstance<CertificateRevocationListBuilder*>(env, obj);
}
