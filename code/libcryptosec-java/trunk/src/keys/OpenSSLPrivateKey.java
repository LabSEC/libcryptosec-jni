package keys;

import jni.JniObject;

public class OpenSSLPrivateKey extends JniObject {

	private native void _delete();
	
	public OpenSSLPrivateKey(int reference) {
		super(reference);
	}

	@Override
	public void delete() {
		_delete();
	}

}
