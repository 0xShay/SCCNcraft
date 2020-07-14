package in.shaycryptoco.SCCNcraft.misc;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import in.shaycryptoco.SCCNcraft.Main;

public class StartMessage {
	
	private static Main plugin;

	public static void logMessage(){
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();	
		console.sendMessage(plugin.getConfig().getString("start_message"));
		
	}
	
}
