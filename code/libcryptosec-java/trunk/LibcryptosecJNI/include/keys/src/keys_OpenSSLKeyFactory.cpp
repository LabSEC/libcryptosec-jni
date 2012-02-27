#include "keys/keys_OpenSSLKeyFactory.h"
#include <jni.h>
#include <string>
#include <vector>
#include <libcryptosec/DynamicEngine.h>


JNIEXPORT jint JNICALL Java_keys_OpenSSLKeyFactory__1loadEngine (JNIEnv* env, jobject obj, jstring _enginePath, jstring _engineId, jobjectArray _commands)
{
	/*
	 * Conversão
	 */
	std::string enginePath(env->GetStringUTFChars(_enginePath, 0));
	std::string engineId(env->GetStringUTFChars(_engineId, 0));
	std::vector<std::pair<std::string, std::string> > commands = convertCommandArray(env, _commands);
	DynamicEngine* engine = new DynamicEngine(enginePath, engineId, commands);
	return (int)engine;
}
