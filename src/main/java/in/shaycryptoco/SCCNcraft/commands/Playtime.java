package in.shaycryptoco.SCCNcraft.commands;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import com.earth2me.essentials.utils.DateUtil;
import com.earth2me.essentials.utils.EnumUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Playtime implements CommandExecutor {

    private static final Statistic PLAY_ONE_TICK = EnumUtil.getStatistic("PLAY_ONE_MINUTE", "PLAY_ONE_TICK");

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Essentials ess = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");

        if (args.length == 1) {
            if (player.hasPermission("sccncraft.general.playtime.others")) {

                Player victim = Bukkit.getServer().getPlayer(args[0]);
                User user = ess.getUser(victim);

                if (user != null) {
                    player.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "[==={ SCCNcraft | " + ChatColor.AQUA + victim.getName() + "'s " + ChatColor.GREEN + "Playtime }===]");

                    long playtimeMs = System.currentTimeMillis() - (user.getBase().getStatistic(PLAY_ONE_TICK) * 50);
                    player.sendMessage(ChatColor.GREEN + DateUtil.formatDateDiff(playtimeMs));
                } else {
                    player.sendMessage(ChatColor.GREEN  + "That user could not be found.");
                }

            } else {
                player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
            };
        } else if (args.length == 0) {
            if (player.hasPermission("sccncraft.general.playtime")) {

                User user = ess.getUser(player);

                if (user != null) {
                    player.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "[==={ SCCNcraft | " + ChatColor.AQUA + player.getName() + "'s " + ChatColor.GREEN + "Playtime }===]");

                    long playtimeMs = System.currentTimeMillis() - (user.getBase().getStatistic(PLAY_ONE_TICK) * 50);
                    player.sendMessage(ChatColor.GREEN + DateUtil.formatDateDiff(playtimeMs));
                } else {
                    player.sendMessage(ChatColor.GREEN  + "That user could not be found.");
                }

            } else {
                player.sendMessage(ChatColor.GREEN + "You don't have permission to do that!");
            };
        };

        return true;
    }

}
