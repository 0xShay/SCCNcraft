package in.shaycryptoco.SCCNcraft.commands;

import in.shaycryptoco.SCCNcraft.misc.CurrencyFormat;
import in.shaycryptoco.SCCNcraft.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoBalance implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Economy economy = Main.getEconomy();

            if (args.length == 0 || args.length == 1) {

                if (args.length == 1) {
                    Player victim = Bukkit.getServer().getPlayer(args[0]);

                    if (victim == null) {
                        player.sendMessage(ChatColor.GREEN + "A player of that username cannot be found.");
                    } else {
                        if (player.hasPermission("sccncraft.eco.balance.others")) {
                            player.sendMessage(ChatColor.AQUA + victim.getDisplayName() + ChatColor.GREEN + " has " + ChatColor.AQUA + CurrencyFormat.formatCurrency(economy.getBalance(victim)) + ChatColor.GREEN + " SCCN");
                        } else {
                            player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
                        }
                    }

                } else {
                    if (player.hasPermission("sccncraft.eco.balance")) {
                        player.sendMessage(ChatColor.GREEN + "You have " + ChatColor.AQUA + CurrencyFormat.formatCurrency(economy.getBalance(player)) + ChatColor.GREEN + " SCCN");
                    } else {
                        player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
                    }
                }

            }

        }

        return true;
    }

}
