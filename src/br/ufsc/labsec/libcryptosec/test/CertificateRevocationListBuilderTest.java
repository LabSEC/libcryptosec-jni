package br.ufsc.labsec.libcryptosec.test;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.crl.OpensslCertificateRevocationListBuilder;
import br.ufsc.labsec.libcryptosec.crl.OpensslRevokedCertificate;
import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.crl.OpensslCertificateRevocationList;
import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;

public class CertificateRevocationListBuilderTest extends LibcryptosecJavaTest {

	protected OpensslCertificateRevocationListBuilder builder;

	@Before
	public void setUp() throws Exception {
		builder = newBuilder();
	}

	@After
	public void tearDown() throws Exception {
		builder.delete();
	}

	@Test
	public void testDelete() {
		OpensslCertificateRevocationListBuilder builder = new OpensslCertificateRevocationListBuilder();
		builder.delete();
	}

	@Test
	public void testCertificateRevocationListBuilder() {
		OpensslCertificateRevocationListBuilder builder = new OpensslCertificateRevocationListBuilder();
		builder.delete();
	}

	@Test
	public void testCertificateRevocationListBuilderString() throws EncodeException {
		OpensslCertificateRevocationListBuilder builder = new OpensslCertificateRevocationListBuilder(this.getCRL().getPemEncoded());
		builder.delete();
	}
	
	@Test
	public void testCertificateRevocationListBuilderByteArray() throws EncodeException {
		OpensslCertificateRevocationListBuilder builder = new OpensslCertificateRevocationListBuilder(this.getCRL().getDerEncoded());
		builder.delete();
	}

	@Test
	public void testSetSerialNumberLong() throws CertificationException {
		long longSerialNumber = 10000000L;
		builder.setSerialNumber(longSerialNumber);
	}

	@Test
	public void testSetSerialNumberBigInteger() throws CertificationException, BigIntegerException {
		BigInteger bigIntegerSerialNumber = new BigInteger("10000000");
		builder.setSerialNumber(bigIntegerSerialNumber);
	}

	@Test
	public void testSetVersion() {
		long longVersion = 10000000L;
		builder.setVersion(longVersion);
	}

	@Test
	public void testSetIssuer() {
		try {
			builder.setIssuer(issuerRdnSequence);
		} catch (CertificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetLastUpdate() {
		builder.setLastUpdate(now());
	}

	@Test
	public void testSetNextUpdate() {
		builder.setNextUpdate(now());
	}

	@Test
	public void testAddRevokedCertificate() throws CertificationException {
		OpensslRevokedCertificate revokedCertificate = new OpensslRevokedCertificate();
		builder.addRevokedCertificate(revokedCertificate);
	}

	@Test
	public void testAddRevokedCertificates() throws CertificationException {
		OpensslRevokedCertificate[] revokedCertificates = new OpensslRevokedCertificate[1];
		revokedCertificates[0] = new OpensslRevokedCertificate();
		builder.addRevokedCertificates(revokedCertificates);
	}

	@Test
	public void testSign() throws CertificationException {
		builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
	}

	private OpensslCertificateRevocationListBuilder newBuilder() {
		return new OpensslCertificateRevocationListBuilder();
	}
	
	private OpensslCertificateRevocationList getCRL() {
		try {
			return builder.sign(getPrivateKey(), OpensslMessageDigestAlgorithm.SHA);
		} catch (CertificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
