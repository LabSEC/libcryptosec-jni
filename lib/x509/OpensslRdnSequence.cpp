#include "br_ufsc_labsec_libcryptosec_x509_OpensslRdnSequence.h"
#include <jni.h>
#include <libcryptosec/certificate/RDNSequence.h>
#include "util/Util.h"

// FIXME: find a way to make this global variable unnecessary
// (i.e, fix Util::getInstance in 64 bit machines)
RDNSequence* rdnSequenceInstance;

jlong Java_br_ufsc_labsec_libcryptosec_x509_OpensslRdnSequence__1init(JNIEnv* env, jobject obj)
{
	rdnSequenceInstance = new RDNSequence();
	return (jlong) rdnSequenceInstance;
}

void Java_br_ufsc_labsec_libcryptosec_x509_OpensslRdnSequence__1addEntry__Ljava_lang_String_2Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _entryTypeString, jstring _entryValue)
{
	RDNSequence* sequence = rdnSequenceInstance;//Util::getInstance<RDNSequence*>(env, obj);
	std::string entryTypeString = Util::jstringToString(env, _entryTypeString);
	std::string entryValue = Util::jstringToString(env, _entryValue);
	RDNSequence::EntryType entryType = Util::stringToRDNSequenceEntryType(entryTypeString);
	sequence->addEntry(entryType, entryValue);
}

void Java_br_ufsc_labsec_libcryptosec_x509_OpensslRdnSequence__1addEntry__Ljava_lang_String_2_3Ljava_lang_String_2(JNIEnv* env, jobject obj, jstring _entryTypeString, jobjectArray _entryValues)
{
	RDNSequence* sequence = Util::getInstance<RDNSequence*>(env, obj);
	std::string entryTypeString = Util::jstringToString(env, _entryTypeString);
	RDNSequence::EntryType entryType = Util::stringToRDNSequenceEntryType(entryTypeString);
	std::vector<std::string> entryValues = Util::jstringArrayTostringVector(env, _entryValues);
	sequence->addEntry(entryType, entryValues);
}

void Java_br_ufsc_labsec_libcryptosec_x509_OpensslRdnSequence__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<RDNSequence*>(env, obj);
}
