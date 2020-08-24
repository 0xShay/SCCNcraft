package in.shaycryptoco.SCCNcraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Rules implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("sccncraft.general.rules")) {

                player.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "[==={ SCCNcraft Rules }===]");
                player.sendMessage(ChatColor.AQUA + "1) " + ChatColor.GREEN + "Be respectful to ALL players - not just staff.");
                player.sendMessage(ChatColor.AQUA + "2) " + ChatColor.GREEN + "No extremist discussion in chat.");
                player.sendMessage(ChatColor.AQUA + "3) " + ChatColor.GREEN + "No racism.");
                player.sendMessage(ChatColor.AQUA + "4) " + ChatColor.GREEN + "No doxxing (giving out personal information about others without their permission)");
                player.sendMessage(ChatColor.AQUA + "5) " + ChatColor.GREEN + "No hacks");
                player.sendMessage(ChatColor.AQUA + "6) " + ChatColor.GREEN + "No griefing");
                player.sendMessage(ChatColor.AQUA + "7) " + ChatColor.GREEN + "No tp-trapping");
                player.sendMessage(ChatColor.AQUA + "8) " + ChatColor.GREEN + "Abandoning a claim just to kill someone without the agreement of both parties is not allowed.");
                player.sendMessage(ChatColor.AQUA + "9) " + ChatColor.GREEN + "Staff will always have the final judgement in situations.");
                player.sendMessage(ChatColor.AQUA + "10) " + ChatColor.GREEN + "Have fun!");

            } else {
                player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
            }

        } else {

            Server server = Bukkit.getServer();

            ConsoleCommandSender console = server.getConsoleSender();

            console.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "[==={ SCCNcraft Rules }===]");
            console.sendMessage(ChatColor.AQUA + "1) " + ChatColor.GREEN + "Be respectful to ALL players - not just staff.");
            console.sendMessage(ChatColor.AQUA + "2) " + ChatColor.GREEN + "No extremist discussion in chat.");
            console.sendMessage(ChatColor.AQUA + "3) " + ChatColor.GREEN + "No racism.");
            console.sendMessage(ChatColor.AQUA + "4) " + ChatColor.GREEN + "No doxxing (giving out personal information about others without their permission)");
            console.sendMessage(ChatColor.AQUA + "5) " + ChatColor.GREEN + "No hacks");
            console.sendMessage(ChatColor.AQUA + "6) " + ChatColor.GREEN + "No griefing");
            console.sendMessage(ChatColor.AQUA + "7) " + ChatColor.GREEN + "No tp-trapping");
            console.sendMessage(ChatColor.AQUA + "8) " + ChatColor.GREEN + "Abandoning a claim just to kill someone without the agreement of both parties is not allowed.");
            console.sendMessage(ChatColor.AQUA + "9) " + ChatColor.GREEN + "Staff will always have the final judgement in situations.");
            console.sendMessage(ChatColor.AQUA + "10) " + ChatColor.GREEN + "Have fun!");

        }

        return true;
    }

}
