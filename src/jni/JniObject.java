package jni;

public abstract class JniObject {
		
	private native void _delete(int reference);
	
	protected int reference;
	
	public JniObject(){
		
	}
	
	public JniObject(int reference){
		this.reference = reference;
	}
	
	public void delete(){
		_delete(this.reference);
	}
	
	public int getReference(){
		return this.reference;
	}
	
	
}
