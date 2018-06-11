#include "br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine.h"
#include <string>
#include <vector>
#include <jni.h>
#include <libcryptosec/DynamicEngine.h>
#include <libcryptosec/Engines.h>
#include "util/Util.h"
#include <pthread.h>

std::vector<std::pair<std::string, std::string> > convertCommandArray(JNIEnv* env, jobjectArray jcommandarray)
{
	std::vector<std::pair<std::string, std::string> > commands;
	unsigned int size = env->GetArrayLength(jcommandarray);

	jobject command_obj;
	jclass command_class;

	for(unsigned int i = 0; i < size; i++)
	{
		//Lê objeto do array
		command_obj = env->GetObjectArrayElement(jcommandarray, i);

		//Recupera o id dos atributos "command" e "value" do objeto
		command_class = env->GetObjectClass(command_obj);
		jfieldID commandFid = env->GetFieldID(command_class, "command", "Ljava/lang/String;");
		jfieldID valueFid = env->GetFieldID(command_class, "value", "Ljava/lang/String;");
		if (commandFid == 0 || valueFid == 0) {
			throw; /* failed to find the field */
		}

		//Converte para array de char
		jstring jcommand = (jstring)env->GetObjectField(command_obj, commandFid);
		const char* command = env->GetStringUTFChars(jcommand, NULL);
		jstring jvalue = (jstring)env->GetObjectField(command_obj, valueFid);
		const char* value = env->GetStringUTFChars(jvalue, NULL);

		if (command == 0 || value == 0) {
			throw; /* out of memory */
		}

		std::pair<std::string, std::string> commandValue(command, value);
		commands.push_back(commandValue);
	}

	return commands;
}

jlong Java_br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine__1init(JNIEnv* env, jobject obj, jstring _enginePath, jstring _engineId, jobjectArray _commands)
{

	/*
	 * A Libcryptosec deve garantir que a engine não seja carregada mais de uma vez?
	 */
	Engines::loadDynamicEngineSupport();

	/*
	 * Conversão
	 */
	std::string enginePath(env->GetStringUTFChars(_enginePath, 0));
	std::string engineId(env->GetStringUTFChars(_engineId, 0));
	std::vector<std::pair<std::string, std::string> > commands = convertCommandArray(env, _commands);

	try
	{
		DynamicEngine* engine = 0;
		engine = new DynamicEngine(enginePath, engineId, commands);

		return jlong(engine);
	}
	catch(EngineException& ex)
	{
		Util::throwNewException(env, "EngineException", ex.getMessage());
		return 0;
	}
}



void Java_br_ufsc_labsec_libcryptosec_engine_OpensslDynamicEngine__1delete(JNIEnv* env, jobject obj)
{
	Util::deleteInstance<DynamicEngine*>(env, obj);
}
