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
            player.sendMessage(ChatColor.AQUA + "1) " + ChatColor.GREEN + "Be respectful to ALL players - not just staff.");
            player.sendMessage(ChatColor.AQUA + "2) " + ChatColor.GREEN + "No extremist discussion in chat.");
            player.sendMessage(ChatColor.AQUA + "3) " + ChatColor.GREEN + "No racism.");
            player.sendMessage(ChatColor.AQUA + "4) " + ChatColor.GREEN + "No doxxing (giving out personal information about others without their permission)");
            player.sendMessage(ChatColor.AQUA + "5) " + ChatColor.GREEN + "NO HACKS");
            player.sendMessage(ChatColor.AQUA + "6) " + ChatColor.GREEN + "Have fun!");

        }

        return true;
    }

}
