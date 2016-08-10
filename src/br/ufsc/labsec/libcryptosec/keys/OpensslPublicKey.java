package br.ufsc.labsec.libcryptosec.keys;

import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslPublicKey extends JniObject {

	private native void _delete();
	
	public OpensslPublicKey(long reference) {
		super(reference);
	}

	@Override
	public void delete() {
		_delete();
	}
}
