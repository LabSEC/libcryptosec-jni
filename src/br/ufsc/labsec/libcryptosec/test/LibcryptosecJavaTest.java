package br.ufsc.labsec.libcryptosec.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.ufsc.labsec.libcryptosec.engine.OpensslEngineCommand;
import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyFactory;
import br.ufsc.labsec.libcryptosec.keys.OpensslKeyPair;
import br.ufsc.labsec.libcryptosec.keys.OpensslPrivateKey;
import br.ufsc.labsec.libcryptosec.keys.OpensslPublicKey;
import br.ufsc.labsec.libcryptosec.x509.OpensslRdnSequence;
import br.ufsc.labsec.libcryptosec.x509.OpensslRdnSequenceEntryType;

public class LibcryptosecJavaTest {
	
	static {
		System.load("/home/fabio/Desktop/Hawa/libcryptosec-jni/libcryptosec-jni-1.1.0/libcryptosec_jni.so");			
	}
	
	public static OpensslRdnSequence subjectRdnSequence;
	public static OpensslRdnSequence issuerRdnSequence;
	public static OpensslKeyPair keyPair;
	public static String enginePath = "/etc/hawa/engines/openhsmd-ca.so";
	public static String engineId = "openhsmd";
	public static OpensslEngineCommand[] commands = {new OpensslEngineCommand("ADDRESS_CONN", "192.168.66.48")};
	public static String keyId = "chave-2048";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		keyPair = OpensslKeyFactory.getInstance(enginePath, engineId, commands).getKeyPair(keyId);
		
		subjectRdnSequence = new OpensslRdnSequence();
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.COMMON_NAME, "Lucas Martins");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION, "UFSC");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION_UNIT, "LabSEC");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.COUNTRY, "BR");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.STATE_OR_PROVINCE, "Santa Catarina");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.LOCALITY, "Florianopolis");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.EMAIL, "lucasgm@inf.ufsc.br");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.INITIALS, "LGM");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.SERIAL_NUMBER, "201006669");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.TITLE, "Scientist");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.GIVEN_NAME, "Murdoc");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.PSEUDONYM, "lucasgm");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.DN_QUALIFIER, "DN_QUALIFIER_VALUE");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.DOMAIN_COMPONENT, "DOMAIN_COMPONENT_VALUE");		
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.GENERATION_QUALIFIER, "GENERATION_QUALIFIER_VALUE");
		subjectRdnSequence.addEntry(OpensslRdnSequenceEntryType.SURNAME, "SURNAME_VALUE");
		
		issuerRdnSequence = new OpensslRdnSequence();
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.COMMON_NAME, "Lucas Martins");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION, "UFSC");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION_UNIT, "LabSEC");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.COUNTRY, "BR");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.STATE_OR_PROVINCE, "Santa Catarina");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.LOCALITY, "Florianopolis");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.EMAIL, "lucasgm@inf.ufsc.br");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.INITIALS, "LGM");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.SERIAL_NUMBER, "201006669");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.TITLE, "Scientist");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.GIVEN_NAME, "Murdoc");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.PSEUDONYM, "lucasgm");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.DN_QUALIFIER, "DN_QUALIFIER_VALUE");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.DOMAIN_COMPONENT, "DOMAIN_COMPONENT_VALUE");		
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.GENERATION_QUALIFIER, "GENERATION_QUALIFIER_VALUE");
		issuerRdnSequence.addEntry(OpensslRdnSequenceEntryType.SURNAME, "SURNAME_VALUE");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		issuerRdnSequence.delete();
		subjectRdnSequence.delete();
		
		keyPair.delete();
	}
	
	public static String now(){
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		return format.format(now);
	}
	
	public static String nowPlus3years(){
		Calendar cal =  Calendar.getInstance();
		cal.add(Calendar.YEAR, 3);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		return format.format(cal.getTime());
	}
	
	public static OpensslPublicKey getPublicKey()
	{
		try {
			return keyPair.getPublicKey();
		} catch (AsymmetricKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static OpensslPrivateKey getPrivateKey()
	{
		try {
			return keyPair.getPrivateKey();
		} catch (AsymmetricKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getPemEncodedCertificate()
	{
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
		
		return certToSignPem;
	}
	
	public static byte[] getDerEncodedCertificate()
	{		
		return null;
	}
	
}
