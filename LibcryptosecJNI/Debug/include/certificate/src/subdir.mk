################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate.cpp \
../include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder.cpp \
../include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest.cpp 

OBJS += \
./include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate.o \
./include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder.o \
./include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest.o 

CPP_DEPS += \
./include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificate.d \
./include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateBuilder.d \
./include/certificate/src/br_ufsc_labsec_libcryptosec_certificate_OpensslCertificateRequest.d 


# Each subdirectory must supply rules for building sources it contributes
include/certificate/src/%.o: ../include/certificate/src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib/java/jdk1.7.0_03/include/ -I"/home/lucasgm/workspaces/workspace-sgc/LibcryptosecJNI/include" -I/usr/lib/java/jdk1.7.0_03/include/linux -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


