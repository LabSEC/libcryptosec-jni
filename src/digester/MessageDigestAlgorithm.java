package digester;

public enum MessageDigestAlgorithm {
	SHA("SHA"),
	SHA1("SHA1");
	
	private String _algorithmName;

	MessageDigestAlgorithm(String algorithmName){
		this._algorithmName = algorithmName;
	}

	public String getName() {
	    return _algorithmName;
	}
}
