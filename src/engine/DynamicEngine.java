package engine;

import jni.JniObject;

public class DynamicEngine extends JniObject {

	private native int _init(String enginePath, String engineId, EngineCommand[] commands);
	private native void _delete();
	
	public DynamicEngine(int reference) {
		super(reference);
	}
	
	public DynamicEngine(String enginePath, String engineId, EngineCommand[] commands) {
		this.reference = _init(enginePath, engineId, commands);
	}

	@Override
	public void delete() {
		_delete();
	}

}
