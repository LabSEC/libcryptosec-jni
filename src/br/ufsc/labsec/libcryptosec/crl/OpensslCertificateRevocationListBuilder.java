package br.ufsc.labsec.libcryptosec.crl;

import java.math.BigInteger;

import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificate;
import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.jni.JniObject;
import br.ufsc.labsec.libcryptosec.keys.OpensslPrivateKey;

public class OpensslCertificateRevocationListBuilder extends JniObject {

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
	
	private native void _addExtension(String oid, boolean isCritical, byte[] value);

	/*
	 * @param privateKeyReference A reference to a Libcryptosec's PrivateKey object 
	 */
	private native int _sign(int privateKeyReference, String messageDigestAlgorithm);
	
	
	/*
	 * Java Constructors
	 */
	public OpensslCertificateRevocationListBuilder()
	{
		this.reference = _init();
	}
	
	public OpensslCertificateRevocationListBuilder(String pemEncoded) throws EncodeException {
		this.reference = _init(pemEncoded);
	}
	
	public OpensslCertificateRevocationListBuilder(byte[] derEncoded) throws EncodeException {
		this.reference = _init(derEncoded);
	}	
	
	/*
	 * Serial Number
	 */
	public void setSerialNumber(long serial) throws CertificationException {
		_setSerialNumber(serial);
	}
	public void setSerialNumber(BigInteger serial) throws CertificationException, BigIntegerException {
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
	public void setIssuer(OpensslCertificate issuer) throws CertificationException {
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
	public void addRevokedCertificate(OpensslRevokedCertificate revokedCertificate) throws CertificationException {
		_addRevokedCertificate(revokedCertificate.getReference());
	}
	
	public void addRevokedCertificates(OpensslRevokedCertificate[] revokedCertificates) throws CertificationException {
		int size = revokedCertificates.length;
		int[] revokedCertificatesReferences = new int[size];
		for(int i = 0; i < revokedCertificates.length; i++)
		{
			revokedCertificatesReferences[i] = revokedCertificates[i].getReference();
		}
		_addRevokedCertificates(revokedCertificatesReferences);
	}

	public void addExtension(String oid, boolean isCritical, byte[] value) throws CertificationException
	{
        	_addExtension(oid, isCritical, value);
	}

	
	/*
	 * Sign
	 */
	public OpensslCertificateRevocationList sign(OpensslPrivateKey privateKey, OpensslMessageDigestAlgorithm messageDigestAlgorithm) 
			throws CertificationException 
	{
		return new OpensslCertificateRevocationList(_sign(privateKey.getReference(), messageDigestAlgorithm.toString()));
	}
	
	
	/*
	 * Destructro
	 */
	public void delete() {
		_delete();
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
