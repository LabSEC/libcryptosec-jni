package br.ufsc.labsec.libcryptosec.crl;

import java.math.BigInteger;

import br.ufsc.labsec.libcryptosec.exceptions.BigIntegerException;
import br.ufsc.labsec.libcryptosec.jni.JniObject;


public class OpensslRevokedCertificate extends JniObject {
	
	private native int _init();
	private native void _delete();
	
	private native void _setSerialNumber(long certificateSerialNumber);
	private native void _setSerialNumber(String certificateSerialNumber);
	private native void _setRevocationDate(String revocationDate);
	private native void _setReasonCode(String reasonCode);
	
	public OpensslRevokedCertificate() {
		this.reference = _init();
	}
	
	/*
	 * TODO verifiar possível exceção trocada
	 */
	public void setCertificateSerialNumber(long certificateSerialNumber) throws BigIntegerException {
		_setSerialNumber(certificateSerialNumber);
	}
	public void setCertificateSerialNumber(BigInteger certificateSerialNumber) {
		_setSerialNumber(certificateSerialNumber.toString());
	}
	
	public void setRevocationDate(String revocationDate) {
		_setRevocationDate(revocationDate);
	}
	
	public void setReasonCode(OpensslRevokedCertificateReasonCode reasonCode) {
		_setReasonCode(reasonCode.toString());
	}
	
	@Override
	public void delete() {
		_delete();
	}
	
//	public long getCertificateSerialNumber(){
//		return certificateSerialNumber.longValue();
//	}
//	
//	public BigInteger getCertificateSerialNumberBigInt(){
//		return this.certificateSerialNumber;
//	}
//
//	public String getRevocationDate(){
//		return this.revocationDate;
//	}
//	
//	public RevokedCertificateReasonCode getReasonCode(){
//		return this.reasonCode;
//	}
	
//	std::string getXmlEncoded();
//	std::string getXmlEncoded(std::string tab);
//	static std::string reasonCode2Name(RevokedCertificate::ReasonCode reasonCode);

}
