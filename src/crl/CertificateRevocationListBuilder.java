package crl;

import java.math.BigInteger;

import x509.OpenSSLRDNSequence;
import x509.RDNSequenceEntryType;

import digester.MessageDigestAlgorithm;

import jni.JniObject;
import keys.OpenSSLPrivateKey;

public class CertificateRevocationListBuilder extends JniObject {

	/*
	 * Build a Libcryptosec's CertificateRevocationListBuilder object and returns its reference
	 */
	private native int _init();
	private native int _init(String pemEncoded);
	private native int _init(byte[] derEncoded);
	
	/*
	 * Destructor
	 */
	private native void _delete();
	
	private native void _setSerialNumber(long serial);
	private native void _setSerialNumber(String serial);
	private native void _setVersion(long version);
	
	/*
	 * @param issuerReference A reference to a Libcryptosec's RDNSequence object
 	 */
	private native void _setIssuer(int issuerReference);
	
	/*
	 * DateTime
	 */
	private native void _setLastUpdate(String dateTime);
	private native void _setNextUpdate(String dateTime);
	
	/*
	 * @param revokedCertificateReference A reference to a Libcryptosec's RevokedCertificate object
	 */
	private native void _addRevokedCertificate(int revokedCertificateReference);
	
	/*
	 * @param revokedCertificateReferences An array of references to Libcryptosec's RevokedCertificate objects
	 */
	private native void _addRevokedCertificates(int[] revokedCertificateReferences);
	
	/*
	 * @param privateKeyReference A reference to a Libcryptosec's PrivateKey object 
	 */
	private native int _sign(int privateKeyReference, String messageDigestAlgorithm);
	
	
	/*
	 * Java Constructors
	 */
	public CertificateRevocationListBuilder()
	{
		this.reference = _init();
	}
	
	public CertificateRevocationListBuilder(String pemEncoded){//	throws Exception(ExncodeException){}
		this.reference = _init(pemEncoded);
	}
	
	public CertificateRevocationListBuilder(byte[] derEncoded){//	throw (EncodeException){}
		this.reference = _init(derEncoded);
	}	
	
	/*
	 * Destructro
	 */
	public void delete() {
		_delete();
	}
	
	/*
	 * Serial Number
	 */
	public void setSerialNumber(long serial) {// throw (CertificationException){}
		_setSerialNumber(serial);
	}
	public void setSerialNumber(BigInteger serial){// throw (CertificationException, BigIntegerException)
		_setSerialNumber(serial.toString());
	}
	
	/*
	 * Version
	 */
	public void setVersion(long version){
		_setVersion(version);
	}
	
	/*
	 * Issuer
	 */
	public void setIssuer(OpenSSLRDNSequence issuer) {// throw (CertificationException){}
		_setIssuer(issuer.getReference());
	}
	
	/*
	 * LastUpdate
	 */
	public void setLastUpdate(String dateTime){
		_setLastUpdate(dateTime);
	}	
	
	/*
	 * NextUpdate
	 */
	public void setNextUpdate(String dateTime){
		_setNextUpdate(dateTime);
	}
	
	/*
	 * Add Revoked Certificates
	 */
	public void addRevokedCertificate(OpenSSLRevokedCertificate revokedCertificate) {//throw (CertificationException){}
		_addRevokedCertificate(revokedCertificate.getReference());
	}
	public void addRevokedCertificates(OpenSSLRevokedCertificate[] revokedCertificates) {// throw (CertificationException){}
		int size = revokedCertificates.length;
		int[] revokedCertificatesReferences = new int[size];
		for(int i = 0; i < revokedCertificates.length; i++)
		{
			revokedCertificatesReferences[i] = revokedCertificates[i].getReference();
		}
		_addRevokedCertificates(revokedCertificatesReferences);
	}
	
	/*
	 * Sign
	 */
	public OpenSSLCertificateRevocationList sign(OpenSSLPrivateKey privateKey, MessageDigestAlgorithm messageDigestAlgorithm){
		return new OpenSSLCertificateRevocationList(_sign(privateKey.getReference(), messageDigestAlgorithm.toString()));
	}
	
//	void addExtension(Extension& extension) throw (CertificationException){}
//	void addExtensions(std::vector<Extension *> &extensions) throw (CertificationException){}
//	void replaceExtension(Extension &extension) throw (CertificationException){}
	
//	std::string getXmlEncoded(){}
//	std::string getXmlEncoded(std::string tab){}
//	long getSerialNumber() throw (CertificationException){}
//	BigInteger getSerialNumberBigInt() throw (CertificationException, BigIntegerException){}
//	long getVersion() throw (CertificationException){}
//	RDNSequence getIssuer(){}
//	DateTime getLastUpdate(){}
//	DateTime getNextUpdate(){}
//	std::vector<RevokedCertificate> getRevokedCertificate(){}
//	X509_CRL* getX509Crl() const{}
//	CertificateRevocationListBuilder& operator =(const CertificateRevocationListBuilder& value){}
//	std::vector<Extension*> getExtension(Extension::Name extensionName){}
//	std::vector<Extension*> getExtensions(){}
//	std::vector<Extension *> getUnknownExtensions(){}
}
