################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.cpp \
../include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder.cpp \
../include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslRevokedCertificate.cpp 

OBJS += \
./include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.o \
./include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder.o \
./include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslRevokedCertificate.o 

CPP_DEPS += \
./include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationList.d \
./include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslCertificateRevocationListBuilder.d \
./include/crl/src/br_ufsc_labsec_libcryptosec_crl_OpensslRevokedCertificate.d 


# Each subdirectory must supply rules for building sources it contributes
include/crl/src/%.o: ../include/crl/src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib/java/jdk1.7.0_03/include/ -I"/home/lucasgm/workspaces/workspace-sgc/LibcryptosecJNI/include" -I/usr/lib/java/jdk1.7.0_03/include/linux -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


