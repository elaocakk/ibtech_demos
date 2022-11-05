package reflections_demo;

import java.net.InetSocketAddress;

public class ServerConfigurations {
	private static ServerConfigurations serConfigurations ;
	
	private  InetSocketAddress serverAddress;
	private  String greetingMessage = "";
	
	public ServerConfigurations(int port , String greetingMessage) {
		
		this.serverAddress = new InetSocketAddress("local", port);
		this.greetingMessage = greetingMessage;
		
		if (serConfigurations == null)
			serConfigurations = this;
		
	}

	public static ServerConfigurations getInstance() {
		return serConfigurations;
	}
	
	public InetSocketAddress getServerAddress() {
		return serverAddress;
	}

	public String getGreetingMessage() {
		return greetingMessage;
	}
	


}
