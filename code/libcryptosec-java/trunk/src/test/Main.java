package test;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import x509.OpenSSLRDNSequence;
import x509.RDNSequenceEntryType;

import crl.CertificateRevocationListBuilder;
import crl.OpenSSLCertificateRevocationList;
import crl.OpenSSLRevokedCertificate;
import crl.RevokedCertificateReasonCode;

import certificate.CertificateBuilder;
import certificate.OpenSSLCertificate;
import digester.MessageDigestAlgorithm;

import keys.OpenSSLKeyFactory;
import keys.OpenSSLKeyPair;
import keys.OpenSSLPrivateKey;
import engine.EngineCommand;

public class Main {

	//Load the library
		static {
			System.load("/home/lucasgm/workspaces/workspace-sgc/LibcryptosecJNI/Debug/libLibcryptosecJNI");			
		}
		
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String enginePath = "/home/lucasgm/engine_openhsmd.so";
		String engineId = "openhsmd";
		EngineCommand command = new EngineCommand("ADDRESS_CONN", "150.162.56.239");
		EngineCommand[] commands = {command};

		String keyId = "chave-2048";

		String certToSignPem = "-----BEGIN CERTIFICATE-----\n" +
				"MIICuzCCAiSgAwIBAgIJAP59oKL2CuHXMA0GCSqGSIb3DQEBBQUAME4xCzAJBgNV\n" +
				"BAYTAkJSMQswCQYDVQQIDAJTQzENMAsGA1UECgwEVUZTQzEPMA0GA1UECwwGTGFi\n" +
				"U0VDMRIwEAYDVQQDDAlBQyBMYWJTRUMwHhcNMTExMjEzMTcwMjEwWhcNMTIxMjEy\n" +
				"MTcwMjEwWjB0MQswCQYDVQQGEwJCUjELMAkGA1UECAwCU1AxETAPBgNVBAcMCFNv\n" +
				"cm9jYWJhMSAwHgYDVQQDDBdMdWNhcyBHb25jYWx2ZXMgTWFydGluczEjMCEGCSqG\n" +
				"SIb3DQEJARYUbHVjYXNnbS5idEBnbWFpbC5jb20wgZ8wDQYJKoZIhvcNAQEBBQAD\n" +
				"gY0AMIGJAoGBAKWuAmJbj1WYHHriS/jZiEPqPpXs5oRPYnWje92tHzThwdrZBzj+\n" +
				"17uAaZ6r39AMWG3Q1zx04CDV+RsHchsk9Y3gia6sRv2ikvhXtv+ozDwDIL828hRP\n" +
				"Uo9c9KPP2r3Oy8vhl/tmG82VN6XhmwzJPlVhFJDbNO+t0ru2OSq5kSx1AgMBAAGj\n" +
				"ezB5MAkGA1UdEwQCMAAwLAYJYIZIAYb4QgENBB8WHU9wZW5TU0wgR2VuZXJhdGVk\n" +
				"IENlcnRpZmljYXRlMB0GA1UdDgQWBBRST3j3Og7McNshTcSvGaIJMis+PTAfBgNV\n" +
				"HSMEGDAWgBSO4HTC2NwNpOYsWJ+ow4FHq9Ni0jANBgkqhkiG9w0BAQUFAAOBgQCJ\n" +
				"sISh0EXmiCjji2vGtwu8eSpxwSyI3rv73OdNnC5D6Xx4MKE+ZtcRn2SA+FHwDt1V\n" +
				"ZhUWTiyBtNW0Ytn9rIYxxogqVwrU8upf/fGdO+gL5hMohv0GkkwQsmckFQSI8kC+\n" +
				"1nxFzDCM8ML+QmDFCUTWphqeNASEAZdDztNOqeV2hg==\n" +
				"-----END CERTIFICATE-----";

		OpenSSLKeyFactory factory = OpenSSLKeyFactory.getInstance(enginePath, engineId, commands);
		OpenSSLKeyPair keyPair = factory.getKeyPair(keyId);
		OpenSSLPrivateKey privateKey = keyPair.getPrivateKey();
		
		CertificateBuilder builder = new CertificateBuilder(certToSignPem);
		
		OpenSSLRDNSequence rdnSequence = new OpenSSLRDNSequence();
		rdnSequence.addEntry(RDNSequenceEntryType.COMMON_NAME, "Laboratorio de Seguranca em Computacao");
		rdnSequence.addEntry(RDNSequenceEntryType.ORGANIZATION, "UFSC");
		builder.setIssuer(rdnSequence);		
		
		rdnSequence = new OpenSSLRDNSequence();
		rdnSequence.addEntry(RDNSequenceEntryType.COMMON_NAME, "Lucas Goncalves Martins");
		rdnSequence.addEntry(RDNSequenceEntryType.ORGANIZATION, "UFSC");
		rdnSequence.addEntry(RDNSequenceEntryType.ORGANIZATION_UNIT, "LabSEC");
		builder.setSubject(rdnSequence);
		
		
		OpenSSLCertificate certificate = builder.sign(privateKey, MessageDigestAlgorithm.SHA1);
		System.out.println("Java: " + certificate.getPemEncoded());
		
		/*
		 * Building revokedCertificate
		 */
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssZ");
		String dataString = format.format(date);
		
		OpenSSLRevokedCertificate revokedCertificate = new OpenSSLRevokedCertificate();
		BigInteger serialNumber = new BigInteger("1");
		revokedCertificate.setCertificateSerialNumber(serialNumber);
		revokedCertificate.setReasonCode(RevokedCertificateReasonCode.AACOMPROMISE);
		revokedCertificate.setRevocationDate(dataString);
		
		CertificateRevocationListBuilder crlBuilder = new CertificateRevocationListBuilder();
		crlBuilder.addRevokedCertificate(revokedCertificate);
		OpenSSLCertificateRevocationList crl = crlBuilder.sign(privateKey, MessageDigestAlgorithm.SHA1);
		System.out.println("Java: " + crl.getPemEncoded());
	}

}
