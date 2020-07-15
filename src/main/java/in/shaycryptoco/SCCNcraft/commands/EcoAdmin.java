package in.shaycryptoco.SCCNcraft.commands;

import in.shaycryptoco.SCCNcraft.CurrencyFormat;
import in.shaycryptoco.SCCNcraft.Main;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoAdmin implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Economy economy = Main.getEconomy();

            if (args.length == 3 && args[0].equalsIgnoreCase("take")) {

                if (player.hasPermission("sccncraft.eco.admin")) {

                    double amount = Double.valueOf(args[1]);

                    if (Bukkit.getServer().getPlayer(args[2]) == null) {

                        player.sendMessage(ChatColor.GREEN + "A player with that name cannot be found!");

                    } else {

                        Player victim = Bukkit.getServer().getPlayer(args[2]);

                        EconomyResponse response = economy.withdrawPlayer(victim, amount);
                        if (response.transactionSuccess()) {
                            victim.sendMessage(ChatColor.AQUA + CurrencyFormat.formatCurrency(response.amount) + ChatColor.GREEN + " SCCN has been removed from your balance!");
                            victim.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.AQUA + CurrencyFormat.formatCurrency(response.balance) + ChatColor.GREEN + " SCCN");
                            player.sendMessage(ChatColor.AQUA + CurrencyFormat.formatCurrency(response.amount) + ChatColor.GREEN + " SCCN has been removed from " + ChatColor.AQUA + victim.getDisplayName() + ChatColor.GREEN + "'s balance");
                            player.sendMessage(ChatColor.GREEN + "Their new balance is " + ChatColor.AQUA + CurrencyFormat.formatCurrency(response.balance) + ChatColor.GREEN + " SCCN");
                        } else {
                            player.sendMessage(ChatColor.GREEN + "Failed to remove money from the user's balance.");
                            player.sendMessage(ChatColor.GREEN + "Reason: " + ChatColor.GOLD + response.errorMessage);
                        }

                    }

                } else {
                    player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
                }

            } else if (args.length == 3 && args[0].equalsIgnoreCase("give")) {

                if (player.hasPermission("sccncraft.eco.admin")) {

                    double amount = Double.valueOf(args[1]);

                    if (Bukkit.getServer().getPlayer(args[2]) == null) {

                        player.sendMessage(ChatColor.GREEN + "A player with that name cannot be found!");

                    } else {

                        Player victim = Bukkit.getServer().getPlayer(args[2]);

                        EconomyResponse response = economy.depositPlayer(victim, amount);
                        if (response.transactionSuccess()) {
                            victim.sendMessage(ChatColor.AQUA + CurrencyFormat.formatCurrency(response.amount) + ChatColor.GREEN + " SCCN has been added to your balance!");
                            victim.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.AQUA + CurrencyFormat.formatCurrency(response.balance) + ChatColor.GREEN + " SCCN");
                            player.sendMessage(ChatColor.AQUA + CurrencyFormat.formatCurrency(response.amount) + ChatColor.GREEN + " SCCN has been added to " + ChatColor.AQUA + victim.getDisplayName() + ChatColor.GREEN + "'s balance");
                            player.sendMessage(ChatColor.GREEN + "Their new balance is " + ChatColor.AQUA + CurrencyFormat.formatCurrency(response.balance) + ChatColor.GREEN + " SCCN");
                        } else {
                            player.sendMessage(ChatColor.GREEN + "Failed to add money to the user's balance.");
                            player.sendMessage(ChatColor.GREEN + "Reason: " + ChatColor.GOLD + response.errorMessage);
                        }

                    }

                } else {
                    player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
                }

            }

        }

        return true;
    }
}
