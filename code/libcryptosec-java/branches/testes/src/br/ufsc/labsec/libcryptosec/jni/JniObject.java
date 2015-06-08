package br.ufsc.labsec.libcryptosec.jni;

public abstract class JniObject {
		
	private native void _delete(int reference);
	
	protected int reference;
	
	public JniObject(){
		
	}
	
	public JniObject(int reference){
		this.reference = reference;
	}
	
	public abstract void delete();
	
	public int getReference(){
		return this.reference;
	}
	
}
