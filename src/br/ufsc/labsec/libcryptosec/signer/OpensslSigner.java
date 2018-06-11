package br.ufsc.labsec.libcryptosec.signer;

import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.exceptions.SignerException;
import br.ufsc.labsec.libcryptosec.keys.OpensslPrivateKey;
import br.ufsc.labsec.libcryptosec.keys.OpensslPublicKey;

public class OpensslSigner {
	
	private static native byte[] _sign(long key, byte[] hash, String algorithm);
	private static native boolean _verify(long key, byte[] signature, byte[] hash, String algorithm);
	
	public static byte[] sign(OpensslPrivateKey key, byte[] hash, OpensslMessageDigestAlgorithm algorithm) 
			throws SignerException
	{
		return _sign(key.getReference(), hash, algorithm.getName());
	}
	
	public static boolean verify(OpensslPublicKey key, byte[] signature, byte[] hash, OpensslMessageDigestAlgorithm algorithm) 
			throws SignerException
	{
		return _verify(key.getReference(), signature, hash, algorithm.getName());
	}
}
