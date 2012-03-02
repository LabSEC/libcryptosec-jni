package br.ufsc.labsec.libcryptosec.certificate;

import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslCertificate extends JniObject {

	/*
	 * Destructor
	 */
	private native void _delete();
	
	private native String _getPemEncoded();
	private native byte[] _getDerEncoded();
	
	public OpensslCertificate(int reference) {
		super(reference);
	}
	
	public void delete(){
		_delete();
	}
	
	public String getPemEncoded() throws EncodeException {
		return _getPemEncoded();
	}
	
	public byte[] getDerEncoded() throws EncodeException {
		return _getDerEncoded();
	}
}
