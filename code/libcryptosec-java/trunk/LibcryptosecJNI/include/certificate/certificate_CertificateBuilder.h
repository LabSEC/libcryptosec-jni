/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class certificate_CertificateBuilder */

#ifndef _Included_certificate_CertificateBuilder
#define _Included_certificate_CertificateBuilder
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     certificate_CertificateBuilder
 * Method:    _init
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1init__
  (JNIEnv *, jobject);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _init
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1init__Ljava_lang_String_2
  (JNIEnv *, jobject, jstring);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _init
 * Signature: ([B)I
 */
JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1init___3B
  (JNIEnv *, jobject, jbyteArray);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _delete
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1delete
  (JNIEnv *, jobject);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setSerialNumber
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setSerialNumber__J
  (JNIEnv *, jobject, jlong);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setSerialNumber
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setSerialNumber__Ljava_lang_String_2
  (JNIEnv *, jobject, jstring);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setVersion
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setVersion
  (JNIEnv *, jobject, jlong);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setSubject
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setSubject
  (JNIEnv *, jobject, jint);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setIssuer
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setIssuer
  (JNIEnv *, jobject, jint);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setNotBefore
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setNotBefore
  (JNIEnv *, jobject, jstring);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setNotAfter
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setNotAfter
  (JNIEnv *, jobject, jstring);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setPublicKey
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1setPublicKey__Ljava_lang_String_2
  (JNIEnv *, jobject, jstring);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setPublicKey
 * Signature: ([B)I
 */
JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1setPublicKey___3B
  (JNIEnv *, jobject, jbyteArray);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _setPublicKey
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_certificate_CertificateBuilder__1setPublicKey__I
  (JNIEnv *, jobject, jint);

/*
 * Class:     certificate_CertificateBuilder
 * Method:    _sign
 * Signature: (ILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_certificate_CertificateBuilder__1sign
  (JNIEnv *, jobject, jint, jstring);

#ifdef __cplusplus
}
#endif
#endif
