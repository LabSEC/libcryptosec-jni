package br.ufsc.labsec.libcryptosec.crl;

public enum OpensslRevokedCertificateReasonCode {
	UNSPECIFIED("UNSPECIFIED"),
	KEY_COMPROMISE("KEY_COMPROMISE"),
	CA_COMPROMISE("CA_COMPROMISE"),
	AFFILIATION_CHANGED("AFFILIATION_CHANGED"),
	SUPER_SEDED("SUPER_SEDED"),
	CESSATION_OF_OPERATION("CESSATION_OF_OPERATION"),
	CERTIFICATE_HOLD("CERTIFICATE_HOLD"),
	PRIVILEGE_WITH_DRAWN("PRIVILEGE_WITH_DRAWN"),
	AACOMPROMISE("AACOMPROMISE");
	
	private String _reasonCode;

	OpensslRevokedCertificateReasonCode(String reasonCode){
		_reasonCode = reasonCode;
	}

	public String getName() {
	    return _reasonCode;
	}
}
