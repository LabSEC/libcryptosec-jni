package br.ufsc.labsec.libcryptosec.test;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificateBuilder;
import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificate;
import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;


public class CertificateBuilderTest extends LibcryptosecJavaTest {

	protected OpensslCertificateBuilder builder;
	protected OpensslCertificateBuilder filledBuilder;
	
	@Before
	public void setUp() throws Exception {
		builder = newBuilder();
		filledBuilder = newFilledBuilder();
	}

	@After
	public void tearDown() throws Exception {
		builder.delete();
		filledBuilder.delete();
	}
	
	@Test
	public void testDelete() {
		OpensslCertificateBuilder builder = new OpensslCertificateBuilder();
		builder.delete();
	}

	@Test
	public void testCertificateBuilder() {
		OpensslCertificateBuilder builder = new OpensslCertificateBuilder();
		builder.delete();
	}

	@Test
	public void testCertificateBuilderString() {
		OpensslCertificateBuilder builder;
		try {
			builder = new OpensslCertificateBuilder(getPemEncodedCertificate());
			builder.delete();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCertificateBuilderByteArray() {
//		TODO		
//		@SuppressWarnings("unused")
//		CertificateBuilder builder = new CertificateBuilder(getDerEncodedCertificate());
	}

	@Test
	public void testSetSerialNumberString() {
		try {
			builder.setSerialNumber("1");
		} catch (BigIntegerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetSerialNumberBigInteger() {
		try {
			builder.setSerialNumber(new BigInteger("1"));
		} catch (BigIntegerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetSerialNumberLong() {
		builder.setSerialNumber(1);
	}

	@Test
	public void testSetVersion() {
		builder.setVersion(0);
	}

	@Test
	public void testSetPublicKey() {
		builder.setPublicKey(getPublicKey());
	}

	@Test
	public void testSetNotBefore() {
		builder.setNotAfter(now());
	}

	@Test
	public void testSetNotAfter() {
		builder.setNotAfter(nowPlus3years());
	}

	@Test
	public void testSetIssuer() {
		builder.setSubject(issuerRdnSequence);
	}

	@Test
	public void testSetSubject() {
		builder.setSubject(subjectRdnSequence);
	}

	@Test
	public void testSign() {
		OpensslCertificate signedCert;
		System.out.println("XXXX");
		try {
//			signedCert = newFilledBuilder().sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
//			signedCert.delete();
			signedCert = newFilledBuilder().sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA1);
			signedCert.delete();
//			signedCert = newFilledBuilder().sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA224);
//			signedCert.delete();
//			signedCert = newFilledBuilder().sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA256);
//			signedCert.delete();
//			signedCert = newFilledBuilder().sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA384);
//			signedCert.delete();
//			signedCert = newFilledBuilder().sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA512);
		} catch (CertificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AsymmetricKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test(expected=CertificationException.class)
	public void testSignCertificationException() throws CertificationException {
		try{
			OpensslCertificate signedCert = builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
			signedCert.delete();
			signedCert = builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA1);
			signedCert.delete();
		}
		catch (AsymmetricKeyException e) {
			e.printStackTrace();
		}
	}
	
	public void testSignAsymmetricKeyException() {
		
	}
	
	public OpensslCertificateBuilder newBuilder() {
		try {
			return new OpensslCertificateBuilder(getPemEncodedCertificate());
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public OpensslCertificateBuilder newFilledBuilder() {
		OpensslCertificateBuilder builder;
		try {
			builder = new OpensslCertificateBuilder(getPemEncodedCertificate());
			builder.setIssuer(issuerRdnSequence);
			builder.setNotAfter(nowPlus3years());
			builder.setNotBefore(now());
			builder.setPublicKey(getPublicKey());
			builder.setSerialNumber(new BigInteger("1"));
			builder.setSubject(subjectRdnSequence);
			builder.setVersion(0);
			return builder;
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BigIntegerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
