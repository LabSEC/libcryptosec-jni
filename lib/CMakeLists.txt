cmake_minimum_required(VERSION 2.8)
project(libcryptosec_jni)

set(CMAKE_MODULE_PATH "${CMAKE_CURRENT_SOURCE_DIR}/cmake" ${CMAKE_MODULE_PATH})
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fpermissive -fPIC")
find_package(JNI REQUIRED)
find_package(LibCryptoSEC REQUIRED)

include_directories(${CMAKE_SOURCE_DIR} ../include ${JNI_INCLUDE_DIRS} ${LIBCRYPTOSEC_INCLUDE_DIR})

if (JNI_FOUND)
    message (STATUS "JNI_INCLUDE_DIRS=${JNI_INCLUDE_DIRS}")
    message (STATUS "JNI_LIBRARIES=${JNI_LIBRARIES}")
endif()

file(GLOB_RECURSE SOURCE_FILES *.cpp)
add_library(cryptosec_jni SHARED ${SOURCE_FILES})
target_link_libraries(cryptosec_jni ${JNI_LIBRARIES} ${LIBCRYPTOSEC_LIBRARIES})
