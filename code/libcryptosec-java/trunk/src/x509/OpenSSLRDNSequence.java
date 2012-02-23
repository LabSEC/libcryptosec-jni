package x509;

import jni.JniObject;

public class OpenSSLRDNSequence extends JniObject {

	private native int _init();
	private native int _addEntry(String entryTypeString, String value);
	private native int _addEntry(String entryTypeString, String[] value);

	public OpenSSLRDNSequence() {
		this.reference = _init();
	}

	public void addEntry(RDNSequenceEntryType type, String value) {
		_addEntry(type.toString(), value);
	}
	
	public void addEntry(RDNSequenceEntryType type, String[] values) {
		_addEntry(type.toString(), values);
	}

//	String[] getEntries(RDNSequenceEntryType type) {
//
//	}
//
//	std:vector<std::pair<ObjectIdentifier, std::string> > getUnknownEntries();
//	std::vector<std::pair<ObjectIdentifier, std::string> > getEntries() const;

}
