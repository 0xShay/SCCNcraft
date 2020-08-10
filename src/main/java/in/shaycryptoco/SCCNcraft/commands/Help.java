package in.shaycryptoco.SCCNcraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("sccncraft.general.help")) {
                player.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "[==={ SCCNcraft Commands }===]");
                player.sendMessage(ChatColor.GREEN + "A list of commands can be seen in the Discord server.");
                player.sendMessage(ChatColor.GREEN + "https://discord.gg/V8uwRRK");
            } else {
                player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
            }

        }

        return true;
    }

}
