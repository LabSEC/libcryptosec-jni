package crl;

import java.math.BigInteger;

import jni.JniObject;

public class OpenSSLRevokedCertificate extends JniObject {
	
	private native int _init();
	private native void _setSerialNumber(long certificateSerialNumber);
	private native void _setSerialNumber(String certificateSerialNumber);
	private native void _setRevocationDate(String revocationDate);
	private native void _setReasonCode(String reasonCode);
	
	public OpenSSLRevokedCertificate() {
		this.reference = _init();
	}
	
	public void setCertificateSerialNumber(long certificateSerialNumber) {// throw (BigIntegerException);
		_setSerialNumber(certificateSerialNumber);
	}
	public void setCertificateSerialNumber(BigInteger certificateSerialNumber) {
		_setSerialNumber(certificateSerialNumber.toString());
	}
	
	public void setRevocationDate(String revocationDate) {
		_setRevocationDate(revocationDate);
	}
	
	public void setReasonCode(RevokedCertificateReasonCode reasonCode) {
		_setReasonCode(reasonCode.toString());
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
