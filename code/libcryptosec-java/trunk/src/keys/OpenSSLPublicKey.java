package keys;

import jni.JniObject;

public class OpenSSLPublicKey extends JniObject {

	private native void _delete();
	
	public OpenSSLPublicKey(int reference) {
		super(reference);
	}

	@Override
	public void delete() {
		_delete();
	}
}
