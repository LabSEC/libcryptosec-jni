package br.ufsc.labsec.libcryptosec.engine;

public class OpensslEngineCommand {
	
	String command;
	String value;
	
	public OpensslEngineCommand(String command, String value) {
		this.command = command;
		this.value = value;
	}
	
	public String getCommand()
	{
		return this.command;
	}
	
	public String getValue()
	{
		return this.value;
	}
}
