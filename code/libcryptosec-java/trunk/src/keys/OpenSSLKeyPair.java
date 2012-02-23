package keys;

import engine.DynamicEngine;
import jni.JniObject;

public class OpenSSLKeyPair extends JniObject {
	
	private native int _loadKeyPair(int engineReference, String keyId);
	private native int _getPublicKey();
	private native int _getPrivateKey();
	
	public OpenSSLKeyPair(DynamicEngine engine, String keyId)
	{
		this.reference = _loadKeyPair(engine.getReference(), keyId);
	}
	
	public OpenSSLPrivateKey getPrivateKey()
	{
		return new OpenSSLPrivateKey(_getPrivateKey());
	}
	
	public OpenSSLPublicKey getPublicKey()
	{
		return new OpenSSLPublicKey(_getPublicKey());
	}
}
