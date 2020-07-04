package in.shaycryptoco.sccncraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("The SCCNcraft plugin has been loaded!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("The SCCNcraft plugin has been unloaded!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("test")) {
		
			Player player = (Player)sender;
			
			player.sendMessage("test back to you");
				
		};
		
		return true;
		
	};
	
}
