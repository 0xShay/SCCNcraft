package in.shaycryptoco.SCCNcraft.commands;

import in.shaycryptoco.SCCNcraft.misc.CurrencyFormat;
import in.shaycryptoco.SCCNcraft.Main;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoPay implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Economy economy = Main.getEconomy();

            if (args.length == 2) {

                if (player.hasPermission("sccncraft.eco.pay")) {

                    Player victim = Bukkit.getServer().getPlayer(args[0]);
                    double amount = Double.valueOf(args[1]);

                    EconomyResponse responseWithdraw = economy.withdrawPlayer(player, amount);
                    if (responseWithdraw.transactionSuccess()) {
                        // money has been taken from sender
                        EconomyResponse responseDeposit = economy.depositPlayer(victim, amount);
                        if (responseDeposit.transactionSuccess()) {
                            // money has been paid to receiver
                            player.sendMessage(ChatColor.GREEN + "You have sent " + ChatColor.AQUA + CurrencyFormat.formatCurrency(amount) + ChatColor.GREEN + " SCCN to " + ChatColor.AQUA + victim.getDisplayName());
                            victim.sendMessage(ChatColor.GREEN + "You have received " + ChatColor.AQUA + CurrencyFormat.formatCurrency(amount) + ChatColor.GREEN + " SCCN from " + ChatColor.AQUA + player.getDisplayName());
                        } else {
                            victim.sendMessage(ChatColor.GREEN + "Failed to receive SCCN from user.");
                            victim.sendMessage(ChatColor.GREEN + "Reason: " + ChatColor.GOLD + responseDeposit.errorMessage);
                        }
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Failed to send SCCN to user.");
                        player.sendMessage(ChatColor.GREEN + "Reason: " + ChatColor.GOLD + responseWithdraw.errorMessage);
                    }

                } else {
                    player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
                }

            }

        }

        return true;
    }

}
