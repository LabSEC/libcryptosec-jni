package crl;

import jni.JniObject;

public class OpenSSLCertificateRevocationList extends JniObject {

	private native String _getPemEncoded();
	private native byte[] _getDerEncoded();
	
	public OpenSSLCertificateRevocationList(int reference) {
		super(reference);
	}
	
	public String getPemEncoded() {
		return _getPemEncoded();
	}
	
	public byte[] getDerEncoded() {
		return _getDerEncoded();
	}

}
