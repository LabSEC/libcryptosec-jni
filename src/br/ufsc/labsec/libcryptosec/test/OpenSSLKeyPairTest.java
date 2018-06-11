package br.ufsc.labsec.libcryptosec.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.exceptions.EngineException;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyFactory;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyPair;
import br.ufsc.labsec.libcryptosec.keys.OpensslPrivateKey;
import br.ufsc.labsec.libcryptosec.keys.OpensslPublicKey;

public class OpenSSLKeyPairTest extends LibcryptosecJavaTest{
	protected OpensslKeyPair keyPair;
	
	@Before
	public void setUpBefore() throws Exception {
		keyPair = OpensslKeyFactory.getInstance(enginePath, engineId, commands).getKeyPair(keyId);
	}

	@After
	public void tearDown() throws Exception {
		keyPair.delete();
	}

	@Test
	public void testDelete() throws EngineException {
		OpensslKeyPair keyPair = OpensslKeyFactory.getInstance(enginePath, engineId, commands).getKeyPair(keyId);
		keyPair.delete();
	}

	@Test
	public void testOpenSSLKeyPair() throws EngineException {
		OpensslKeyPair keyPair = OpensslKeyFactory.getInstance(enginePath, engineId, commands).getKeyPair(keyId);
		keyPair.delete();
	}

	@Test
	public void testGetPrivateKey() throws AsymmetricKeyException, EncodeException, EngineException {
		OpensslPrivateKey privKey = keyPair.getPrivateKey();
		privKey.delete();
	}

	@Test
	public void testGetPublicKey() throws EngineException, AsymmetricKeyException, EncodeException {
		OpensslPublicKey pubKey = keyPair.getPublicKey();
		pubKey.delete();
	}

}
