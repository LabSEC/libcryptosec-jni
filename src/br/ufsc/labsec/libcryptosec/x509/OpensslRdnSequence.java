package br.ufsc.labsec.libcryptosec.x509;

import br.ufsc.labsec.libcryptosec.jni.JniObject;

public class OpensslRdnSequence extends JniObject {

	private native long _init();
	private native void _delete();
	private native void _addEntry(String entryTypeString, String value);
	private native void _addEntry(String entryTypeString, String[] value);

	public OpensslRdnSequence() {
		this.reference = _init();
	}

	public void addEntry(OpensslRdnSequenceEntryType type, String value) {
		_addEntry(type.toString(), value);
	}
	
	public void addEntry(OpensslRdnSequenceEntryType type, String[] values) {
		_addEntry(type.toString(), values);
	}
	
	@Override
	public void delete() {
		_delete();
	}

//	String[] getEntries(RDNSequenceEntryType type) {
//
//	}
//
//	std:vector<std::pair<ObjectIdentifier, std::string> > getUnknownEntries();
//	std::vector<std::pair<ObjectIdentifier, std::string> > getEntries() const;

}
