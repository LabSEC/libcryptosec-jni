# Libcryptosec -JNI

## What is

## Requirements

Java version capable of handling JNI
Libcryptosec
CMake

## Compile

First, take a look at ./lib/CMakeLists.txt, and configure accordingly then just run `ant`
=======

Libcryptosec-JNI
===========
Java Native Interface for the Libcryptosec library.

## Contributions

* We take in pull requests, feel free to fork :-)
* the Master and Dev branches are protected. Use branches and 
pull requests.
* Avoid backwards incompability! We use this for many of our project.


## Compilation
#### Configuring
The following configurations must be made before compiling:
* Libcryptosec-JNI requires Libcryptosec 2.3.0 compiled statically. 
* The folder /usr/include/ must include the headers of the same OpenSSL version used to compile Libcryptosec 2.3.0.

#### Compiling
* Requires java 8 with JNI.
* ```$ant``` to compile;


## Tags and OpenSSL

### 1.0 and lower
Use Libcryptosec 2.2.1.

### 1.1.0 and higher
Use Libcryptosec 2.3.0.