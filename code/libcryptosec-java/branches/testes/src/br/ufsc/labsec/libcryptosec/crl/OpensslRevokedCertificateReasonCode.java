package br.ufsc.labsec.libcryptosec.crl;

import java.util.HashMap;

public enum OpensslRevokedCertificateReasonCode {
	UNSPECIFIED(0),
	KEY_COMPROMISE(1),
	CA_COMPROMISE(2),
	AFFILIATION_CHANGED(3),
	SUPER_SEDED(4),
	CESSATION_OF_OPERATION(5),
	CERTIFICATE_HOLD(6),
	PRIVILEGE_WITH_DRAWN(9),
	AACOMPROMISE(10);

    private static HashMap<Integer, OpensslRevokedCertificateReasonCode> reasonCodeById = new HashMap<Integer, OpensslRevokedCertificateReasonCode>();
    static {
        for (OpensslRevokedCertificateReasonCode reasonCode : OpensslRevokedCertificateReasonCode.values()) {
            reasonCodeById.put(reasonCode.getId(), reasonCode);
        }
    }
    
    private int _id;

	OpensslRevokedCertificateReasonCode(int id){
	    _id = id;
	}

	public int getId() {
	    return _id;
	}
	
	public static OpensslRevokedCertificateReasonCode getReasonById(int id) {
	    OpensslRevokedCertificateReasonCode reasonCode = reasonCodeById.get(id);
        return reasonCode;
	}
}
