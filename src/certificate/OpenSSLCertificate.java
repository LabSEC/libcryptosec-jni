package certificate;

import jni.JniObject;

public class OpenSSLCertificate extends JniObject {

	/*
	 * Destructor
	 */
	private native void _delete();
	
	private native String _getPemEncoded();
	private native byte[] _getDerEncoded();
	
	public OpenSSLCertificate(int reference) {
		super(reference);
	}
	
	public void delete(){
		_delete();
	}
	
	public String getPemEncoded(){
		return _getPemEncoded();
	}
	
	public byte[] getDerEncoded(){
		return _getDerEncoded();
	}
}
