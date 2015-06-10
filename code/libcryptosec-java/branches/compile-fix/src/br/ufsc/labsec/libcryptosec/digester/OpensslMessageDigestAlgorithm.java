package br.ufsc.labsec.libcryptosec.digester;

public enum OpensslMessageDigestAlgorithm {
	MD4("MD4"),
	MD5("MD5"),
	RIPEMD160("RIPEMD160"),
	SHA("SHA"),
	SHA1("SHA1"),
	SHA224("SHA224"),
	SHA256("SHA256"),
	SHA384("SHA384"),
	SHA512("SHA512");
	
	private String _algorithmName;

	OpensslMessageDigestAlgorithm(String algorithmName){
		this._algorithmName = algorithmName;
	}

	public String getName() {
	    return _algorithmName;
	}
}
