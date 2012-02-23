package engine;

public class EngineCommand {
	
	String command;
	String value;
	
	public EngineCommand(String command, String value) {
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
