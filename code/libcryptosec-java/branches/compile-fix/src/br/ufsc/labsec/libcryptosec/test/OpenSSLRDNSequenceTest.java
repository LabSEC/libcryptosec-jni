package br.ufsc.labsec.libcryptosec.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.x509.OpensslRdnSequence;
import br.ufsc.labsec.libcryptosec.x509.OpensslRdnSequenceEntryType;


public class OpenSSLRDNSequenceTest extends LibcryptosecJavaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LibcryptosecJavaTest.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LibcryptosecJavaTest.tearDownAfterClass();
	}

	@Test
	public void testDelete() {
		OpensslRdnSequence sequence = new OpensslRdnSequence();
		sequence.delete();
	}

	@Test
	public void testOpenSSLRDNSequence() {
		OpensslRdnSequence sequence = new OpensslRdnSequence();
		sequence.delete();
	}

	@Test
	public void testAddEntryRDNSequenceEntryTypeString() {
		OpensslRdnSequence sequence  = new OpensslRdnSequence();
		sequence.addEntry(OpensslRdnSequenceEntryType.COMMON_NAME, "Lucas Martins");
		sequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION, "UFSC");
		sequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION_UNIT, "LabSEC");
		sequence.addEntry(OpensslRdnSequenceEntryType.COUNTRY, "BR");
		sequence.addEntry(OpensslRdnSequenceEntryType.STATE_OR_PROVINCE, "Santa Catarina");
		sequence.addEntry(OpensslRdnSequenceEntryType.LOCALITY, "Florianopolis");
		sequence.addEntry(OpensslRdnSequenceEntryType.EMAIL, "lucasgm@inf.ufsc.br");
		sequence.addEntry(OpensslRdnSequenceEntryType.INITIALS, "LGM");
		sequence.addEntry(OpensslRdnSequenceEntryType.SERIAL_NUMBER, "201006669");
		sequence.addEntry(OpensslRdnSequenceEntryType.TITLE, "Scientist");
		sequence.addEntry(OpensslRdnSequenceEntryType.GIVEN_NAME, "Murdoc");
		sequence.addEntry(OpensslRdnSequenceEntryType.PSEUDONYM, "lucasgm");
		sequence.addEntry(OpensslRdnSequenceEntryType.DN_QUALIFIER, "DN_QUALIFIER_VALUE");
		sequence.addEntry(OpensslRdnSequenceEntryType.DOMAIN_COMPONENT, "DOMAIN_COMPONENT_VALUE");		
		sequence.addEntry(OpensslRdnSequenceEntryType.GENERATION_QUALIFIER, "GENERATION_QUALIFIER_VALUE");
		sequence.addEntry(OpensslRdnSequenceEntryType.SURNAME, "SURNAME_VALUE");
		sequence.delete();
	}

	@Test
	public void testAddEntryRDNSequenceEntryTypeStringArray() {
		OpensslRdnSequence sequence  = new OpensslRdnSequence();
		sequence.addEntry(OpensslRdnSequenceEntryType.COMMON_NAME, new String[] {"Lucas Martins", "Lucas GM", "Lucas Goncalves Martins"});
		sequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION, new String[] {"UFSC", "Universidade Federal de Santa Catarina"});
		sequence.addEntry(OpensslRdnSequenceEntryType.ORGANIZATION_UNIT, new String[] {"LabSEC", "Laboratorio de Seguranca em Computacao"});
		sequence.addEntry(OpensslRdnSequenceEntryType.COUNTRY, "BR");
		sequence.addEntry(OpensslRdnSequenceEntryType.STATE_OR_PROVINCE, new String[] {"SC", "Santa Catarina"});
		sequence.addEntry(OpensslRdnSequenceEntryType.LOCALITY, new String[] {"FLP", "Florianopolis"});
		sequence.addEntry(OpensslRdnSequenceEntryType.EMAIL, new String[] {"lucasgm@inf.ufsc.br", "lucasgm.bt@gmail.com"});
		sequence.addEntry(OpensslRdnSequenceEntryType.INITIALS, new String[] {"LGM", "LM"});
		sequence.addEntry(OpensslRdnSequenceEntryType.SERIAL_NUMBER, new String[] {"201006669", "06132025"});
		sequence.addEntry(OpensslRdnSequenceEntryType.TITLE, new String[] {"Cientista", "Graduando"});
		sequence.addEntry(OpensslRdnSequenceEntryType.GIVEN_NAME, new String[] {"Lucas", "Martins"});
		sequence.addEntry(OpensslRdnSequenceEntryType.PSEUDONYM, new String[] {"Lucasgm", "Lucasgmartins"});
		sequence.addEntry(OpensslRdnSequenceEntryType.DN_QUALIFIER, new String[] {"DN_QUALIFIER_VALUE", "DN_QUALIFIER_VALUE_2"});
		sequence.addEntry(OpensslRdnSequenceEntryType.DOMAIN_COMPONENT, new String[] {"DOMAIN_COMPONENT_VALUE", "DOMAIN_COMPONENT_VALUE_2"});		
		sequence.addEntry(OpensslRdnSequenceEntryType.GENERATION_QUALIFIER, new String[] {"GENERATION_QUALIFIER_VALUE", "GENERATION_QUALIFIER_VALUE_2"});
		sequence.addEntry(OpensslRdnSequenceEntryType.SURNAME, new String[] {"SURNAME_VALUE", "SURNAME_VALUE_2"});
		sequence.delete();
	}

}
