package br.ufsc.labsec.libcryptosec.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.exceptions.SignerException;
import br.ufsc.labsec.libcryptosec.signer.OpensslSigner;

public class OpensslSignerTest extends LibcryptosecJavaTest {

	@Test
	public void testSign() {
		String data1 = "Teste1";
		String data2 = "Teste2";
		try {
			byte[] signature1 = OpensslSigner.sign(getPrivateKey(), data1.getBytes(), OpensslMessageDigestAlgorithm.SHA1);
			byte[] signature2 = OpensslSigner.sign(getPrivateKey(), data1.getBytes(), OpensslMessageDigestAlgorithm.SHA1);
			assertArrayEquals(signature1, signature2);
			
			signature2 = OpensslSigner.sign(getPrivateKey(), data1.getBytes(), OpensslMessageDigestAlgorithm.SHA256);
			assertFalse(signature1.equals(signature2));
			
			signature2 = OpensslSigner.sign(getPrivateKey(), data2.getBytes(), OpensslMessageDigestAlgorithm.SHA1);
			assertFalse(signature1.equals(signature2));
			
		} catch (SignerException e) {
			fail();
			e.printStackTrace();
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public void testVerify() {
		String data = "Teste";
		try {
			byte[] signature = OpensslSigner.sign(getPrivateKey(), data.getBytes(), OpensslMessageDigestAlgorithm.SHA1);
			boolean verify = OpensslSigner.verify(getPublicKey(), signature, data.getBytes(), OpensslMessageDigestAlgorithm.SHA1);
			assertTrue(verify);
		} catch (SignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getHexString(byte[] b) throws Exception {
		String result = "";
		for (int i=0; i < b.length; i++) {
			result +=
					Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		}
		return result;
	}

}
