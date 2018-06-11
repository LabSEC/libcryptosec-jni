package br.ufsc.labsec.libcryptosec.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.labsec.libcryptosec.engine.OpensslDynamicEngine;
import br.ufsc.labsec.libcryptosec.engine.OpensslEngineCommand;
import br.ufsc.labsec.libcryptosec.exceptions.EngineException;

public class DynamicEngineTest {
	
	static {
		System.load("/home/fabio/Desktop/Hawa/libcryptosec-jni/libcryptosec-jni-1.1.0/libcryptosec_jni.so");			
	}
	
	OpensslDynamicEngine engine;
	
	public static String enginePath = "/etc/hawa/engines/openhsmd-ca.so";
	public static String engineId = "openhsmd";
	public static OpensslEngineCommand[] commands = {new OpensslEngineCommand("ADDRESS_CONN", "192.168.66.48")};
	public static String keyId = "chave-2048";
	
	@Before
	public void setUpBefore() throws Exception {
	}

	@After
	public void tearDownAfter() throws Exception {
	}

	@Test
	public void testDelete() throws EngineException {
		engine = new OpensslDynamicEngine(enginePath, engineId, commands);
		engine.delete();
	}

	@Test
	public void testDynamicEngineStringStringEngineCommandArray() throws EngineException {
		engine = new OpensslDynamicEngine(enginePath, engineId, commands);
		engine.delete();
	}

}
