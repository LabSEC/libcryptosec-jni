#ifndef UTIL_H_
#define UTIL_H_

#include <jni.h>
#include <string>
#include <libcryptosec/MessageDigest.h>
#include <libcryptosec/ByteArray.h>
#include <libcryptosec/certificate/RDNSequence.h>
#include <libcryptosec/certificate/RevokedCertificate.h>
#include "exceptions/EnumConversionException.h"

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

	template<class T>
	static void deleteInstance(JNIEnv* env, jobject obj) {
		T instance = getInstance<T>(env, obj);
		delete instance;
	}

	static void throwNewException(JNIEnv* env, std::string name, std::string msg)
	{
		std::string exceptionPath = "br/ufsc/labsec/libcryptosec/exceptions/" + name;
		jclass cls = env->FindClass(exceptionPath.c_str());
		if (cls == NULL) {
			std::cerr << "Util::throwNewException: Exception class " + exceptionPath + " not found" << std::endl;
			return;
		}
		else if (cls != NULL) {
			env->ThrowNew(cls, msg.c_str());
		}

		/* free the local ref */
		env->DeleteLocalRef(cls);
	}

	static std::string jstringToString(JNIEnv* env, jstring _data){
		const char* data = env->GetStringUTFChars(_data, 0);
		std::string ret(data);
		env->ReleaseStringUTFChars(_data, data);
		return ret;
	}

	static std::vector<std::string> jstringArrayTostringVector(JNIEnv* env, jobjectArray jstringArray) {
		jsize size = env->GetArrayLength(jstringArray);
		std::vector<std::string> ret;
		for(int i = 0; i < size; i++)
		{
			jstring jvalue = (jstring)env->GetObjectArrayElement(jstringArray, i);
			std::string value = Util::jstringToString(env, jvalue);
			ret.push_back(value);
		}
		return ret;
	}

	static ByteArray jbytearrayToByteArray(JNIEnv* env, jbyteArray _data) {
		jsize size = env->GetArrayLength(_data);
		jbyte* elements = env->GetByteArrayElements(_data, 0);
		ByteArray ret = ByteArray((unsigned char*) elements, size);
		env->ReleaseByteArrayElements(_data, elements, 0);
		return ret;
	}

	static jbyteArray byteArrayTojbytearray(JNIEnv* env, ByteArray& _data) {
		jsize size = _data.size();
		jbyte* jdata = (signed char*) _data.getDataPointer();
		jbyteArray data = env->NewByteArray(size);
		env->SetByteArrayRegion(data, 0, size, jdata);
		return data;
	}

	template <class T>
	static std::vector<T> getObjectReferenceVector(JNIEnv* env, jintArray _referenceArray)
	{
		int size = env->GetArrayLength(_referenceArray);
		jint* references = env->GetIntArrayElements(_referenceArray, 0);
		std::vector<T> objectsReferences;
		for(int i = 0; i < size; i++)
		{
			objectsReferences.push_back((T)references[i]);
		}
		env->ReleaseIntArrayElements(_referenceArray, references, 0);
		return objectsReferences;
	}

	template <class T>
	static std::vector<T> getObjectVector(JNIEnv* env, jintArray _referenceArray)
	{
		int size = env->GetArrayLength(_referenceArray);
		int* references = env->GetIntArrayElements(_referenceArray, 0);
		std::vector<T> objects;
		for(int i = 0; i < size; i++)
		{
			objects.push_back(*((T*)references[i]));
		}
		env->ReleaseIntArrayElements(_referenceArray, references, 0);
		return objects;
	}

	static MessageDigest::Algorithm jstringToMessageDigestAlgorithm(JNIEnv* env, jstring _algName)
	{
		return stringToMessageDigestAlgorithm(jstringToString(env, _algName));
	}

	static MessageDigest::Algorithm stringToMessageDigestAlgorithm(std::string algName)
		throw (EnumConversionException)
	{
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
			throw new EnumConversionException("String \""+ algName +"\" doesn't name a MessageDigest::Algorithm");
	}

	static RevokedCertificate::ReasonCode jstringToRevokedCertificateReasonCode(JNIEnv* env, jstring _algName)
	{
		return stringToRevokedCertificateReasonCode(jstringToString(env, _algName));
	}

	static RevokedCertificate::ReasonCode stringToRevokedCertificateReasonCode(std::string reasonCode)
		throw (EnumConversionException)
	{
		if (reasonCode == "AACOMPROMISE")
			return RevokedCertificate::AACOMPROMISE;
		else if (reasonCode == "AFFILIATION_CHANGED")
			return RevokedCertificate::AFFILIATION_CHANGED;
		else if (reasonCode == "CA_COMPROMISE")
			return RevokedCertificate::CA_COMPROMISE;
		else if (reasonCode == "CERTIFICATE_HOLD")
			return RevokedCertificate::CERTIFICATE_HOLD;
		else if (reasonCode == "CESSATION_OF_OPERATION")
			return RevokedCertificate::CESSATION_OF_OPERATION;
		else if (reasonCode == "KEY_COMPROMISE")
			return RevokedCertificate::KEY_COMPROMISE;
		else if (reasonCode == "PRIVILEGE_WITH_DRAWN")
			return RevokedCertificate::PRIVILEGE_WITH_DRAWN;
		else if (reasonCode == "SUPER_SEDED")
			return RevokedCertificate::SUPER_SEDED;
		else if (reasonCode == "UNSPECIFIED")
			return RevokedCertificate::UNSPECIFIED;
		else
			throw new EnumConversionException("String \""+ reasonCode +"\" doesn't name a RevokedCertificate::ReasonCode");
	}

	static RDNSequence::EntryType jstringToRDNSequenceEntryType(JNIEnv* env, jstring _algName)
	{
		return stringToRDNSequenceEntryType(jstringToString(env, _algName));
	}

	static RDNSequence::EntryType stringToRDNSequenceEntryType(std::string entryType)
		throw (EnumConversionException)
	{
		if (entryType == "COMMON_NAME")
			return RDNSequence::COMMON_NAME;
		else if (entryType == "COUNTRY")
			return RDNSequence::COUNTRY;
		else if (entryType == "DN_QUALIFIER")
			return RDNSequence::DN_QUALIFIER;
		else if (entryType == "DOMAIN_COMPONENT")
			return RDNSequence::DOMAIN_COMPONENT;
		else if (entryType == "EMAIL")
			return RDNSequence::EMAIL;
		else if (entryType == "GENERATION_QUALIFIER")
			return RDNSequence::GENERATION_QUALIFIER;
		else if (entryType == "GIVEN_NAME")
			return RDNSequence::GIVEN_NAME;
		else if (entryType == "INITIALS")
			return RDNSequence::INITIALS;
		else if (entryType == "LOCALITY")
			return RDNSequence::LOCALITY;
		else if (entryType == "ORGANIZATION")
			return RDNSequence::ORGANIZATION;
		else if (entryType == "ORGANIZATION_UNIT")
			return RDNSequence::ORGANIZATION_UNIT;
		else if (entryType == "PSEUDONYM")
			return RDNSequence::PSEUDONYM;
		else if (entryType == "SERIAL_NUMBER")
			return RDNSequence::SERIAL_NUMBER;
		else if (entryType == "STATE_OR_PROVINCE")
			return RDNSequence::STATE_OR_PROVINCE;
		else if (entryType == "SURNAME")
			return RDNSequence::SURNAME;
		else if (entryType == "TITLE")
			return RDNSequence::TITLE;
		else if (entryType == "UNKNOWN")
			return RDNSequence::UNKNOWN;
		else
			throw new EnumConversionException("String \""+ entryType +"\" doesn't name an RDNSequence::EntryType");
	}
};

#endif /* UTIL_H_ */
