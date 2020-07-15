package in.shaycryptoco.SCCNcraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rules implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "[==={ SCCNcraft Rules }===]");
            player.sendMessage(ChatColor.AQUA + "1) " + ChatColor.GREEN + "Nothing");
            player.sendMessage(ChatColor.AQUA + "2) " + ChatColor.GREEN + "Nothing");
            player.sendMessage(ChatColor.AQUA + "3) " + ChatColor.GREEN + "Nothing");
            player.sendMessage(ChatColor.AQUA + "4) " + ChatColor.GREEN + "Nothing");
            player.sendMessage(ChatColor.AQUA + "5) " + ChatColor.GREEN + "Nothing");

        }

        return true;
    }

}
