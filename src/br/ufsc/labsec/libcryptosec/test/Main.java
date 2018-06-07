package br.ufsc.labsec.libcryptosec.test;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificateBuilder;
import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificate;
import br.ufsc.labsec.libcryptosec.crl.OpensslCertificateRevocationListBuilder;
import br.ufsc.labsec.libcryptosec.crl.OpensslCertificateRevocationList;
import br.ufsc.labsec.libcryptosec.crl.OpensslRevokedCertificate;
import br.ufsc.labsec.libcryptosec.crl.OpensslRevokedCertificateReasonCode;
import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.engine.OpensslEngineCommand;
import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.exceptions.EngineException;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyFactory;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyPair;
import br.ufsc.labsec.libcryptosec.keys.OpensslPrivateKey;
import br.ufsc.labsec.libcryptosec.x509.OpensslRdnSequence;
import br.ufsc.labsec.libcryptosec.x509.OpensslRdnSequenceEntryType;





public class Main {

	//Load the library
	static {
		System.load("/home/fabio/Desktop/Hawa/libcryptosec-jni/libcryptosec-jni-1.1.0/libcryptosec_jni.so");			
	}
		
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String enginePath = "/etc/hawa/engines/openhsmd-ca.so";
		String engineId = "openhsmd";
		OpensslEngineCommand command = new OpensslEngineCommand("ADDRESS_CONN", "192.168.66.48");
		OpensslEngineCommand[] commands = {command};

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


		try {
			OpensslKeyFactory factory = OpensslKeyFactory.getInstance(enginePath, engineId, commands);
			OpensslKeyPair keyPair = factory.getKeyPair(keyId);
			OpensslPrivateKey privateKey = keyPair.getPrivateKey();
			
			OpensslCertificateBuilder builder = new OpensslCertificateBuilder(certToSignPem);
			
			OpensslRdnSequence rdnSequence = new OpensslRdnSequence();
			rdnSequence.addEntry(OpensslRdnSequenceEntryType.COMMON_NAME, "Laboratorio de Seguranca em Computacao");
			rdnSequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION, "UFSC");
			builder.setIssuer(rdnSequence);		
			
			rdnSequence = new OpensslRdnSequence();
			rdnSequence.addEntry(OpensslRdnSequenceEntryType.COMMON_NAME, "Lucas Goncalves Martins");
			rdnSequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION, "UFSC");
			rdnSequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION_UNIT, "LabSEC");
			builder.setSubject(rdnSequence);
			
			OpensslCertificate certificate;
			
			certificate = builder.sign(privateKey, OpensslMessageDigestAlgorithm.SHA1);
			System.out.println("Java: " + certificate.getPemEncoded());
			
			/*
			 * Building revokedCertificate
			 */
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssZ");
			String dataString = format.format(date);
			
			OpensslRevokedCertificate revokedCertificate = new OpensslRevokedCertificate();
			BigInteger serialNumber = new BigInteger("1");
			revokedCertificate.setCertificateSerialNumber(serialNumber);
			revokedCertificate.setReasonCode(OpensslRevokedCertificateReasonCode.AACOMPROMISE);
			revokedCertificate.setRevocationDate(dataString);
			
			OpensslCertificateRevocationListBuilder crlBuilder = new OpensslCertificateRevocationListBuilder();
			crlBuilder.addRevokedCertificate(revokedCertificate);
			OpensslCertificateRevocationList crl = crlBuilder.sign(privateKey, OpensslMessageDigestAlgorithm.SHA1);
			System.out.println("Java: " + crl.getPemEncoded());
			
		} catch (EngineException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CertificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AsymmetricKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
