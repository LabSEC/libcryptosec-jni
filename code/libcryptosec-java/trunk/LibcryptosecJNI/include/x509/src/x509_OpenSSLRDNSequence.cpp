#include "x509/x509_OpenSSLRDNSequence.h"
#include <jni.h>
#include <libcryptosec/certificate/RDNSequence.h>
#include "util/Util.h"

jint Java_x509_OpenSSLRDNSequence__1init(JNIEnv* env, jobject obj)
{
	return (jint) new RDNSequence();
}

void Java_x509_OpenSSLRDNSequence__1addEntry__Ljava_lang_String_2Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _entryTypeString, jstring _entryValue)
{
	RDNSequence* sequence = Util::getInstance<RDNSequence*>(env, obj);
	std::string entryTypeString = Util::jstringToString(env, _entryTypeString);
	std::string entryValue = Util::jstringToString(env, _entryValue);
	RDNSequence::EntryType entryType = Util::stringToRDNSequenceEntryType(entryTypeString);
	sequence->addEntry(entryType, entryValue);
}

void Java_x509_OpenSSLRDNSequence__1addEntry__Ljava_lang_String_2_3Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _entryTypeString, jobjectArray _entryValues)
{
	RDNSequence* sequence = Util::getInstance<RDNSequence*>(env, obj);
	std::string entryTypeString = Util::jstringToString(env, _entryTypeString);
	RDNSequence::EntryType entryType = Util::stringToRDNSequenceEntryType(entryTypeString);
	std::vector<std::string> entryValues = Util::jstringArrayTostringVector(env, _entryValues);
	sequence->addEntry(entryType, entryValues);
}

