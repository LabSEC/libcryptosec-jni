################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../include/engine/src/br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine.cpp 

OBJS += \
./include/engine/src/br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine.o 

CPP_DEPS += \
./include/engine/src/br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine.d 


# Each subdirectory must supply rules for building sources it contributes
include/engine/src/%.o: ../include/engine/src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib/java/jdk1.7.0_03/include/ -I"/home/lucasgm/workspaces/workspace-sgc/LibcryptosecJNI/include" -I/usr/lib/java/jdk1.7.0_03/include/linux -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


