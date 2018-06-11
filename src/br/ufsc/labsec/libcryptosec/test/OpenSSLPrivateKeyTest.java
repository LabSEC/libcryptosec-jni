package br.ufsc.labsec.libcryptosec.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.keys.OpensslPrivateKey;

public class OpenSSLPrivateKeyTest extends LibcryptosecJavaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LibcryptosecJavaTest.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LibcryptosecJavaTest.tearDownAfterClass();
	}

	@Test
	public void testDelete() throws AsymmetricKeyException, EncodeException {
		OpensslPrivateKey sk = keyPair.getPrivateKey();
		sk.delete();
	}

}
