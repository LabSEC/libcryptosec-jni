cmake_minimum_required(VERSION 2.8)
project(libcryptosec_jni)

set(CMAKE_MODULE_PATH "${CMAKE_CURRENT_SOURCE_DIR}/cmake" ${CMAKE_MODULE_PATH})

# REMOVE -fpermissive as soon as possible, currently code does not build with it.
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fpermissive -fPIC")
find_package(JNI REQUIRED)
find_package(LibCryptoSEC REQUIRED)

# Searches first at local, then at generated headers, so that wrong headers are easily overridable.
# If javah generates anything wrongly, just create if correctly by hand and place on . directory.
include_directories(${CMAKE_SOURCE_DIR} ../include ${JNI_INCLUDE_DIRS} ${LIBCRYPTOSEC_INCLUDE_DIR})

# Search everything that ends by cpp, list the files manually when you have time to.
file(GLOB_RECURSE SOURCE_FILES *.cpp)
add_library(cryptosec_jni SHARED ${SOURCE_FILES})
target_link_libraries(cryptosec_jni ${JNI_LIBRARIES} ${LIBCRYPTOSEC_LIBRARIES})
