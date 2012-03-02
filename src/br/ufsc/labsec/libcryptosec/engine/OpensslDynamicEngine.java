package br.ufsc.labsec.libcryptosec.engine;

import br.ufsc.labsec.libcryptosec.exceptions.EngineException;
import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslDynamicEngine extends JniObject {

	private native int _init(String enginePath, String engineId, OpensslEngineCommand[] commands);
	private native void _delete();
	
	public OpensslDynamicEngine(int reference) {
		super(reference);
	}
	
	public OpensslDynamicEngine(String enginePath, String engineId, OpensslEngineCommand[] commands)  
			throws EngineException 
	{
		this.reference = _init(enginePath, engineId, commands);
	}

	@Override
	public void delete() {
		_delete();
	}

}
