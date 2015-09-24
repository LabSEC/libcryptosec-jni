#include "../br_ufsc_labsec_libcryptosec_signer_OpensslSigner.h"
#include <libcryptosec/Signer.h>
#include <libcryptosec/PublicKey.h>
#include <libcryptosec/PrivateKey.h>
#include <libcryptosec/ByteArray.h>
#include "util/Util.h"

jbyteArray Java_br_ufsc_labsec_libcryptosec_signer_OpensslSigner__1sign(JNIEnv* env, jclass cls, jint _key, jbyteArray _hash, jstring _hashAlgorithm)
{
	PrivateKey* key = (PrivateKey*)_key;
	ByteArray hash = Util::jbytearrayToByteArray(env, _hash);
	MessageDigest::Algorithm hashAlgorithm = Util::jstringToMessageDigestAlgorithm(env, _hashAlgorithm);

	try
	{
		ByteArray signature = Signer::sign(*key, hash, hashAlgorithm);
		return Util::byteArrayTojbytearray(env, signature);
	}
	catch(SignerException& ex)
	{
		Util::throwNewException(env, "SignerException", ex.getMessage());
		return 0;
	}
}

jboolean Java_br_ufsc_labsec_libcryptosec_signer_OpensslSigner__1verify(JNIEnv* env, jclass cls, jint _key, jbyteArray _signature, jbyteArray _hash, jstring _hashAlgorithm)
{
	PublicKey* key = (PublicKey*)_key;
	ByteArray signature = Util::jbytearrayToByteArray(env, _signature);
	ByteArray hash = Util::jbytearrayToByteArray(env, _hash);
	MessageDigest::Algorithm hashAlgorithm = Util::jstringToMessageDigestAlgorithm(env, _hashAlgorithm);

	try
	{
		return (jboolean)Signer::verify(*key, signature, hash, hashAlgorithm);
	}
	catch(SignerException& ex)
	{
		Util::throwNewException(env, "SignerException", ex.getMessage());
		return 0;
	}
}
