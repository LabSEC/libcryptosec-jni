package br.ufsc.labsec.libcryptosec.keys;

import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslPrivateKey extends JniObject {

	private native void _delete();
	
	public OpensslPrivateKey(int reference) {
		super(reference);
	}

	@Override
	public void delete() {
		_delete();
	}

}
