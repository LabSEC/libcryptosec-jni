package br.ufsc.labsec.libcryptosec.certificate;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;

import br.ufsc.labsec.libcryptosec.certificate.OpensslCertificate;
import br.ufsc.labsec.libcryptosec.digester.OpensslMessageDigestAlgorithm;
import br.ufsc.labsec.libcryptosec.exceptions.AsymmetricKeyException;
import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;
import br.ufsc.labsec.libcryptosec.exceptions.CertificationException;
import br.ufsc.labsec.libcryptosec.exceptions.EncodeException;
import br.ufsc.labsec.libcryptosec.jni.JniObject;
import br.ufsc.labsec.libcryptosec.keys.OpensslPrivateKey;
import br.ufsc.labsec.libcryptosec.keys.OpensslPublicKey;
import br.ufsc.labsec.libcryptosec.x509.OpensslRdnSequence;

/*
 * 
 */
public class OpensslCertificateBuilder extends JniObject {
	
	/*
	 * Construtores
	 */
	private native long _init();
	private native long _init(String pemEncoded);
	private native long _init(byte[] derEncoded);
	private native long _init(long certificateRequestReference);
	
	/*
	 * Destructor
	 */
	private native void _delete();
	
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
	private native void _setSubject(long subjectReference);
	
	/*
	 * @param subjectReference A reference to a Libcryptosec's RDNSequence object
	 */
	private native void _alterSubject(long subjectReference);

	/*
	 * @param issuerReference A reference to a Libcryptosec's RDNSequence object
	 */
	private native void _setIssuer(long issuerReference);
	
	/*
	 * DateTime
	 */
	private native void _setNotBefore(String dateTime);
	private native void _setNotAfter(String dateTime);
	
	/*
	 * Builds a Libcryptosec PublicKey object with encodedKey argument, sets it as 
	 * certificate's public key and returns it's reference, to be destroyed after it's usage.
	 */
	private native long _setPublicKey(String publicKeyPemEncoded);
	private native long _setPublicKey(byte[] publicKeyDerEncoded);
	
	/*
	 * Sets the referenced Libcryptosec's PublicKey object as certificate's public key.
	 */
	private native void _setPublicKey(long publicKeyReference);
	
	/*
	 * Returns a reference to an Libcryptosec Certificate object
	 */
	private native long _sign(long keyReference, String hashAlgorithm);
	
	private native void _addExtension(String oid, boolean isCritical, byte[] value);
	
	/*
	 * Constructors
	 */
	public OpensslCertificateBuilder() {
		this.reference = _init();
	}
	
	public OpensslCertificateBuilder(String pemEncoded) throws EncodeException
	{
		this.reference = _init(pemEncoded);
	}
	
	public OpensslCertificateBuilder(byte[] derEncoded) throws EncodeException
	{
		this.reference = _init(derEncoded);
	}
	
	public OpensslCertificateBuilder(OpensslCertificateRequest certificateRequest) {
		this.reference = _init(certificateRequest.getReference());
	}
	
	/*
	 * Serial Number
	 */
	public void setSerialNumber(String serial) throws BigIntegerException {
		_setSerialNumber(serial);
	}	
	public void setSerialNumber(BigInteger serial) throws BigIntegerException {
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
	public void setPublicKey(PublicKey publicKey) throws EncodeException {
		_setPublicKey(publicKey.getEncoded());
	}
	
	public void setPublicKey(OpensslPublicKey publicKey) {
		_setPublicKey(publicKey.getReference());
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
	public void setIssuer(OpensslCertificate issuer)
	{
		_setIssuer(issuer.getReference());
	}	
	public void setSubject(OpensslRdnSequence subject)
	{
		_setSubject(subject.getReference());
	}
	public void alterSubject(OpensslRdnSequence subject)
	{
		_alterSubject(subject.getReference());
	}
	
	/*
	 * Sign
	 */
	public OpensslCertificate sign(OpensslPrivateKey key, OpensslMessageDigestAlgorithm messageDigestAlgorithm)
			throws CertificationException, AsymmetricKeyException
	{
		return new OpensslCertificate(_sign(key.getReference(), messageDigestAlgorithm.toString()));
	}
	
	/*
	 * Destructor
	 */
	@Override
	public void delete() {
		_delete();
	}
	
	
    public void addExtension(String oid, boolean isCritical, byte[] value) throws CertificationException
    {
        _addExtension(oid, isCritical, value);
    }

    public static void main(String[] args) throws IOException {
		System.load("/usr/lib/libcryptosecca-jni.so");
		byte[] pkcs10Bytes = Files.readAllBytes(Paths
				.get("/home/guilherme/pkcs10.der"));
		OpensslCertificateRequest req = new OpensslCertificateRequest(pkcs10Bytes);
		System.out.println(req.getReference());
		
		OpensslCertificateBuilder segfault = new OpensslCertificateBuilder(req);	
		System.out.println("passed");
	}
	
//	void setExtensions(X509Extension extension)
//	{
//		
//	}
	

	
//	void addExtensions(X509Extension extension) throws CertificationException
//	{
//	
//	}

	
//	void replaceExtension(X509Extension extension) throws CertificationException
//	{
//	
//	}
	
//	std::vector<Extension *> removeExtension(Extension::Name extensionName) throws CertificationException
//	{
//
//	}

//	std::vector<Extension *> removeExtension(ObjectIdentifier extOID) throws CertificationException
//	{
//	
//	}
	
	/*
	 * GETTERS
	 */
	
//	BigInteger getSerialNumberBigInt() throws CertificationException, BigIntegerException
//	{
//		
//	}
	
//	public long getSerialNumber() throws CertificationException 
//	{
//		
//	}
	
//	MessageDigestAlgorithm getMessageDigestAlgorithm() throws MessageDigestException
//	{
//		
//	}

//	long getVersion() throws CertificationException
//	{
//	
//	}
	
//	PublicKey getPublicKey() throws CertificationException, AsymmetricKeyException
//	{
//		
//	}

//	byte[] getPublicKeyInfo() throws CertificationException
//	{
//		
//	}
	
//	DateTime getNotBefore()
//	{
//		
//	}
	
//	DateTime getNotAfter()
//	{
//		
//	}
	
//	RDNSequence getIssuer()
//	{
//		
//	}
	
//	RDNSequence getSubject()
//	{
//		
//	}
	
//	std::vector<Extension*> getExtension(Extension::Name extensionName)
//	{
//		
//	}
	
//	std::vector<Extension*> getExtensions()
//	{
//		
//	}
	
//	std::vector<Extension *> getUnknownExtensions()
//	{
//		
//	}
	
}
