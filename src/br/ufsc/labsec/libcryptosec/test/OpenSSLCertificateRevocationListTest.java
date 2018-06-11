package br.ufsc.labsec.libcryptosec.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.crl.OpensslCertificateRevocationList;
import br.ufsc.labsec.libcryptosec.crl.OpensslCertificateRevocationListBuilder;
import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;

public class OpenSSLCertificateRevocationListTest extends LibcryptosecJavaTest {

	protected OpensslCertificateRevocationListBuilder builder;
	protected OpensslCertificateRevocationList certificateRevocationList;

	@Before
	public void setUp() throws Exception {
		builder = newBuilder();
		certificateRevocationList = newRevocationList();
	}

	@After
	public void tearDown() throws Exception {
		certificateRevocationList.delete();
		builder.delete();
	}

	@Test
	public void testDelete() {
		try {
			OpensslCertificateRevocationList certificateRevocationList = builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
			certificateRevocationList.delete();
		} catch (CertificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testOpenSSLCertificateRevocationList() {
		new OpensslCertificateRevocationList(certificateRevocationList.getReference());
	}

	@Test
	public void testGetPemEncoded() throws EncodeException {
		certificateRevocationList.getPemEncoded();
	}

	@Test
	public void testGetDerEncoded() throws EncodeException {
		certificateRevocationList.getDerEncoded();
	}

	private OpensslCertificateRevocationListBuilder newBuilder() {
		return new OpensslCertificateRevocationListBuilder();
	}
	
	private OpensslCertificateRevocationList newRevocationList() {
		try {
			return builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
		} catch (CertificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
