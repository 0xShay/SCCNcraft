package in.shaycryptoco.SCCNcraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Discord implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "[==={ SCCNcraft Discord Server }===]");
            player.sendMessage(ChatColor.AQUA + "Join our Discord server to keep updated! " + ChatColor.GREEN + "https://discord.gg/V8uwRRK");

        }

        return true;
    }

}
