package br.ufsc.labsec.libcryptosec.certificate;

import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslCertificateRequest extends JniObject {

	private native void _delete();
	private native int _init();
	private native int _init(String pem);
	private native int _init(byte[] der);
	
	
	public OpensslCertificateRequest(){
		this.reference = _init();
	}
	
	public OpensslCertificateRequest(String pemEncoded){
		this.reference = _init(pemEncoded);
	}
	
	public OpensslCertificateRequest(byte[] derEncoded){
		this.reference = _init(derEncoded);
	}
	
	@Override
	public void delete() {
		_delete();
	}

}
