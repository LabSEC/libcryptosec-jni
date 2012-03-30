################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair.cpp \
../include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPrivateKey.cpp \
../include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPublicKey.cpp 

OBJS += \
./include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair.o \
./include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPrivateKey.o \
./include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPublicKey.o 

CPP_DEPS += \
./include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslKeyPair.d \
./include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPrivateKey.d \
./include/keys/src/br_ufsc_labsec_libcryptosec_keys_OpensslPublicKey.d 


# Each subdirectory must supply rules for building sources it contributes
include/keys/src/%.o: ../include/keys/src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib/java/jdk1.7.0_03/include/ -I"/home/lucasgm/workspaces/workspace-sgc/LibcryptosecJNI/include" -I/usr/lib/java/jdk1.7.0_03/include/linux -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


