package keys;

import engine.DynamicEngine;
import engine.EngineCommand;
import jni.JniObject;

public class OpenSSLKeyFactory extends JniObject {

	private native int _loadEngine(String enginePath, String engineId, EngineCommand[] commands);
	
	static OpenSSLKeyFactory instanece = null;
	
	private DynamicEngine engine;
	
	private OpenSSLKeyFactory(String enginePath, String engineId, EngineCommand[] commands)
	{
		this.engine = new DynamicEngine(_loadEngine(enginePath, engineId, commands));
	}
	
	static public OpenSSLKeyFactory getInstance(String enginePath, String engineId, EngineCommand[] commands)
	{
		if(instanece == null)
			instanece = new OpenSSLKeyFactory(enginePath, engineId, commands);
		
		return instanece;
	}
	
	public OpenSSLKeyPair getKeyPair(String keyId)
	{
		return new OpenSSLKeyPair(this.engine, keyId);
	}
}
