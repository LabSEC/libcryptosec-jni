package jni;

public class JniObject {
		
	private native void _destroy(int reference);
	
	protected int reference;
	
	public JniObject(){
		
	}
	
	public JniObject(int reference){
		this.reference = reference;
	}
	
	public void destroy(){
		_destroy(this.reference);
	}
	
	public int getReference(){
		return this.reference;
	}
	
}
