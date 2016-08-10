/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder */

#ifndef _Included_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
#define _Included_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _init
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1init__
  (JNIEnv *, jobject);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _init
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1init__Ljava_lang_String_2
  (JNIEnv *, jobject, jstring);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _init
 * Signature: ([B)J
 */
JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1init___3B
  (JNIEnv *, jobject, jbyteArray);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _delete
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1delete
  (JNIEnv *, jobject);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _setSerialNumber
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setSerialNumber__J
  (JNIEnv *, jobject, jlong);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _setSerialNumber
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setSerialNumber__Ljava_lang_String_2
  (JNIEnv *, jobject, jstring);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _setVersion
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setVersion
  (JNIEnv *, jobject, jlong);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _setIssuer
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setIssuer
  (JNIEnv *, jobject, jlong);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _setLastUpdate
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setLastUpdate
  (JNIEnv *, jobject, jstring);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _setNextUpdate
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1setNextUpdate
  (JNIEnv *, jobject, jstring);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _addRevokedCertificate
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1addRevokedCertificate
  (JNIEnv *, jobject, jlong);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _addRevokedCertificates
 * Signature: ([J)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1addRevokedCertificates
  (JNIEnv *, jobject, jlongArray);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _addExtension
 * Signature: (Ljava/lang/String;Z[B)V
 */
JNIEXPORT void JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1addExtension
  (JNIEnv *, jobject, jstring, jboolean, jbyteArray);

/*
 * Class:     br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder
 * Method:    _sign
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder__1sign
  (JNIEnv *, jobject, jlong, jstring);

#ifdef __cplusplus
}
#endif
#endif
