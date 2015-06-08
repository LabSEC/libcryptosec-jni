################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../include/signer/src/br_ufsc_labsec_libcryptosec_signer_OpensslSigner.cpp 

OBJS += \
./include/signer/src/br_ufsc_labsec_libcryptosec_signer_OpensslSigner.o 

CPP_DEPS += \
./include/signer/src/br_ufsc_labsec_libcryptosec_signer_OpensslSigner.d 


# Each subdirectory must supply rules for building sources it contributes
include/signer/src/%.o: ../include/signer/src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib/java/jdk1.7.0_03/include/ -I"/home/lucasgm/workspaces/workspace-sgc/LibcryptosecJNI/include" -I/usr/lib/java/jdk1.7.0_03/include/linux -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


