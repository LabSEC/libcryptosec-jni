package certificate;

import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;

import javax.naming.ldap.Rdn;

import x509.OpenSSLRDNSequence;

import jni.JniObject;
import keys.OpenSSLPrivateKey;

import digester.MessageDigestAlgorithm;

/*
 * 
 */
public class CertificateBuilder extends JniObject {
	
	/*
	 * Construtores
	 */
	private native int _init();
	private native int _init(String pemEncoded);
	private native int _init(byte[] derEncoded);
	
	/*
	 * Set Serial Number
	 */
	private native void _setSerialNumber(long serial);
	private native void _setSerialNumber(String serial);
	
	/*
	 * Set Version
	 */
	private native void _setVersion(long serial);
	
	/*
	 * @param subjectReference A reference to a Libcryptosec's RDNSequence object
	 */
	private native void _setSubject(int subjectReference);
	
	/*
	 * @param issuerReference A reference to a Libcryptosec's RDNSequence object
	 */
	private native void _setIssuer(int issuerReference);
	
	/*
	 * DateTime
	 */
	private native void _setNotBefore(String dateTime);
	private native void _setNotAfter(String dateTime);
	
	private native void _setPublicKey(String privateKeyPemEncoded);
	private native void _setPublicKey(byte[] privateKeyDerEncoded);
	
	/*
	 * Returns a reference to an Libcryptosec Certificate object
	 */
	private native int _sign(int keyReference, String hashAlgorithm);
	
	/*
	 * Constructors
	 */
	public CertificateBuilder() {
		this.reference = _init();
	}
	
	public CertificateBuilder(String pemEncoded)// throw (EncodeException)
	{
		this.reference = _init(pemEncoded);
	}
	
	public CertificateBuilder(byte[] derEncoded) //throw (EncodeException)
	{
		this.reference = _init(derEncoded);
	}
	
	/*
	 * Serial Number
	 */
	public void setSerialNumber(String serial) {// throw (BigIntegerException) {
		_setSerialNumber(serial);
	}	
	public void setSerialNumber(BigInteger serial) {// throw (BigIntegerException) {
		_setSerialNumber(serial.toString());
	}	
	public void setSerialNumber(long serial) {
		_setSerialNumber(serial);
	}	
	
	/*
	 * Version
	 */
	public void setVersion(long version){
		_setVersion(version);
	}

	/*
	 * PublicKey
	 */
	public void setPublicKey(PublicKey publicKey) {
		_setPublicKey(publicKey.getEncoded());
	}

	/*
	 * NotBefore and NotAfter
	 */
	public void setNotBefore(String dateTime)
	{
		_setNotBefore(dateTime);
	}
	public void setNotAfter(String dateTime)
	{
		_setNotAfter(dateTime);
	}
	
	/*
	 * Issuer and Subject
	 */
	public void setIssuer(OpenSSLRDNSequence issuer)
	{
		_setIssuer(issuer.getReference());
	}	
	public void setSubject(OpenSSLRDNSequence subject)
	{
		_setSubject(subject.getReference());
	}
	
	/*
	 * Sign
	 */
	public OpenSSLCertificate sign(OpenSSLPrivateKey key, MessageDigestAlgorithm messageDigestAlgorithm) //throw (CertificationException, AsymmetricKeyException);
	{
		return new OpenSSLCertificate(_sign(key.getReference(), messageDigestAlgorithm.toString()));
	}
	
//	void setExtensions(X509Extension extension)
//	{
//		//TODO set extensions
//	}
//	void addExtension(X509Extension extension) {// throw (CertificationException);
//	
//}
//void addExtensions(X509Extension extension) {//throw (CertificationException);
//	
//}
//
//void replaceExtension(X509Extension extension) {//throw (CertificationException);
//	
//}
//
//std::vector<Extension *> removeExtension(Extension::Name extensionName){// throw (CertificationException);
//	
//}
//
//std::vector<Extension *> removeExtension(ObjectIdentifier extOID) {//throw (CertificationException);
//	
//}
	
//	BigInteger getSerialNumberBigInt() throw (CertificationException, BigIntegerException);
	
	
//	
//	public long getSerialNumber() { //throw (CertificationException) {
//		
//	}
	
//	MessageDigestAlgorithm getMessageDigestAlgorithm() { // throw (MessageDigestException)
//		
//	}
//	
//	
//	long getVersion() {// throw (CertificationException);
//		
//	}
	

//	
//	PublicKey getPublicKey() {//throw (CertificationException, AsymmetricKeyException);
//		
//	}
//	
//	byte[] getPublicKeyInfo() {// throw (CertificationException);
//		
//	}
	
	
//	DateTime getNotBefore();
//	DateTime getNotAfter();
//	RDNSequence getIssuer();
//	RDNSequence getSubject();
//	std::vector<Extension*> getExtension(Extension::Name extensionName);
//	std::vector<Extension*> getExtensions();
//	std::vector<Extension *> getUnknownExtensions();
	
}
