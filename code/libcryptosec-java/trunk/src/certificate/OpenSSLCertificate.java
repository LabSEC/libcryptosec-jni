package certificate;

import jni.JniObject;

public class OpenSSLCertificate extends JniObject {

	private native String _getPemEncoded();
	private native byte[] _getDerEncoded();
	
	public OpenSSLCertificate(int reference) {
		super(reference);
	}
	
	public String getPemEncoded(){
		return _getPemEncoded();
	}
	
	public byte[] getDerEncoded(){
		return _getDerEncoded();
	}
}
