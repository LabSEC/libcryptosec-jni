package br.ufsc.labsec.libcryptosec.test;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificateBuilder;
import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificateRequest;
import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;

public class OpenSSLCertificateRequest extends LibcryptosecJavaTest{
	
	protected static OpensslCertificateBuilder builder;
	
	@BeforeClass
	public static void setUp() throws Exception {
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

	@AfterClass
	public static void tearDown() throws Exception {
		builder.delete();
	}
	
	@Test
	public void testDelete() throws CertificationException, AsymmetricKeyException {
		OpensslCertificateRequest certRequest = new OpensslCertificateRequest();
		certRequest.delete();
	}
	
	@Test
	public void testOpensslCertificate() throws CertificationException, AsymmetricKeyException {
		OpensslCertificateRequest certRequest = new OpensslCertificateRequest();
		certRequest.delete();
	}
	
}
