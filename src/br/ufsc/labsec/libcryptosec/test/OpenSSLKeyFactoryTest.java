package br.ufsc.labsec.libcryptosec.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.exceptions.EngineException;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyFactory;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyPair;

public class OpenSSLKeyFactoryTest extends LibcryptosecJavaTest{
	
	static OpensslKeyFactory keyFact;
	
	@Before
	public void setUpBefore() {
	}

	@After
	public void tearDownAfter() {
	}

	@Test
	public void testGetInstance() throws EngineException {
		keyFact = OpensslKeyFactory.getInstance(enginePath, engineId, commands);
	}

	@Test
	public void testGetKeyPair() throws EngineException {
		OpensslKeyPair keyPair = OpensslKeyFactory.getInstance(enginePath, engineId, commands).getKeyPair(keyId);
		keyPair.delete();
	}

}
