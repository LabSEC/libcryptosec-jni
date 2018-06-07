package br.ufsc.labsec.libcryptosec.keys;

import br.ufsc.labsec.libcryptosec.engine.OpensslDynamicEngine;
import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.exceptions.EngineException;
import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslKeyPair extends JniObject {
	
	private native long _init(long engineReference, String keyId);
	private native void _delete();
	private native long _getPublicKey();
	private native long _getPrivateKey();
	
	public OpensslKeyPair(OpensslDynamicEngine engine, String keyId) throws EngineException
	{
		this.reference = _init(engine.getReference(), keyId);
	}
	
	public OpensslPrivateKey getPrivateKey() throws AsymmetricKeyException, EncodeException
	{
		return new OpensslPrivateKey(_getPrivateKey());
	}
	
	public OpensslPublicKey getPublicKey() throws AsymmetricKeyException, EncodeException
	{
		return new OpensslPublicKey(_getPublicKey());
	}
	@Override
	public void delete() {
		_delete();
	}
}
