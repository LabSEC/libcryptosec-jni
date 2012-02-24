package engine;

import jni.JniObject;

public class DynamicEngine extends JniObject {

	//TODO mover para DynamicEngine
	private native int _init(String enginePath, String engineId, EngineCommand[] commands);
		
	public DynamicEngine(int reference) {
		super(reference);
	}
	
	public DynamicEngine(String enginePath, String engineId, EngineCommand[] commands) {
		this.reference = _init(enginePath, engineId, commands);
	}

}
