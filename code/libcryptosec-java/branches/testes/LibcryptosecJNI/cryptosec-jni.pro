######################################################################
# Automatically generated by qmake (2.01a) Wed Apr 11 12:53:56 2012
######################################################################

TEMPLATE = lib
TARGET = 
LIBS += -lcryptosec -lc
DEPENDPATH += . \
              include/certificate \
              include/crl \
              include/engine \
              include/exceptions \
              include/keys \
              include/signer \
              include/util \
              include/x509 \
              include/certificate/src \
              include/crl/src \
              include/engine/src \
              include/keys/src \
              include/signer/src \
              include/x509/src
INCLUDEPATH += . include /usr/lib/jvm/java-7-oracle/include /usr/lib/jvm/java-7-oracle/include/linux

# Input
HEADERS += include/certificate/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate.h \
           include/certificate/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder.h \
           include/certificate/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest.h \
           include/crl/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.h \
           include/crl/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder.h \
           include/crl/br_ufsc_labsec_libcryptosec_crl_OpensslRevokedCertificate.h \
           include/engine/br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine.h \
           include/exceptions/EnumConversionException.h \
           include/keys/br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair.h \
           include/keys/br_ufsc_labsec_libcryptosec_keys_OpensslPrivateKey.h \
           include/keys/br_ufsc_labsec_libcryptosec_keys_OpensslPublicKey.h \
           include/signer/br_ufsc_labsec_libcryptosec_signer_OpensslSigner.h \
           include/util/Util.h \
           include/x509/br_ufsc_labsec_libcryptosec_x509_OpensslRdnSequence.h
SOURCES += include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate.cpp \
           include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder.cpp \
           include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest.cpp \
           include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.cpp \
           include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder.cpp \
           include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslRevokedCertificate.cpp \
           include/engine/src/br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine.cpp \
           include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair.cpp \
           include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPrivateKey.cpp \
           include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPublicKey.cpp \
           include/signer/src/br_ufsc_labsec_libcryptosec_signer_OpensslSigner.cpp \
           include/x509/src/br_ufsc_labsec_libcryptosec_x509_OpensslRdnSequence.cpp
