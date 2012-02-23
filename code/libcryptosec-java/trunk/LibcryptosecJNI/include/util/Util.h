#ifndef UTIL_H_
#define UTIL_H_

#include <jni.h>
#include <string>
#include <libcryptosec/MessageDigest.h>
#include <libcryptosec/ByteArray.h>
#include <libcryptosec/certificate/RDNSequence.h>
#include <libcryptosec/certificate/RevokedCertificate.h>
#include "Util.h"

class Util {

public:
	Util();
	virtual ~Util();

	template<class T>
	static T getInstance(JNIEnv* env, jobject obj) {
		jclass obj_class = env->GetObjectClass(obj);
		jfieldID fid = env->GetFieldID(obj_class, "reference", "I");
		void* keyPairReference = (void*) env->GetIntField(obj, fid);
		return (T) keyPairReference;
	}

	static std::vector<std::string> jstringArrayTostringVector(JNIEnv* env, jobjectArray jstringArray) {
		jsize size = env->GetArrayLength(jstringArray);
		std::vector<std::string> ret;
		for(int i = 0; i < size; i++)
		{
			jstring jvalue = (jstring)env->GetObjectArrayElement(jstringArray, i);
			std::string value = env->GetStringUTFChars(jvalue, 0);
			ret.push_back(value);
		}
		return ret;
	}

	static ByteArray jbytearrayToByteArray(JNIEnv* env, jbyteArray _data) {
		jsize size = env->GetArrayLength(_data);
		jbyte* jdata = env->GetByteArrayElements(_data, 0);
		return ByteArray((unsigned char*) jdata, size);
	}

	static jbyteArray byteArrayTojbytearray(JNIEnv* env, ByteArray& _data) {
		jsize size = _data.size();
		jbyte* jdata = (signed char*) _data.getDataPointer();
		jbyteArray data = env->NewByteArray(size);
		env->SetByteArrayRegion(data, 0, size, jdata);
		return data;
	}

	static MessageDigest::Algorithm stringToMessageDigestAlgorithm(std::string algName) {
		if (algName == "SHA")
			return MessageDigest::SHA;
		else if (algName == "SHA1")
			return MessageDigest::SHA1;
		else if (algName == "SHA224")
			return MessageDigest::SHA224;
		else if (algName == "SHA256")
			return MessageDigest::SHA256;
		else if (algName == "SHA384")
			return MessageDigest::SHA384;
		else if (algName == "SHA512")
			return MessageDigest::SHA512;
		else if (algName == "RIPEMD160")
			return MessageDigest::RIPEMD160;
		else if (algName == "MD4")
			return MessageDigest::MD4;
		else if (algName == "MD5")
			return MessageDigest::MD5;
		else
			throw;//TODO implement
	}

	static RevokedCertificate::ReasonCode stringToRevokedCertificateReasonCode(std::string algName) {
		if (algName == "AACOMPROMISE")
			return RevokedCertificate::AACOMPROMISE;
		else if (algName == "AFFILIATION_CHANGED")
			return RevokedCertificate::AFFILIATION_CHANGED;
		else if (algName == "CA_COMPROMISE")
			return RevokedCertificate::CA_COMPROMISE;
		else if (algName == "CERTIFICATE_HOLD")
			return RevokedCertificate::CERTIFICATE_HOLD;
		else if (algName == "CESSATION_OF_OPERATION")
			return RevokedCertificate::CESSATION_OF_OPERATION;
		else if (algName == "KEY_COMPROMISE")
			return RevokedCertificate::KEY_COMPROMISE;
		else if (algName == "PRIVILEGE_WITH_DRAWN")
			return RevokedCertificate::PRIVILEGE_WITH_DRAWN;
		else if (algName == "SUPER_SEDED")
			return RevokedCertificate::SUPER_SEDED;
		else if (algName == "UNSPECIFIED")
			return RevokedCertificate::UNSPECIFIED;
		else
			throw;//TODO implement
	}

	static RDNSequence::EntryType stringToRDNSequenceEntryType(std::string algName)
	{
		if (algName == "COMMON_NAME")
			return RDNSequence::COMMON_NAME;
		else if (algName == "COUNTRY")
			return RDNSequence::COUNTRY;
		else if (algName == "DN_QUALIFIER")
			return RDNSequence::DN_QUALIFIER;
		else if (algName == "DOMAIN_COMPONENT")
			return RDNSequence::DOMAIN_COMPONENT;
		else if (algName == "EMAIL")
			return RDNSequence::EMAIL;
		else if (algName == "GENERATION_QUALIFIER")
			return RDNSequence::GENERATION_QUALIFIER;
		else if (algName == "GIVEN_NAME")
			return RDNSequence::GIVEN_NAME;
		else if (algName == "INITIALS")
			return RDNSequence::INITIALS;
		else if (algName == "LOCALITY")
			return RDNSequence::LOCALITY;
		else if (algName == "ORGANIZATION")
			return RDNSequence::ORGANIZATION;
		else if (algName == "ORGANIZATION_UNIT")
			return RDNSequence::ORGANIZATION_UNIT;
		else if (algName == "PSEUDONYM")
			return RDNSequence::PSEUDONYM;
		else if (algName == "SERIAL_NUMBER")
			return RDNSequence::SERIAL_NUMBER;
		else if (algName == "STATE_OR_PROVINCE")
			return RDNSequence::STATE_OR_PROVINCE;
		else if (algName == "SURNAME")
			return RDNSequence::SURNAME;
		else if (algName == "TITLE")
			return RDNSequence::TITLE;
		else if (algName == "UNKNOWN")
			return RDNSequence::UNKNOWN;
		else
			throw;//TODO implement
	}
};

#endif /* UTIL_H_ */
