package in.shaycryptoco.SCCNcraft.listeners;

import in.shaycryptoco.SCCNcraft.Main;
import in.shaycryptoco.SCCNcraft.misc.CurrencyFormat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.logging.Logger;

public class PlayerJoinListener implements Listener {

    private static final Logger log = Logger.getLogger("Minecraft");

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Economy economy = Main.getEconomy();

        Player player = e.getPlayer();

        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();

        Objective o = b.registerNewObjective("SCCN", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "SCCNcraft\n");

        o.getScore(" ").setScore(5);
        o.getScore(ChatColor.GREEN + "Player: " + ChatColor.AQUA + player.getName()).setScore(4);
        o.getScore(ChatColor.GREEN + "Balance: " + ChatColor.AQUA + CurrencyFormat.formatCurrency(economy.getBalance(player)) + " SCCN").setScore(3);
        o.getScore("").setScore(2);
        o.getScore(ChatColor.AQUA + "sccncraft.shaycryptoco.in").setScore(1);

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main, () -> {
            // code
        });

        player.setScoreboard(b);

    }

}
