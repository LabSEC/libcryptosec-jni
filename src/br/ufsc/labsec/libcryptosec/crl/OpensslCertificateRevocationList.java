package br.ufsc.labsec.libcryptosec.crl;

import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslCertificateRevocationList extends JniObject {

	/*
	 * Destructor
	 */
	private native void _delete();
	private native String _getPemEncoded();
	private native byte[] _getDerEncoded();
	
	public OpensslCertificateRevocationList(long reference) {
		super(reference);
	}
	
	public String getPemEncoded() throws EncodeException {
		return _getPemEncoded();
	}
	
	public byte[] getDerEncoded() throws EncodeException {
		return _getDerEncoded();
	}
	
	@Override
	public void delete() {
		_delete();		
	}

}
