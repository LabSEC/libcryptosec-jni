cmake_minimum_required(VERSION 2.8)
project(libcryptosec_jni)

set(CMAKE_MODULE_PATH "${CMAKE_CURRENT_SOURCE_DIR}/cmake" ${CMAKE_MODULE_PATH})

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -pipe -O2 -Wall -W -D_REENTRANT -fPIC")
set(CMAKE_MODULE_LINKER_FLAGS "${CMAKE_MODULE_LINKER_FLAGS} -pipe -O2 -Wall -W -D_REENTRANT")
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -pipe -O2 -Wall -W -D_REENTRANT")
set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} -pipe -O2 -Wall -W -D_REENTRANT")


message(STATUS ${CMAKE_SHARED_LINKER_FLAGS})
# Fix the find_package for Libcryptosec or find a better solution other than a static path for include and libraries
# find_package(JNI REQUIRED)
set(LIBCRYPTOSEC_INCLUDE_DIR /usr/include/libcryptosec/include)
# might as well be /usr/lib64/libcryptosec.so
set(LIBCRYPTOSEC_LIBRARIES /usr/lib/libcryptosec.so)

# Searches first at local, then at generated headers, so that wrong headers are easily overridable.
# If javah generates anything wrongly, just create if correctly by hand and place on . directory.
set(LIBCRYPTOSEC_INCLUDE_DIR /usr/include/libcryptosec)
include_directories(${CMAKE_SOURCE_DIR} ../include ${JNI_INCLUDE_DIRS} ${LIBCRYPTOSEC_INCLUDE_DIR})

# Search everything that ends by cpp, list the files manually when you have time to.
file(GLOB_RECURSE SOURCE_FILES *.cpp)
add_library(cryptosec_jni SHARED ${SOURCE_FILES})
target_link_libraries(cryptosec_jni ${JNI_LIBRARIES} ${LIBCRYPTOSEC_LIBRARIES})
