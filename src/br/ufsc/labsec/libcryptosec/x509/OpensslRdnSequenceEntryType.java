package br.ufsc.labsec.libcryptosec.x509;

import java.util.HashMap;

public enum OpensslRdnSequenceEntryType {
	COUNTRY("2.5.4.6"),
	STATE_OR_PROVINCE("2.5.4.8"),
	LOCALITY("2.5.4.7"),
	ORGANIZATION("2.5.4.10"),
	ORGANIZATION_UNIT("2.5.4.11"),
	COMMON_NAME("2.5.4.3"),
	EMAIL("1.2.840.113549.1.9.1"),
	DN_QUALIFIER("2.5.4.46"),
	SERIAL_NUMBER("2.5.4.5"),
	TITLE("2.5.4.12"),
	SURNAME("2.5.4.4"),
	GIVEN_NAME("2.5.4.42"),
	INITIALS("2.5.4.43"),
	PSEUDONYM("2.5.4.65"),
	GENERATION_QUALIFIER("2.5.4.44"),
	DOMAIN_COMPONENT("0.9.2342.19200300.100.1.25"),
	UNKNOWN("UNKNOWN");
	
    private static HashMap<String, OpensslRdnSequenceEntryType> rdnByOid = new HashMap<String, OpensslRdnSequenceEntryType>();
    static {
        for (OpensslRdnSequenceEntryType rdn : OpensslRdnSequenceEntryType.values()) {
            rdnByOid.put(rdn.getOid(), rdn);
        }
    }
	
	private String oid;
	
	OpensslRdnSequenceEntryType(String oid)
	{
	    this.oid = oid;
	}
		
	public String getOid()
	{
	    return this.oid;
	}
	
	public static OpensslRdnSequenceEntryType getRdnByOid(String oid) 
	{
	    OpensslRdnSequenceEntryType rdn = rdnByOid.get(oid);
	    return (rdn != null) ? rdn : OpensslRdnSequenceEntryType.UNKNOWN;
	}
	
}
