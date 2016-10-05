package br.ufsc.labsec.libcryptosec.jni;

public abstract class JniObject {
		
	private native void _delete(long reference);
	
	protected long reference;
	
	public JniObject(){
		
	}
	
	public JniObject(long reference){
		this.reference = reference;
	}
	
	public abstract void delete();
	
	public long getReference(){
		return this.reference;
	}
	
}
