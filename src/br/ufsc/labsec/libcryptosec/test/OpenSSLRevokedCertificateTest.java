package br.ufsc.labsec.libcryptosec.test;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.crl.OpensslRevokedCertificate;
import br.ufsc.labsec.libcryptosec.crl.OpensslRevokedCertificateReasonCode;
import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;


public class OpenSSLRevokedCertificateTest extends LibcryptosecJavaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LibcryptosecJavaTest.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LibcryptosecJavaTest.tearDownAfterClass();
	}

	@Test
	public void testDelete() {
		OpensslRevokedCertificate revoked = new OpensslRevokedCertificate();
		revoked.delete();
	}

	@Test
	public void testOpenSSLRevokedCertificate() {		
		OpensslRevokedCertificate revoked = new OpensslRevokedCertificate();
		revoked.delete();
	}

	@Test
	public void testSetCertificateSerialNumberLong() throws BigIntegerException {
		OpensslRevokedCertificate revoked = new OpensslRevokedCertificate();
		revoked.setCertificateSerialNumber(1);
		revoked.delete();
	}

	@Test
	public void testSetCertificateSerialNumberBigInteger() {
		OpensslRevokedCertificate revoked = new OpensslRevokedCertificate();
		revoked.setCertificateSerialNumber(new BigInteger("1"));
		revoked.delete();
	}

	@Test
	public void testSetRevocationDate() {
		OpensslRevokedCertificate revoked = new OpensslRevokedCertificate();
		revoked.setRevocationDate(now());
		revoked.delete();
	}

	@Test
	public void testSetReasonCode() {
		OpensslRevokedCertificate revoked = new OpensslRevokedCertificate();
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.AACOMPROMISE);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.AFFILIATION_CHANGED);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.CA_COMPROMISE);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.CERTIFICATE_HOLD);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.CESSATION_OF_OPERATION);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.KEY_COMPROMISE);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.PRIVILEGE_WITH_DRAWN);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.SUPER_SEDED);
		revoked.setReasonCode(OpensslRevokedCertificateReasonCode.UNSPECIFIED);
		revoked.delete();
	}

}
