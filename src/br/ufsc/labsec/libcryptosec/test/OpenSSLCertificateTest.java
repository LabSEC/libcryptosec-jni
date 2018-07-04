package br.ufsc.labsec.libcryptosec.test;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificate;
import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificateBuilder;
import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;

public class OpenSSLCertificateTest extends LibcryptosecJavaTest{
	
	protected OpensslCertificateBuilder builder;
	
	@Before
	public void setUp() throws Exception {
		try {
			builder = new OpensslCertificateBuilder(getPemEncodedCertificate());
			builder.setIssuer(issuerRdnSequence);
			builder.setNotAfter(nowPlus3years());
			builder.setNotBefore(now());
			builder.setPublicKey(getPublicKey());
			builder.setSerialNumber(new BigInteger("1"));
			builder.setSubject(subjectRdnSequence);
			builder.setVersion(0);
		} catch (EncodeException e) {
			e.printStackTrace();
		} catch (BigIntegerException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		builder.delete();
	}
	
	@Test
	public void testDelete() throws CertificationException, AsymmetricKeyException {
		OpensslCertificate certificate = builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
		certificate.delete();
	}
	
	@Test
	public void testOpensslCertificate() throws CertificationException, AsymmetricKeyException {
		OpensslCertificate certificate = builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
		certificate.delete();
	}

	@Test
	public void testGetPemEncoded() throws EncodeException, CertificationException, AsymmetricKeyException {
		OpensslCertificate certificate = builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
		certificate.getPemEncoded();
		certificate.delete();
	}

	@Test
	public void testGetDerEncoded() throws EncodeException, CertificationException, AsymmetricKeyException {
		OpensslCertificate certificate = builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
		certificate.getDerEncoded();
		certificate.delete();
	}
}
